--rellenando la tabla
-- Insertar datos en CLIENTE
INSERT INTO CLIENTE (nombre, email, telefono) VALUES 
('Juan Pérez', 'juan.perez@example.com', '555-1234'),
('María López', 'maria.lopez@example.com', '555-5678'),
('Carlos García', 'carlos.garcia@example.com', '555-9101'),
('Ana Torres', 'ana.torres@example.com', '555-1122');

-- Insertar datos en EQUIPO
INSERT INTO EQUIPO (tipo_equipo, marca, modelo, numero_serie, id_cliente) VALUES 
('Laptop', 'Dell', 'XPS 13', 'SN123456', 1),
('Smartphone', 'Samsung', 'Galaxy S21', 'SN789101', 2),
('Tablet', 'Apple', 'iPad Pro', 'SN112233', 3),
('PC', 'HP', 'Pavilion', 'SN445566', 4);

-- Insertar datos en ESTADO_REPARACION
INSERT INTO ESTADO_REPARACION (descripcion) VALUES 
('En revisión'),
('En proceso de reparación'),
('Pendiente de repuestos'),
('Reparación completa'),
('Entregado al cliente');

-- Insertar datos en EMPLEADO
INSERT INTO EMPLEADO (nombre, email, telefono, clave) VALUES 
('Roberto Fernández', 'roberto.fernandez@example.com', '555-2233', 'clave123'),
('Elena Martínez', 'elena.martinez@example.com', '555-3344', 'clave456'),
('Luis Gómez', 'luis.gomez@example.com', '555-4455', 'clave789');

-- Insertar datos en REPARACION
INSERT INTO REPARACION (id_equipo, id_empleado, id_estado, fecha_inicio, fecha_entrega, descripcion_problema, descripcion_reparacion, costo_reparacion, costo_mano_obra, fecha_entrega_estimada, estado_actual) VALUES 
(1, 1, 1, '2024-11-01 10:00:00', NULL, 'La pantalla no enciende', NULL, NULL, 50.00, '2024-11-07 10:00:00', 'En revisión'),
(2, 2, 2, '2024-11-02 11:00:00', NULL, 'Problemas con la batería', 'Cambio de batería', 30.00, 20.00, '2024-11-08 11:00:00', 'En proceso de reparación'),
(3, 3, 3, '2024-11-03 12:00:00', NULL, 'El equipo se calienta mucho', 'Reemplazo de ventilador', 40.00, 25.00, '2024-11-10 12:00:00', 'Pendiente de repuestos'),
(4, 1, 4, '2024-11-04 13:00:00', '2024-11-05 15:00:00', 'El equipo no enciende', 'Reemplazo de fuente de poder', 100.00, 50.00, '2024-11-06 15:00:00', 'Reparación completa');

-- Insertar datos en METODO
INSERT INTO METODO (descripcion) VALUES 
('Efectivo'),
('Tarjeta de crédito'),
('Transferencia bancaria');

-- Insertar datos en PAGO
INSERT INTO PAGO (id_reparacion, id_metodo, fecha, importe) VALUES 
(1, 1, '2024-11-01 10:30:00', 25.00),
(2, 2, '2024-11-02 11:30:00', 20.00),
(3, 3, '2024-11-03 12:30:00', 30.00),
(4, 1, '2024-11-04 13:30:00', 75.00);

-- Insertar datos en ITEM
INSERT INTO ITEM (nombre, descripcion, costo) VALUES 
('Pantalla LCD', 'Pantalla de repuesto para laptop', 150.00),
('Batería', 'Batería compatible con modelos Samsung Galaxy', 30.00),
('Ventilador', 'Ventilador de repuesto para tablet', 20.00),
('Fuente de poder', 'Fuente de poder para PC HP', 60.00);

-- Insertar datos en REPARACION_ITEM
INSERT INTO REPARACION_ITEM (id_reparacion, id_item, cantidad) VALUES 
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 1);

-- Insertar datos en ADELANTO
INSERT INTO ADELANTO (id_reparacion, monto, fecha) VALUES 
(1, 25.00, '2024-11-01 10:30:00'),
(2, 20.00, '2024-11-02 11:30:00'),
(3, 15.00, '2024-11-03 12:30:00'),
(4, 50.00, '2024-11-04 13:30:00');

-- Insertar datos en RECIBO
INSERT INTO RECIBO (id_reparacion, costo_total, adelanto, pago_final, fecha) VALUES 
(1, 100.00, 25.00, 75.00, '2024-11-07 10:00:00'),
(2, 70.00, 20.00, 50.00, '2024-11-08 11:00:00'),
(3, 65.00, 15.00, 50.00, '2024-11-10 12:00:00'),
(4, 150.00, 50.00, 100.00, '2024-11-06 15:00:00');

