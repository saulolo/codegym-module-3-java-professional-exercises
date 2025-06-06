package org.educatiom.lesson09_ProtocoloHTTP;


public class Rest {

    public static void main(String[] args) {

        System.out.println("--------------------- REST ---------------------------");
        //Enfoque de API remota
        /*Todos los programadores cometen el mismo error al construir una arquitectura cliente-servidor. Comienzan a
        tratar las solicitudes al servidor como llamadas a métodos .

        para procesar correctamente las llamadas a nuevos métodos, el servidor debe recordar los resultados de las llamadas a métodos anteriores.

        En la web, esto es un gran problema. Internet puede desaparecer, el navegador puede cerrarse. La página se puede
        volver a cargar o hacer clic accidentalmente en un enlace, y así sucesivamente. Y el servidor seguirá almacenando
        megabytes de datos de solicitudes de usuarios anteriores.
        Entonces, ¿cómo llamar a los métodos del servidor? La respuesta correcta sería terrible: ¡de ninguna manera!


        //Enfoque REST
        El servidor se considera como un repositorio de datos que es visible al exterior en forma de árbol .
        Si desea obtener una lista de todos los usuarios, llame a la consulta

        http://server.com/users

        Si desea obtener datos sobre el usuario 113, ejecute la consulta:
        http://server.com/users/113
        Y así sucesivamente, tod en la misma línea.

        Una vez más, el servidor se ve como un depósito de datos que es visible desde el exterior en forma de árbol.

        Los datos se pueden recibir: solicitudes GET , modificación: solicitud POST y eliminación: solicitud DELETE .

        //Sin estado
        El protocolo REST de interacción entre el cliente y el servidor requiere la siguiente condición: durante el
        período entre solicitudes del cliente, no se almacena información sobre el estado del cliente en el servidor.
        El estado de la sesión se guarda en el lado del cliente.

        //Uniformidad de la interfaz
        Todas las rutas utilizadas para recuperar objetos del servidor están estandarizadas. Esto es muy conveniente,
        especialmente si obtiene datos de otros servidores REST.

        Todas las interfaces de objetos deben cumplir con tres condiciones:
        - Identificación de recursos: Todos los recursos se identifican en las solicitudes mediante un URI. Los recursos
        dentro del servidor están separados de las vistas que se devuelven a los clientes.
        - Manipulación de recursos a través de una vista: Si el cliente almacena una representación del recurso,
        incluidos los metadatos, entonces tiene suficiente información para modificar o eliminar el recurso en el servidor.
        - Mensajes "autodescriptivos": Cada mensaje contiene suficiente información para entender cómo manejarlo.
        Por ejemplo, si necesita información sobre el usuario

         //Almacenamiento en caché
        El enfoque REST asume que las solicitudes de datos se realizan a través del protocolo HTTP. Por lo tanto, los
        objetos se obtienen llamando a una solicitud GET. Esto significa que, como todos los recursos recibidos a través
        de una solicitud GET, están sujetos a todas las reglas para almacenar en caché los recursos HTTP.
        Es decir, los datos recibidos a través de la API REST se almacenan en caché de la misma manera que cualquier
        recurso estático en los servidores web.

        */


        System.out.println("--------------------- Tipos de protocolo http ---------------------------");
        //http
        /*Existen tres versiones de dichos protocolos

                +---------------------+
                |   HTTP Semantics    |
                +--------+-----+------+
                |HTTP 1.1|HTTP/2|HTTP/3|
                +--------+-----+------+
                | TLS/SSL|TLS  | TLS  |
                |optional|1.2+ | 1.3  |
                +--------+-----+------+
                |  TCP   | TCP | QUIC |
                +--------+-----+------+
                |           UDP       |
                +---------------------+
                |     IPv4 / IPv6     |
                +---------------------+


        //https
        Comencemos con la primera modificación del protocolo http: el protocolo https . Este es el mismo http, pero se
        le ha agregado el cifrado de contenido. Después de tod, las solicitudes y respuestas Http son archivos de texto
        ordinarios. Probablemente no desee que tod lo que su navegador envíe y reciba pase por Internet sin problemas.

        Para solucionar este problema se inventó el protocolo https ( http+security ) . Cuando intenta realizar una
        solicitud utilizando el protocolo https, su navegador primero establece una conexión con el servidor requerido y
        le solicita su certificado SSL.

        Luego se verifica la autenticidad de este certificado: contiene el nombre del dominio y una lista de claves
        públicas de quienes emitieron este certificado al servidor.

        Si el certificado es genuino, el navegador establece una conexión cifrada con ese servidor. Y ya dentro de esta
        conexión, los datos se transmiten a través del protocolo http.

        Hoy en día, este protocolo se ha convertido en el estándar de facto y casi ha suplantado al antiguo http.

        //http/2
        Pero no hay nada en este mundo que no se pueda mejorar. Después de que Google ganó la guerra de los navegadores ,
        decidió apoderarse de tod Internet. Y, por supuesto, por una causa noble. Decidieron mejorar el protocolo http.
        - Cifrado obligatorio.
        - Compresión de datos en cabeceras HTTP.
        - El servidor puede enviar archivos incluso antes de que sean solicitados (tecnología push).
        - Puede haber varias solicitudes http en una única conexión TCP.
        - Las solicitudes se procesan como una canalización (no es necesario esperar una respuesta para enviar una nueva solicitud).
        - El protocolo es binario (no es necesario traducir los caracteres no imprimibles a texto).

        Gran parte de esto está oculto para el programador de Java y se mantiene a nivel del servidor web y del navegador.

        //http/3
        La tercera versión del protocolo http aún se está finalizando y su mayor innovación es el rechazo del protocolo
        TCP. Los datos pasarán inmediatamente por UDP.



        */

    }
}
