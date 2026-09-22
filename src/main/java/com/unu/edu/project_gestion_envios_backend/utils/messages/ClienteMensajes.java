package com.unu.edu.project_gestion_envios_backend.utils.messages;

public final class ClienteMensajes {

    private ClienteMensajes() {
    }

    public static final String NOT_FOUND_BY_DNI = "Cliente no encontrado por el DNI";

    public static final String NOMBRE_OBLIGATORIO = "El nombre es obligatorio";
    public static final String NOMBRE_SIZE = "El nombre no puede superar los 20 caracteres";

    public static final String SEGUNDO_NOMBRE_SIZE = "El segundo nombre no puede superar los 20 caracteres";

    public static final String APELLIDO_PATERNO_OBLIGATORIO = "El apellido paterno es obligatorio";
    public static final String APELLIDO_PATERNO_SIZE = "El apellido paterno no puede superar los 30 caracteres";

    public static final String APELLIDO_MATERNO_OBLIGATORIO = "El apellido materno es obligatorio";
    public static final String APELLIDO_MATERNO_SIZE = "El apellido materno no puede superar los 30 caracteres";

    public static final String DNI_OBLIGATORIO = "El DNI es obligatorio";
    public static final String DNI_FORMATO = "El DNI debe tener exactamente 8 dígitos";

    public static final String TELEFONO_OBLIGATORIO = "El teléfono es obligatorio";
    public static final String TELEFONO_FORMATO = "El teléfono debe tener exactamente 9 dígitos";

    public static final String ACTIVO_OBLIGATORIO = "El estado activo es obligatorio";

}