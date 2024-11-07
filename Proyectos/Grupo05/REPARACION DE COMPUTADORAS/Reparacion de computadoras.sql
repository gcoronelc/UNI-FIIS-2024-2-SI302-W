-- Creación de la base de datos
CREATE DATABASE TiendaReparaciones2;
USE TiendaReparaciones2;

-- Tabla CLIENTE
CREATE TABLE CLIENTE (
    id_cliente INT PRIMARY KEY IDENTITY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL
);

-- Tabla EQUIPO
CREATE TABLE EQUIPO (
    id_equipo INT PRIMARY KEY IDENTITY,
    tipo_equipo VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    numero_serie VARCHAR(50) NOT NULL UNIQUE,
    id_cliente INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES CLIENTE(id_cliente)
);

-- Tabla ESTADO_REPARACION
CREATE TABLE ESTADO_REPARACION (
    id_estado INT PRIMARY KEY IDENTITY,
    descripcion VARCHAR(50) NOT NULL
);

-- Tabla EMPLEADO
CREATE TABLE EMPLEADO (
    id_empleado INT PRIMARY KEY IDENTITY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    clave VARCHAR(20) NOT NULL
);

-- Tabla REPARACION
CREATE TABLE REPARACION (
    id_reparacion INT PRIMARY KEY IDENTITY,
    id_equipo INT NOT NULL,
    id_empleado INT NULL,
    id_estado INT NOT NULL,
    fecha_inicio DATETIME NOT NULL,
    fecha_entrega DATETIME NULL,
    descripcion_problema TEXT NOT NULL,
    descripcion_reparacion TEXT,
    costo_reparacion DECIMAL(10, 2),
    FOREIGN KEY (id_equipo) REFERENCES EQUIPO(id_equipo),
    FOREIGN KEY (id_empleado) REFERENCES EMPLEADO(id_empleado),
    FOREIGN KEY (id_estado) REFERENCES ESTADO_REPARACION(id_estado)
);

-- Tabla METODO
CREATE TABLE METODO (
    id_metodo INT PRIMARY KEY IDENTITY,
    descripcion VARCHAR(50) NOT NULL
);

-- Tabla PAGO
CREATE TABLE PAGO (
    id_pago INT PRIMARY KEY IDENTITY,
    id_reparacion INT NOT NULL,
    id_metodo INT NOT NULL,
    fecha DATETIME NOT NULL,
    importe DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_reparacion) REFERENCES REPARACION(id_reparacion),
    FOREIGN KEY (id_metodo) REFERENCES METODO(id_metodo)
);

-- Tabla ITEM (para registrar piezas, componentes y materiales utilizados en cada reparación)
CREATE TABLE ITEM (
    id_item INT PRIMARY KEY IDENTITY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    costo DECIMAL(10, 2) NOT NULL
);

-- Tabla REPARACION_ITEM (para registrar los ítems utilizados en cada reparación)
CREATE TABLE REPARACION_ITEM (
    id_reparacion INT NOT NULL,
    id_item INT NOT NULL,
    cantidad INT NOT NULL,
    FOREIGN KEY (id_reparacion) REFERENCES REPARACION(id_reparacion),
    FOREIGN KEY (id_item) REFERENCES ITEM(id_item),
    PRIMARY KEY (id_reparacion, id_item)
);

-- Tabla ADELANTO (para registrar los adelantos de los clientes)
CREATE TABLE ADELANTO (
    id_adelanto INT PRIMARY KEY IDENTITY,
    id_reparacion INT NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    fecha DATETIME NOT NULL,
    FOREIGN KEY (id_reparacion) REFERENCES REPARACION(id_reparacion)
);

-- Agregar columnas adicionales a la tabla REPARACION
ALTER TABLE REPARACION
ADD 
    costo_mano_obra DECIMAL(10, 2),
    fecha_entrega_estimada DATETIME,
    estado_actual VARCHAR(50);

-- Crear una tabla RECIBO para detallar el recibo final
CREATE TABLE RECIBO (
    id_recibo INT PRIMARY KEY IDENTITY,
    id_reparacion INT NOT NULL,
    costo_total DECIMAL(10, 2) NOT NULL,
    adelanto DECIMAL(10, 2) NOT NULL,
    pago_final DECIMAL(10, 2) NOT NULL,
    fecha DATETIME NOT NULL,
    FOREIGN KEY (id_reparacion) REFERENCES REPARACION(id_reparacion)
);
