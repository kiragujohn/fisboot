DROP Sequence fis_sequence;
CREATE Sequence fis_sequence START 1001;

INSERT INTO app_user (id, first_name, last_name, password, email, created_date) 
VALUES (6, 'John', 'Njoroge', 'password', 'kiragujohn@hotmail.com', '2018-09-17 18:47:52.69');

INSERT INTO CITY (id, address, latitude, longitude) 
VALUES (7, 'Durban', -29.883333, 31.049999);

INSERT INTO CITY (id, address, latitude, longitude) 
VALUES (11, 'Pretoria', -25.747868, 28.229271);

INSERT INTO CITY (id, address, latitude, longitude) 
VALUES (8, 'Johannesburg', -26.205681, 28.046822);

INSERT INTO CITY (id, address, latitude, longitude) 
VALUES (9, 'Bloemfontein', -29.087217, 26.154898);

INSERT INTO CITY (id, address, latitude, longitude) 
VALUES (10, 'Port Elizabeth', -33.958252, 25.619022);

INSERT INTO CITY (id, address, latitude, longitude) 
VALUES (12, 'Soweto', -26.248537, 27.854033);

INSERT INTO CITY (id, address, latitude, longitude) 
VALUES (13, 'Georgea', -33.977074, 22.457581);

INSERT INTO CITY (id, address, latitude, longitude) 
VALUES (14, 'Vryburg', -26.958405, 24.729860);

INSERT INTO CITY (id, address, latitude, longitude) 
VALUES (15, 'Sebokeng', -26.563404, 27.844164);

INSERT INTO CITY (id, address, latitude, longitude) 
VALUES (16, 'Cape Town', -33.918861, 18.423300);

INSERT INTO CITY (id, address, latitude, longitude) 
VALUES (17, 'Pietermaritzburg', -29.61679, 30.39278);