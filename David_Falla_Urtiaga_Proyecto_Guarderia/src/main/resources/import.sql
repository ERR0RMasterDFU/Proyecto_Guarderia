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

ALTER SEQUENCE alumno_seq RESTART WITH 62;

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
INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (2, 'Héctor', 'Florez', 'Galán', '64639431R', '441140275', 2, 6);
INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (3, 'Laura', 'Galván', 'Blanco', '95372302L', '744077085', 1, 3);
INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (4, 'Paula', 'Aranda', 'Pérez', '37609339S', '371547358', 1, 2);
INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (5, 'Pablo', 'Noguerol', 'Ureña', '45786554V', '382343443', 2, 4);
INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (6, 'María', 'Núñez', 'Iglesias', '96755140M', '301185680', 2, 1);
INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (7, 'Manuel', 'Pérez', 'Gómez', '00796433N', '674450136', 1, 5);
INSERT INTO Profesor (id, nombre, primer_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (8, 'Huang', 'Yueying', 'Y9086809Y', '854248643', 1, 2);
INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (9, 'Fabián', 'Ramiro', 'López', '31947902M', '897535526', 1, 6);
INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (10, 'Ester', 'Valencia', 'Ródenas', '56010542E', '492282089', 1, 1);
INSERT INTO Profesor (id, nombre, primer_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (11, 'Fukutsuchi', 'Yorikane', 'Z3444850F', '829969699', 2, 2);
INSERT INTO Profesor (id, nombre, primer_apellido, segundo_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (12, 'Oier', 'Tirado', 'Montiel', '39347544H', '009707157', 1, 4);
INSERT INTO Profesor (id, nombre, primer_apellido, dni, num_telefono, curso_id, encargado_id) VALUES (13, 'Harigae', 'Katsunosuki', 'Y6047437S', '546069182', 2, 3);

ALTER SEQUENCE profesor_seq RESTART WITH 63;

-----------------------------------------------------------------------------------------------------------------------------------------------------------

-- OBSERVACIONES ------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Observacion (id, alumno_id, profesor_id, actividad_id, mensaje, fecha_observacion) VALUES (1, 1, 4, 2, 'Se ha atragantado con una patata.', '2024-05-27 19:35:54'); 
INSERT INTO Observacion (id, alumno_id, profesor_id, actividad_id, mensaje, fecha_observacion) VALUES (2, 2, 3, 3, 'Ha aplastado a otro alumno mientras dormía.', '2024-05-28 16:21:03');
INSERT INTO Observacion (id, alumno_id, profesor_id, actividad_id, mensaje, fecha_observacion) VALUES (3, 8, 7, 5, 'Se ha cortado con el filo del papel.', '2024-05-29 18:08:54');
INSERT INTO Observacion (id, alumno_id, profesor_id, actividad_id, mensaje, fecha_observacion) VALUES (4, 1, 12, 4, 'Le ha dado un balonazo muy fuerte a otro niño durante el partido.', '2024-05-30 17:47:42');
INSERT INTO Observacion (id, alumno_id, profesor_id, actividad_id, mensaje, fecha_observacion) VALUES (5, 4, 6, 1, 'Ha venido con los deberes sin hacer.', '2024-05-31 08:24:15');
INSERT INTO Observacion (id, alumno_id, profesor_id, actividad_id, mensaje, fecha_observacion) VALUES (6, 5, 2, 6, 'Ha pegado a otro niño sin querer en la actuación', '2024-06-03 20:10:34');
INSERT INTO Observacion (id, alumno_id, profesor_id, actividad_id, mensaje, fecha_observacion) VALUES (7, 10, 5, 4, 'Se ha chocado contra el poste de la portería', '2024-06-04 16:08:28');
INSERT INTO Observacion (id, alumno_id, profesor_id, actividad_id, mensaje, fecha_observacion) VALUES (8, 12, 13, 3, 'Ronca mucho y demasiado fuerte.', '2024-06-05 15:31:09');
INSERT INTO Observacion (id, alumno_id, profesor_id, actividad_id, mensaje, fecha_observacion) VALUES (9, 9, 11, 2, 'Ha vomitado todos los macarrones sobre la mesa.', '2024-06-06 13:45:31');
INSERT INTO Observacion (id, alumno_id, profesor_id, actividad_id, mensaje, fecha_observacion) VALUES (10, 11, 7, 5, 'Los cuadros que pinta son excepcionalmente bonitos.', '2024-06-07 16:08:28');
INSERT INTO Observacion (id, alumno_id, profesor_id, actividad_id, mensaje, fecha_observacion) VALUES (11, 12, 2, 6, 'No se ha aprendido correctamente su papel.', '2024-06-10 17:16:00');
INSERT INTO Observacion (id, alumno_id, profesor_id, actividad_id, mensaje, fecha_observacion) VALUES (12, 4, 6, 1, 'Se ha limpiado los mocos en la chaqueta de un profesor.', '2024-06-10 08:27:04');

ALTER SEQUENCE observacion_seq RESTART WITH 62;

-----------------------------------------------------------------------------------------------------------------------------------------------------------