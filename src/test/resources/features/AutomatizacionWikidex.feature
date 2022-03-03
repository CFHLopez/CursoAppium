  #Autor: Christian López.
  #Automatizador: Christian López.
  #Datos: .
  #modificación: Christian López.
  #fecha modificacion: 02-03-2022

#Auto generated Octane revision tag
  Feature:  Pruebas APK Wikidex

    Background:
      Given Inicio en aplicacion "Wikidex.apk" desde dispositivo nombre "emulator-5554", virtual "true" y wait activity "net.wikidex.www.wikidex.*"
      And Visualizo el mensaje de bienvenida text "Bienvenido a WikiDex"
      And Visualizo imagen de Wikidex

   # Prueba 01 en Apk Wikidex, prueba de busqueda de elemento
    @Test01
    Scenario: TP-01-Se valida busqueda y resultados en busqueda de elementos
      Given Necesito buscar un registro en especifico
      And Selecciono el icono de buscar
      And Ingreso texto en el campo de busquedad texto "Rayquaza"
      Then Visualizo los resultados de la busqueda
      And Cerrar la aplicación

      # Prueba 02 en Apk Wikidex, prueba de busqueda de elemento
    @Test02
    Scenario: TP-02-Se valida busqueda y resultado del elemento buscado
      Given Necesito buscar un registro en especifico
      And Selecciono el icono de buscar
      And Ingreso texto en el campo de busquedad texto "Rayquaza"
      Then Visualizo los resultados de la busqueda
      And Selecciono el primer resultado encontrado
      Then Visualizo el contenido de "Rayquaza" en el resultado encontrado
      And Cerrar la aplicación

        # Prueba 03 en Apk Wikidex, agregar y quitar favoritos en modo nocturno
    @Test03
    Scenario: TP-03-Se valida busqueda de una página al azar en la cual se agrega y luego quita de favoritos
      Given Necesito cambiar la vista a modo nocturno
      And Selecciono el icono ajustes
      And Selecciono activar el modo nocturno
      Given Necesito buscar una pagina al azar
      And Selecciono el menu lateral izquierdo
      And Selecciono "Página aleatoria" del menu lateral izquierdo
      Then Visualizo una pagina aleatoria
      And Selecciono el menu de mas opciones
      And Seleciono "Guardar" de el menu mas opciones
      And Selecciono el menu lateral izquierdo
      And Selecciono "Favoritos" del menu lateral izquierdo
      Then Visualizo la vista de favoritos
      And Visualizo solo "1" resultado agregado en la pagina de favoritos
      Then Necesito eliminar la pagina guardada
      And Selecciono eliminar la pagina guardada
      Then Visualizo mensaje "No hay favoritos."
      And Cerrar la aplicación