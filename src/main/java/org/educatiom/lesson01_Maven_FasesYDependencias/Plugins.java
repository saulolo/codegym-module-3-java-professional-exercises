package org.educatiom.lesson01_Maven_FasesYDependencias;

public class Plugins {

    public static void main(String[] args) {

        System.out.println("--------------------- Plugins ---------------------------");
        //Introducción a los Plugins
        /*Los ciclos de vida estándar se pueden mejorar con la funcionalidad mediante los plugins de Maven.
        Los plugins le permiten insertar nuevos pasos en el ciclo estándar (por ejemplo, distribución al servidor de
        aplicaciones) o ampliar los pasos existentes.

        Los plugins en Maven no son algo extraordinario, por el contrario, son lo más común y frecuente. Después de todo,
        si desea establecer algunos matices de la construcción de su proyecto, debe especificar la información necesaria
        en pom.xml. Y la única forma de hacer esto es escribir un "plugins".

        Ejemplo:
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-checkstyle-plugin</artifactId>
                <version>2.6</version>
            </plugin>
        </plugins>

         Si queremos enseñarle a Maven sobre compilaciones especiales del proyecto, debemos agregar a pom.xml una
         indicación para iniciar el plugin deseado en la fase requerida y con los parámetros requeridos .
        */


        System.out.println("--------------------- Variables en Maven ---------------------------");
        //Variables
        /*Esto es muy útil cuando necesita hacer coincidir los parámetros en diferentes partes del archivo pom.
        Por ejemplo, puede poner la versión de Java, las versiones de la biblioteca, las rutas a ciertos recursos en
        una variable.
        Para esto, hay una sección especial en pom.xml – <properties>, en la que se declaran las variables. La forma
        general de la variable es la siguiente:
        Ejemplo:
        <properties>
            <junit.version>5.2</junit.version>
            <project.artifactId>new-app</project.artifactId>
            <maven.compiler.source>1.13</maven.compiler.source>
            <maven.compiler.target>1.15</maven.compiler.target>
        </properties>

        Se accede a las variables usando una sintaxis diferente:
        $ { variable -name } _

        settings.xmlSe puede acceder a las propiedades usando el prefijo settings. Los nombres pueden ser cualquier
        cosa, se toman de settings.xml. Ejemplo:
        ${settings.localRepository} sets the path to the local repository.








        */
    }
}
