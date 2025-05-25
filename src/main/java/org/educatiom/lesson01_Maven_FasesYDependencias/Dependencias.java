package org.educatiom.lesson01_Maven_FasesYDependencias;

public class Dependencias {

    public static void main(String[] args) {

        System.out.println("--------------------- Dependencias ---------------------------");
        //Confiabilidad
        /*Fue uan de las cosas por las que Maven fue tan popular.
        Si desea agregar alguna biblioteca a su proyecto Maven, solo necesita agregarla al archivo pom, en la sección
        de dependencias.

        <dependencies>

              <dependency>
             <groupId>org.springframework</groupId> <artifactId>spring-core</artifactId> <version>5.3.18</version>
              </dependency>

        </dependencies>

        Si agrega estas líneas a su proyecto, IDEA descargará inmediatamente las bibliotecas requeridas.
        Unos segundos después de eso, puede usar sus clases en su código.

        Para agregar las bibliotecas al proyecto podemos dirigirnos a https://mvnrepository.com/,
        Utilizar siempre las versiones final.

        Primero, muchas grandes empresas tienen repositorios maven con sus propias bibliotecas.
        En segundo lugar, antes de la invención de Docker, muchos proyectos simplemente se colocaban en el repositorio
        corporativo de Maven después de construirse. ¿Y qué? Gran lugar para guardar. Y el control de versiones
        vuelve a ser compatible.

        En general, si de repente decide conectar un repositorio de terceros a su proyecto, esto se puede hacer
        simplemente agregando dependencias:

        <repositories>

              <repository>
             <id>public-codegym-repo</id> <name>Public CodeGym Repository</name> <url>http://maven.codegym.cc</url>
              </repository>

              <repository>
             <id>private-codegym-repo</id> <name>Private CodeGym Repository</name> <url>http://maven2.codegym.cc</url>
              </repository>

        </repositories>

        Cada repositorio tiene 3 cosas: Clave/ID, Nombre y URL . Puede especificar cualquier nombre: es para su
        conveniencia, la ID también es para sus necesidades internas, de hecho, solo necesita especificar la URL.




         */



    }
}
