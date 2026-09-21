-- ==========================================================
-- 1. CIUDADES
-- ==========================================================
INSERT INTO ciudades (nombre, created_at, updated_at, created_by, updated_by)
SELECT d.nombre, NOW(), NULL, NULL, NULL
FROM (VALUES
          ('Pucallpa'),
          ('Lima'),
          ('Tingo María'),
          ('Huánuco')
     ) AS d(nombre)
WHERE NOT EXISTS (
    SELECT 1 FROM ciudades c WHERE c.nombre = d.nombre
);

-- ==========================================================
-- 2. AGENCIAS (1 por ciudad)
-- ==========================================================
INSERT INTO agencias (nombre, direccion, ciudad_id, created_at, updated_at, created_by, updated_by)
SELECT d.nombre, d.direccion, c.id, NOW(), NULL, NULL, NULL
FROM (VALUES
          ('Agencia Pucallpa Central', 'Jr. Ucayali 450', 'Pucallpa'),
          ('Agencia Lima Centro', 'Av. Javier Prado Este 2500', 'Lima'),
          ('Agencia Tingo María', 'Av. Alameda Perú 320', 'Tingo María'),
          ('Agencia Huánuco', 'Jr. Dos de Mayo 780', 'Huánuco')
     ) AS d(nombre, direccion, ciudad_nombre)
         JOIN ciudades c ON c.nombre = d.ciudad_nombre
WHERE NOT EXISTS (
    SELECT 1 FROM agencias a WHERE a.nombre = d.nombre
);

-- ==========================================================
-- 3. EMPLEADOS
-- Pucallpa (3): emp1 (ADMIN), emp2, emp3
-- Lima (3): emp4 (ADMIN), emp5, emp6
-- Tingo María (2): emp7, emp8
-- Huánuco (2): emp9, emp10
-- ==========================================================
INSERT INTO empleados (
    nombre, segundo_nombre, apellido_paterno, apellido_materno, dni, telefono,
    activo, rol, username, password, agencia_id, created_at, updated_at, created_by, updated_by
)
SELECT
    d.nombre, d.segundo_nombre, d.apellido_paterno, d.apellido_materno,
    d.dni, d.telefono, TRUE, d.rol, d.username, d.password,
    a.id, NOW(), NULL, NULL, NULL
FROM (VALUES
          -- Pucallpa (1 al 3)
          (1, 'Carlos', 'Alberto', 'Rojas', 'Mendoza', '71000001', '961000001', 'ADMINISTRADOR', 'crojas', '$2y$10$Fai/lgoHtIRx6kGszxS3iOFmRcJ.pukd0QTaouQuoFCLhttZHiVVy', 'Agencia Pucallpa Central'),
          (2, 'Ana', 'María', 'Sánchez', 'Torres', '71000002', '961000002', 'EMPLEADO', 'asanchez', '$2y$10$MRuGVQ7AwzdjXXlo8NVKjO0Ahz4BTt3AntlLJnW/v5HQxVuBbLdWG', 'Agencia Pucallpa Central'),
          (3, 'Marcos', NULL, 'Pinedo', 'Vega', '71000003', '961000003', 'EMPLEADO', 'mpinedo', '$2y$10$SolSl5Iy63eeTvd8JoeoZuYDsc/w3V5IotqL23YMTy/jOskhJwhge', 'Agencia Pucallpa Central'),

          -- Lima (4 al 6)
          (4, 'Roberto', 'Luis', 'García', 'Alva', '72000001', '981000001', 'ADMINISTRADOR', 'rgarcia', '$2y$10$E9zBrFaA0lD9DLJqH6ZgG.B5FlcBGTMAy7T8.JeRr.UScyvTi9eNW', 'Agencia Lima Centro'),
          (5, 'Lucía', 'Elena', 'Flores', 'Vargas', '72000002', '981000002', 'EMPLEADO', 'lflores', '$2y$10$JJwa8DkXzgzAbPnjj3VIPuB3Kazi7i7FPU0/a21709FCJsUFJVtQS', 'Agencia Lima Centro'),
          (6, 'Diego', NULL, 'Navarro', 'Castro', '72000003', '981000003', 'EMPLEADO', 'dnavarro', '$2y$10$FzkW4CnD5VUCreKg5VeCa.Oz4J6/4.M9tuYwgsYNSdiuKFsmHy626', 'Agencia Lima Centro'),

          -- Tingo María (7 y 8)
          (7, 'Jorge', 'Eduardo', 'Paredes', 'Rios', '73000001', '962000001', 'EMPLEADO', 'jparedes', '$2y$10$2DiUIicHqxRFE8LRtXeP.uRN1S18LZmIz1SClbtDin/L8VBQdMdG.', 'Agencia Tingo María'),
          (8, 'Rosa', 'Isabel', 'Gómez', 'Quispe', '73000002', '962000002', 'EMPLEADO', 'rgomez', '$2y$10$WVajbZ0PwDN90EpVFIH72OTQIeIBQ./WfHcbwImIA2jGuMG8I.55m', 'Agencia Tingo María'),

          -- Huánuco (9 y 10)
          (9, 'Manuel', 'Antonio', 'Dávila', 'Salazar', '74000001', '963000001', 'EMPLEADO', 'mdavila', '$2y$10$RIdDZ1rWYmQxtFWns4lmJO4eEREHXLYK3OoFZomaQXbIxdsjCD4hK', 'Agencia Huánuco'),
          (10, 'Katia', 'Paola', 'Morales', 'Cueva', '74000002', '963000002', 'EMPLEADO', 'kmorales', '$2y$10$aygy/kXM/AnK7FfTqBzLf.87.LIStTXScnfa33.1LocJY0qHwe3jO', 'Agencia Huánuco')
     ) AS d(orden_insert, nombre, segundo_nombre, apellido_paterno, apellido_materno, dni, telefono, rol, username, password, agencia_nombre)
         JOIN agencias a ON a.nombre = d.agencia_nombre
WHERE NOT EXISTS (
    SELECT 1 FROM empleados e WHERE e.dni = d.dni
)
ORDER BY d.orden_insert ASC;

-- ==========================================================
-- 4. CLIENTES (3 Clientes registrados por empleados)
-- ==========================================================
INSERT INTO clientes (nombre, segundo_nombre, apellido_paterno, apellido_materno, dni, telefono, activo, created_at, updated_at, created_by, updated_by)
SELECT
    d.nombre, d.segundo_nombre, d.apellido_paterno, d.apellido_materno,
    d.dni, d.telefono, TRUE, NOW(), NULL, e.id, NULL
FROM (VALUES
          ('Juan', 'Pedro', 'Benítez', 'Solano', '45123451', '955111222', 'crojas'),
          ('María', 'Fernanda', 'López', 'Ríos', '45123452', '955333444', 'crojas'),
          ('Carlos', NULL, 'Gutiérrez', 'Chávez', '45123453', '955555666', 'mdavila')
     ) AS d(nombre, segundo_nombre, apellido_paterno, apellido_materno, dni, telefono, emp_username)
         JOIN empleados e ON e.username = d.emp_username
WHERE NOT EXISTS (
    SELECT 1 FROM clientes c WHERE c.dni = d.dni
);

-- ==========================================================
-- 5. PAQUETES (5 Paquetes)
-- IDs esperados para el nro_rastreo: 01=Pucallpa, 02=Lima, 03=Tingo, 04=Huánuco
-- ==========================================================
INSERT INTO paquetes (
    numero_rastreo, remitente_id, destinatario_id, destinatario_nombre, destinatario_apellido, destinatario_dni,
    agencia_envio_id, agencia_destino_id, peso, es_fragil, estado_actual, observaciones,
    created_at, updated_at, created_by, updated_by
)
SELECT
    d.numero_rastreo, rem.id, dest.id, d.dest_nom, d.dest_ape, d.dest_dni,
    a_env.id, a_dest.id, d.peso, d.es_fragil, d.estado_actual, d.obs,
    NOW(), NULL, emp.id, NULL
FROM (VALUES
          -- Paq 1: Pucallpa -> Lima | Remitente: Cliente 2 | Creador: Emp 3 Pucallpa (mpinedo) | LISTO_PARA_RECOJO
          ('01023248', '45123452', '45123451', 'Juan', 'Benítez', '45123451', 'Agencia Pucallpa Central', 'Agencia Lima Centro', 4.50, FALSE, 'LISTO_PARA_RECOJO', 'Entrega urgente', 'mpinedo'),

          -- Paq 2: Pucallpa -> Tingo María | Remitente: Cliente 2 | Creador: Emp 2 Pucallpa (asanchez) | EN_CAMINO
          ('01037812', '45123452', '45123453', 'Carlos', 'Gutiérrez', '45123453', 'Agencia Pucallpa Central', 'Agencia Tingo María', 2.00, TRUE, 'EN_CAMINO', 'Contenido frágil de vidrio', 'asanchez'),

          -- Paq 3: Lima -> Pucallpa | Remitente: Cliente 1 | Creador: Emp 1 Lima (rgarcia) | EN_AGENCIA_ENVIO
          ('02019054', '45123451', '45123452', 'María', 'López', '45123452', 'Agencia Lima Centro', 'Agencia Pucallpa Central', 1.25, FALSE, 'EN_AGENCIA_ENVIO', 'Documentación legal', 'rgarcia'),

          -- Paq 4: Huánuco -> Tingo María | Remitente: Cliente 3 | Creador: Emp 2 Huánuco (kmorales) | EN_AGENCIA_DESTINO
          ('04036129', '45123453', '45123451', 'Juan', 'Benítez', '45123451', 'Agencia Huánuco', 'Agencia Tingo María', 8.10, FALSE, 'EN_AGENCIA_DESTINO', 'Caja de repuestos', 'kmorales'),

          -- Paq 5: Huánuco -> Pucallpa | Remitente: Cliente 3 | Creador: Emp 2 Huánuco (kmorales) | EN_CAMINO
          ('04018471', '45123453', '45123452', 'María', 'López', '45123452', 'Agencia Huánuco', 'Agencia Pucallpa Central', 3.00, FALSE, 'EN_CAMINO', 'Mercadería general', 'kmorales')
     ) AS d(numero_rastreo, remitente_dni, dest_dni_ref, dest_nom, dest_ape, dest_dni, ag_envio, ag_destino, peso, es_fragil, estado_actual, obs, emp_creador)
         JOIN clientes rem ON rem.dni = d.remitente_dni
         JOIN clientes dest ON dest.dni = d.dest_dni_ref
         JOIN agencias a_env ON a_env.nombre = d.ag_envio
         JOIN agencias a_dest ON a_dest.nombre = d.ag_destino
         JOIN empleados emp ON emp.username = d.emp_creador
WHERE NOT EXISTS (
    SELECT 1 FROM paquetes p WHERE p.numero_rastreo = d.numero_rastreo
);

-- ==========================================================
-- 6. HISTORIAL DE RASTREO
-- Flujo secuencial:
-- Paquete 1: EN_AGENCIA_ENVIO -> EN_CAMINO -> EN_AGENCIA_DESTINO -> LISTO_PARA_RECOJO
-- Paquete 2: EN_AGENCIA_ENVIO -> EN_CAMINO
-- Paquete 3: EN_AGENCIA_ENVIO
-- Paquete 4: EN_AGENCIA_ENVIO -> EN_CAMINO -> EN_AGENCIA_DESTINO
-- Paquete 5: EN_AGENCIA_ENVIO -> EN_CAMINO
-- ==========================================================
INSERT INTO historial_rastreo (
    paquete_id, estado, mensaje_estado, agencia_id, empleado_id, fecha_hora,
    created_at, updated_at, created_by, updated_by
)
SELECT
    p.id, d.estado, d.mensaje_estado, ag.id, emp.id, d.fecha_hora,
    NOW(), NULL, emp.id, NULL
FROM (VALUES
          -- Paquete 1 (01023248) -> Pucallpa a Lima (Listo para recojo)
          ('01023248', 'EN_AGENCIA_ENVIO', 'Registrado en agencia de origen', 'Agencia Pucallpa Central', 'mpinedo', NOW() - INTERVAL '3 day'),
          ('01023248', 'EN_CAMINO', 'El paquete está en camino a la agencia destino', 'Agencia Pucallpa Central', 'mpinedo', NOW() - INTERVAL '2 day'),
          ('01023248', 'EN_AGENCIA_DESTINO', 'Llegó a la agencia de destino', 'Agencia Lima Centro', 'lflores', NOW() - INTERVAL '1 day'),
          ('01023248', 'LISTO_PARA_RECOJO', 'Disponible en ventanilla para recojo', 'Agencia Lima Centro', 'rgarcia', NOW() - INTERVAL '4 hour'),

          -- Paquete 2 (01037812) -> Pucallpa a Tingo María (En camino)
          ('01037812', 'EN_AGENCIA_ENVIO', 'Registrado en agencia de origen', 'Agencia Pucallpa Central', 'asanchez', NOW() - INTERVAL '12 hour'),
          ('01037812', 'EN_CAMINO', 'El paquete está en camino a la agencia destino', 'Agencia Pucallpa Central', 'asanchez', NOW() - INTERVAL '6 hour'),

          -- Paquete 3 (02019054) -> Lima a Pucallpa (En agencia de envío)
          ('02019054', 'EN_AGENCIA_ENVIO', 'Registrado en agencia de origen', 'Agencia Lima Centro', 'rgarcia', NOW() - INTERVAL '2 hour'),

          -- Paquete 4 (04036129) -> Huánuco a Tingo María (En agencia destino)
          ('04036129', 'EN_AGENCIA_ENVIO', 'Registrado en agencia de origen', 'Agencia Huánuco', 'kmorales', NOW() - INTERVAL '24 hour'),
          ('04036129', 'EN_CAMINO', 'El paquete está en camino a la agencia destino', 'Agencia Huánuco', 'kmorales', NOW() - INTERVAL '18 hour'),
          ('04036129', 'EN_AGENCIA_DESTINO', 'Llegó a la agencia de destino', 'Agencia Tingo María', 'jparedes', NOW() - INTERVAL '2 hour'),

          -- Paquete 5 (04018471) -> Huánuco a Pucallpa (En camino)
          ('04018471', 'EN_AGENCIA_ENVIO', 'Registrado en agencia de origen', 'Agencia Huánuco', 'kmorales', NOW() - INTERVAL '8 hour'),
          ('04018471', 'EN_CAMINO', 'El paquete está en camino a la agencia destino', 'Agencia Huánuco', 'kmorales', NOW() - INTERVAL '3 hour')
     ) AS d(numero_rastreo, estado, mensaje_estado, agencia_nombre, emp_username, fecha_hora)
         JOIN paquetes p ON p.numero_rastreo = d.numero_rastreo
         JOIN agencias ag ON ag.nombre = d.agencia_nombre
         JOIN empleados emp ON emp.username = d.emp_username
WHERE NOT EXISTS (
    SELECT 1 FROM historial_rastreo hr
    WHERE hr.paquete_id = p.id AND hr.estado = d.estado
);


-- ==========================================================
-- ASIGNAR AL PRIMER EMPLEADO COMO RESPONSABLE DE CREACIÓN (created_by)
-- DE CIUDADES Y AGENCIAS
-- ==========================================================

-- 1. Actualizar ciudades
UPDATE ciudades
SET created_by = (
    SELECT id FROM empleados WHERE dni = '71000001' LIMIT 1
    )
WHERE created_by IS NULL;

-- 2. Actualizar agencias
UPDATE agencias
SET created_by = (
    SELECT id FROM empleados WHERE dni = '71000001' LIMIT 1
    )
WHERE created_by IS NULL;