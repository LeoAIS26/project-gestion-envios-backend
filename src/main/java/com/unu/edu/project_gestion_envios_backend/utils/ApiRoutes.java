package com.unu.edu.project_gestion_envios_backend.utils;

public final class ApiRoutes {

    private ApiRoutes() {
    }

    public static final class PaqueteRoutes {

        private PaqueteRoutes() {
        }

        public static final String BASE = "/api/paquetes";
        public static final String LISTADO = BASE + "/listado";
        public static final String ADD = BASE;
    }

    public static final class ClienteRoutes {

        private ClienteRoutes() {
        }

        public static final String BASE = "/api/clientes";
        public static final String BY_DNI = "/dni";
    }

    public static final class AgenciasRoutes {

        private AgenciasRoutes() {
        }

        public static final String BASE = "/api/agencias";
    }
}
