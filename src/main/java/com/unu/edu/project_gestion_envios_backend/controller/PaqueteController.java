package com.unu.edu.project_gestion_envios_backend.controller;

import com.unu.edu.project_gestion_envios_backend.controller.request.PaqueteRequest;
import com.unu.edu.project_gestion_envios_backend.dto.PaqueteListadoItemDTO;
import com.unu.edu.project_gestion_envios_backend.dto.generic.DataResponse;
import com.unu.edu.project_gestion_envios_backend.dto.generic.StatusResponse;
import com.unu.edu.project_gestion_envios_backend.model.Paquete;
import com.unu.edu.project_gestion_envios_backend.service.PaqueteService;
import com.unu.edu.project_gestion_envios_backend.utils.ApiRoutes;
import com.unu.edu.project_gestion_envios_backend.utils.Constantes;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaqueteController {

    private final PaqueteService paqueteService;

    @GetMapping(ApiRoutes.PaqueteRoutes.LISTADO)
    @Operation(
            summary = "Listar paquetes",
            description = "Endpoint para listar todos los paquetes registrados")
    public ResponseEntity<DataResponse<List<PaqueteListadoItemDTO>>> listarPaquetes() {

        List<PaqueteListadoItemDTO> resultado =
                paqueteService.listar().stream()
                        .map(PaqueteListadoItemDTO::fromEntity)
                        .toList();

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        DataResponse.<List<PaqueteListadoItemDTO>>builder()
                                .status(
                                        new StatusResponse(
                                                HttpStatus.OK.value(),
                                                Constantes.MENSAJE_EXITOSO,
                                                Constantes.MENSAJE_DATOS_ENCONTRADOS))
                                .data(resultado)
                                .build());
    }

    @PostMapping(ApiRoutes.PaqueteRoutes.ADD)
    public ResponseEntity<DataResponse<PaqueteListadoItemDTO>> add(@Valid @RequestBody PaqueteRequest request) {
        Paquete paquete = paqueteService.upsert(request);
        PaqueteListadoItemDTO dto = PaqueteListadoItemDTO.fromEntity(paquete);

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        DataResponse.<PaqueteListadoItemDTO>builder()
                                .status(new StatusResponse(HttpStatus.OK.value(), Constantes.MENSAJE_EXITOSO, Constantes.MENSAJE_CREACION_EXITOSA))
                                .data(dto)
                                .build()
                );
    }
}
