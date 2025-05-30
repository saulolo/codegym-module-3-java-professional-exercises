package org.educatiom.lesson05_Logging;

import java.io.File;
import java.io.PrintStream;

public class Logs {

    public static void main(String[] args) {

        System.out.println("--------------------- Logging (Registro) en Java ---------------------------");
        //Introducción a los logs
        /*El registro es una lista de eventos que han ocurrido. Casi como un diario o diario náutico. Bueno, en
        consecuencia, un registrador es un objeto con el que puede iniciar sesión. En programación, se acostumbra
        registrar casi tod. Y en Java, tod es así e incluso un poco más.
        La mayoría de las veces, la información se escribe en el registro sobre los parámetros del method con el que se
        llamó, todos los errores interceptados y mucha información intermedia. Cuanto más completo sea el registro, más
        fácil será restaurar la secuencia de eventos y rastrear las causas de una falla o error.
        Pero cuanto más grande es el registro, más difícil es trabajar con él. A veces, los registros alcanzan varios
        gigabytes por día. Esto esta bien.

        //Registros fallidos
        Como los primeros registros, los desarrolladores utilizaron simplemente la salida a la consola . Es conveniente
        hacer esto durante la depuración de la aplicación, cuando toda la información importante y los valores de las
        variables se escriben en la consola. Pero dicho registro es completamente inaplicable durante el funcionamiento
        normal de la aplicación.
        En primer lugar, es posible que la aplicación quiera enviar algo a la consola y el usuario no quiera ver la
        información de servicio destinada al programador en absoluto.
        En segundo lugar, el tamaño del búfer de la consola es limitado, no puedes escribir mucho allí.
        Y finalmente, en tercer lugar, la información sobre los errores del programa que se recopila durante un largo
        período de tiempo debe enviarse a los desarrolladores del programa. Y es más conveniente escribir toda esta
        información a la vez en un archivo.
        Los desarrolladores resolvieron rápidamente el primer problema: se les ocurrió otro flujo de salida System.err.
        Puede escribirle mensajes y se enviarán a un hilo separado, y no a la consola estándar.
        E incluso se resolvió el problema de escribir en un archivo:
        */
        try {
            System.setErr(new PrintStream(new File("log.txt")));
            System.err.println("Message 1");
            System.err.println("Message 2");
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*Pero incluso de esta forma, no resolvió tod el problema, por lo que se decidió crear una biblioteca especial
        que escribiera mensajes de registro en un archivo. Lo hizo de manera inteligente y permitió la flexibilidad de
        configurar filtros para eventos y datos registrados.
        Tod el proceso de registro, de hecho, consta de tres partes:

        La primera parte es la recopilación de información .
        La segunda parte es el filtrado de la información recopilada.
        La tercera parte es el registro de la información seleccionada.
        */

        System.out.println("--------------------- log4j ---------------------------");
        //Introducción al registrador log4j
        /*El primer registrador popular en la comunidad de Java fue el log4j. Incluirlo en el proyecto es muy sencillo,
        para ello solo necesitas añadir un par de líneas a tu pom.xml
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>2.2.17</version>
        </dependency>
        */

        System.out.println("--------------------- Historia de los Logging en Java ---------------------------");
        //Primer logging - log4j
        /*Como ya sabes, la historia de los registros comenzó con System.err.println()la salida de un registro a la
        consola. Todavía se usa activamente para la depuración, por ejemplo, Intellij IDEA lo usa para mostrar mensajes
        de error en la consola. Pero esta opción no tiene ninguna configuración, así que sigamos adelante.

        El primer registrador y el más popular se llamaba Log4j. Era una solución buena y altamente personalizable.
        Debido a diversas circunstancias, esta decisión nunca llegó al JDK, lo que molestó mucho a toda la comunidad.

        Había log4jtres cosas para esto:

        registro de subpaquetes;
        conjunto de appenders (resultados);
        Configuración de recarga en caliente.

        En primer lugar, la configuración log4jpodría escribirse de tal manera que permita iniciar sesión en un paquete
        y deshabilitarlo en otro.
        En segundo lugar, log4jpermitía escribir los resultados del registro en varios archivos de registro a la vez.
        Y la salida a cada uno podría configurarse individualmente.
        Por lo tanto, cada archivo de registro se ajustó a un tipo particular de problema esperado. Esto simplifica
        enormemente la vida de los programadores que no disfrutan mirando manualmente los archivos de registro de gigabytes.
        log4jpermitía cambiar la configuración del registro directamente mientras el programa se estaba ejecutando,
        sin reiniciarlo. Esto fue muy útil cuando era necesario corregir el trabajo de los registros para encontrar
        información adicional sobre un error específico.

        //Primer registrador oficial - JUL: java.util.logging
        Después de que apareció el zoológico de registradores en la comunidad de Java, los desarrolladores JDKdecidieron
        crear un registrador estándar que todos usarían. Así es como apareció el registrador JUL: paquete java.util.logging.
        La buena noticia es que el registrador JULestá incluido JDK, la mala noticia es que pocas personas lo usan.

        //Primera envoltura de registrador - JCL: registro de jakarta commons
        Sin embargo, a los desarrolladores comunes de Java no les gustó que casi todas las bibliotecas tengan su propio
        registrador y deban configurarse de alguna manera especial. Por lo tanto, la comunidad decidió crear un
        envoltorio especial sobre otros registradores: así es comoJCL: jakarta commons logging.
        Y nuevamente, el proyecto, que fue creado para ser un líder, no se convirtió en uno. No se usaba


        //Primero último registrador - Logging
        Pero eso no es tod. El desarrollador log4jdecidió que él era el más inteligente (bueno, porque la mayoría de la
        gente usaba su registrador) y decidió escribir un nuevo registrador mejorado que combinaría las ventajas log4jde
        otros registradores.
        El nuevo registrador fue llamado Logback. Era este registrador el que se suponía que se convertiría en el futuro
        registrador único que todos usarían. Se basó en la misma idea que en log4j

        se agrega al pom con la siguiente dependencia:
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.6</version>
        </dependency>

        Las diferencias estaban en Logback:
        - desempeño mejorado;
        - soporte nativo añadido slf4j;
        - opción de filtrado ampliada.

        Otra ventaja de este registrador era que tenía una configuración predeterminada muy buena. Y tenía que configurar
        el registrador solo si quería cambiar algo en ellos. Además, el archivo de configuración se adaptó mejor al
        software corporativo: todas sus configuraciones se establecieron como xml/.

        De forma predeterminada, Logbackno requiere ninguna configuración y registra todos los registros del nivel DEBUG
        y superior. Si necesita un comportamiento diferente, se puede configurar a través de xmlla configuración

        //Registrador universal más reciente - SLF4J: Simple Logging Facade para Java
        En 2006, uno de los creadores log4jabandonó el proyecto y decidió volver a intentar crear un registrador universal.
        Pero esta vez no se trataba de un nuevo registrador, sino de un nuevo estándar universal (envoltorio) que
        permitía que diferentes registradores interactuaran entre sí.
        Este registrador se llamaba slf4j — Simple Logging Facade for Java, era un envoltorio alrededor de log4j, JUL,
        common-loggins and logback. Este registrador resolvió un problema real: administrar un zoológico de registradores,
        por lo que todos comenzaron a usarlo de inmediato.

        Solucionamos heroicamente los problemas que nos creamos a nosotros mismos. Como puede ver, el progreso ha llegado
        al punto de que hemos creado un envoltorio sobre el envoltorio.

        La envoltura en sí consta de dos partes:

        API, que se utiliza en aplicaciones;
        Implementaciones que se agregan como dependencias separadas para cada registrador.
        Puede conectar el registrador al proyecto usando el código:
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.17.2</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.17.2</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-slf4j-impl</artifactId>
            <version>2.17.2</version>
        </dependency>

        Después de eso, SLF4Jcomenzó a crecer rápidamente en popularidad, por el momento esta es la mejor solución.

        */

        System.out.println("--------------------- Lista de niveles de eventos ---------------------------");
        /*Esta tampoco es una opción: demasiada información es tan mala como muy poca.*/

        /*
        El programador, al escribir un evento en el registro, debe decidir por sí mismo qué tan importante es esta información. El nivel de gravedad del evento lo elige el autor del mensaje. Hay log4j5 niveles de importancia de la información registrada:

        DEBUG
        INFO
        WARN
        ERROR
        FATAL

        +-------+------------------------------------------------------------------------------------+
        | Nivel |                                   Descripción                                                                        |
        +-------+------------------------------------------------------------------------------------+
        | DEBUG | Eventos informativos detallados que son más útiles para depurar una aplicación.    |
        +-------+------------------------------------------------------------------------------------+
        | INFO  | Mensajes informativos que resaltan el progreso de la aplicación a un nivel        |
        |       | general.                                                                           |
        +-------+------------------------------------------------------------------------------------+
        | WARN  | Situaciones potencialmente dañinas.                                               |
        +-------+------------------------------------------------------------------------------------+
        | ERROR | Eventos de error que aún podrían permitir que la aplicación continúe ejecutándose. |
        +-------+------------------------------------------------------------------------------------+
        | FATAL | Eventos de error muy graves que presumiblemente provocarán que la aplicación     |
        |       | aborte.                                                                            |
        +-------+------------------------------------------------------------------------------------+


        //niveles de registro
        +-------+------------------------------------------------------------------------------------+
        | Nivel |                                       Nota                                                                               |
        +-------+------------------------------------------------------------------------------------+
        | ALL   | Registrar todos los mensajes.                                                      |
        +-------+------------------------------------------------------------------------------------+
        | TRACE | Un mensaje pequeño durante la depuración.                                         |
        +-------+------------------------------------------------------------------------------------+
        | DEBUG | Mensajes importantes para la depuración.                                          |
        +-------+------------------------------------------------------------------------------------+
        | INFO  | Mensajes simples.                                                                  |
        +-------+------------------------------------------------------------------------------------+
        | WARN  | Escribe solo fatal, error y advertencia.                                           |
        +-------+------------------------------------------------------------------------------------+
        | ERROR | Escribir solo errores y errores fatales.                                           |
        +-------+------------------------------------------------------------------------------------+
        | FATAL | Escribir solo errores fatales.                                                     |
        +-------+------------------------------------------------------------------------------------+
        | OFF   | No escribir ningún mensaje en el registro.                                         |
        +-------+------------------------------------------------------------------------------------+

        //Agregadores en Log4j
        +-------------------+------------------------------------------------------------------------------------+
        | Anexadores        | Descripción                                                                        |
        +-------------------+------------------------------------------------------------------------------------+
        | Console           | Imprime datos en la consola.                                                       |
        +-------------------+------------------------------------------------------------------------------------+
        | File              | Envía datos a un archivo.                                                          |
        +-------------------+------------------------------------------------------------------------------------+
        | DailyRollingFile  | Envía datos a un archivo, el archivo se sobrescribe cíclicamente.                  |
        +-------------------+------------------------------------------------------------------------------------+
        | Async             | Le permite escribir datos en otro appender de forma asíncrona.                     |
        +-------------------+------------------------------------------------------------------------------------+
        | Socket            | Escribe datos en un socket específico.                                             |
        +-------------------+------------------------------------------------------------------------------------+
        | JDBC              | Escribe mensajes en la base de datos usando el protocolo JDBC.                     |
        +-------------------+------------------------------------------------------------------------------------+
        | JPA               | Escribe mensajes en la base de datos usando el protocolo JPA.                      |
        +-------------------+------------------------------------------------------------------------------------+
        | HTTP              | Envía eventos a través del protocolo HTTP a un servidor remoto.                    |
        +-------------------+------------------------------------------------------------------------------------+
        | SMTP              | Almacena mensajes en un búfer y luego los envía como un correo electrónico.        |
        +-------------------+------------------------------------------------------------------------------------+


        //Vulnerabilidad de Log4Shell
        La Agencia de Protección de Infraestructura y Ciberseguridad de EE. UU. (CISA) dijo que el problema Log4Shelles
        una de las vulnerabilidades más graves de la historia. Sí, estamos hablando de nuestra biblioteca favorita log4j.

        Si un proyecto de Java usa una biblioteca log4j, entonces podría ser pirateado con bastante facilidad. Y dado que
        casi tod el software del servidor está escrito en Javael log4jregistrador de Java más popular, según los expertos
        en seguridad, la vulnerabilidad afectó al 93% de los entornos de nube corporativos. Incluyendo los gustos de
        Amazon AWS, Microsoft Azure, Google Cloud, Cloudflare, iCloud, Minecraft, Steam y muchos más.

        La buena noticia es que el problema se solucionó rápidamente en la biblioteca .

        La mala noticia es que millones de servidores en tod el mundo todavía ejecutan la versión anterior de esta biblioteca ...

        */
    }
}
