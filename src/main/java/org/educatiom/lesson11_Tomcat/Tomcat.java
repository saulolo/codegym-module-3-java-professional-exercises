package org.educatiom.lesson11_Tomcat;


public class Tomcat {

    public static void main(String[] args) {

        System.out.println("--------------------- Servlets, aplicaciones web y sus contenedores ---------------------------");
        //Introducción a las aplicaciones web
        /*. Las aplicaciones web grandes y complejas del lado del servidor son donde domina Java.
        Una aplicación web es un programa que tiene una interfaz web en lugar de una interfaz gráfica que se puede
        abrir en un navegador como un sitio web normal. Por lo tanto, un programa grande y complejo se ejecuta en el
        servidor y se puede acceder desde cualquier navegador.

        //Servidores web
        Allá por los años 90, cuando aparecieron las primeras aplicaciones web, se les ocurrió la idea de dividirlas en dos partes: la propia aplicación web y el servidor web .

        El servidor web se hizo cargo de tod el trabajo rutinario de trabajar con el protocolo HTTP:

        - Sirviendo archivos estáticos como HTML, CSS, JavaScript;
        - Gestión de derechos de acceso a los recursos;
        - Gestión de carga, operación y descarga de aplicaciones web;
        - Registro, registro de errores;
        - Garantizar la interacción de las aplicaciones web entre sí y similares.

        debido al hecho de que un servidor se usó miles de veces, fue muy rentable gastar los esfuerzos de la comunidad
        de Java para agregar funciones a un servidor web común, y no a todos en su propia aplicación web.

        Así nació el servidor web más popular para aplicaciones web escritas en Java, Apache Tomcat. La página oficial
        del proyecto es https://tomcat.apache.org/

       */

        System.out.println("--------------------- Dispositivo de archivos War ---------------------------");
        /*Cada aplicación web, cuando se carga en el servidor web, se empaqueta en un solo archivo .war. WAR ahora
        significa Recursos de aplicaciones web, aunque solía ser Web ARchive. De hecho, este es un archivo zip que
        contiene una aplicación web empaquetada.
        Dentro del archivo war hay recursos web estáticos como archivos .html, .css, .js, etc. También puede haber
        imágenes, videos y, en general, cualquier archivo. Pueden estar en la raíz o en subcarpetas, no importa.
        Tomcat simplemente los servirá si se solicitan.

        /WEB-INF/clases/	directorio para clases Java no JAR compiladas, incluidas las clases de servlet y los archivos de recursos que necesita el cargador antes de ejecutar la aplicación
        /WEB-INF/lib/	lugar para almacenar bibliotecas jar
        /WEB-INF/web.xml	descriptor de despliegue

        //Estructura de archivos war y proyecto maven
        Ahora pasemos a la jerarquía de directorios del proyecto Maven. Puedes ver el diseño completo del catálogo en el manual oficial. Aquí nos familiarizaremos con él en una versión algo abreviada, excluyendo los recursos de prueba. Entonces, la jerarquía de directorios estándar de Maven se ve así:

        src/principal/java	códigos fuente de clases de aplicaciones y bibliotecas de acuerdo con la jerarquía de paquetes generalmente aceptada
        src/principal/recursos	archivos de recursos de la aplicación: configuración de la base de datos, archivos de localización, etc.
        src/principal/webapp	recursos de aplicaciones web (archivos JSP, archivos de texto, scripts, etc.)

         */

        System.out.println("--------------------- Estructura web.xml ---------------------------");
        //Esquema general de web.xml
        /*El archivo web.xml almacena información de configuración de la aplicación. No es una parte obligatoria de la
        misma, pero es muy utilizada para configurar una aplicación web.

        Este archivo debe estar ubicado en la carpeta WEB-INF . Cuando se inicia Tomcat, lee su contenido y utiliza la
        configuración que contiene. Si el archivo contiene errores, Tomcat también muestra un error.

        //Servlet
        Un servlet puede atender solicitudes en diferentes URL, por lo que en web-xml, el servlet y su asignación a URL
        se escriben por separado.
        Con la ayuda de web.xml, los parámetros se pueden pasar al servlet durante su inicialización, estarán
        disponibles a través de la interfaz ServletConfig. También puede establecer parámetros para toda la aplicación
        web, estarán disponibles a través del archivo ServletContext.

        //filter
        La aplicación web también puede contener archivos especiales utility servlets - filters. Realizan diversas
        tareas de servicio: redirigir llamadas, verificar autorización, etc.

        */

        System.out.println("--------------------- Personalización de aplicaciones web con anotaciones ---------------------------");
        /*A partir de la versión 7, Tomcat comenzó a admitir la especificación de servlet web Servlet API 3.0 .
        En particular, apareció un paquete llamado javax.servlet.annotation. Contiene varios tipos de anotaciones que se
        pueden utilizar para anotar una clase de servlet. Si usa una anotación, no se requiere el descriptor de
        implementación (web.xml).

        Lista de las anotaciones más útiles:

        Anotación	        Descripción
    	@WebServlet	        Declara un servlet
    	@WebInitParam	    Especifica un parámetro de inicialización.
    	@WebFilter	        Declara un filtro web
    	@WebListener	    Declara el oyente web
    	@ServletSecurity	Le permite configurar los ajustes de seguridad

    	Ejemplo:

            @WebServlet( urlPatterns = {"/api/*"} )
            public class Example extends HttpServlet {
                protected void doGet( HttpServletRequest request, HttpServletResponse response) throws Exception {
                     response.setContentType("text/html");
                     PrintWriter out = response.getWriter();
                     out.println("Hello World!");
                }
            }

        Una anotación es suficiente para declarar un servlet y mapearlo para atender todas las solicitudes que llegarán
        a la URL dada por el /api/.

         //Configuración de la asignación de servlets
         Echemos un vistazo a los principales:

            Atributo	                Descripción
        	name	        Nombre exclusivo del servlet (como en web.xml)
        	displayName	    Nombre de servlet legible por humanos
        	description	    Descripción del servlet
        	value	        Establece la URL para el mapeo
        	urlPatterns	    Especifica una lista de URL para mapear (usado en lugar de valor)
        	initParams	    Le permite establecer los parámetros de inicio del servlet
        	asyncSupported	Especifica que el servlet puede ejecutarse de forma asíncrona (HTTP/2)
        	loadOnStartup	Número de secuencia para controlar la prioridad de inicio del servlet
        	smallIcon	    Establece un pequeño icono de servlet
        	largeIcon	    Establece un icono de servlet grande


        //Configuración del mapeo de filtros
        Estos son los atributos que tiene una anotación @WebFilter:
        	Atributo	            Descripción
    	filterName	        Filtrar nombre único (como en web.xml)
	    displayName	        Nombre de filtro legible por humanos
	    description	        Descripción del filtro
	    value / urlPatterns	Establece una lista de URL para mapear
	    dispatcherTypes	    Especifica una lista de DispatcherTypes
	    servletNames	    Especifica una lista de servlets para aplicar a
	    initParams	        Le permite establecer los parámetros de inicio del filtro.
	    asyncSupported	    Especifica que el filtro puede ejecutarse de forma asíncrona (HTTP/2)
	    smallIcon	        Establece un pequeño icono de filtro
	    largeIcon	        Establece un icono de filtro grande

*/

    }
}
