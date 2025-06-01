# 🌐 GUÍA RÁPIDA DE DISPOSITIVOS DE RED: CÓMO SE CONECTA EL MUNDO 🌍

Este documento explora los fundamentos de las redes, desde su origen hasta
conceptos clave como direcciones IP, subredes y protocolos que hacen
posible la comunicación en Internet.

---
## 1. ORÍGENES Y FUNDAMENTOS DE LA RED 💡

-   **DARPA (Defense Advanced Research Projects Agency):** Fundada en 1958, fue responsable de financiar el desarrollo de ARPANET, UNIX-BSD y el conjunto de protocolos TCP/IP. Es la agencia de investigación y desarrollo del Departamento de Defensa de los Estados Unidos. No realiza investigaciones directamente, sino que otorga subvenciones.

-   **ARPANET:** Desarrollada durante la Guerra Fría para crear una red robusta que pudiera sobrevivir a fallos críticos. La primera prueba funcional fue el 29 de octubre de 1969. Se considera el precursor de Internet. 
-   **TCP/IP:** Un conjunto de protocolos creado en 1972 por Vinton Cerf y su equipo. TCP se encarga de descomponer y reensamblar mensajes en paquetes (datagramas), mientras que IP se encarga de transmitir esos datagramas individualmente. ARPANET se cambió a TCP/IP el 1 de enero de 1983, considerado el "cumpleaños oficial de Internet". 

-   **UNIX/BSD:** BSD-UNIX es una familia de sistemas operativos que se originó en la Universidad de California, Berkeley, y es otra creación financiada por DARPA. UNIX fue la base para muchos "clones" o sistemas "tipo UNIX" compatibles, como GNU/Linux, MacOS, MINIX y FreeBSD. 
---
## 2. MODELO OSI: LAS 7 CAPAS DE LA COMUNICACIÓN 📊

El Modelo de Interconexión de Sistemas Abiertos (OSI) es una referencia básica
para la interconexión de sistemas. Consta de 7 capas, donde las capas inferiores
no tienen conocimiento de las superiores, y la interacción entre ellas es mínima y estandarizada. 

| Capa              | Tipo de Datos | Funciones Principales                        | Ejemplos (Protocolos/Estándares) | Equipos de Red             |
| :---------------- | :------------ | :------------------------------------------- | :------------------------------- | :------------------------- |
| **7. Aplicación** | Datos         | Acceso a servicios de red.        | HTTP, FTP, POP3, WebSocket  | Hosts (clientes), Firewall de Red  |
| **6. Presentación** | Datos         | Representación de datos y cifrado.  | ASCII, JPEG, MIDI      | -                          |
| **5. Sesión** | Datos         | Gestión de sesiones.      | RPC, PAP, L2TP, gRPC   | -                          |
| **4. Transporte** | Segmento/Datagrama | Conexión segura y fiable punto a punto, confiabilidad.  | TCP, UDP, SCTP, puertos  | -                          |
| **3. Red** | Paquete       | Determinación de rutas y direccionamiento lógico (IP).  | IPv4, IPv6, IPsec, ICMP  | Router, puerta de enlace, firewall  |
| **2. Enlace de Datos** | Trama         | Direccionamiento físico (MAC y LLC).  | PPP, Ethernet, DSL, ARP  | Puente, Switch, Punto de acceso  |
| **1. Física** | Bit           | Trabajo con el medio, señales, transmisión binaria. | USB, RJ (par trenzado, fibra óptica) | Concentrador (Hub), Repetidor  |

---
## 3. MODELO TCP/IP: LA PILA DE PROTOCOLOS DE INTERNET 💻

La pila de protocolos TCP/IP consta de cuatro capas que representan las funciones
esenciales para la comunicación en Internet. 

| Capa                   | Protocolos/Ejemplos                                 |
| :--------------------- | :-------------------------------------------------- |
| **Capa de Aplicación** | HTTP, SMTP, DNS, FTP                    |
| **Capa de Transporte** | TCP, UDP                              |
| **Capa de Internet** | ARP, IP, ICMP, DHCP                     |
| **Capa de Acceso a la Red** | Ethernet, Wi-Fi, DSL                  |

---
## 4. HOSTS Y SUBREDES: IDENTIFICANDO DISPOSITIVOS 🏡

-   **Hosts:** Cualquier dispositivo de red (computadoras, servidores, routers, impresoras) que necesita una dirección IP para interactuar en la red. 
-   **Subred:** Conjunto de computadoras que son servidas por un equipo de red específico. 
-   **Máscara de Subred:** Una plantilla que el equipo de red usa para asignar IPs a sus subordinados. Es un número donde los bits de la subred son "unos" y los bits del host son "ceros", y se escribe en formato decimal con puntos.

---
## 5. DIRECCIONES IP: LA IDENTIDAD EN LA RED 🆔

-   **Estructura:** Una dirección IP (ej. 192.168.1.1) se compone de cuatro partes separadas por puntos, cada una llamada octeto. 
    -   La primera parte representa el número de red. 
    -   La otra parte representa el identificador del host.
    -   Juntas, forman una dirección IP única para un host.

-   **Direcciones IP Privadas:** Rangos de IPs asignados por IANA para uso en redes locales privadas. No se enrutan a través de Internet. 
    -   `10.0.0.0 — 10.255.255.255` 
    -   `172.16.0.0 — 172.31.255.255` 
    -   `192.168.0.0 — 192.168.255.255` 
    -   Los ISP compran bloques de IPs públicas de IANA y los revenden. 

-   **DHCP (Dynamic Host Configuration Protocol):** Protocolo de capa de aplicación que permite a los dispositivos obtener automáticamente direcciones IP y otros parámetros de red. 
    -   **Tipos de Asignación de IP:**
        -   **Manual:** Administrador asocia IP específica con dirección MAC. 
        -   **Automática:** IP disponible asignada al azar de un rango, permanente. 
        -   **Dinámica:** IP asignada por un período específico (arrendamiento), puede reasignarse. 

-   **localhost y 127.0.0.1:** `127.0.0.1` es la dirección de bucle de retroceso (loopback address), también conocida como "localhost".  Ambos se usan indistintamente para conectarse a un servidor ejecutándose en tu propia máquina. 

--- 
## 6. DNS: TRADUCIENDO NOMBRES A NÚMEROS 📜

-   **Sistema de Nombres de Dominio (DNS):** Un sistema distribuido que traduce nombres de host (ej. `google.com`) a direcciones IP, y obtiene información sobre enrutamiento de correo y nodos de servicio. 
-   Organizado jerárquicamente con servidores DNS que interactúan. 
-   **Importante:** Una IP puede tener múltiples nombres de dominio (alojamiento virtual), y un nombre de dominio puede tener múltiples IPs (equilibrio de carga, CDN). 

-   **Registros DNS Comunes:**
    -   **Registro A:** Establece la dirección IP para un dominio. 
    -   **CNAME:** Permite establecer un alias para un nombre de dominio (ej. `www.codegym.cc == codegym.cc`). 
    -   **Registro MX:** Contiene información sobre el servidor de correo. 
    -   **Registro NS:** Indica la dirección del servidor DNS que contiene la información para el dominio. 

-   **Archivo de hosts:** Un archivo local que mapea direcciones IP a nombres de dominio. Prioritario sobre DNS para resoluciones. 
    -   Ubicaciones: `/etc/hosts` (Linux), `%SystemRoot%\system32\drivers\etc\hosts` (Windows), `/system/etc/hosts` (Android). 
    -   Ejemplo: `127.0.0.1 localhost`

-   **Servidores DNS Públicos:** Ofrecen ventajas como velocidad y gran caché DNS para carga acelerada de sitios web, y seguridad (bloqueo de sitios maliciosos, filtrado de contenido). 

---
## 7. NAT: TRADUCCIÓN DE DIRECCIONES DE RED 🚪

-   **Network Address Translation (NAT):** Un servicio que suele estar en cada enrutador y actúa como puerta de enlace para que las redes locales se conecten a redes globales (Internet). 
-   Traduce direcciones IP privadas a direcciones IP públicas, permitiendo que dispositivos con IPs locales accedan a recursos externos. 
-   Útil para conservar direcciones IPv4 públicas. 
-   Las redes locales usan direcciones IP privadas (10.0.0.0/8, 172.16.0.0/12, 192.168.0.0/16). 
-   Los enrutadores NAT usan un "pool NAT" de direcciones IPv4 públicas. 

---
## 8. VPN: REDES PRIVADAS VIRTUALES 🔒

-   **Virtual Private Network (VPN):** Una red privada virtual que permite conectar a redes remotas (oficina, hogar) de forma segura. 
-   Consiste en un servidor VPN (configurado por el administrador) y un cliente VPN (en dispositivos del usuario). 
-   Al conectarse, tu dispositivo "cree" que está dentro de la red local donde se encuentra el servidor VPN. Esto puede hacer que un sitio web crea que estás en la ubicación del servidor VPN. 

-   **Tipos de VPN:**
    -   **Intranet VPN:** Conecta múltiples sucursales de una organización en una red unificada y segura a través de canales públicos. 
    -   **Acceso Remoto VPN:** Crea un canal seguro entre la red corporativa y un usuario individual que trabaja remotamente. 
    -   **Extranet VPN:** Para redes accesadas por usuarios "externos" como clientes. 
    -   **Internet VPN:** Usada por proveedores para acceso a Internet, típicamente cuando múltiples usuarios comparten un canal físico.
    -   **Cliente/Servidor VPN:** Protege datos transmitidos entre dos nodos (no redes completas) de una red corporativa. 

-   **OpenVPN:** Un programa gratuito que implementa tecnología VPN. Soporta modos cliente-servidor y punto a punto. 
    -   **Tipos de Autenticación:**
        -   Clave precompartida (más simple).
        -   Basada en certificados (más flexible). 
        -   Nombre de usuario y contraseña (no requiere certificado de cliente).

---
### METADATOS DEL DOCUMENTO 📄

| Campo           | Detalles                                                     |
| :-------------- |:-------------------------------------------------------------|
| **Título** | GUÍA RÁPIDA DE DISPOSITIVOS DE RED: CÓMO SE CONECTA EL MUNDO |
| **Autor(es)** | Saul Echeverri                                               |
| **Versión** | 1.0.0                                                        |
| **Fecha de Creación** | 31 de Mayo de 2025                                           |
| **Última Actualización** | 31 de Mayo de 2025                                           |
| **Notas Adicionales**  | Documento base para referencia rápida de Redes.              |

---