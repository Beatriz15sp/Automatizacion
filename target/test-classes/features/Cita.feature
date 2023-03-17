Feature: Funcionalidad Reservar cita
  Rule: Yo como usuario quiero sacar una cita
  dentro de la aplicación de manera exitosa y que se guarde mis datos correctamente.

    Background: Ingresar a la web


    Scenario Outline:Validar reserva de cita fue exitoso
      Given ingreso a la web a reservar cita
      And usuario inicia session con las credenciales <usuario> y <password>
      When ingreso los datos <facility>,<healthcareProgram>, <visitDate>, <comment> en formulario
      Then valido que se genero la orden correctamente con mis datos ingresados <facility>,<readmission>,<healthcareProgram>, <visitDate>, <comment>
      Examples:
        |usuario|password| facility | readmission|healthcareProgram | visitDate  | comment |
        |John Doe| ThisIsNotAPassword | Hongkong CURA Healthcare Center|Yes| None | 16/03/2023 | Prueba |
