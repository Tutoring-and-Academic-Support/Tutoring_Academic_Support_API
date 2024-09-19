-- Insert usuarios
INSERT INTO usuario (id, email, contraseña, rol)
VALUES ('1', 'admin@example.com', 'hashed_password', 'ADMINISTRADOR')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO usuario (id, email, contraseña, rol)
VALUES ('2', 'tutor@example.com', 'hashed_password', 'TUTOR')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO usuario (id, email, contraseña, rol)
VALUES ('3', 'estudiante@example.com', 'hashed_password', 'ESTUDIANTE')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO usuario (id, email, contraseña, rol)
VALUES ('4', 'profesor1@example.com', 'hashed_password_profesor', 'TUTOR')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO usuario (id, email, contraseña, rol)
VALUES ('5', 'estudiante2@example.com', 'hashed_password_estudiante', 'ESTUDIANTE')
    ON CONFLICT (id) DO NOTHING;

-- Insert administrador
INSERT INTO administrador (id, email, nivel, usuario_id)
VALUES ('1', 'admin@example.com', 'Senior', '1')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO administrador (id, email, nivel, usuario_id)
VALUES ('2', 'admin2@example.com', 'Junior', '4')
    ON CONFLICT (id) DO NOTHING;

-- Insert tutor
INSERT INTO tutor (id, email, nombre, departamento, usuario_email)
VALUES ('2', 'tutor@example.com', 'John Doe', 'Ingeniería de Software', 'tutor@example.com')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO tutor (id, email, nombre, departamento, usuario_email)
VALUES ('3', 'profesor1@example.com', 'Dr. Ana Torres', 'Ingeniería Informática', 'profesor1@example.com')
    ON CONFLICT (id) DO NOTHING;

-- Insert estudiante
INSERT INTO estudiante (id, email, nombre, matricula, usuario_id)
VALUES ('3', 'estudiante@example.com', 'Jane Smith', '20210001', '3')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO estudiante (id, email, nombre, matricula, usuario_id)
VALUES ('4', 'estudiante2@example.com', 'Carlos Ramos', '20220002', '5')
    ON CONFLICT (id) DO NOTHING;

-- Insert cursos
INSERT INTO curso (id, titulo, descripcion)
VALUES ('1', 'Introducción a la Programación', 'Curso básico de programación en Java')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO curso (id, titulo, descripcion)
VALUES ('3', 'Sistemas Operativos', 'Curso sobre el diseño e implementación de sistemas operativos')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO curso (id, titulo, descripcion)
VALUES ('4', 'Redes de Computadoras', 'Curso sobre redes y protocolos de comunicación')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO curso (id, titulo, descripcion)
VALUES ('2', 'Base de Datos Avanzadas', 'Curso sobre bases de datos relacionales y no relacionales')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO curso (id, titulo, descripcion)
VALUES ('3', 'Sistemas Operativos', 'Curso sobre el diseño e implementación de sistemas operativos')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO curso (id, titulo, descripcion)
VALUES ('4', 'Redes de Computadoras', 'Curso sobre redes y protocolos de comunicación')
    ON CONFLICT (id) DO NOTHING;

-- Insert materiales
INSERT INTO material (id, titulo, tipo, fecha_subida, curso_id)
VALUES ('1', 'Capítulo 1 - Introducción', 'PDF', '2024-09-18', '1')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO material (id, titulo, tipo, fecha_subida, curso_id)
VALUES ('2', 'Ejercicio Práctico 1', 'VIDEO', '2024-09-18', '2')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO material (id, titulo, tipo, fecha_subida, curso_id)
VALUES ('3', 'Capítulo 2 - Memoria Virtual', 'PDF', '2024-09-19', '3')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO material (id, titulo, tipo, fecha_subida, curso_id)
VALUES ('4', 'Clase práctica de Redes', 'VIDEO', '2024-09-19', '4')
    ON CONFLICT (id) DO NOTHING;

-- Insert comentario
INSERT INTO comentario (id, texto, fecha, id_estudiante, id_material)
VALUES ('1', 'Este material fue muy útil, gracias.', '2024-09-18', '3', '1')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO comentario (id, texto, fecha, id_estudiante, id_material)
VALUES ('2', 'El video de redes fue muy claro.', '2024-09-20', '4', '4')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO comentario (id, texto, fecha, id_estudiante, id_material)
VALUES ('3', 'Me sirvió mucho el capítulo de Memoria Virtual.', '2024-09-21', '3', '3')
    ON CONFLICT (id) DO NOTHING;

-- Insert progreso
INSERT INTO progreso (id, id_estudiante, curso_id, porcentaje, estado)
VALUES ('1', '3', '1', 0.75, 'EN_PROGRESO')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO progreso (id, id_estudiante, curso_id, porcentaje, estado)
VALUES ('2', '4', '3', 0.85, 'EN_PROGRESO')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO progreso (id, id_estudiante, curso_id, porcentaje, estado)
VALUES ('3', '3', '4', 0.60, 'EN_PROGRESO')
    ON CONFLICT (id) DO NOTHING;

-- Insert suscripción
INSERT INTO suscripcion (id, usuario_id, tipo, fecha_inicio, fecha_expiracion)
VALUES ('1', '3', 'PERSONAL', '2024-09-01', '2024-10-01')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO suscripcion (id, usuario_id, tipo, fecha_inicio, fecha_expiracion)
VALUES ('2', '5', 'PERSONAL', '2024-09-05', '2024-10-05')
    ON CONFLICT (id) DO NOTHING;

-- Insert estudiante_curso
INSERT INTO estudiante_curso (id_estudiante, id_curso)
VALUES ('3', '1')
    ON CONFLICT (id_estudiante, id_curso) DO NOTHING;

INSERT INTO estudiante_curso (id_estudiante, id_curso)
VALUES ('3', '2')
    ON CONFLICT (id_estudiante, id_curso) DO NOTHING;

INSERT INTO estudiante_curso (id_estudiante, id_curso)
VALUES ('4', '3')
    ON CONFLICT (id_estudiante, id_curso) DO NOTHING;

INSERT INTO estudiante_curso (id_estudiante, id_curso)
VALUES ('4', '4')
    ON CONFLICT (id_estudiante, id_curso) DO NOTHING;