package com.unu.edu.project_gestion_envios_backend.utils.messages;

public final class PaqueteMensajes {

    private PaqueteMensajes() {
    }

    public static final String NUMERO_RASTREO_OBLIGATORIO = "El número de rastreo es obligatorio";
    public static final String NUMERO_RASTREO_MAX_LENGTH = "El número de rastreo no debe exceder los 10 caracteres";

    public static final String REMITENTE_ID_OBLIGATORIO = "El ID del remitente es obligatorio";
    public static final String REMITENTE_ID_INVALIDO = "El ID del remitente debe ser válido";

    public static final String DESTINATARIO_ID_INVALIDO = "El ID del destinatario debe ser válido";

    public static final String DESTINATARIO_NOMBRE_OBLIGATORIO = "El nombre del destinatario es obligatorio";
    public static final String DESTINATARIO_NOMBRE_MAX_LENGTH = "El nombre del destinatario no debe exceder los 20 caracteres";

    public static final String DESTINATARIO_APELLIDO_OBLIGATORIO = "El apellido del destinatario es obligatorio";
    public static final String DESTINATARIO_APELLIDO_MAX_LENGTH = "El apellido del destinatario no debe exceder los 30 caracteres";

    public static final String DESTINATARIO_DNI_OBLIGATORIO = "El DNI del destinatario es obligatorio";
    public static final String DESTINATARIO_DNI_FORMATO = "El DNI debe contener exactamente 8 dígitos numéricos";

    public static final String AGENCIA_ENVIO_ID_OBLIGATORIO = "La agencia de envío es obligatoria";
    public static final String AGENCIA_ENVIO_ID_INVALIDO = "El ID de la agencia de envío debe ser válido";

    public static final String AGENCIA_DESTINO_ID_OBLIGATORIO = "La agencia de destino es obligatoria";
    public static final String AGENCIA_DESTINO_ID_INVALIDO = "El ID de la agencia de destino debe ser válido";

    public static final String PESO_OBLIGATORIO = "El peso es obligatorio";
    public static final String PESO_MINIMO = "El peso debe ser mayor a 0";
    public static final String PESO_DIGITOS = "El peso debe tener como máximo 8 enteros y 2 decimales";

    public static final String ES_FRAGIL_OBLIGATORIO = "Debe indicar si el paquete es frágil";

    public static final String ESTADO_ACTUAL_OBLIGATORIO = "El estado actual es obligatorio";
}