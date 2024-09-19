-- Insertar tutores
INSERT INTO tutor (departamento, nombre, contraseña, email)
VALUES ('Matemáticas', 'Juan Pérez', 'password123', 'juan.perez@correo.com'),
       ('Ciencias', 'María García', 'password456', 'maria.garcia@correo.com'),
       ('Informática', 'Carlos López', 'password789', 'carlos.lopez@correo.com')
    ON CONFLICT (email) DO NOTHING;

-- Insertar cursos
INSERT INTO curso (nombre_curso, descripcion, estado, valoracion)
VALUES ('Curso de Matemáticas Avanzadas', 'Un curso sobre álgebra y cálculo', 'PUBLICADO', 5),
       ('Introducción a la Biología', 'Conceptos básicos de biología', 'NO_PUBLICADO', 4),
       ('Desarrollo Web', 'Aprende a desarrollar páginas web', 'PUBLICADO', 5)
    ON CONFLICT (nombre_curso) DO NOTHING;

-- Insertar estudiantes
INSERT INTO estudiante (ciclo, nombre, contraseña, email)
VALUES (3, 'Pedro Sánchez', 'clave123', 'pedro.sanchez@correo.com'),
       (2, 'Ana Fernández', 'clave456', 'ana.fernandez@correo.com'),
       (1, 'Luis Torres', 'clave789', 'luis.torres@correo.com')
    ON CONFLICT (email) DO NOTHING;

-- Insertar asignaciones de estudiante a curso
INSERT INTO estudiante_curso (id_estudiante, id_curso, fecha)
VALUES (1, 1, '2024-09-01'),
       (2, 2, '2024-09-02'),
       (3, 3, '2024-09-03')
    ON CONFLICT (id_estudiante, id_curso) DO NOTHING;

INSERT INTO progreso (porcentaje, fecha_ultimo_acceso, id_estudiante, id_curso)
VALUES (50.0, '2024-09-10', 1, 1),
       (75.0, '2024-09-12', 2, 2),
       (100.0, '2024-09-15', 3, 3)
    ON CONFLICT (id_estudiante, id_curso) DO NOTHING;


-- Insertar materiales
INSERT INTO material (titulo, tipo, fecha_subida, curso_id)
VALUES ('Álgebra Avanzada', 'PDF', '2024-09-01', 1),
       ('Biología Celular', 'VIDEO', '2024-09-02', 2),
       ('Desarrollo Web: HTML', 'TEXTO', '2024-09-03', 3)
    ON CONFLICT (titulo, curso_id) DO NOTHING;

-- Insertar notas
INSERT INTO nota (texto, fecha, material_id)
VALUES ('Nota sobre álgebra', '2024-09-05', 1),
       ('Resumen de biología celular', '2024-09-06', 2),
       ('Tarea sobre HTML', '2024-09-07', 3)
    ON CONFLICT (material_id, fecha) DO NOTHING;

-- Insertar comentarios
-- Insertar comentarios sin especificar el campo id, dejando que se genere automáticamente
INSERT INTO comentario (texto, fecha, curso_id)
VALUES ('Muy buen curso de matemáticas', '2024-09-08', 1),
       ('Curso interesante sobre biología', '2024-09-09', 2),
       ('El curso de desarrollo web es excelente', '2024-09-10', 3)
    ON CONFLICT (id) DO NOTHING;


-- Insertar pagos
INSERT INTO pago (fecha_pago, monto_total)
VALUES ('2024-09-11', 2000.0),
       ('2024-09-12', 2250.0),
       ('2024-09-13', 2160.0)
    ON CONFLICT (fecha_pago) DO NOTHING;

-- Insertar detalles de pago
INSERT INTO detalle_pago (descripcion, cantidad_estudiantes, precio_por_estudiante, id_pago)
VALUES ('Pago por curso de matemáticas', 10, 200.0, 1),
       ('Pago por curso de biología', 15, 150.0, 2),
       ('Pago por curso de desarrollo web', 12, 180.0, 3)
    ON CONFLICT (id_pago, descripcion) DO NOTHING;

-- Insertar asignaciones de curso a tutor
INSERT INTO curso_tutor (id_curso, id_tutor, fecha_asignacion, fecha_termino)
VALUES (1, 1, '2024-09-01', '2024-12-01'),
       (2, 2, '2024-09-01', '2024-12-01'),
       (3, 3, '2024-09-01', '2024-12-01')
    ON CONFLICT (id_curso, id_tutor) DO NOTHING

