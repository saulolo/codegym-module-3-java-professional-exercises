package org.educatiom.lesson01_Maven_FasesYDependencias;

public class FasesMaven {
    public static void main(String[] args) {

        System.out.println("--------------------- Fases Despliegue Maven ---------------------------");
        //El montaje del proyecto se dividió en fases, cuya descripción daré en la siguiente tabla:
        /*

        Orden	Fase    	Descripción Estándar de Maven
        1	 	validate	Valida la exactitud de la metainformación sobre el proyecto.
        2		compile	    Compila el código fuente del proyecto.
        3		test	    Ejecuta las pruebas unitarias usando un framework de pruebas adecuado.
        4		package	    Toma el código compilado y lo empaqueta en un nuevo artefacto (JAR, WAR, EAR, etc.).
        5		verify	    Ejecuta verificaciones sobre los resultados del paquete para asegurar que cumplen con los requisitos de calidad.
        6		install	    Instala el paquete final en el repositorio Maven local para que otros proyectos locales puedan usarlo como dependencia.
        7	    deploy	    Copia el paquete final al repositorio remoto para ser compartido con otros desarrolladores o servidores de producción.

        Al mismo tiempo, los pasos son claramente secuenciales . Si le dice a Maven que ejecute el comando del paquete,
        primero ejecutará las fases de validación, compilación y prueba y solo luego el paquete.

        Para ejecutar alguna fase basta con solo escribir el comando en cuestion o desplegat la pestaña maven en Intellij
        y en el apartado Lifecycle se desplegaran todas, ademas hay dos comandos mas, clean (se usa para borrar
        completamente la carpeta de destino) y site (puede crear la documentación del proyecto).
        */


        System.out.println("--------------------- Construyendo un Proyecto ---------------------------");
        //Compilando el proyecto
        /*Si desea compilar el proyecto, debe ejecutar la fase de compilación. Esto se puede hacer usando la línea de
        comando: mvn compile o a través de la interfaz de IDEA haciendo clic en el elemento compile
        Después de eso, Maven comenzará a construir el proyecto y verá un registro del proceso de construcción similar a
        este:

        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------
        [INFO] Total time: 0.742 s
        [INFO] Finished at: 2016-09-19T22:41:26+04:00
        [INFO] Final Memory: 7M/18M
        [INFO] ------------------------------------------------------------------------

        Si algo salió mal, el registro se verá así:

        [ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.0:compile (default-compile) on project demo: Fatal error compiling: invalid target release: 11 -> [Help 1]
        [ERROR]
        [ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
        [ERROR] Re-run Maven using the -X switch to enable full debug logging.
        [ERROR]
        [ERROR] For more information about the errors and possible sliutions, please read the flilowing articles:
        [ERROR] [Help 1]
        http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException

        */

        System.out.println("--------------------- Ciclos de Vida ---------------------------");
        //Todos los comandos maven se dividen en tres grupos
        /*Se denominan ciclos de vida porque especifican el orden de las fases que se ejecutan durante una compilación
        o un ciclo de vida particular porque no todas las actividades de Maven son compilaciones.
        Hay tres ciclos de vida:
        Y cada uno de ellos tiene su propio orden de fase. Limpio tiene el más corto:
        * clean: (1.pre-clean -> 2.clean -> 3.post-clean): Comando de ejemplo: mvn clean (esto ejecutará pre-clean, clean y post-clean en orden).
        * build: ((1.validate -> 2.initialize -> 3.generate-sources -> 4.process-sources -> 5.generate-resources -> 6.process-resources -> 7.compile -> 8.process-test-sources -> 9.process-test-resources -> 10.test-compile -> 11.test -> 12.package -> 13.pre-integration-test -> 14.integration-test -> 15.post-integration-test -> 16.verify -> 17.install -> 18.deploy):
        * site: (1.pre-site -> 2.site  -> 3.post-site -> 4.site-deploy): Comando de ejemplo: mvn site (genera la documentación), mvn site-deploy (publica la documentación).


        //Ciclos de Vida y Fases de Maven
      Orden	    Ciclo de Vida	Fase Nativa de Maven	        Descripción Resumida en Español
                 CLEAN	                            	    Ciclo para limpiar la construcción del proyecto.
        1		                    pre-clean	            Ejecuta tareas antes de la limpieza real.
        2		                    clean	                Elimina los archivos y directorios generados (ej. target/).
        3	                    	post-clean	            Realiza tareas después de la limpieza.
                 DEFAULT		                            Ciclo principal de construcción del proyecto.
        1		                    validate	            Valida la exactitud del proyecto y su configuración.
        2		                    initialize	            Inicializa el estado para la construcción.
        3		                    generate-sources	    Genera código fuente adicional (ej. a partir de XML).
        4		                    process-sources	        Procesa el código fuente (ej. filtrado).
        5		                    generate-resources	    Genera recursos del proyecto.
        6		                    process-resources	    Procesa y copia los recursos al directorio de destino.
        7		                    compile	                Compila el código fuente principal.
        8		                    process-test-sources    Procesa el código fuente de las pruebas.
        9		                    process-test-resources	Procesa y copia los recursos de las pruebas.
        10		                    test-compile	        Compila el código fuente de las pruebas.
        11		                    test	                Ejecuta las pruebas unitarias del proyecto.
        12		                    package	                Empaqueta el código compilado en un artefacto (JAR, WAR, etc.).
        13		                    pre-integration-test	Prepara el entorno para las pruebas de integración.
        14		                    integration-test	    Ejecuta las pruebas de integración.
        15		                    post-integration-test	Realiza acciones posteriores a las pruebas de integración.
        16		                    verify	                Verifica la calidad y validez del artefacto.
        17		                    install	                Instala el artefacto en el repositorio Maven local.
        18		                    deploy	                Copia el artefacto final a un repositorio remoto o servidor.
                 SITE		                                Ciclo para generar y publicar la documentación del proyecto.
        1		                    pre-site	            Realiza tareas antes de generar el sitio.
        2		                    site	                Genera la documentación del sitio del proyecto.
        3		                    post-site	            Realiza tareas después de generar el sitio.
        4		                    site-deploy	            Publica el sitio generado en un servidor web.



        */


    }

}
