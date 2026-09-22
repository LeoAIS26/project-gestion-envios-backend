package com.unu.edu.project_gestion_envios_backend.utils.mapper;

import com.unu.edu.project_gestion_envios_backend.dto.request.PaqueteRequest;
import com.unu.edu.project_gestion_envios_backend.model.Paquete;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaqueteMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "id", ignore = true)
    Paquete mapToModel(PaqueteRequest paqueteRequest);
}
