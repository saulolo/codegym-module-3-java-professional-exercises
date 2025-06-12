package org.educatiom.lesson12_Servlets;

public class Servlets {

    public static void main(String[] args) {

        System.out.println("--------------------- Servlets ---------------------------");
        //Interfaz de Servlet
        /*Fue la adición de servlets a Java lo que llevó a Java a ser el estándar de facto para aplicaciones de
        servidores grandes. El 80% de tod el software empresarial del mundo está escrito en Java. Y en China, tod es
        al 100%. Entonces, ¿qué son los servlets?

        Un servlet es exactamente lo que convierte un programa Java en un servicio web y le permite procesar las
        solicitudes de los clientes

        Entonces, un servlet es un complemento de Java que se incorporó Java web-servery le permitió ejecutar código
        Java cuando se solicitó para ciertas páginas. Y ya este código Java, representado por una clase heredada de la
        clase Servlet, hizo lo que pretendían sus desarrolladores.

        Y como ya sabrás, el servidor web Java más popular es Tomcat . Nombrado, por cierto, en honor al gato Tom de la
        caricatura "Tom y Jerry"

        ¿Cómo interactúa Tomcat con los servlets? De hecho, este proceso está estandarizado y se denomina ciclo de vida
        del servlet . En él, un servlet es un objeto cargable y un servidor web es un contenedor de servlet .


        //Clase HttpServlet
        Los programadores no trabajan directamente con esta clase. Bueno, rara vez funcionan. La clase más utilizada
        HttpServletse hereda de Servlet.

                        Metod                                  Descripción
        	init()	                            Llamado una vez cuando se carga el servlet
        	destroy()	                        Llamado una vez cuando se descarga el servlet
        	service(HttpRequest, HttpResponse)	Llamado para cada nueva solicitud al servlet
        	doGet(HttpRequest, HttpResponse)	Llamado para cada nueva solicitud GET al servlet
        	doPost(HttpRequest, HttpResponse)	Llamado para cada nueva solicitud POST al servlet
        	doHead(HttpRequest, HttpResponse)	Llamado para cada nueva solicitud HEAD al servlet
        	doDelete(HttpRequest, HttpResponse)	Llamado para cada nueva solicitud DELETE al servlet
        	doPut(HttpRequest, HttpResponse)	Llamado para cada nueva solicitud PUT al servlet


        //service(HttpServletRequest request, HttpServletResponse response)
        El métod service()tiene una implementación predeterminada. Si no se redefine, se ejecutará.

                Metod	                                    Descripción
        service(HttpRequest, HttpResponse)	Llamado para cada nueva solicitud al servlet
        doGet(HttpRequest, HttpResponse)	Llamado para cada nueva solicitud GET al servlet
        doPost(HttpRequest, HttpResponse)	Llamado para cada nueva solicitud POST al servlet
        doHead(HttpRequest, HttpResponse)	Llamado para cada nueva solicitud HEAD al servlet
        doDelete(HttpRequest, HttpResponse)	Llamado para cada nueva solicitud DELETE al servlet
        doPut(HttpRequest, HttpResponse)	Llamado para cada nueva solicitud PUT al servlet

        En su clase, puede redefinir un metod service()o dejarlo solo, pero luego redefinir los métodos doGet(),
        doPost(), ... según sea necesario.

        //HttpServletRequest
        Este objeto tiene bastantes métodos, ya que simplemente almacena los datos de la solicitud, ya través de él puedes interactuar con el contenedor.

        Los métodos se pueden dividir en 2 grandes grupos:

        Métodos relacionados con la autorización del usuario
        Métodos para trabajar con datos de consulta

        //Solicitar datos
        El segundo grupo de métodos es mucho más interesante. ¿Qué tipo de datos tenemos en la solicitud?

        - Metod http
        - URI
        - Opciones
        - Títulos

        Veamos qué métodos están disponibles para trabajar con ellos:

            Metod	                            Descripción
    	getMethod()	                Devuelve el Metod HTTP: GET, POST, DELETE, ...
    	getRequestURI()	            Devuelve el URI de solicitud: http://codegym.cc/my/data
    	getRequestURL()	            Devuelve la URL de solicitud: http://codegym.cc/my/data
    	getQueryString()	        Devuelve Query, es decir, tod después de ?
    	getParameterMap()	        Devuelve una lista de parámetros de consulta.
    	getParameter(String name)	Devuelve el valor del parámetro por su nombre
    	getContentType()	        Devuelve el cuerpo de la solicitud MimeType
    	getReader()	                Lector para leer el cuerpo de la solicitud como texto
    	getInputStream()	        InputStream para leer el cuerpo de la solicitud como byte []
    	getSession()	            Devuelve un objeto HttpSession
    	getCookies()	            Devuelve una matriz de objetos Cookie[]
    	getHeaderNames()	        Devuelve una lista de títulos, solo nombres.
    	getHeader(String name)	    Devuelve el valor del encabezado por nombre
    	getServletPath()	        Devuelve la parte de la URL que hace referencia al servlet
    	getContextPath()	        Devuelve la parte de la URI que especifica el contenido de la solicitud


    	//Clase HttpServletResponse
        Después de llamar service()a su metod de servlet, el contenedor web generará una respuesta al cliente basada en
        el archivo HttpServletResponse. Entonces, si desea influir de alguna manera en la respuesta del cliente, debe
        modificar este objeto.

        La respuesta del servidor consta de tres partes:

        - Línea de estado (por ejemplo: 200 OK)
        - Encabezados
        - Cuerpo de respuesta

        La respuesta de su servlet se escribe en un búfer, no se envía inmediatamente al usuario. Por lo tanto, en algún
        momento (si, por ejemplo, ocurre un error), puede restablecer (borrar) tod lo que está escrito en el búfer.
        Incluso puede llamar al metod reset() y borrar no solo el contenido del búfer, sino también los encabezados
        con el código de respuesta.

        //RedirectServlet()
         El segundo punto importante es la redirección. Si su servlet decide redirigir al cliente a otra URL, entonces
         debe enviar esta URL de alguna manera al cliente. Esto se puede hacer usando el sendRedirect.

        //getWriter()
        Para ello, la clase HttpServletResponsetiene un metod especial getWriter()que devuelve un objeto PrintStream.
        Si alguien se olvidó, este es el tipo de campo con el nombre System.out.

        Para escribir un texto como respuesta del servlet, necesita:

        - Obtenga el objeto PrintStream llamando al response.getWriter().
        - Escriba lo que considere necesario en el objeto PrintStream (todos los datos se escribirán en el búfer).
        - Envíe el búfer al usuario llamando al metod close()en PrintStream.

        */

        System.out.println("--------------------- HttpSession ---------------------------");
        /*Cuando un cliente realiza una solicitud a un servlet, el contenedor de servlet verifica si el parámetro ID de
        sesión está presente en la solicitud. Si no existe dicho parámetro (por ejemplo, el cliente se está comunicando
        con el servidor por primera vez), el contenedor de servlet crea un nuevo objeto HttpSession y también le asigna
        una ID única. ¿Por qué es necesaria una sesión? Puede almacenar información sobre el cliente entre llamadas.
        Tiene algo así como un HashMap en su interior, en el que puedes almacenar objetos por claves. Y algunos métodos
        para esto:

                Métodos	                                Descripción
        setAttribute(String name, Object o)	    Agrega un objeto a la sesión.
        getAttribute(String name)	            Obtiene un objeto de la sesión.
        removeAttribute(String name)	        Elimina un objeto de la sesión.

        Primero, es el nombre J SESSION ID. Es debajo de él que la identificación de la sesión se almacena en las cookies.
        Como puede ver, es bastante fácil de recordar: J+SESSION+ID.

        Si nadie usó la sesión durante un intervalo de tiempo, entonces se borra sola: todos los objetos que almacenó
        se eliminan de ella. Esto se hace para ahorrar memoria.

        Por defecto, este intervalo es de 1800 segundos == 30 minutos. Si establece el valor en -1, la sesión será
        "eterna" y se eliminará solo cuando el usuario cierre la pestaña del navegador (bueno, o el cliente se desconecte).

        //init()
        Después de que el servidor web haya creado el objeto servlet y lo haya colocado en el contenedor, llama al
        métod init() del servlet . Puede anular este métod e inicializar lo que necesite en él.

        //getConfig()
        Por cierto, no todos los parámetros se pueden pasar al servlet en los archivos de propiedades. Por ejemplo, su
        servlet interactúa con otros servlets en una aplicación web distribuida.

        Luego, debe asegurarse de que el contenedor pase toda la información necesaria a su servlet cuando llame a su
        métod init() . Además, él hace precisamente eso.

        */

        System.out.println("--------------------- Filters ---------------------------");
        //Introducción a los filtros
        /*También existen los llamados "servlets de utilidad": filtros . Son muy similares a los servlets, pero su
        trabajo principal es ayudar a los servlets a procesar las solicitudes

        Un filtro es como una secretaria y un servlet es como un director. Antes de que el documento llegue al escritorio
        del director, pasará por las manos del secretario. Y después de que el director lo firme, volverá a pasar a la
        secretaria, ya como correspondencia saliente

        +--------+               +------------------------------+
        | CLIENT | <=======> <==>  |        Container             |
        +--------+               |  +--------+    +----------+  |
                                 |  | Filter |<-->| Servlet 1|  |
                                 |  +--------+    +----------+  |
                                 |  | Filter |<-->| Servlet 1|  |
                                 |  +--------+    +----------+  |
                                 |  | Filter |<-->| Servlet 1|  |
                                 |  +--------+    +----------+  |
                                 |  | Filter |<-->| Servlet 1|  |
                                 |  +--------+    +----------+  |
                                 +------------------------------+

        Leyenda:
        => flujo de petición
        <= flujo de respuesta

        //Filter, FilterChain, FilterConfig
        Los filtros son muy similares a los servlets, pero con un par de pequeñas diferencias. Para escribir su propio
        filtro, debe heredar del javax.servlet.Filter.

        El filtro también tiene métodos init()y destroy(). En lugar de un métod, service()un filtro tiene un doFilter().
        E incluso tiene su propia clase FilterConfig. El filtro también se agrega al servlet en el archivo web.xml o
        mediante la anotación @WebFilter.

        Metods:
            Métodos	                                                Descripción
        init(FilterConfig config)	                            Inicialización del filtro
    	destroy()	                                            Descarga del filtro
    	doFilter(ServletRequest , ServletResponse, FilterChain)	Procesamiento de solicitudes (filtrado)

    	¿Cuál es la diferencia entre un servlet y un filtro?
    	Puede haber varios filtros, y procesan secuencialmente la solicitud (y la respuesta). Se combinan en una llamada
    	cadena, e incluso hay una clase especial para ellos FilterChain.

        Después de procesar la solicitud en el métod, doFilter()debe llamar al método doFilter()del siguiente filtro en
        la cadena.

        En realidad, no puede agregar el cuerpo de la respuesta de esa manera . Formalmente, los filtros y los servlets
        son independientes entre sí y se pueden cambiar de forma independiente. Pueden ser escritos por diferentes
        desarrolladores en diferentes momentos. La función de filtro es solo una función de servicio, por ejemplo:

        - Registro de todas las solicitudes entrantes (y respuestas)
        - Compresión de datos
        - Cifrado (y descifrado) de datos
        - Solicitar Validación de Datos
        - Agregar/eliminar encabezados deseados
        - Solicitudes de redireccionamiento
        - Control de acceso (comprobar si el usuario ha iniciado sesión

        //RequestDispatcher
        Este objeto se puede utilizar para redirigir una solicitud existente a otro servlet . Por ejemplo, resultó que
        el usuario no está autorizado y queremos mostrarle una página con autorización. Bueno, o hubo un error en el
        servidor y queremos mostrar una página de error al usuario.

        //Comparación de redireccionamiento y reenvío
        Y un punto más importante. Si desea redirigir al usuario a otro URI en su servlet, puede hacerlo de dos maneras:

        - redirect
        - forward

        */

    }
}
