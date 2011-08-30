insert into pais(codigo, nombre) values('PE', 'Perú');
insert into pais(codigo, nombre) values('US', 'Estados Unidos');

insert into usuario(username, password, nombre, pais) values('lshimokawa', '1234', 'Lennon', 'PE');
insert into usuario(username, password, nombre, pais) values('jperez', '5678', 'Juan', 'PE');

insert into rol(nombre, descripcion) values('admin', 'Administrador');
insert into rol(nombre, descripcion) values('user', 'Usuario');

insert into usuario_rol(id_usuario, id_rol) values (1, 1);
insert into usuario_rol(id_usuario, id_rol) values (1, 2);
insert into usuario_rol(id_usuario, id_rol) values (2, 1);