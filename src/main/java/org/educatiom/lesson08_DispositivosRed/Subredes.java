package org.educatiom.lesson08_DispositivosRed;


public class Subredes {

    public static void main(String[] args) {

        System.out.println("--------------------- Subredes ---------------------------");
        //Introducción a hosts y subredes
        /*Las direcciones IP se utilizan para identificar dispositivos en una red, Para comunicarse con otros dispositivos
        a través de una red, se debe asignar una dirección IP a cada dispositivo de red (incluidos ordenadores, servidores,
        enrutadores, impresoras). Dichos dispositivos en la red se denominan hosts .
        todas las computadoras que son atendidas por un equipo de red específico se denominan subred . Cada subred tiene
        un patrón por el cual el equipo de red asigna direcciones IP a sus subredes. Este patrón se denomina máscara de
        subred .
        Las máscaras de subred le permiten dividir una red en varias subredes y también establecer la cantidad máxima de
        hosts patrocinados.

        //Introducción a las direcciones IP
        Una dirección IP consta de cuatro partes, escritas como números decimales con puntos (por ejemplo, 192.168.1.1).
        Cada una de estas cuatro partes se llama octeto . Un octeto son ocho dígitos binarios, como 00001111.
        Así, cada octeto puede tomar el valor binario de 00000000a 11111111o de 0a 255decimal.

        //Estructura de la dirección IP
        La primera parte de la dirección IP es el número de red, la otra parte es la ID del host. Juntos forman una
        dirección IP de host única. Cuanto más corto sea el número de red, más hosts puede caber. Si el número de red
        ocupa 3 bytes, solo quedará un byte por número de host (el máximo 255 de hosts en la red).

        Los enrutadores utilizan el número de red para reenviar paquetes a las redes deseadas, mientras que la ID de
        host identifica el dispositivo específico en esa red a la que se deben entregar los paquetes.

        La siguiente figura muestra un ejemplo de una dirección IP donde los primeros tres octetos ( 192.168.1) son el
        número de red y el cuarto octeto ( 16) es la ID del host.




        La cantidad de dígitos binarios en una dirección IP que son por número de red y la cantidad de dígitos en una
        dirección que son por ID de host pueden ser diferentes según la máscara de subred.

        //

             . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .
            :                                                           :
            :                192.168.1.[16]< - - - - - - -              :
            :                    |                       |              :
            :                    V                       |              :
            :                .----------.          .-----------------.  :
            :                |    S     |          |                 |  :
            :                |    E     |----------|      [PC]       |  :
            :    .-------.   |    R     |          |                 |  :
            :    |  [PC] |---|    V     |          '-----------------'  :
            :    |       |   |    I     |                               :
            :    '-------'   |    D     |                               :
            :                |    O     |                               :
            :                |    R     |                               :
            :                ------------                               :
            :                  |   |  |                                 :
            :   .-------.      |   |  |        .-------.                :
            :   | [PC]  |------'   |  '--------| [PC]  |                :
            :   |       |          |           |       |                :
            :   '-------'          |           '-------'                :
            :                      |                                    :
            :                  .-------.                                :
            :                  | [PC]  |                                :
            :                  |       |                                :
            :                  '-------'                                :
            :                                                           :
            . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .

        */

        System.out.println("--------------------- Máscaras de subred ---------------------------");
        //IP privadas
        /*Cada host en Internet debe tener una dirección única. La excepción son las direcciones IP dentro de las redes
        locales.
        Si tiene su propia red local en su oficina, sus computadoras tendrán sus propias direcciones IP no únicas.
        Sin embargo, si es una computadora conectada directamente a Internet o un servidor, debe tener una dirección IP
        pública única.

        Existe una organización especial (IANA) que se ocupa de la distribución de direcciones IP. Los ISP le compran
        direcciones IP en bloques (subredes) y luego las venden a sus clientes. Entonces, si paga por una dirección IP
        blanca, entonces tod está en orden (el proveedor también paga dinero por ello).

        Dado que estas subredes no son públicas, cualquiera puede usarlas para cualquier propósito. Hay tres subredes de
        este tipo: grande, mediana y pequeña.

        Los siguientes tres bloques de direcciones IP están reservados para ellos:

        10.0.0.0—10.255.255.255
        172.16.0.0—172.31.255.255
        192.168.0.0—192.168.255.255
        Las direcciones IP de estas subredes privadas a veces se denominan direcciones "grises".

        //Máscaras de subred
        Para determinar qué bits de una dirección IP se refieren al número de host y qué bits se refieren al número de
        subred, se utiliza la llamada máscara de subred .

        Todos los bits de subred son iguales 1, todos los bits de host son iguales 0.

        //DHCP
        Los administradores del sistema pueden asignar direcciones estáticas a las computadoras. Los dinámicos se
        asignan a los equipos automáticamente mediante el servicio DHCP, este es un protocolo de aplicación que permite
        que los dispositivos de red obtengan automáticamente una dirección IP y otros parámetros necesarios para operar
        en una red TCP/IP.

        //Distribución de direcciones IP
        El protocolo DHCP proporciona tres formas de asignar direcciones IP:
        Distribución manual, Distribución automática y distribución dinámica.

        //Opciones de DHCP
        Además de la dirección IP, DHCP también puede proporcionar al cliente parámetros adicionales necesarios para el
        funcionamiento normal de la red. Estas opciones se denominan opciones de DHCP. Hay muchos, pero solo necesitas
        conocer algunos de ellos.

        Algunas de las opciones más utilizadas son:
        - dirección IP del enrutador predeterminado;
        - Máscara de subred;
        - direcciones de servidores DNS;
        - Nombre de dominio DNS.

        ¿Qué es 127.0.0.1?
        La dirección IP 127.0.0.1se conoce como dirección de bucle invertido, pero puede verla como localhost .
        Cuando apunta su navegador a 127.0.0.1, intenta conectarse a la computadora que está usando en este momento.
        Esto es útil cuando desea conectarse a un servidor en su computadora.

        127.0.0.1es especial entre las direcciones IP. Como regla general, la dirección IP es única para cada computadora
        tanto en la red local como en Internet. Sin embargo, 127.0.0.1siempre apunta a la computadora que está usando
        actualmente, pase lo que pase.

        Por ejemplo, configura un servidor en la computadora de su trabajo y puede conectarse escribiendo 127.0.0.1en su
        navegador en el trabajo. Sin embargo, cuando llegue a casa y escriba 127.0.0.1, se conectará a la computadora de
        su casa. Para conectarse a una computadora de trabajo, necesitará su dirección IP pública.

        //¿Qué es localhost?
        Escribirlo asi: 127.0.0.1. o asi: localhost es lo mismo, Puede pensar en localhost como el "nombre" de una
        dirección 127.0.0.1.

        Localhost no necesita un servidor DNS porque su computadora ya sabe que desea conectarse a ella.
        De esta manera, puede usar localhost incluso si no tiene una conexión a Internet.

                 */

        System.out.println("--------------------- DNS ---------------------------");
        //Introducción a DNS
        /*En los años 70, la gente se cansó de recordar las direcciones IP de los servidores a los que querían acceder.
        Al mismo tiempo, surgió la idea de usar un nombre más simple y fácil de recordar en lugar de una dirección de
        host numérica.
        En 1984, cuatro estudiantes de UC Berkeley escribieron la primera versión del sistema de nombres de dominio
        jerárquico. Ahora se usa ampliamente, especialmente en sistemas Unix, y sigue siendo el software de DNS más
        utilizado en Internet.

        ¡Importante! El nombre y la dirección IP no se relacionan necesariamente como uno a uno. Una dirección IP puede
        tener muchos nombres de dominio, lo que le permite admitir muchos sitios web en una computadora (esto se denomina
        alojamiento compartido ).

        //registros DNS
        Hay varias docenas de entradas de este tipo en total, por lo que consideraremos solo las más populares:

        A	        DIRECCIÓN	                    Dirección IP
        AAAA	    Dirección IPv6	            Dirección en formato IPv6
        CNOMBRE	    Nombre Canonico	            Nombre canónico para alias
        MX	        intercambiador de correo	Dirección de puerta de enlace de correo para el dominio
        NS	        nombre del servidor	        La dirección del nodo responsable de la zona de dominio.
        SOA	        Comienzo de la autoridad	Indicación de la autoridad de la información
        SRV	        selección de servidor	    Especificación de ubicaciones de servidor para servicios
        PTR	        puntero	                    Coincidencia de nombre de dirección: coincidencia inversa para A y AAAA
        TXT	        cadena de texto	            Escriba datos binarios arbitrarios, hasta 255 bytes

        //Búsqueda de dirección IP
        Veamos cómo funciona el sistema DNS.
        Digamos que escribiste api.codegym.cc en tu navegador. El navegador se pondrá en contacto con el servicio de
        DNS local y le pedirá que le proporcione una dirección IP para el dominio api.codegym.cc. Esto es lo que sucederá
        a continuación:

        En este caso, en el proceso de búsqueda de una IP por nombre, funcionaron las siguientes reglas:

        - El navegador envió una solicitud recursiva a un servidor DNS conocido (en respuesta a este tipo de solicitud,
          el servidor debe devolver una dirección IP o una respuesta vacía y un código de error NXDOMAIN).
        - El servidor DNS que recibió la solicitud del navegador envió solicitudes no recursivas en sucesión, a las que
          recibió respuestas de otros servidores DNS, hasta que recibió una respuesta del servidor responsable de la zona
          solicitada.
        - El resto de los servidores DNS mencionados estaban procesando solicitudes de forma no recursiva (y lo más
          probable es que no hubieran procesado solicitudes de forma recursiva, incluso si tal requisito estuviera en
          la solicitud).

        //archivo de hosts
        Notamos que la primera búsqueda está en el archivo de hosts locales. Este es el heredero del archivo HOSTS.TXT,
        que se inventó en los días de ARPANET. Sí, todavía existe y todavía está en uso.

        Se encuentra en la ruta:
        - /etc/hosts en Linux.
        - %SystemRoot%\system32\drivers\etc\hosts en Windows.
        - /sistema/etc/hosts en android.

        */

        System.out.println("--------------------- NAT ---------------------------");
        //Introducción a NAT
        /*Otro tema muy interesante es NAT. NAT significa traducción de direcciones de red y generalmente está presente
        en cada enrutador como un servicio. Entonces, ¿qué es y por qué es necesario?
        NAT es un punto por el cual las redes locales se pueden conectar a redes globales, como Internet, por ejemplo.

        Hay 8 mil millones de personas en el mundo y ya hay muchos más dispositivos de red: teléfonos, computadoras
        portátiles, relojes inteligentes, servidores, cualquier dispositivo inteligente. Y solo hay 4 mil millones de
        direcciones IP. Solía ​​parecer mucho, pero con el rápido crecimiento de Internet, quedó claro para todos
        que esto no era suficiente.

        Aquí NAT viene al rescate: una dirección IPv4 pública puede ser utilizada por cientos, incluso miles de
        dispositivos, cada uno de los cuales tiene una dirección IPv4 local. NAT tiene el beneficio adicional de agregar
        un grado de privacidad y seguridad a una red porque oculta las direcciones IPv4 internas de las redes externas.

        NAT incluye cuatro tipos de direcciones:

        Dirección local interna (Dirección local interna);
        Dirección global interna (Dirección global interna);
        Fuera de la dirección local ;
        Dirección global externa (Dirección global externa);

        Un enrutador NAT es el punto de separación entre las redes internas y externas, y entre las direcciones locales
        y globales.

        */

    }
}
