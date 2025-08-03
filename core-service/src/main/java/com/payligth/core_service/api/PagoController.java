package com.payligth.core_service.api;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Operation(summary = "Verifica si el sistema está activo")
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("paylight-core-service operativo");
    }

    @Operation(summary = "Crea un nuevo pago")
    @PostMapping
    public ResponseEntity<String> crearPago(@RequestBody String payload) {
        // Aquí se llamaría a la capa de aplicación / dominio
        return ResponseEntity.ok("Pago recibido correctamente");
    }
}