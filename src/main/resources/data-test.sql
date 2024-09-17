INSERT INTO usuario (id, email, contraseña, rol)
VALUES ('U001', 'juan@example.com', 'password123', 'ESTUDIANTE')
    ON CONFLICT (email) DO NOTHING;

INSERT INTO estudiante (id, email, nombre, matricula, usuario_id)
VALUES ('E001', 'juan@example.com', 'Juan Perez', '2021001', 'U001')
    ON CONFLICT (email) DO NOTHING;

INSERT INTO curso (id, titulo, descripcion)
VALUES (1, 'Matemáticas Avanzadas', 'Curso de matemáticas nivel avanzado')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO estudiante_curso (email_estudiante, id_curso)
VALUES ('juan@example.com', 1)
    ON CONFLICT (email_estudiante, id_curso) DO NOTHING;

INSERT INTO progreso (id, porcentaje, estado, estudiante_id, curso_id)
VALUES ('P001', 75.0, 'EN_PROGRESO', 'E001', 1)
    ON CONFLICT (id) DO NOTHING;

INSERT INTO suscripcion (id, usuario_id, tipo, fecha_inicio, fecha_expiracion)
VALUES ('S001', 'U001', 'PERSONAL', '2024-01-01', '2024-12-31')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO material (id, titulo, tipo, fecha_subida, curso_id)
VALUES (1, 'PDF de Álgebra Lineal', 'PDF', '2024-02-01', 1)
    ON CONFLICT (id) DO NOTHING;

INSERT INTO comentario (id, texto, fecha, email_estudiante, id_material)
VALUES ('C001', 'Este PDF me ayudó mucho a entender el tema', '2024-02-10', 'juan@example.com', 1)
    ON CONFLICT (id) DO NOTHING;
