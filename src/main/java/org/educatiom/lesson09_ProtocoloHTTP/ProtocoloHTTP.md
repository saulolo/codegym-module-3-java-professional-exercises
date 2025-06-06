# 🌐 GUÍA RÁPIDA DEL PROTOCOLO HTTP: LA BASE DE LA WEB 🚀

El Protocolo de Transferencia de Hipertexto (HTTP) es el corazón de la World Wide Web.
Permite la comunicación entre clientes (navegadores) y servidores para la
transferencia de recursos como páginas web, imágenes, etc.

---
## 1. ARQUITECTURA CLIENTE-SERVIDOR 🧑‍💻➡️🖥️

-   **Esencia:** Divide a los participantes en dos partes lógicas: clientes y servidores.
-   **Servidor:** Su tarea es atender las solicitudes de los clientes. Realiza la mayor parte del trabajo, almacena datos y garantiza su integridad.
-   **Cliente:** Cuando necesita datos del servidor, envía una solicitud y luego recibe una respuesta.
-   **Ventajas:** Fiabilidad, clientes débiles y económicos, y carga equilibrada.

---
## 2. ESTRUCTURA DE UNA URL (Uniform Resource Locator) 🔗

Una URL es un Localizador Universal de Recursos. Es la dirección de un recurso en la web.

-   **Estructura Típica:** `protocol://host/path?query#anchor`.
    -   `protocol`: Define el protocolo de interacción (ej. HTTP, HTTPS, FTP, SSH).
    -   `host`: Nombre del servidor en la red.
    -   `path`: Ubicación del archivo o recurso en el servidor.
    -   `query`: Conjunto de parámetros `nombre=valor` separados por `&`. Comienza con `?` y termina con `#` o el fin del enlace. Los caracteres sospechosos se codifican.
    -   `anchor`: Etiqueta especial en la página HTML para desplazarse a una ubicación específica.
-   **Obligatorio:** `protocol` y `host` siempre deben especificarse.

---
## 3. ESTRUCTURA DEL MENSAJE HTTP 📨

Un mensaje HTTP (solicitud o respuesta) consta de tres partes:

-   **Línea de Inicio (Starting Line):** La primera línea, define el tipo de mensaje.
-   **Encabezados (Headers):** Parámetros que siguen a la línea de inicio.
-   **Cuerpo del Mensaje (Message Body):** Contenido principal del mensaje, al final.
-   **Separación:** Encabezados y cuerpo se separan por una línea en blanco.

---
## 4. MÉTODOS HTTP: ACCIONES EN EL SERVIDOR 🛠️

La primera palabra en una solicitud HTTP es el nombre del método.

| Método  | Descripción                                                                 | Seguridad | Idempotencia |
| :------ | :-------------------------------------------------------------------------- | :-------- | :----------- |
| `GET`   | Solicita una representación de un recurso específico. Sólo recupera datos.  | Sí        | Sí           |
| `HEAD`  | Solicita los encabezados de un recurso, sin el cuerpo. Útil para verificar metadatos. | Sí        | Sí           |
| `POST`  | Envía datos al servidor para crear un nuevo recurso o realizar una acción. | No        | No           |
| `PUT`   | Envía datos al servidor para actualizar o crear un recurso en una URL específica. | No        | Sí           |
| `DELETE`| Elimina un recurso específico.                                              | No        | Sí           |
| `CONNECT`| Establece un túnel a un servidor identificado por el recurso objetivo.        | No        | No           |
| `OPTIONS`| Describe las opciones de comunicación para el recurso o el servidor.          | Sí        | Sí           |
| `TRACE` | Realiza una prueba de bucle de retorno de mensajes a lo largo de la ruta al recurso objetivo. | Sí        | Sí           |
| `PATCH` | Aplica modificaciones parciales a un recurso.                               | No        | No           |

-   **Seguro:** Una solicitud "segura" (safe) no modifica el estado del servidor (ej. `GET`, `HEAD`).
-   **Idempotente:** Una solicitud "idempotente" produce el mismo resultado en el servidor, independientemente de cuántas veces se ejecute (ej. `GET`, `PUT`, `DELETE`).

---
## 5. CÓDIGOS DE RESPUESTA HTTP: EL ESTADO DE LA SOLICITUD 🚥
La primera línea de una respuesta HTTP contiene el código de estado (3 dígitos) y una breve descripción.
Indican el resultado de la solicitud del cliente.

| Categoría         | Rango        | Significado                                     | Ejemplos Comunes y Descripción Breve                                         |
| :---------------- | :----------- | :---------------------------------------------- | :--------------------------------------------------------------------------- |
| **1xx Informativos** | `100-199`    | La solicitud ha sido recibida y se continúa el proceso. | `100 Continue`: El cliente debe continuar con su solicitud.               |
|                   |              |                                                 | `101 Switching Protocols`: El servidor cambia de protocolo.                   |
| **2xx Éxito** | `200-299`    | La acción fue recibida, entendida y aceptada exitosamente. | `200 OK`: La solicitud ha tenido éxito.                                     |
|                   |              |                                                 | `201 Created`: El recurso fue creado exitosamente.                           |
|                   |              |                                                 | `204 No Content`: La solicitud fue exitosa, pero no hay contenido para enviar. |
| **3xx Redirección** | `300-399`    | Se necesita una acción adicional para completar la solicitud. | `301 Moved Permanently`: El recurso ha sido movido permanentemente.          |
|                   |              |                                                 | `302 Found`: El recurso ha sido encontrado temporalmente en otra ubicación.   |
|                   |              |                                                 | `304 Not Modified`: El recurso no ha sido modificado desde la última solicitud. |
| **4xx Errores del Cliente** | `400-499`    | La solicitud contiene una sintaxis incorrecta o no puede ser cumplida. | `400 Bad Request`: La solicitud es inválida.                                 |
|                   |              |                                                 | `401 Unauthorized`: Se requiere autenticación.                               |
|                   |              |                                                 | `403 Forbidden`: El servidor se niega a autorizar la solicitud.              |
|                   |              |                                                 | `404 Not Found`: El recurso solicitado no fue encontrado.                    |
|                   |              |                                                 | `405 Method Not Allowed`: El método usado no está permitido para el recurso. |
|                   |              |                                                 | `408 Request Timeout`: El servidor agotó el tiempo de espera para la solicitud. |
| **5xx Errores del Servidor** | `500-599`    | El servidor falló al cumplir una solicitud aparentemente válida. | `500 Internal Server Error`: Un error genérico del servidor.                 |
|                   |              |                                                 | `502 Bad Gateway`: El servidor, actuando como puerta de enlace, recibió una respuesta inválida. |
|                   |              |                                                 | `503 Service Unavailable`: El servidor no está listo para manejar la solicitud. |


---
### 6. ENCABEZADOS HTTP: METADATOS DE LA COMUNICACIÓN 🏷️
Los encabezados HTTP son pares de nombre-valor que proporcionan metadatos
esenciales sobre la solicitud o la respuesta. Se colocan después de la
línea de inicio y antes del cuerpo del mensaje, separados por una línea en blanco.

-   **Función Principal:** Permiten al cliente y al servidor pasar información
    adicional sobre la solicitud, la respuesta, o sobre el cuerpo del mensaje.

-   **Categorías Comunes de Encabezados:**
    -   **Generales:** Aplicables a cualquier tipo de mensaje (solicitud o respuesta).
        -   `Connection`: Controla si la conexión de red permanece abierta después de que la transacción actual finalice.
        -   `Date`: Fecha y hora en que se originó el mensaje.
        -   `Via`: Indica servidores proxy intermedios por los que ha pasado la solicitud/respuesta.
    -   **De Solicitud (Request Headers):** Usados por el cliente para proporcionar información al servidor.
        -   `Host`: El dominio del servidor al que el cliente desea conectarse. **Obligatorio** para HTTP/1.1.
        -   `User-Agent`: Información sobre el software del cliente (navegador, sistema operativo).
        -   `Accept`: Tipos de medios (MIME types) que el cliente puede procesar.
        -   `Accept-Language`: Idiomas preferidos para la respuesta.
        -   `Cookie`: Envía cookies previamente almacenadas por el servidor.
        -   `Authorization`: Credenciales de autenticación para el servidor.
        -   `If-Modified-Since`: Fecha para peticiones condicionales (para caching).
    -   **De Respuesta (Response Headers):** Usados por el servidor para proporcionar información al cliente.
        -   `Server`: Información sobre el software del servidor.
        -   `Content-Type`: El tipo de medio del recurso enviado en el cuerpo de la respuesta (ej. `text/html`, `application/json`).
        -   `Content-Length`: El tamaño del cuerpo del mensaje en bytes.
        -   `Set-Cookie`: Envía cookies al cliente para que las almacene.
        -   `Location`: Usado para redirecciones (con códigos 3xx), indica la nueva URL.
        -   `Cache-Control`: Directivas de almacenamiento en caché.
        -   `WWW-Authenticate`: Usado con el código 401 para solicitar autenticación.
    -   **De Entidad (Entity Headers):** Describen el cuerpo del mensaje, tanto en solicitudes como en respuestas.
        -   `Content-Encoding`: El método de codificación aplicado al cuerpo.
        -   `Content-Language`: El idioma del contenido del cuerpo.
        -   `Content-Location`: Una URI del recurso contenido.
        -   `Expires`: Fecha/hora después de la cual la respuesta se considera caducada.


---
### 7. TIPOS DE PROTOCOLOS HTTP: EVOLUCIÓN Y SEGURIDAD 📈


El protocolo HTTP ha evolucionado para adaptarse a las necesidades de la web moderna,
mejorando el rendimiento y la seguridad.

-   **HTTP/1.x (HTTP/1.0, HTTP/1.1):**
    -   **HTTP/1.0:** Versión original. Una conexión TCP por cada solicitud HTTP. Ineficiente para múltiples recursos.
    -   **HTTP/1.1:** Mejora significativa. Permite mantener la conexión TCP abierta para múltiples solicitudes (conexiones persistentes), reduciendo la latencia. Introdujo más métodos, encabezados y códigos de estado.

-   **HTTPS (HTTP Secure):**
    -   Es el mismo protocolo HTTP, pero con una capa de seguridad adicional: el cifrado de contenido mediante **SSL/TLS (Secure Sockets Layer/Transport Layer Security)**.
    -   Los datos se cifran antes de ser enviados y se descifran al ser recibidos, protegiéndolos de interceptaciones.
    -   Utiliza el puerto por defecto `443` (HTTP usa el `80`).
    -   Esencial para la seguridad en la web (transacciones bancarias, inicio de sesión, etc.).

-   **HTTP/2:**
    -   Desarrollado a partir de SPDY de Google para mejorar el rendimiento de HTTP/1.1 sin cambiar la semántica de HTTP.
    -   **Características Clave:**
        -   **Multiplexación:** Permite enviar múltiples solicitudes y respuestas a la vez sobre una única conexión TCP. Se eliminan los "head-of-line blocking" de HTTP/1.1.
        -   **Compresión de Encabezados (HPACK):** Reduce el tamaño de los encabezados de las solicitudes y respuestas.
        -   **Priorización de flujos:** Permite a los clientes indicar al servidor qué recursos son más importantes.
        -   **Server Push (Envío del Servidor):** El servidor puede enviar recursos al cliente antes de que este los solicite, anticipándose a las necesidades.
        -   **Binario:** El protocolo es binario, lo que facilita el parseo y reduce los errores en comparación con el formato de texto de HTTP/1.x.
        -   **Cifrado Obligatorio (en la práctica):** Aunque la especificación no lo hace estrictamente obligatorio, la mayoría de los navegadores solo soportan HTTP/2 sobre TLS, lo que hace que el cifrado sea un requisito práctico.

-   **HTTP/3:**
    -   La tercera versión mayor del protocolo HTTP, aún en desarrollo o recientemente estandarizada.
    -   **Innovación principal:** Abandono del protocolo TCP y adopción de **UDP** como capa de transporte, utilizando un nuevo protocolo llamado **QUIC (Quick UDP Internet Connections)**.
    -   **Ventajas de QUIC/UDP:**
        -   Reduce la latencia de establecimiento de conexión.
        -   Mejora la resiliencia a la pérdida de paquetes.
        -   Elimina el "head-of-line blocking" a nivel de transporte (no solo a nivel de aplicación como en HTTP/2).
        -   Mejor rendimiento en redes con alta latencia o pérdida de paquetes.
    -   Apunta a ser aún más rápido y eficiente que HTTP/2, especialmente en redes móviles.

---
## METADATOS DEL DOCUMENTO 📄

| Campo           | Detalles                                                   |
| :-------------- |:-----------------------------------------------------------|
| **Título** | GUÍA RÁPIDA DEL PROTOCOLO HTTP: LA BASE DE LA WEB         |
| **Autor(es)** | Saul Echeverri                                             |
| **Versión** | 1.0.0                                                      |
| **Fecha de Creación** | 30 de Mayo de 2025                                         |
| **Última Actualización** | 30 de Mayo de 2025                                         |
| **Notas Adicionales**  | Documento base para referencia rápida de HTTP.            |

---