package org.educatiom.lesson08_DispositivosRed;


public class Darpa {

    public static void main(String[] args) {

        System.out.println("--------------------- DARPA ---------------------------");
        //lanzamiento de satélite
        /*En 1957, la Unión Soviética superó a Estados Unidos en el lanzamiento del primer satélite, lo que supuso un
        duro golpe para el prestigio nacional de los estadounidenses. En respuesta a los hechos, el Congreso declaró que
        esto no debería volver a suceder, y en 1958 se creó la organización DARPA .

        Inicialmente llamado ARPA, pasó a llamarse DARPA (con la palabra Defensa añadida) en 1972, luego volvió a ARPA
        en 1993 y finalmente volvió a DARPA el 11 de marzo de 1996.

        DARPA fue responsable de financiar el desarrollo de la universidad de ARPANET (de la que más tarde surgió Internet),
        así como Unix-BSD (el sistema UNIX de Berkeley) y la pila de protocolos TCP/IP. La organización actualmente
        patrocina el desarrollo de vehículos robóticos, entre otras cosas.

        //ARPANET
        En el apogeo de la Guerra Fría, Estados Unidos quería una red que pudiera incluso sobrevivir a una guerra nuclear.
        Para supervisar este problema, se creó un departamento especial en la organización ARPA, la Oficina de Métodos
        de Procesamiento de Información. Y el propio desarrollo de la red se encomendó a un grupo de cuatro universidades:

        - Universidad de California, Los Angeles
        - Centro de investigación de Stanford
        - Universidad de Utah
        - UC Santa Bárbara

        En solo seis meses, se desarrolló la primera versión funcional. La primera prueba de la tecnología tuvo lugar
        el 29 de octubre de 1969 a las 21:00 horas . La red constaba de dos terminales, que debían estar lo más separados
        posible para probar el sistema en los modos máximos.

        La primera terminal estaba ubicada en la Universidad de California, y la segunda, a una distancia de hasta 600 km,
        en la Universidad de Stanford

        El experimento consistía en enviar la palabra inicio de sesión a través de la red. No funcionó la primera vez,
        algo salió mal. Pero unas horas más tarde se repitió el experimento y tuvo éxito: el destinatario vio la palabra
        iniciar sesión en su monitor.

         la red fue utilizada principalmente por científicos.

        En 1973, las universidades europeas comenzaron a conectarse a la red: se volvió verdaderamente internacional. En 1977,
        había hasta 111 computadoras (servidores) en la red. Y ya en 1983, de 4.000 ordenadores que había repartidos
        por tod Estados Unidos, se establecieron comunicaciones por satélite con Hawái y Europa.

        //TCP/IP
        las primeras computadoras estaban conectadas directamente a terminales y las usaban usuarios individuales,
        generalmente en el mismo edificio o habitación. Estas redes se conocieron como redes de área local ( LAN ).
        Las redes que van más allá de lo local, es decir, redes de área amplia ( WAN ), surgieron en la década de 1950 y
        se introdujeron en la década de 1960.

        Muy a menudo, las redes locales fueron desarrolladas por empleados de universidades técnicas y laboratorios para
        sus necesidades internas. Tenían sus propios protocolos de transferencia de datos (a veces analógicos) y, en la
        mayoría de los casos, no eran compatibles entre sí.

        Sin embargo, en 1972, un grupo de desarrolladores dirigido por Vinton Cerf creó una pila de protocolos denominada
        TCP/IP. Era versátil y adecuado tanto para WAN como para múltiples LAN.

        En julio de 1976, Vint Cerf y Bob Kahn demostraron por primera vez la transmisión de datos utilizando TCP en
        tres redes diferentes. El paquete viajó por la siguiente ruta: San Francisco - Londres - Universidad del Sur de
        California. Al final de su viaje, el paquete había recorrido 150.000 km sin perder un solo bit.

        En 1978, Cerf, Jon Postel y Danny Cohan decidieron dividir el protocolo TCP vigente en ese momento en dos
        funciones distintas: TCP e IP (Protocolo de Internet).

        TCP era responsable de descomponer el mensaje en pequeños paquetes, datagramas, y unirlos en el destino final.
        IP era responsable de transmitir datagramas individuales con control de recepción.

        Así nació el moderno protocolo de Internet. Y el 1 de enero de 1983, ARPANET cambió a un nuevo protocolo. Este
        día se considera la fecha oficial de nacimiento de Internet .

        //UNIX/BSD
        Otra creación de DARPA es el sistema operativo BSD-UNIX. Se trata de toda una familia de sistemas operativos
        que se remonta a las distribuciones de la Universidad de Berkeley. Tod comenzó con el sistema operativo UNIX.

        UNIX era muy bueno y ya había muchos programas para él, por lo que comenzaron a aparecer clones de UNIX en masa,
        construidos sobre los mismos principios y apoyando el trabajo con sus programas. Dichos sistemas operativos se
        denominan similares a Unix . Estos clones incluyeron:

        - BSD Unix
        - GNU/Linux
        - Mac OS
        - MINIX
        - FreeBSD

        Sí, sí, los sistemas operativos MacOS e iOS también tienen un sistema operativo BSD-UNIX bajo el capó. Estas son las empanadas.

        Dondequiera que excave, encontrará UNIX:

        Android tiene Linux bajo el capó, basado en UNIX
        iPhone con iOS basado en FreeBSD
        MacBook con macOS basado en FreeBSD
        Casi cualquier servidor es Linux y tiene UNIX bajo el capó.
        Enrutadores, refrigeradores inteligentes, televisores inteligentes: tod bajo el capó de alguna manera tiene el
        viejo UNIX.

        */

        System.out.println("--------------------- Modelo OSI ---------------------------");
        //Introducción a OSI
        /*Cuando recién se estaba desarrollando la red ARPA, realmente queríamos que fuera lo más inteligente posible.
        Pero cuanto más compleja es la red, más difícil es desarrollarla y mantenerla. Como solución, se propuso dividir
        todas las funciones de la red en capas lógicas.


            +-------------------------------------------------+
            |                    OSI MODEL                    |
            +---------------------+---------------------------+
            |        Data         | Application               |
            |                     | Network Process           |
            |                     | to Application            |
            +---------------------+---------------------------+
            |        Data         | Presentation              |
            |                     | Data Representation       |
            |                     | and Encryption [cite: 1]  |
            +---------------------+---------------------------+
            |        Data         | Session                   |
            |                     | Interhost Communication   |
            +---------------------+---------------------------+
            |       Segments      | Transport                 |
            |                     | End-to-end connections    |
            |                     | and reliability           |
            +---------------------+---------------------------+
            |       Packets       | Network                   |
            |                     | Path Determination and IP |
            |                     | (logical addressing)      |
            +---------------------+---------------------------+
            |        Frames       | Data Link                 |
            |                     | Physical Addressing       |
            +---------------------+---------------------------+
            |         Bits        | Physical                  |
            |                     | Media, Signal and Binary  |
            |                     | Transmission              |
            +---------------------+---------------------------+

        En total, hay 7 niveles en este modelo. La interacción de niveles está estrictamente estandarizada y
        minimizada. El nivel inferior no tiene idea de la presencia de niveles superiores y su estructura.

        Los protocolos de estas capas implementan completamente toda la funcionalidad del modelo OSI. Toda la
        interacción del usuario en las redes IP se basa en la pila de protocolos TCP/IP.

        La pila de protocolos TCP/IP es independiente del hardware físico, lo que, entre otras cosas, garantiza una
        interacción completamente transparente entre redes cableadas e inalámbricas.

        La capa de aplicación es donde se ejecutan la mayoría de las aplicaciones de red.

        //Capa de aplicación
        Para la interacción de programas, existen protocolos de alto nivel para el intercambio de información. Por
        ejemplo, los navegadores funcionan con el protocolo HTTP, el correo se envía con el protocolo SMTP, Telegram
        funciona con su propio protocolo encriptado.

        Pero no estamos muy interesados ​​en los protocolos privados. En la mayoría de los casos, encontrará
        protocolos masivos como un cliente ftp para FTP (transferencia de archivos), SSH (conexión segura a una máquina
        remota), DNS (traducción de caracteres a direcciones IP) y muchos otros.

       Casi todos estos protocolos se ejecutan sobre TCP, aunque algunos se ejecutan sobre UDP (Protocolo de datagramas
       de usuario) para acelerar las cosas. Pero, lo que es más importante, estos protocolos tienen puertos predeterminados.
       Ejemplo:

        20 Puerto FTP a TCP 20 (para transferencia de datos) y 21 (para comandos de control)
        22-SSH
        23 - Telnet
        53 - Consultas DNS
        80-HTTP
        443-HTTPS

        Estos puertos están definidos por la Agencia de Asignación de Nombres y Parámetros Únicos (IANA).

        Hay varios otros protocolos de capa de aplicación populares: Echo, Finger, Gopher, HTTP, HTTPS, IMAP, IMAPS, IRC,
        NNTP, NTP, POP3, POPS, QOTD, RTSP, SNMP, SSH, Telnet, XDMCP.

        //Capa de transporte
        Los protocolos de la capa de transporte están diseñados para resolver el problema de la entrega garantizada de
        mensajes tambien controlan el orden en que llegan los mensajes.

        UDP es un protocolo de datagramas sin conexión. También se le llama protocolo de transferencia “poco fiable”,
        en el sentido de la imposibilidad de verificar la entrega de un mensaje al destinatario, así como la posible mezcla
        de paquetes. Las aplicaciones que requieren una transmisión de datos garantizada utilizan el protocolo TCP.

        UDP se usa normalmente en aplicaciones como transmisión de video y juegos donde se tolera la pérdida de paquetes
        y volver a intentarlo es difícil o injustificado, o en aplicaciones de respuesta de desafío (como consultas de
        DNS) donde establecer una conexión requiere más recursos que el reenvío.

        Tanto TCP como UDP usan un número llamado puerto para definir el protocolo de la capa superior.
        */

    }
}
