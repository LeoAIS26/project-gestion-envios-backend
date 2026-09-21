-- ==========================================================
-- 1. CIUDADES
-- ==========================================================
INSERT INTO public.ciudades (created_at, updated_at, nombre)
SELECT now(), NULL, v.nombre
FROM (VALUES
          ('Lima'),
          ('Pucallpa'),
          ('Tingo María'),
          ('Huánuco')
     ) AS v(nombre)
WHERE NOT EXISTS (
    SELECT 1 FROM public.ciudades c WHERE c.nombre = v.nombre
);

-- ==========================================================
-- 2. AGENCIAS (1 por cada ciudad)
-- ==========================================================
INSERT INTO public.agencias (created_at, updated_at, ciudad_id, direccion, nombre)
SELECT now(), NULL, c.id, v.direccion, v.nombre
FROM (VALUES
          ('Agencia Pucallpa Central', 'Pucallpa', 'Av. San Martín 450'),
          ('Agencia Tingo María', 'Tingo María', 'Av. Alameda Perú 230'),
          ('Agencia Lima Centro', 'Lima', 'Av. Nicolás de Piérola 1020'),
          ('Agencia Huánuco Principal', 'Huánuco', 'Jr. Dos de Mayo 640')
     ) AS v(nombre, ciudad_nombre, direccion)
         JOIN public.ciudades c ON c.nombre = v.ciudad_nombre
WHERE NOT EXISTS (
    SELECT 1 FROM public.agencias a WHERE a.nombre = v.nombre
);

-- ==========================================================
-- 3. USUARIOS (3 Clientes sin agencia/login, 10 Empleados)
-- ==========================================================
INSERT INTO public.usuarios (
    created_at, updated_at, activo, agencia_id,
    apellido_materno, apellido_paterno, dni, nombre,
    "password", rol, segundo_nombre, telefono, username
)
SELECT
    now(), NULL, v.activo, a.id,
    v.apellido_materno, v.apellido_paterno, v.dni, v.nombre,
    v.password, v.rol, v.segundo_nombre, v.telefono, v.username
FROM (VALUES
          -- 3 Clientes (sin login ni agencia asociada)
          ('CLIENTE_1', 'Juan', 'Carlos', 'Pérez', 'Gómez', '45892101', '961000101', NULL, NULL, 'CLIENTE', true, NULL),
          ('CLIENTE_2', 'María', 'Elena', 'Torres', 'Ríos', '46982302', '961000102', NULL, NULL, 'CLIENTE', true, NULL),
          ('CLIENTE_3', 'Carlos', 'Alberto', 'Ramírez', 'Vargas', '47891203', '961000103', NULL, NULL, 'CLIENTE', true, NULL),

          -- Empleados Pucallpa (3 empleados: 1 admin + 2 empleados)
          ('EMP_PUC_1', 'Luis', 'Alberto', 'Mendoza', 'Sánchez', '71000101', '961111001', 'lmendoza', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'ADMINISTRADOR', true, 'Agencia Pucallpa Central'),
          ('EMP_PUC_2', 'Ana', 'Lucía', 'Fernández', 'Ruiz', '71000102', '961111002', 'afernandez', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'EMPLEADO', true, 'Agencia Pucallpa Central'),
          ('EMP_PUC_3', 'Jorge', 'Antonio', 'Rojas', 'Castro', '71000103', '961111003', 'jrojas', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'EMPLEADO', true, 'Agencia Pucallpa Central'),

          -- Empleados Lima (3 empleados: 1 admin + 2 empleados)
          ('EMP_LIM_1', 'Pedro', 'Jesús', 'Vásquez', 'Mejía', '72000101', '961222001', 'pvasquez', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'EMPLEADO', true, 'Agencia Lima Centro'),
          ('EMP_LIM_2', 'Sofía', 'Beatriz', 'Morales', 'Paz', '72000102', '961222002', 'smorales', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'EMPLEADO', true, 'Agencia Lima Centro'),
          ('EMP_LIM_3', 'Ricardo', 'Andrés', 'Chávez', 'Alva', '72000103', '961222003', 'rchavez', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'ADMINISTRADOR', true, 'Agencia Lima Centro'),

          -- Empleados Tingo María (2 empleados)
          ('EMP_TM_1', 'Rosa', 'Isabel', 'Cruz', 'Salas', '73000101', '961333001', 'rcruz', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'EMPLEADO', true, 'Agencia Tingo María'),
          ('EMP_TM_2', 'Diego', 'Paul', 'Salazar', 'Bello', '73000102', '961333002', 'dsalazar', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'EMPLEADO', true, 'Agencia Tingo María'),

          -- Empleados Huánuco (2 empleados)
          ('EMP_HCO_1', 'Miriam', 'Janet', 'Torres', 'Vega', '74000101', '961444001', 'mtorres', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'EMPLEADO', true, 'Agencia Huánuco Principal'),
          ('EMP_HCO_2', 'Víctor', 'Hugo', 'Paredes', 'Díaz', '74000102', '961444002', 'vparedes', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'EMPLEADO', true, 'Agencia Huánuco Principal')
     ) AS v(ref, nombre, segundo_nombre, apellido_paterno, apellido_materno, dni, telefono, username, password, rol, activo, agencia_nombre)
         LEFT JOIN public.agencias a ON a.nombre = v.agencia_nombre
WHERE NOT EXISTS (
    SELECT 1 FROM public.usuarios u WHERE u.dni = v.dni
);

-- ==========================================================
-- 4. PAQUETES (5 paquetes con formato de rastreo: OO DD RRRR)
-- ==========================================================
INSERT INTO public.paquetes (
    created_at, updated_at, agencia_envio_id, agencia_destino_id,
    remitente_id, destinatario_id, destinatario_nombre, destinatario_apellido,
    destinatario_dni, es_fragil, estado_actual, numero_rastreo, observaciones, peso
)
SELECT
    now(), NULL, ae.id, ad.id,
    rem.id, dest.id, dest.nombre, dest.apellido_paterno,
    dest.dni, v.es_fragil, v.estado_actual, v.numero_rastreo, v.observaciones, v.peso
FROM (VALUES
          -- 1. Pucallpa -> Lima | Remitente: Cliente 2 | Estado: LISTO_PARA_RECOJO
          ('01034821', 'Agencia Pucallpa Central', 'Agencia Lima Centro', '46982302', '45892101', false, 'LISTO_PARA_RECOJO', 'Documentación legal', 1.5),
          -- 2. Pucallpa -> Tingo María | Remitente: Cliente 2 | Estado: EN_AGENCIA_ENVIO
          ('01027593', 'Agencia Pucallpa Central', 'Agencia Tingo María', '46982302', '47891203', true, 'EN_AGENCIA_ENVIO', 'Caja de cerámicas', 3.2),
          -- 3. Lima -> Pucallpa | Remitente: Cliente 1 | Estado: EN_AGENCIA_ENVIO
          ('03011942', 'Agencia Lima Centro', 'Agencia Pucallpa Central', '45892101', '46982302', false, 'EN_AGENCIA_ENVIO', 'Repuestos de cómputo', 5.0),
          -- 4. Huánuco -> Tingo María | Remitente: Cliente 3 | Estado: EN_AGENCIA_DESTINO
          ('04028315', 'Agencia Huánuco Principal', 'Agencia Tingo María', '47891203', '45892101', false, 'EN_AGENCIA_DESTINO', 'Prendas de vestir', 2.8),
          -- 5. Huánuco -> Pucallpa | Remitente: Cliente 3 | Estado: EN_CAMINO
          ('04016207', 'Agencia Huánuco Principal', 'Agencia Pucallpa Central', '47891203', '46982302', true, 'EN_CAMINO', 'Equipo electrónico', 4.5)
     ) AS v(numero_rastreo, ag_envio, ag_dest, remitente_dni, dest_dni, es_fragil, estado_actual, observaciones, peso)
         JOIN public.agencias ae ON ae.nombre = v.ag_envio
         JOIN public.agencias ad ON ad.nombre = v.ag_dest
         JOIN public.usuarios rem ON rem.dni = v.remitente_dni
         JOIN public.usuarios dest ON dest.dni = v.dest_dni
WHERE NOT EXISTS (
    SELECT 1 FROM public.paquetes p WHERE p.numero_rastreo = v.numero_rastreo
);

-- ==========================================================
-- 5. HISTORIAL DE RASTREO
-- ==========================================================
INSERT INTO public.historial_rastreo (
    created_at, updated_at, agencia_id, empleado_id,
    estado, fecha_hora, mensaje_estado, paquete_id
)
SELECT
    now(), NULL, a.id, e.id,
    v.estado, v.fecha_hora, v.mensaje_estado, p.id
FROM (VALUES
          -- Paquete 1 (01034821): Pucallpa -> Lima
          ('01034821', 'Agencia Pucallpa Central', '71000103', 'EN_AGENCIA_ENVIO', now() - INTERVAL '3 days', 'Registrado en agencia de origen'),
          ('01034821', 'Agencia Pucallpa Central', '71000103', 'EN_CAMINO', now() - INTERVAL '2 days', 'El paquete está en camino a la agencia destino'),
          ('01034821', 'Agencia Lima Centro', '72000101', 'EN_AGENCIA_DESTINO', now() - INTERVAL '1 day', 'Llegó a la agencia de destino'),
          ('01034821', 'Agencia Lima Centro', '72000101', 'LISTO_PARA_RECOJO', now() - INTERVAL '5 hours', 'Disponible en ventanilla para recojo'),

          -- Paquete 2 (01027593): Pucallpa -> Tingo María
          ('01027593', 'Agencia Pucallpa Central', '71000102', 'EN_AGENCIA_ENVIO', now() - INTERVAL '4 hours', 'Registrado en agencia de origen'),

          -- Paquete 3 (03011942): Lima -> Pucallpa
          ('03011942', 'Agencia Lima Centro', '72000101', 'EN_AGENCIA_ENVIO', now() - INTERVAL '6 hours', 'Registrado en agencia de origen'),

          -- Paquete 4 (04028315): Huánuco -> Tingo María
          ('04028315', 'Agencia Huánuco Principal', '74000102', 'EN_AGENCIA_ENVIO', now() - INTERVAL '2 days', 'Registrado en agencia de origen'),
          ('04028315', 'Agencia Huánuco Principal', '74000102', 'EN_CAMINO', now() - INTERVAL '1 day', 'El paquete está en camino a la agencia destino'),
          ('04028315', 'Agencia Tingo María', '73000101', 'EN_AGENCIA_DESTINO', now() - INTERVAL '2 hours', 'Llegó a la agencia de destino'),

          -- Paquete 5 (04016207): Huánuco -> Pucallpa
          ('04016207', 'Agencia Huánuco Principal', '74000102', 'EN_AGENCIA_ENVIO', now() - INTERVAL '18 hours', 'Registrado en agencia de origen'),
          ('04016207', 'Agencia Huánuco Principal', '74000102', 'EN_CAMINO', now() - INTERVAL '8 hours', 'El paquete está en camino a la agencia destino')
     ) AS v(numero_rastreo, agencia_nombre, empleado_dni, estado, fecha_hora, mensaje_estado)
         JOIN public.paquetes p ON p.numero_rastreo = v.numero_rastreo
         JOIN public.agencias a ON a.nombre = v.agencia_nombre
         JOIN public.usuarios e ON e.dni = v.empleado_dni
WHERE NOT EXISTS (
    SELECT 1 FROM public.historial_rastreo hr
    WHERE hr.paquete_id = p.id AND hr.estado = v.estado
);