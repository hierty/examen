CREATE TABLE IF NOT EXISTS incidencias (
    id INT(11) NOT NULL AUTO_INCREMENT,
    denunciante VARCHAR(100),
    urbanizacion VARCHAR(100),
    calle VARCHAR(100),
    referencias VARCHAR(100),
    descripcion VARCHAR(255),
    fecha DATETIME,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

-- Insertar 10 registros de ejemplo
INSERT INTO incidencias (denunciante, urbanizacion, calle, referencias, descripcion, fecha)
VALUES
    ('Juan Pérez', 'Ciudad Jardín', 'Calle A', 'Cerca del parque', 'Problema de iluminación', '2023-11-26 08:30:00'),
    ('María Gómez', 'Los Pinos', 'Calle B', 'Frente a la escuela', 'Bache en la carretera', '2023-11-26 09:15:00'),
    ('Carlos Rodríguez', 'Las Flores', 'Calle C', 'Esquina del mercado', 'Basura acumulada', '2023-11-26 10:00:00'),
    ('Ana Martínez', 'Villa Serena', 'Calle D', 'Al lado del centro comercial', 'Vandalismo en la parada de autobús', '2023-11-26 11:20:00'),
    ('Pedro Sánchez', 'El Bosque', 'Calle E', 'Frente a la iglesia', 'Semáforo dañado', '2023-11-26 12:45:00'),
    ('Laura Fernández', 'La Colina', 'Calle F', 'Cerca del hospital', 'Fuga de agua', '2023-11-26 14:00:00'),
    ('Miguel Ramos', 'Los Alamos', 'Calle G', 'Junto al colegio', 'Pintadas en la pared', '2023-11-26 15:30:00'),
    ('Isabel Torres', 'Mirador del Valle', 'Calle H', 'Detrás del cine', 'Árbol caído', '2023-11-26 16:45:00'),
    ('José López', 'La Cascada', 'Calle I', 'Cerca del río', 'Deslizamiento de tierra', '2023-11-26 17:30:00'),
    ('Elena Herrera', 'El Mirador', 'Calle J', 'Frente al mirador', 'Farola rota', '2023-11-26 18:15:00');