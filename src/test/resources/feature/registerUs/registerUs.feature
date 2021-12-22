@test
Feature:  Formulario de Registro
  Yo como PO
  Quiero un formulario de Registro
  para que mis clientes puedan
  comprar los productos

  @Scenario
  Scenario: el usuario realiza el registro
    Given que el usuario esta en la seccion de logueo para crear nuevo usuario
    When el usuario ingresa un pepito0197@gmail.com valido
    And completa el formulario de registro con los campos obligatorios
      | nombre | apellido | password | day | month | year | nombre1 | apellido1 | company | direccion                  | ciudad  | estado | codPostal | telefono  |
      | pepito | perez    | 123456   | 12  | 6     | 1998 | pepito  | perez     | indra   | Pennsylvania Av. NW, 20037 | Alabama | 1      | 36523     | 320984901 |
    Then el usuario deberia ver el nombre de usuario
