package org.educatiom.lesson10_HttpClient;


public class HttpClient {

    public static void main(String[] args) {

        System.out.println("--------------------- HttpClient ---------------------------");
        //Introducción a HttpClient
        /*A partir de JDK 11, los desarrolladores de la plataforma Java agregaron una nueva y poderosa herramienta a
        JDK para realizar solicitudes http, el archivo java.net.http. Contiene cuatro clases clave:

        HttpClient
        HttpRequest
        HttpResponse
        WebSocket

        Estas son clases muy poderosas que le permiten realizar todos los tipos posibles de solicitudes utilizando los
        protocolos HTTP, HTTP/2y WebSocket
        Además, puede utilizar estas clases para realizar solicitudes http sincrónicas y asincrónicas.
        Hacer una solicitud http consta de las siguientes partes:

        Crear un objetoHttpClient
        Crear un objetoHttpRequest
        Envío de una solicitud mediante el métod send()osendAsync()
        Procesamiento de respuestasHttpResponse

        Ejemplo:
        HttpClient client = HttpClient.newBuilder()
                .version(Version.HTTP_1_1)
                .followRedirects(Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
                .authenticator(Authenticator.getDefault())
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
*/


        System.out.println("--------------------- Hacer una petición con HttpRequest ---------------------------");
        //newBuilder(), build()
        /*La clase HttpRequest se usa para describir una solicitud http, que es fácil de entender por su nombre.
        Este objeto no hace nada por sí mismo, solo contiene información diversa sobre la solicitud http. Por lo tanto,
        como probablemente ya adivines, la plantilla de Builder también se usa para crearlo.

        HttpRequest request = HttpRequest.newBuilder() .method1() .method2() .methodN() .build();

        Un ejemplo de una solicitud simple se ve así:

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(“http://codegym.cc”))
            .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //uri()
        Con el métod uri() , puede establecer la URI (o URL) a la que se enviará la solicitud http
        Puede configurar el métod de solicitud http utilizando los siguientes métodos:
        Métodos GET(), POST(), PUT(), DELETE()

        //version()
        También puede configurar la versión del protocolo HTTP. Solo hay 2 opciones:

        HttpClient.Versión.HTTP_1_1
        HttpClient.Versión.HTTP_2

        //timeout()
        También puede establecer el tiempo de ejecución de la consulta. Si pasa y la solicitud nunca se completa, se
        lanzará una HttpTimeoutException .
        El tiempo en sí se establece usando el objetoduraciónde la API de fecha y hora de Java.
        Ejemplo:
        HttpRequest request = HttpRequest.newBuilder()
           .uri(new URI("https://codegym.cc"))
           .timeout( Duration.of(5, SECONDS) )
           .GET()
           .build();

         //header()
         También puede agregar cualquier cantidad de encabezados a cualquier solicitud. Y es tan fácil de hacer como
         cualquier otra cosa. Hay un métod especial para esto: header()
         ejemplo:
         HttpRequest request = HttpRequest.newBuilder()
           .uri(new URI("https://codegym.cc"))
           .header("name1", "value1")
           .header("name2", "value2")
           .GET()
           .build();

         Hay otra forma alternativa de configurar muchos encabezados a la vez. Puede ser útil si, por ejemplo, convirtió una lista de encabezados en una matriz:

        HttpRequest request = HttpRequest.newBuilder()
           .uri(new URI("https://codegym.cc"))
           .headers("name1", "value1", "name2", "value2")
           .GET()
           .build();
        */


        System.out.println("--------------------- Agregar el Body a HttpRequest ---------------------------");
        //Editando el Body
        /*Hay solicitudes PUT y POST , cuando también necesita agregar a la solicitud , es decir, el cuerpo de la
        solicitud.request body

        HttpRequestLa clase tiene una clase interna especial para esto BodyPublisher. Aunque técnicamente es una
        interfaz que tiene múltiples implementaciones

        Ausencia de un cuerpo en la solicitud:
        HttpRequest request = HttpRequest.newBuilder()
           .uri(new URI("https://codegym.cc"))
           .POST(HttpRequest.BodyPublishers.noBody())
           .build();

         //ofString()
           La segunda opción más común es pasar alguna cadena como cuerpo de la solicitud
              .POST(HttpRequest.BodyPublishers.ofString("Hello"))

         //ofFile()
         Finalmente, es posible que desee adjuntar un archivo a la solicitud POST . Así es como normalmente se suben
         tus avatares al servidor.
            .POST(HttpRequest.BodyPublishers.ofFile(avatar))

        //ofByteArray()
        Otro escenario común es enviar un conjunto de bytes al servidor. Por ejemplo, serializó algún objeto como un
        conjunto de bytes, encriptó algo o simplemente desea enviar algún búfer de datos.

        //ofInputStream()
        e permite organizar la transferencia de datos de un flujo a otro, adjuntar un flujo de datos a una solicitud
        de POS que aún no está abierta.

        */

        System.out.println("--------------------- Hacer una solicitud con HttpClient ---------------------------");
        //Metods Send() y BodyHandler()
        /*Esto es lo más importante: enviar esta solicitud.
         Enviaste una solicitud, lo que significa que deberías recibir una respuesta: http response. Y esta respuesta
         puede tener response body: una cadena, un archivo, una matriz de bytes, un InputStream.
         Al igual que cuando se forma una solicitud, debe especificar el tipo response bodyde respuesta. Puede haber 8 piezas en total:

        BodyHandlers.ofByteArray
        BodyHandlers.ofString
        BodyHandlers.ofFile
        BodyHandlers.discarding
        BodyHandlers.replacing
        BodyHandlers.ofLines
        BodyHandlers.fromLineSubscriber
       Según el tipo que BodyHandlershaya pasado al métod send(), devolverá ese tipo de resultado.

       //followRedirects()
       301Además, al enviar una solicitud, puede especificar qué debe hacer HttpClient si el servidor envía o
       302(redireccionamiento temporal o permanente) en respuesta .
       Solo hay 3 opciones para una redirección:
        ALWAYS - siempre;
        NEVER - nunca;
        NORMAL - siempre, excepto HTTPS -> HTTP.

        //proxy()
        Hay un par de opciones más útiles, pero que no se usan con frecuencia. No los necesitas exactamente hasta que
        los necesitas
        El primero es proxy. En la vida cotidiana, no los encuentra a menudo, pero muchas grandes corporaciones tienen
        un complejo sistema de seguridad de tráfico de Internet en su interior y, por lo tanto, varias configuraciones
        de proxy.

        //authenticator()
        Y un punto más importante. El protocolo HTTP admite la autenticación. Justo a nivel de protocolo.
        Ahora este enfoque casi no se usa
        El inicio de sesión e incluso la contraseña se pueden especificar directamente en la solicitud http. Sí,
        incluso ahora puedes.
        no se permite que todas las contraseñas se almacenen como una cadena completa por motivos de seguridad, incluso
        en su propia aplicación . Es decir, su aplicación en su memoria no debe almacenar la contraseña como una cadena.
        De modo que si alguien hizo una memoria húmeda, no se pudo extraer la contraseña .

         */

        System.out.println("--------------------- Solicitudes asíncronas en HttpClient ---------------------------");
        //sendAsync()
        /*También puede enviar solicitudes asincrónicas mediante HttpClient. Por lo general, esto se hace en tres casos.
        El primer caso es que la solicitud llevará mucho tiempo , por ejemplo, enviar/recibir un archivo. A continuación,
        esta operación se inicia y ejecuta de forma asíncrona.

        El segundo caso es que necesita enviar solicitudes con mucha frecuencia y no desea esperar una respuesta de la
        solicitud anterior antes de enviar la siguiente.

        Y finalmente, el tercer caso: el resultado de su solicitud no es importante para usted . Por ejemplo, toma una
        captura de pantalla de su pantalla una vez por minuto y la envía al servidor. Es decir, la lógica de su
        aplicación asume que hay muchas solicitudes y no todas llegan. Entonces es conveniente trabajar de acuerdo con
        el principio: enviar y olvidar.

        El métod sendAsync()devuelve un objeto CompletableFutureque contiene un HttpResponse dentro, que contiene la
        cadena que devolverá el servidor.

        //executor(), ExecutorService
        HttpClient le permite pasar a él ExecutorService(un conjunto de subprocesos) que se utilizará para realizar
        solicitudes asincrónicas. En realidad, en las aplicaciones Java del lado del servidor, esto siempre se hace.

        */

        System.out.println("--------------------- Trabajando con cookies ---------------------------");
        //Administrador de cookies
        /*Como ya sabe, el servidor http puede enviar cookies junto con la respuesta y deberá trabajar con ellas.
        O viceversa, el servidor http está esperando que el cliente le envíe Cookies y debe agregarlas a su solicitud
        http. Por supuesto, puede hacer esto directamente a través de los encabezados (controladores), pero HttpClient
        le ofrece un mecanismo más conveniente: el CookieHandler. Puedes obtenerlo usando el cookieHandler()

        CookieHandler es una clase abstracta, por lo que es común trabajar con su implementación CookieManager.
        Que, a su vez, tiene solo un par de métodos a través de los cuales puede obtener el objeto CookieStore.

        CookieStore es una interfaz que tiene los siguientes métodos:

        add()
        get()
        getCookies()
        remove()
        removeAll()

        */

    }
}
