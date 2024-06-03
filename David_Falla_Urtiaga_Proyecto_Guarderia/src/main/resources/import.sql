-- USUARIOS -----------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Usuario (id, username, dni, password, email, nombre, primer_apellido, segundo_apellido, num_telefono, num_hijos, progenitor, admin) VALUES (1, 'admin', 'null', '{noop}admin', 'null', 'null', 'null', 'null', 'null',  0, 'TUTORLEGAL', 'true');

ALTER SEQUENCE usuario_seq RESTART WITH 51;

-----------------------------------------------------------------------------------------------------------------------------------------------------------



-- ALUMNOS ------------------------------------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------------------------------------------------



-- CURSOS -------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Curso (id, nombre) VALUES (1, 'Primer ciclo');
INSERT INTO Curso (id, nombre) VALUES (2, 'Segundo ciclo');

ALTER SEQUENCE curso_seq RESTART WITH 52;

-----------------------------------------------------------------------------------------------------------------------------------------------------------



-- ACTIVIDADES COMPLEMENTARIAS ----------------------------------------------------------------------------------------------------------------------------

INSERT INTO actividad_complementaria (id, nombre, precio) VALUES (1, 'Aula Matinal', 6.00);
INSERT INTO actividad_complementaria (id, nombre, precio) VALUES (2, 'Comedor', 10.00);
INSERT INTO actividad_complementaria (id, nombre, precio) VALUES (3, 'Siesta', 7.50);
INSERT INTO actividad_complementaria (id, nombre, precio) VALUES (4, 'Fútbol', 4.99);
INSERT INTO actividad_complementaria (id, nombre, precio) VALUES (5, 'Manualidades', 4.99);
INSERT INTO actividad_complementaria (id, nombre, precio) VALUES (6, 'Teatro', 4.99);

ALTER SEQUENCE actividad_complementaria_seq RESTART WITH 56;

-----------------------------------------------------------------------------------------------------------------------------------------------------------



-- PROFESORES ---------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (1, 'Marcial', 'Villaverde', 'Rojas', '47389163D', '264948478', 2, 5);
INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (2, 'Hector', 'Florez', 'Galán', '64639431R', '441140275', 2, 6);
INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (3, 'Laura', 'Galván', 'Blanco', '95372302L', '744077085', 1, 3);
INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (4, 'Paula', 'Aranda', 'Pérez', '37609339S', '371547358', 1, 2);
INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (5, 'Pablo', 'Noguerol', 'Ureña', '45786554V', '382343443', 2, 4);
INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (6, 'María', 'Núñez', 'Iglesias', '96755140M', '301185680', 2, 1);
INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (7, 'Manuel', 'Pérez', 'Gómez', '00796433N', '674450136', 1, 5);
INSERT INTO Profesor (id, nombre, primer_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (8, 'Huang', 'Yueying', 'Y9086809Y', '854248643', 1, 2);

ALTER SEQUENCE profesor_seq RESTART WITH 58;

-----------------------------------------------------------------------------------------------------------------------------------------------------------
