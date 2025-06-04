package org.educatiom.lesson09_ProtocoloHTTP;


public class ArquitecturaClienteServidor {

    public static void main(String[] args) {

        System.out.println("--------------------- Arquitectura Cliente-Servidor ---------------------------");
        //Arquitectura Cliente-Servidor
        /*Todos los participantes de la red se dividen en dos partes lógicas: cliente y servidor.
        La tarea del servidor (servidor, de servir a servir) es atender las solicitudes de los clientes.
        La tarea del cliente es vivir en su propio placer. Cuando el cliente necesita algunos datos del servidor,
        le envía una solicitud.
        Las solicitudes siempre son iniciadas por el cliente. El modo de comunicación siempre tiene lugar en forma de
        petición-respuesta. En cierto sentido, esto es sinónimo del concepto de “cliente-servidor” .

        //Ventajas de la arquitectura cliente-servidor:
        - Confiabilidad

         */

        System.out.println("--------------------- URL del dispositivo ---------------------------");
        /*enlaces o URL. URL significa Localizador Universal de Recursos. Un enlace típico viene dado por una plantilla:
        protocol://host/path?query#anchor
        - Protocol: especifica el nombre del protocolo por el cual el cliente y el servidor se comunicarán.
        Nombres de protocolo típicos: HTTP, HTTPS, FTP, SSH, etc,
        - Hostes el nombre del servidor en la red para enviar la solicitud. Inicialmente era una dirección IP, pero a
        la gente rápidamente se le ocurrieron nombres legibles por humanos (nombres de dominio) para no recordar nada.
        Inicialmente, no queryse pensó en ninguno. Pathespecificó la ubicación del archivo HTML que se suponía que el
        servidor le daría al cliente. Sin embargo, después de que los aficionados se hicieran cargo de la web, rápidamente
        se dieron cuenta de que los archivos HTML podían crearse dinámicamente en el lado del servidor. Por lo tanto, se
        agregó una sección a la URL query, en la que se puede pasar un montón de información útil al servidor.
        Y finalmente anchor, esta es solo una etiqueta especial en una página HTML que le dice al navegador que la
        página no solo debe mostrarse, sino también desplazarse a un lugar determinado, es decir, una etiqueta.

        //Query
        La parte del enlace debajo del títuloquery comienza inmediatamente después del signo de interrogación y
        termina con un # (o el final del enlace). La información de la consulta es un conjunto de parámetros con el
        siguiente formato:
        name=value&name2=value2&nameN=valueN
        La URL no puede contener espacios
         */

        System.out.println("--------------------- Estructura del mensaje HTTP ---------------------------");
        //Vista general del mensaje http
        /*Cada solicitud http (solicitud http) tiene una estructura específica. Y lo mejor es que es un archivo de texto,
        bastante legible incluso para una persona no preparada.
        El mensaje consta de tres partes. La primera línea es la llamada línea inicial , que determina el tipo de mensaje.
        Luego están los parámetros, que también se llaman encabezados, encabezados . Bueno, al final está el cuerpo del
        mensaje .
        ¿Y cómo determinar dónde terminaron los encabezados y comenzó el cuerpo del mensaje? Y aquí tod es simple:
        los encabezados y el cuerpo del mensaje están separados por una línea vacía . Tan pronto como vieron una línea
        vacía en un mensaje http, el cuerpo del mensaje la sigue inmediatamente.

        //Línea de salida
        El tipo de línea de salida está estandarizado y lo establece la plantilla:
        Method URI HTTP/Version

        Para una mejor comprensión, tomemos algunos ejemplos. La página personal del usuario de CodeGym está dada por el
        enlace https://codegym.cc/me

        GET/me HTTP/1.0
        Host: codegym.cc

        omo respuesta, lo más probable es que el servidor envíe:
        HTTP/1.0 200 OK
        page text...

        //Encabezados
        Vienen al principio de un mensaje http. Quizás sería más correcto llamarlos parámetros de servicio.
        Son necesarios para que el cliente http y el servidor http entiendan mejor cómo comunicarse y cómo interpretar
        exactamente los datos recibidos.

        Ejemplos de tales encabezados:
        Content-Type: text/html;charset=windows-1251
        Allow: GET,HEAD,OPTIONS
        Content-Length: 1984

        Cada encabezado es un par de nombre y valor separados por dos puntos, como en JSON.

        */

        System.out.println("--------------------- Métodos HTTP ---------------------------");
        //Lista de métodos HTTP
        /*La primera palabra en una solicitud HTTP es el nombre del métod.

        El estándar HTTP especifica los siguientes métodos:

        Métod      Descripción
        GET         Utilizado para solicitar el contenido del recurso especificado.
        POST        Utilizado para enviar datos desde el cliente al servidor. Crea un nuevo recurso en el servidor.
        PUT         Utilizado para enviar datos desde el cliente al servidor. Modifica el estado del recurso en el servidor.
        DELETE      Elimina el recurso especificado en el servidor.
        HEAD        Es similar a GET, pero el cuerpo de la respuesta está ausente. Se utiliza para recuperar encabezados de respuesta.
        OPTIONS     Solicita al servidor que proporcione una lista de métodos admitidos para el recurso especificado.
        TRACE       Es un metod de servicio que permite verificar si las solicitudes son alteradas por los servidores por los que pasa.
        CONNECT     Es un métod de servicio. Se utiliza para establecer una conexión segura.

        //GET
        Esto es lo que llama el navegador cuando envía una solicitud al servidor para la página siguiente.
        Como resultado, el servidor deberá enviar una respuesta HTTP al navegador, en la que escribir el estado de la
        solicitud y también enviar el recurso solicitado.

        En primer lugar, los recursos recibidos mediante la solicitud GET, el navegador puede almacenar en caché a su
        discreción (hay matices).

        En segundo lugar, al enviar una solicitud al servidor, puede especificar un encabezado especial If-Modified-Sincey
        un archivo date. Si el recurso/documento solicitado ha cambiado desde la fecha especificada, el servidor lo
        enviará. Si no se modifica, no se pasa el cuerpo del recurso. Se supone que está en caché en el cliente.

        //POST y PUT
        El métod POST se utiliza para actualizar un recurso en el servidor. Por ejemplo, cuando carga una imagen en el
        servidor, su navegador envía una solicitud POST.

        Como resultado, el servidor deberá enviar una respuesta HTTP al navegador, en la que escribirá el estado de la
        solicitud y también enviará el recurso modificado. Llamar al métod POST varias veces cambia el estado del
        servidor y el servidor puede devolver una respuesta diferente cada vez .

        //DELETE
        Al recibir esta solicitud, el servidor eliminará el recurso especificado.

        */

        System.out.println("--------------------- Códigos de respuesta HTTP ---------------------------");

        /*La primera línea de la respuesta HTTP es el drenaje estatal. Consta de dos partes: un número de tres dígitos
        (código de respuesta) y un mensaje de texto (descripción de la respuesta).
        RESPONSE-CODE TEXT-DESCRIPTION

        Los códigos de respuesta se dividen en 5 categorías. El primer dígito del código de respuesta determina a qué
        categoría pertenece.

        //Código de respuesta 100
        Todas las respuestas que comienzan con el número 1 se clasifican como informativas. No hablaremos de ellos en
        detalle .

        //Código de respuesta 200
        odas las respuestas que parecen 2xx tienen éxito. La respuesta más querida por los programadores es 200 OK ,
        lo que significa que tod está bien, la solicitud se completó con éxito.
        Código	    Línea	              Descripción
        200	    DE ACUERDO	                Bien
        201	    Creado	                    Creado
        202	    aceptado	                Aceptado
        203	    Información no autorizada	La información no es autorizada
        204	    sin contenido	            Sin contenido
        205	    Restablecer contenido	    Restablecer contenido
        208	    Ya reportado	            Ya reportado

        //Código de respuesta 301, 302
        Las respuestas que parecen 3xx están en la clase de redirección . Indican que el recurso se ha movido a otra ubicación.
        El más popular de ellos:
        301 - mudado permanentemente
        302 - movido temporalmente

        //Código de respuesta 404
        Todas las respuestas que comienzan con el número 4 indican un error del lado del cliente , y hay muchas.
        El más popular lo conoces con certeza: esta es la respuesta "404 - no encontrado".

        //Código de respuesta 501
        Y finalmente, la última categoría son los errores del lado del servidor. Todos estos errores comienzan con el
        número 5. El error más común para un desarrollador es 501 (funcionalidad no implementada). A veces ocurre.

        */

        System.out.println("--------------------- Encabezados HTTP ---------------------------");
        /*Los encabezados de solicitud http son en realidad información de servicio para el cliente http y el servidor
        http.
        Todos los encabezados http se pueden dividir en 4 grupos principales:

        #	Tipo de encabezado	        Descripción	Nota
        1	Encabezados generales	    Encabezados generales	Se utiliza en solicitudes y respuestas.
        2	Encabezados de solicitud	Encabezados de solicitud	Usado solo en solicitudes
        3	encabezados de respuesta	Encabezados de respuesta	Solo se usa en las respuestas.
        4	Encabezados de entidad	    Encabezados de entidad	Acompañar cada entidad de mensaje

        //User-Agent
        Es el encabezado más importante y popular, Esta es una cadena especial que describe qué cliente está realizando
        la solicitud al servidor. Este es el nombre del cliente.

        //Content-Type
        Se utiliza para determinar el tipo MIME del recurso que está sirviendo el servidor.
        Incluso en los albores de Internet, los tipos de contenido multimedia transmitidos se estandarizaron por
        conveniencia. Se denominan tipos de medios de Internet o MimeTypes para abreviar . Se dividen en 9 categorías:
        - solicitud
        - audio
        - ejemplo
        - imagen
        - mensaje
        - modelo
        - multiparte
        - texto
        - video

        //Content-Length
        Este encabezado especifica la longitud de la respuesta del servidor .

        //Accept-Encoding
        Con este encabezado, el cliente puede indicarle al servidor que admite varios algoritmos de compresión de
        contenido

        //Connection
        Keep-Alive
        le dice al servidor que mantenga la conexión abierta: el servidor no cerrará la conexión inmediatamente después
        de enviar la respuesta. Esto hará que la próxima solicitud del mismo cliente al servidor se complete más rápido.

        //Cache-Control
        se puede usar para controlar el almacenamiento en caché del contenido. El almacenamiento en caché configurado
        correctamente acelera el trabajo con el contenido, el almacenamiento en caché configurado torcidamente crea
        problemas de la nada.

        No se debe almacenar nada en el caché, ni de las solicitudes de los clientes ni de las respuestas del servidor.
        La solicitud siempre se envía al servidor, la respuesta siempre se descarga por completo.
        Para deshabilitar el almacenamiento en caché, debe escribir el siguiente encabezado:
        Cache-Control: no-cache, no-store, must-revalidate

        También puede habilitar el tipo de almacenamiento en caché más primitivo y confiable :
        Cache-Control: no-cache

        //Cookie
        El servidor puede almacenar datos en el lado del cliente . Estos datos se denominan cookies . Sin embargo, el
        cliente también puede almacenar la cookie. Son muy útiles para ambas partes.
        Por ejemplo, vas al sitio y ya estás autorizado en él. Es decir, cuando inició sesión la última vez, el servidor
        ordenó al navegador que almacenara información sobre el inicio de sesión exitoso de un determinado usuario.

        Cada cookie tiene 4 parámetros principales:
        - Nombre;
        - significado;
        - período de validez (cuánto tiempo para almacenarlos);
        - el dominio al que está vinculada la cookie.
        Las cookies se almacenan y transmiten en forma de texto, por lo que tanto el nombre como el valor son cadenas.
        Si no se especifica el tiempo de caducidad de las cookies, se destruyen después de cerrar el navegador.

        //Session
        Una vez que el usuario ha iniciado sesión en el sitio, dice que se ha establecido una sesión entre el sitio y el
        servidor.

        El servidor crea un objeto especial en sí mismo, HttpSession,donde almacena toda la información necesaria para
        trabajar con un cliente autorizado. Y el número único de este objeto se almacena en el navegador en forma de
        Cookie.

        Los servidores web de Java suelen utilizar un nombre JSESSIONIDpara almacenar el ID de la sesión.










        */

    }
}
