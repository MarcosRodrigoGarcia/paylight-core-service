pipeline {

   agent {
           node {
               label 'docker-agent-alpine'
               }
         }

  environment {
    IMAGE_NAME = "marcos/paylight-core-service"
    CONTAINER_NAME = "paylight-core"
    PORT = "8085"
  }

  stages {

    stage('Checkout') {
      steps {
              git branch: 'main',
                  url: 'https://github.com/MarcosRodrigoGarcia/paylight-core-service.git'
            }
    }

    stage('Build') {
      steps {
        dir('src') {
              sh 'mvn clean package -DskipTests'
            }
      }
    }

    stage('Build Docker Image') {
      steps {
        sh "docker build -t ${IMAGE_NAME}:latest ."
      }
    }

    stage('Deploy') {
      steps {
        // Parar contenedor si ya existe
        sh """
          docker stop ${CONTAINER_NAME} || true
          docker rm ${CONTAINER_NAME} || true
        """
        // Lanzar nuevo contenedor
        sh """
          docker run -d --name ${CONTAINER_NAME} -p ${PORT}:8085 ${IMAGE_NAME}:latest
        """
      }
    }
  }
}
