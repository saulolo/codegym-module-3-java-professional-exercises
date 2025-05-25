package org.educatiom.lesson01_Maven_FasesYDependencias;

public class Maven {

    public static void main(String[] args) {

        System.out.println("--------------------- Maven ---------------------------");
        //Introducción
        /*Maven es el "arquitecto" y "gerente de construcción" de tus proyectos Java. Maven estandarizó el diseño del
        proyecto. Hay varias opciones para organizar el código dentro de un proyecto, y la más común es:
        Maven es una herramienta de gestión de proyectos y comprensión (Build Automation Tool) desarrollada por Apache.
        Su objetivo principal es simplificar y estandarizar el proceso de construcción, gestión de dependencias y
        despliegue de aplicaciones Java.
        Antes de Maven, los proyectos Java a menudo eran un caos: cada desarrollador manejaba sus librerías a mano, la
        compilación se hacía con scripts complejos (Ant), y nadie sabía exactamente qué versiones de qué librerías se
        estaban usando. Maven vino a poner orden.

        Estructura de un proyecto en Maven:

            project home/
            ├── src/
            │   ├── main/
            │   │   ├── java/
            │   │   └── resources/
            │   └── test/
            │       ├── java/
            │       └── resources/
            ├── target/
            └── pom.xml


        La carpeta src: contiene el código fuente del proyecto. Tiene dos subcarpetas: main y test.
        La carpeta /src/main/java es la raíz de todas las clases Java del proyecto.
        Si hay recursos de texto o binarios, deben almacenarse en la carpeta /src/main/resources.
        La estructura de la carpeta /src/test es similar a la estructura de la carpeta /src/main , pero contiene las
        pruebas y sus recursos.
        ambién hay una carpeta /target en el proyecto , donde Maven guardará el proyecto después de compilarlo.
        El segundo propósito de la carpeta /target es almacenar en caché los resultados de compilación intermedios.
        Al construir un proyecto grande, Maven solo puede reconstruir la parte que ha cambiado, acelerando así el tiempo
        de construcción varias veces.
        Bueno, como guinda del pastel, en la raíz misma del proyecto se encuentra el archivo pom.xml. Contiene toda la
        información necesaria sobre el proyecto
        */

        //Dispositivo pom.xml
        /*Para empezar, el archivo pom es xml, por lo que contiene los encabezados estándar y la información de los
        espacios de nombres. Esto se trata del estándar puramente XML

        Estructura archivo pom.xml:

        <?versión xml="1.0" codificación="UTF-8"?>
        <proyecto xmlns="http://maven.apache.org/POM/4.0.0"
                xmlns:xsi="http://www.w3 .org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

          <modelVersion>4.0.0</modelVersion>

          <groupId>com.sample.app</groupId>
          <artifactId>nueva aplicación</artifactId>
          <version>1.0-SNAPSHOT</version>

          <dependencias>

              <dependencia>
                   <groupId>commons-io</groupId>
                   <artifactId>commons-io</artifactId>
                   <version>2.6</version>
            </dependency>

          </dependencies>

        </proyecto>

        Normalmente la primera línea dentro de la etiqueta <project> es una descripción de la versión del estándar
        del archivo pom.
        Para no entender una vez más lo que describimos (programa, proyecto, módulo, biblioteca, etc.) en el estándar
        Maven, a esto se le llama la palabra artefacto

        Las tres etiquetas que ves significan:
        groupId : el paquete al que pertenece la aplicación, con la adición del nombre de dominio;
        artefactoId : clave de cadena única (identificación del proyecto);
        versión - versión del proyecto.

        Además, después de la descripción del proyecto, suele haber una lista de artefactos (bibliotecas) que utiliza
        el proyecto.
        En el momento de la compilación, Maven encontrará dicha biblioteca en su repositorio global y la agregará a su
        proyecto. Y por cierto, no solo Maven puede hacer esto.



        */

    }
}
