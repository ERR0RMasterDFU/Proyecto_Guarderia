-- USUARIOS -----------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Usuario (id, username, dni, password, email, nombre, primer_apellido, segundo_apellido, num_telefono, num_hijos, progenitor, admin) VALUES (1, 'admin', 'null', '{noop}admin', 'null', 'null', 'null', 'null', 'null',  0, 'TUTORLEGAL', 'true');
INSERT INTO Usuario (id, username, dni, password, email, nombre, primer_apellido, segundo_apellido, num_telefono, num_hijos, progenitor, admin) VALUES (2, 'user', '44923600T', '{noop}1234', 'usuario.salesianostriana@gmail.com', 'Luismi', 'López', 'Magaña', '676002840',  3, 'TUTORLEGAL', 'false');
INSERT INTO Usuario (id, username, dni, password, email, nombre, primer_apellido, segundo_apellido, num_telefono, num_hijos, progenitor, admin) VALUES (3, 'Maksim', '43916709A', '{noop}juJan', 'nerer21078@gmail.com', 'Eneko', 'Sala', 'Carrero', '614030760', 4, 'PADRE', 'false');
INSERT INTO Usuario (id, username, dni, password, email, nombre, primer_apellido, segundo_apellido, num_telefono, num_hijos, progenitor, admin) VALUES (4, 'Naaji', '83603799H', '{noop}BL453', 'Krak3nz0te@gmail.com', 'Maialen', 'Hidalgo', 'Mellado', '848917922',  6, 'MADRE', 'false');

ALTER SEQUENCE usuario_seq RESTART WITH 54;

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



-- ALUMNOS ------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Alumno (id, nombre, primer_apellido, segundo_apellido, edad, fecha_nacimiento, direccion, curso_id, progenitor_id) VALUES (1, 'Mauricio', 'Ramirez', 'Díaz', 2, '2021-09-08', 'Carril de la Torre, 52', 1, 2);
INSERT INTO Alumno (id, nombre, primer_apellido, segundo_apellido, edad, fecha_nacimiento, direccion, curso_id, progenitor_id) VALUES (2, 'Ramón', 'Flores', 'García', 1, '2023-05-04', 'Autovia C-3319 Murcia-San Javier, Km1,4', 1, 4);
INSERT INTO Alumno (id, nombre, primer_apellido, segundo_apellido, edad, fecha_nacimiento, direccion, curso_id, progenitor_id) VALUES (3, 'Claudia', 'Sosa', 'Gómez', 0, '2023-10-29', 'Carretera F-27 San Cayetano-Los Narejos, s/n', 1, 3);
INSERT INTO Alumno (id, nombre, primer_apellido, segundo_apellido, edad, fecha_nacimiento, direccion, curso_id, progenitor_id) VALUES (4, 'Mirta', 'Gutierrez', 'Benitez', 6, '2018-03-21', 'Paraje Torre Octavio, 54', 2, 2);
INSERT INTO Alumno (id, nombre, primer_apellido, segundo_apellido, edad, fecha_nacimiento, direccion, curso_id, progenitor_id) VALUES (5, 'Raúl', 'Aguirre', 'Aguirre', 4, '2020-03-22', 'Avenida Alfonso X El Sabio, 4', 2, 3);
INSERT INTO Alumno (id, nombre, primer_apellido, edad, fecha_nacimiento, direccion, curso_id, progenitor_id) VALUES (6,'Zhu', 'Zedong', 5, '2018-07-19', 'Gran Via, s/n Km 1', 2, 2);
INSERT INTO Alumno (id, nombre, primer_apellido, segundo_apellido, edad, fecha_nacimiento, direccion, curso_id, progenitor_id) VALUES (7, 'Eduard', 'Arjona', 'Yuste', 2, '2022-02-05', 'Av Alicante, 2', 1, 4);
INSERT INTO Alumno (id, nombre, primer_apellido, segundo_apellido, edad, fecha_nacimiento, direccion, curso_id, progenitor_id) VALUES (8, 'Delia', 'Gracia', 'Orellana', 3, '2021-02-19', 'Urbanizacion Buenavista, s/n', 1, 3);
INSERT INTO Alumno (id, nombre, primer_apellido, edad, fecha_nacimiento, direccion, curso_id, progenitor_id) VALUES (9, 'Yuan', 'Shi', 5, '2018-12-30', 'C/ Manuel Wssel De Guimbarda, 1', 2, 4);
INSERT INTO Alumno (id, nombre, primer_apellido, segundo_apellido, edad, fecha_nacimiento, direccion, curso_id, progenitor_id) VALUES (10, 'Cristina', 'Amado', 'Sarmiento', 4, '2019-08-11', 'Carretera F-27 San Cayetano-Los Narejos, s/n', 2, 3);
INSERT INTO Alumno (id, nombre, primer_apellido, edad, fecha_nacimiento, direccion, curso_id, progenitor_id) VALUES (11, 'Mao', 'Bocheng', 1, '2022-10-24', 'Av Fuerzas Armadas, 56', 1, 2);
INSERT INTO Alumno (id, nombre, primer_apellido, segundo_apellido, edad, fecha_nacimiento, direccion, curso_id, progenitor_id) VALUES (12, 'Andoni', 'Ferreiro', 'Guijarro', 6, '2018-02-04', 'Pol. industrial Cabezo Beaza', 2, 3);

ALTER SEQUENCE alumno_seq RESTART WITH 63;

-----------------------------------------------------------------------------------------------------------------------------------------------------------



-- HORARIO ------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Horario (alumno_id, actividad_id) VALUES (1, 2);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (1, 4);

INSERT INTO Horario (alumno_id, actividad_id) VALUES (2, 3);

INSERT INTO Horario (alumno_id, actividad_id) VALUES (3, 1);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (3, 2);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (3, 3);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (3, 4);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (3, 5);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (3, 6);

INSERT INTO Horario (alumno_id, actividad_id) VALUES (4, 1);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (4, 2);

INSERT INTO Horario (alumno_id, actividad_id) VALUES (5, 1);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (5, 6);

INSERT INTO Horario (alumno_id, actividad_id) VALUES (6, 3);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (6, 4);

INSERT INTO Horario (alumno_id, actividad_id) VALUES (7, 2);

INSERT INTO Horario (alumno_id, actividad_id) VALUES (8, 2);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (8, 5);

INSERT INTO Horario (alumno_id, actividad_id) VALUES (9, 1);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (9, 2);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (9, 3);

INSERT INTO Horario (alumno_id, actividad_id) VALUES (10, 1);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (10, 4);

INSERT INTO Horario (alumno_id, actividad_id) VALUES (11, 4);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (11, 5);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (11, 6);

INSERT INTO Horario (alumno_id, actividad_id) VALUES (12, 3);
INSERT INTO Horario (alumno_id, actividad_id) VALUES (12, 6);

ALTER SEQUENCE alumno_seq RESTART WITH 78;

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
