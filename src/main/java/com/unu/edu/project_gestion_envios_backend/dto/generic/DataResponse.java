package com.unu.edu.project_gestion_envios_backend.dto.generic;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record DataResponse<T>(StatusResponse status, T data) {
}
