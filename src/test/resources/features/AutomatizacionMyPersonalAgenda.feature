  #Autor: Christian López.
  #Automatizador: Christian López.
  #Datos: .
  #modificación: Christian López.
  #fecha modificacion: 03-03-2022

#Auto generated Octane revision tag
  Feature:  Pruebas APK My personal agenda

    Background:
      Given Inicio en aplicacion "My Personal Agenda_v6.4.1com.apk" desde dispositivo nombre "emulator-5554", virtual "true" y wait activity "com.tambucho.miagenda.*"
      And Visualizo el texto "Diario" en la parte superior

   # Prueba 01 en Apk My Personal Agenda, comprobar elementos visibles en la vista principal
    @Test01
    Scenario: TP-01-Se valida la visualización de elementos visibles, clickeables y textos en la vista principal
      Given Necesito comprobar los elementos visibles
      And Visualizo el nombre de grupo texto "Todo"
      And Selecciono el icono menu
      Then Visualizo el texto "Mi Agenda" en la parte superior
      And Selecciono el icono menu
      And Selecciono el icono de buscar de my personal agenda
      Then Visualizo una ventana emergente con texto "Buscar"
      And Selecciono cerrar la ventana emergente
      And Selecciono el icono de filtro
      Then Visualizo una ventana emergente con texto "Establecer Filtro"
      And Selecciono cerrar la ventana emergente
      And Visualizo el icono agregar clickeable
      And Cerrar la aplicación

    # Prueba 02 en Apk My Personal Agenda, agregar un nuevo registro fecha
    @Test02
    Scenario: TP-02-Se valida la creación de un nuevo registro fecha
      Given Necesito crear un nuevo registro fecha
      And Selecciono el icono de agregar
      Then Visualizo el texto "Diario" en la parte superior
      And Selecciono el registro visible
      Then Visualizo una ventana emergente con texto "Seleccione Fecha"
      # Modificar por la fecha actual
      And Visualizo un calendario con fecha "3" de "Marzo" de "2022"
      When Seleciono el icono ok
      And Selecciono el icono de agregar texto
      Then Visualizo un nuevo cuadro con texto "<texto>"
      And Selecciono el campo de texto e ingresamos el siguiente texto "Pruebas Apk My Personal Agenda con Cucumber"
      When Seleciono el icono ok
      And Visualizo el texto "Pruebas Apk My Personal Agenda con Cucumber" agregado
      When Seleciono el icono ok
      Then Visualizo el texto "Diario" en la parte superior
      And Visualizo opción de generar pdf
      And Visualizo opción de editar
      And Visualizo opción de agregar color
      And Selecciono el icono menu
      Then Selecciono la opción "Diario" del menu
      And Cerrar la aplicación

    # Prueba 03 en Apk My Personal Agenda, agregar un nuevo registro fecha con una fecha especifica
    @Test03
    Scenario: TP-03-Se valida la creación de un nuevo registro fecha con una fecha en especifico
      Given Necesito crear un nuevo registro fecha
      And Selecciono el icono de agregar
      Then Visualizo el texto "Diario" en la parte superior
      And Selecciono el registro visible
      Then Visualizo una ventana emergente con texto "Seleccione Fecha"
      And Modifico la fecha visualizada por "15" de "Julio" de "2025"
      And Visualizo un calendario con fecha "15" de "Julio" de "2025"
      When Seleciono el icono ok
      And Selecciono el icono de agregar texto
      Then Visualizo un nuevo cuadro con texto "<texto>"
      And Selecciono el campo de texto e ingresamos el siguiente texto "Pruebas Apk My Personal Agenda con Cucumber y se agrega una fecha en especifico con fecha de 15 de Julio de 2025"
      When Seleciono el icono ok
      And Visualizo el texto "Pruebas Apk My Personal Agenda con Cucumber y se agrega una fecha en especifico con fecha de 15 de Julio de 2025" agregado
      When Seleciono el icono ok
      Then Visualizo el texto "Diario" en la parte superior
      And Visualizo opción de generar pdf
      And Visualizo opción de editar
      And Visualizo opción de agregar color
      When Selecciono el icono de agregar color
      And Selecciono un color al azar
      Then Visualizo el texto "Diario" en la parte superior
      And Selecciono el icono menu
      Then Selecciono la opción "Diario" del menu
      And Cerrar la aplicación
