package com.unu.edu.project_gestion_envios_backend.controller;

import com.unu.edu.project_gestion_envios_backend.dto.ClienteDto;
import com.unu.edu.project_gestion_envios_backend.dto.generic.DataResponse;
import com.unu.edu.project_gestion_envios_backend.dto.generic.StatusResponse;
import com.unu.edu.project_gestion_envios_backend.model.Cliente;
import com.unu.edu.project_gestion_envios_backend.service.ClienteService;
import com.unu.edu.project_gestion_envios_backend.utils.ApiRoutes;
import com.unu.edu.project_gestion_envios_backend.utils.Constantes;
import com.unu.edu.project_gestion_envios_backend.utils.messages.ClienteMensajes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
@RequestMapping(ApiRoutes.ClienteRoutes.BASE)
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping(ApiRoutes.ClienteRoutes.BY_DNI)
    public ResponseEntity<DataResponse<ClienteDto>> byDni(@RequestParam("dni")
                                                           @NotBlank(message = ClienteMensajes.DNI_OBLIGATORIO)
                                                           @Pattern(regexp = "\\d{8}", message = ClienteMensajes.DNI_FORMATO) String dni) {
        Cliente cliente = service.findByDniAndActivo(dni);

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        DataResponse.<ClienteDto>builder()
                                .status(new StatusResponse(HttpStatus.OK.value(), Constantes.MENSAJE_EXITOSO, Constantes.MENSAJE_DATOS_ENCONTRADOS))
                                .data(ClienteDto.fromEntity(cliente))
                                .build()
                );
    }

}
