  #Autor: Christian López.
  #Automatizador: Christian López.
  #Datos: .
  #modificación: Christian López.
  #fecha modificacion: 01-03-2022

#Auto generated Octane revision tag
  Feature:  Pruebas APK Wikidex

    Background:
      Given Inicio en aplicacion "Wikidex.apk" desde dispositivo nombre "emulator-5554", virtual "true"
      And visualizo el mensaje de bienvenida text "Bienvenido a WikiDex"
      And visualizo imagen de Wikidex

   # Prueba 01 en Apk Wikidex, prueba de busqueda de elemento
    @Test01
    Scenario: TP-01-Se valida busqueda y resultados en busqueda de elementos
      Given necesito buscar un registro en especifico
      And selecciono el icono de buscar
      And ingreso texto en el campo de busquedad texto "Rayquaza"
      Then visualizo los resultados de la busqueda
      And cerrar la aplicación

      # Prueba 02 en Apk Wikidex, prueba de busqueda de elemento
    @Test02
    Scenario: TP-02-Se valida busqueda y resultado del elemento buscado
      Given necesito buscar un registro en especifico
      And selecciono el icono de buscar
      And ingreso texto en el campo de busquedad texto "Rayquaza"
      Then visualizo los resultados de la busqueda
      And selecciono el primer resultado encontrado
      Then visualizo el contenido de "Rayquaza" en el resultado encontrado
      And cerrar la aplicación

        # Prueba 03 en Apk Wikidex, agregar y quitar favoritos en modo nocturno
    @Test03
    Scenario: TP-03-Se valida busqueda de una página al azar en la cual se agrega y luego quita de favoritos
      Given necesito cambiar la vista a modo nocturno
      And selecciono el icono ajustes
      And selecciono activar el modo nocturno
      Given necesito buscar una pagina al azar
      And selecciono el menu lateral izquierdo
      Then visualizo el menu lateral izquierdo
      And selecciono "Página aleatoria" del menu lateral izquierdo
      Then visualizo una pagina aleatoria
      And selecciono el menu de mas opciones
      Then visualizo el menu de mas opciones
      And Seleciono "Guardar" de el menu mas opciones
      And seleciono el menu lateral izquierdo
      And selecciono "Favoritos" del menu lateral izquierdo
      Then visualizo las paginas agregadas en favoritos
      And visualizo solo "1" resultado
      Then necesito eliminar la pagina guardada
      And selecciono eliminar la pagina guardada
      And cerrar la aplicación