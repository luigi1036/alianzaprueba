### Api Rest para detectar secuencia de ADN

## Objetivo
Este proyecto tiene como objetivo realizar la prueba de conocimiento

## Introducción

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men.
Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante
basándose en su secuencia de ADN.
Para eso te ha pedido crear un programa con un método o función con la siguiente firma (En
alguno de los siguiente lenguajes: ( Java / Python )
:boolean isMutant(String[] dna); // Ejemplo Java
En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras
iguales, de forma oblicua, horizontal o vertical.
Ejemplo (Caso mutante):
String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
En este caso el llamado a la función isMutant(dna) devuelve “true”.

## Estado del proyecto

### Nivel 1 Completado
Programa que cumpla con el método pedido por Magneto.

### Nivel 2 Completado
Crear una API REST, crear el servicio “/mutant/” en donde se pueda detectar si un humano es
mutante enviando la secuencia de ADN mediante un HTTP POST con un Json el cual tenga el
siguiente formato:
POST → /mutant/
{
“dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
En caso de verificar un mutante, debería devolver un HTTP 200-OK, en caso contrario un 403-
Forbidden

### Nivel 3 No Completado
* Anexar una base de datos, la cual guarde los ADN’s verificados con la API.
  Solo 1 registro por ADN. (Completo)
* Exponer un servicio extra “/stats” que devuelva un Json con las estadísticas de las
  verificaciones de ADN: {“count_mutant_dna”:40, “count_human_dna”:100: “ratio”:0.4} (Incompleto)
* Test-Automáticos, Code coverage > 80%. (NO realizado)

## Instruciones para la su prueba

Este proyecto utiliza Gradle. Antes de empezar,
asegurese de descargarlo e instalarlo. Luego, Gradle descargará automáticamente las librerias requeridas por el proyecto

### Repositorio
El código se encuentra alojado en github. Deberas contar con una cuenta github.
* Cree una carpeta en donde se incluirá el código fuente<br>
* Abra su consola y posicionese en la carpeta previamente creada<br>
* Ejecute el comando<br>

git clone https://github.com/luigi1036/alianzaprueba.git<br>

Luego de que termine la descarga, usted tendrá clonado el branch master en la carpeta previamente creada.

Ejecute el proyecto de forma local.

El servicio actualmente cuenta con los siguientes métodos:

Método POST para detectar si un ADN dado es mutante:

La URL del método seria: [http://localhost:8080/mutant](http://localhost:8080/mutant) <br><br> 
Se puede detectar si un humano es mutante enviando la secuencia de ADN mediante un HTTP POST con un Json el cual tenga el siguiente formato:

POST → /mutant/
{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

En caso de verificar que el ADN enviado es mutante, el método devuelve como respuesta un HTTP 200-OK, en caso contrario un 403-Forbidden

Método GET para obtener las estadísticas de las verificaciones de ADN para Magneto

La URL del método es [http://localhost:8080/stats](http://localhost:8080/statss) <br><br>
Se puede probar utilizando Postman.

## Tecnologias

* Java 11
* IDE: Intellij IDEA
* Gradle
* Spring boot
* Mysql


## Mejoras
* Se deberar terminar el desarrollo de del servicio stats
* Se deberan realizar los Test unit.

