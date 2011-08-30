insert into pais(codigo, nombre) values('PE', 'Peru');
insert into pais(codigo, nombre) values('US', 'Estados Unidos');

insert into usuario(username, password, nombre, pais) values('admin', '1234', 'Administrador', 'PE');
insert into usuario(username, password, nombre, pais) values('user', '1234', 'Usuario', 'PE');

insert into rol(nombre, descripcion) values('ROLE_ADMIN', 'Administrador');
insert into rol(nombre, descripcion) values('ROLE_USER', 'Usuario');

insert into usuario_rol(id_usuario, id_rol) values (1, 1);
insert into usuario_rol(id_usuario, id_rol) values (1, 2);
insert into usuario_rol(id_usuario, id_rol) values (2, 1);