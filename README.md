# usuarioMs

********consultar GET

localhost:3000/usuario/api/v1/all/interno
localhost:3000/usuario/api/v1/all/externo

********consultar GET /id

externo
localhost:3000/usuario/api/v1/detail/externo/6109ae28198b9e52d87f9ff9
interno
localhost:3000/usuario/api/v1/detail/interno/6109887b198b9e52d87f9fa7

***********Crear Post

localhost:3000/usuario/api/v1/create/interno

------------------------------@Body

{
"nombres":"Giovanni4",
"usuario":"Guevara",
"password":"123456",
"rol":"admin",
"emailEmpresarial":"gio@gmail.com",
"departamento":"27 y la t"
}


localhost:3000/usuario/api/v1/create/externo

------------------------------@Body

{
"nombres":"Giovanni55",
"usuario":"Guevara",
"password":"123456",
"celular":"0981618026",
"email":"gio@gmail.com",
"direccion":"27 y la t"
}

***********Actualizar Put

**externo

localhost:3000/usuario/api/v1/update/externo/6109ae28198b9e52d87f9ff9

{
"nombres":"Giovanni55",
"usuario":"Guevara",
"password":"123456",
"celular":"0981618026",
"email":"gio@gmail.com",
"direccion":"27 y la t"
}

**interno

localhost:3000/usuario/api/v1/update/interno/6109887b198b9e52d87f9fa7

{
"nombres":"Giovanni44",
"usuario":"Guevara",
"password":"123456",
"rol":"admin",
"emailEmpresarial":"gio@gmail.com",
"departamento":"27 y la t"
}

*********eliminar delete

localhost:3000/usuario/api/v1/delete/interno/6109b87f198b9e52d87f9ffb


