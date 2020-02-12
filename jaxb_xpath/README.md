# Java_JAXB_XPATH
Desde el contenido de un archivo .txt crear archivo .xml y sobre él hacer consulta con xpath

El fichero texto origen contiene información sobre incidencias :

% 2019-09-21 15:27:14 agonzalez jramirez
La impresora no tiene tóner.
Urgente
% 2019-09-22 10:28:37 jramirez afernandez
No se ha entregado la documentación del expediente EXP324.
Normal
% 2019-09-22 16:28:45 smartinez jramirez
No quedan folios.
Normal
% 2019-09-23 11:03:05 smartinez lsuarez
El ordenador de recepción no funciona.
Urgente
% 2019-09-28 13:11:29 jramirez lsuarez
Mi portátil no puede acceder a la wifi.
Normal

Utilizando java.nio se extrae el contenido del fichero que se mapea a
objetos tipo Incidencia. Mediante marshalling JAXB y el schema contenido en
incidenciasEsquema.xsd se crea el archivo incidencias.xml y en él se guardan 
los objeto Incidencia con el formato:
<incidencias>
  <incidencia fechahora=”2019-09-21 15:27:14”>
    <origen>agonzalez</origen>
    <destino>jramirez</destino>
    <detalle>La impresora no tiene tóner.</detalle>
    <tipo>Urgente</tipo>
  </incidencia> 
  
  ...
</incidencias>

Finalmente, con XPATH, se muestra en consola el resultado de consultar
en el fichero xml las incidencias cuyo usuario destino es 'jramirez'
