INSERT INTO roles(nombre) VALUES('ROLE_USER');
INSERT INTO roles(nombre) VALUES('ROLE_ADMIN'); 

INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES('user','1234',1,'Pedro','Perez','pperez@gmail.com');
INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES('admin','5678',1,'Jorge','Reyes','jreyes@gmail.com');

INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(1,1);
INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(2,2);
INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(2,1);
