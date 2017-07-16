--Este archivo debe tener como nombre data-tipobbdd para que spring sepa cogerlo y ejecutarlo
--SET @TEASER = '<p>Descripcion teaser</p>';

--Data dummy Producto
insert into producto(id_producto,nombre,descripcion,imagen,activo,ultima_modificacion) values (1,'yogour natural','natural','',true,CURRENT_TIMESTAMP);
insert into producto(id_producto,nombre,descripcion,imagen,activo,ultima_modificacion) values (2,'yogour frutas','frutas','aaaa',false,CURRENT_TIMESTAMP);
insert into producto(id_producto,nombre,descripcion,imagen,activo,ultima_modificacion) values (3,'azucar','azucar','aaaa',false,CURRENT_TIMESTAMP);

insert into supermercado(id_supermercado,marca,direccion,nombre,activo,ultima_modificacion) values (1,'mercadona','cerca de la carcel','mercado carcel',true,CURRENT_TIMESTAMP);
insert into supermercado(id_supermercado,marca,direccion,nombre,activo,ultima_modificacion) values (2,'mercadona','alto el rollo','mercado rollo',true,CURRENT_TIMESTAMP);

insert into producto_supermercado (id_producto,id_supermercado,orden,precio) values (1,1,1,'4.7');
insert into producto_supermercado (id_producto,id_supermercado,orden,precio) values (1,2,3,'4.5');

insert into rol(id_rol,nombre) values ('1','ROLE_ADMIN');
insert into rol(id_rol,nombre) values ('2','GUEST');

insert into usuario(login,password,activo,ultima_modificacion,nombre) values ('aaa@aaa.com','aaa',true,CURRENT_TIMESTAMP,'eduardo');
insert into usuario(login,password,activo,ultima_modificacion,nombre) values ('bbb@bbb.com','bbb',true,CURRENT_TIMESTAMP,'natalia');

insert into usuario_rol(login,id_rol) values ('aaa@aaa.com',1);

insert into usuario_producto (login,id_producto,cantidad,ultima_modificacion) values ('aaa@aaa.com',1,3,CURRENT_TIMESTAMP);
insert into usuario_producto (login,id_producto,cantidad,ultima_modificacion) values ('aaa@aaa.com',2,1,CURRENT_TIMESTAMP);
insert into usuario_producto (login,id_producto,cantidad,ultima_modificacion) values ('aaa@aaa.com',3,0,CURRENT_TIMESTAMP);

insert into usuario_producto (login,id_producto,cantidad,ultima_modificacion) values ('bbb@bbb.com',1,3,CURRENT_TIMESTAMP);
insert into usuario_producto (login,id_producto,cantidad,ultima_modificacion) values ('bbb@bbb.com',2,1,CURRENT_TIMESTAMP);

insert into usuario_supermercado (login,id_supermercado) values ('bbb@bbb.com',1);
insert into usuario_supermercado (login,id_supermercado) values ('aaa@aaa.com',1);

insert into historico_compras(id,precio,productos,ultima_modificacion,id_supermercado,login) values(1,'2.30','yogour,salsa,lechuga',CURRENT_TIMESTAMP ,1,'aaa@aaa.com');
insert into historico_compras(id,precio,productos,ultima_modificacion,id_supermercado,login) values(2,'3.30','yogour,salsa,lechuga',CURRENT_TIMESTAMP ,1,'aaa@aaa.com');