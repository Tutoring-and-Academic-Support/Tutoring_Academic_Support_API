-- Insertar cursos
INSERT INTO curso (id, nombre, descripcion) VALUES
(1, 'Introducción a Java', 'Curso básico de introducción a Java'),
(2, 'Desarrollo Web con Angular', 'Curso sobre desarrollo web usando Angular'),
(3, 'Fundamentos de SQL', 'Curso sobre conceptos fundamentales de SQL');

-- Insertar materiales
INSERT INTO material (id, titulo, tipo, fecha_subida, curso_id) VALUES
('M001', 'Introducción a Java - Capítulo 1.pdf', 'DOCUMENTO', '2024-09-01 10:00:00', 1),
('M002', 'Estructuras de Datos en Java.mp4', 'VIDEO', '2024-09-02 11:00:00', 1),
('M003', 'Guía Rápida de Angular.pdf', 'DOCUMENTO', '2024-09-03 09:00:00', 2),
('M004', 'Tutorial Angular.mp4', 'VIDEO', '2024-09-04 14:00:00', 2),
('M005', 'Conceptos Básicos de SQL.txt', 'TEXTO', '2024-09-05 15:00:00', 3),
('M006', 'Comandos SQL Avanzados.pdf', 'DOCUMENTO', '2024-09-06 16:00:00', 3);
