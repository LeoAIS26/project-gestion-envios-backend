package com.unu.edu.project_gestion_envios_backend.exception;

import com.unu.edu.project_gestion_envios_backend.dto.generic.DataResponse;
import com.unu.edu.project_gestion_envios_backend.dto.generic.StatusResponse;
import com.unu.edu.project_gestion_envios_backend.utils.Constantes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<DataResponse<Void>> handleDataAccessException(DataAccessException ex) {
        log.error("Error de acceso a datos", ex);
        return buildErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR, Constantes.MENSAJE_ERROR_ACCESO_DATOS);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DataResponse<Void>> handleGenericException(Exception ex) {
        log.error("Error interno no controlado", ex);
        return buildErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR, Constantes.MENSAJE_ERROR_INTERNO);
    }

    private ResponseEntity<DataResponse<Void>> buildErrorResponse(
            HttpStatus httpStatus, String mensaje) {
        return ResponseEntity.status(httpStatus)
                .body(
                        DataResponse.<Void>builder()
                                .status(
                                        new StatusResponse(
                                                httpStatus.value(),
                                                Constantes.MENSAJE_ERROR,
                                                mensaje))
                                .build());
    }
}
