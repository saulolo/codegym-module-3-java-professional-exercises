# 🚀 GUÍA RÁPIDA DEL HTTPCLIENT EN JAVA (JDK 11+) 🌐

El paquete `java.net.http`, introducido en JDK 11, revoluciona la forma en que las
aplicaciones Java realizan solicitudes HTTP. Proporciona una API moderna,
fluida y orientada a objetos, soportando HTTP/1.1, HTTP/2 y WebSockets, y
ofreciendo capacidades tanto síncronas como asíncronas.

---
## 1. CLASES CLAVE DEL PAQUETE `java.net.http` 📚

Las principales abstracciones para interactuar con la red a través de HTTP son:

-   **`HttpClient`**:
    -   La "fábrica" principal para enviar solicitudes y recibir respuestas.
    -   Gestiona las conexiones subyacentes, *timeouts*, redirecciones, *proxies* y autenticación.
    -   Es el punto de entrada para todas las operaciones HTTP.
-   **`HttpRequest`**:
    -   Representa una solicitud HTTP individual y es **inmutable**.
    -   Define el método HTTP (GET, POST, etc.), la URI, los encabezados y el cuerpo de la solicitud.
    -   Se construye utilizando el patrón **Builder** para mayor legibilidad y flexibilidad.
-   **`HttpResponse`**:
    -   Encapsula la respuesta HTTP recibida de un servidor.
    -   Contiene el código de estado, los encabezados de respuesta y el cuerpo de la respuesta.
-   **`WebSocket`**:
    -   Proporciona soporte nativo para la comunicación bidireccional sobre un único socket TCP,
        siguiendo el protocolo WebSocket.

---
## 2. FLUJO BÁSICO DE UNA SOLICITUD HTTP 🔄

Realizar una petición HTTP con `HttpClient` sigue un patrón simple y directo:

1.  **Creación de `HttpClient`**: Instanciar un cliente HTTP. Se puede configurar con
    diversos parámetros globales para las solicitudes que enviará.
2.  **Creación de `HttpRequest`**: Construir la solicitud específica que se desea enviar,
    definiendo su método, URI, encabezados y cuerpo.
3.  **Envío de la Solicitud**: Utilizar el `HttpClient` para enviar la `HttpRequest` y
    esperar la `HttpResponse`. Puede ser síncrono (`send()`) o asíncrono (`sendAsync()`).
4.  **Manejo de la `HttpResponse`**: Procesar la respuesta recibida, accediendo a su
    código de estado, encabezados y cuerpo.

---
## 3. CONSTRUCCIÓN DE `HttpRequest` (PATRÓN BUILDER) 🛠️

`HttpRequest` es inmutable. Se construye utilizando `HttpRequest.newBuilder()` y una
cadena de métodos encadenados antes de llamar a `build()`.

| Método de `HttpRequest.Builder` | Descripción                                                          | Ejemplo de Uso                                     |
| :------------------------------ | :------------------------------------------------------------------- | :------------------------------------------------- |
| `.uri(URI uri)`                 | Establece la URI de destino para la solicitud.                       | `.uri(URI.create("https://api.example.com"))`    |
| `.GET()`                        | Define el método HTTP como GET.                                      | `.GET()`                                           |
| `.POST(BodyPublisher publisher)`| Define el método HTTP como POST y su cuerpo.                         | `.POST(BodyPublishers.ofString(jsonBody))`       |
| `.PUT(BodyPublisher publisher)` | Define el método HTTP como PUT y su cuerpo.                          | `.PUT(BodyPublishers.ofFile(Paths.get("data.txt")))` |
| `.DELETE()`                     | Define el método HTTP como DELETE.                                   | `.DELETE()`                                        |
| `.method(String name, BodyPublisher publisher)` | Establece un método HTTP personalizado y su cuerpo.       | `.method("PATCH", BodyPublishers.ofString(partialJson))` |
| `.header(String name, String value)` | Añade un encabezado a la solicitud. Se puede llamar múltiples veces. | `.header("Content-Type", "application/json")`     |
| `.headers(String... headers)`   | Añade múltiples encabezados como pares de nombre/valor.              | `.headers("Accept", "application/xml", "User-Agent", "MyApp")` |
| `.timeout(Duration duration)`   | Establece un *timeout* para la solicitud.                            | `.timeout(Duration.ofSeconds(20))`               |
| `.version(HttpClient.Version version)` | Especifica la versión del protocolo HTTP (HTTP_1_1, HTTP_2). | `.version(HttpClient.Version.HTTP_2)`            |
| `.build()`                      | Finaliza la construcción y devuelve la instancia de `HttpRequest`.   | `.build()`                                         |

**`HttpRequest.BodyPublishers` (Para construir el cuerpo de la solicitud):**

| Método de `BodyPublishers` | Descripción                                                                |
| :------------------------- | :------------------------------------------------------------------------- |
| `noBody()`                 | Indica que la solicitud no tiene cuerpo (para GET, DELETE).                |
| `ofString(String body)`    | Crea un *publisher* para un cuerpo de tipo `String` (ej., JSON, XML).     |
| `ofFile(Path path)`        | Crea un *publisher* para enviar el contenido de un archivo.                |
| `ofInputStream(Supplier<? extends InputStream> streamSupplier)` | Crea un *publisher* para enviar datos desde un `InputStream`. |
| `ofByteArray(byte[] array)`| Crea un *publisher* para enviar un arreglo de bytes.                       |

**Ejemplo de Creación de `HttpRequest` (POST JSON):**

```java
String jsonPayload = "{\"nombre\": \"Alice\", \"edad\": 30}";
HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("[https://api.example.com/usuarios](https://api.example.com/usuarios)"))
    .header("Content-Type", "application/json")
    .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
    .build();
```

---
## 4. ENVÍO DE SOLICITUDES Y MANEJO DE RESPUESTAS 📤➡️📥

El `HttpClient` es responsable de enviar la `HttpRequest` y proporcionar la `HttpResponse`.

| Método de `HttpClient`                                     | Descripción                                                                 |
| :--------------------------------------------------------- | :-------------------------------------------------------------------------- |
| `newHttpClient()`                                          | Crea un `HttpClient` con la configuración por defecto.                      |
| `newBuilder()`                                             | Inicia la construcción de un `HttpClient` personalizado.                    |
| `send(HttpRequest request, BodyHandler<T> responseBodyHandler)` | **Síncrono**: Envía la solicitud y bloquea el hilo hasta recibir la respuesta. |
| `sendAsync(HttpRequest request, BodyHandler<T> responseBodyHandler)` | **Asíncrono**: Envía la solicitud y devuelve un `CompletableFuture` para manejar la respuesta de forma no bloqueante. |

`HttpResponse.BodyHandlers` (Procesamiento del cuerpo de la respuesta)

| Método            | Descripción                                         | Tipo de retorno |
|-------------------|-----------------------------------------------------|------------------|
| `ofString()`      | Devuelve el cuerpo como `String`.                   | `String`         |
| `ofInputStream()` | Devuelve el cuerpo como `InputStream`.              | `InputStream`    |
| `ofByteArray()`   | Devuelve el cuerpo como `byte[]`.                   | `byte[]`         |
| `discarding()`    | Descarta el cuerpo.                                 | `Void`           |
| `ofFile(Path path)` | Escribe directamente el cuerpo en un archivo.    | `Void`           |

🧪 Ejemplo de Solicitud Síncrona

```java
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/data"))
    .GET()
    .build();

try {
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println("Status Code: " + response.statusCode());
    System.out.println("Response Body: " + response.body());
} catch (IOException | InterruptedException e) {
    e.printStackTrace();
}
```
🧪 Ejemplo de Solicitud Asíncrona
```java
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/async-data"))
    .GET()
    .build();

client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
    .thenApply(HttpResponse::body)
    .thenAccept(body -> System.out.println("Async Response Body: " + body))
    .exceptionally(e -> {
        System.err.println("Error en la solicitud asíncrona: " + e.getMessage());
        return null;
    })
    .join(); // Para esperar en un ejemplo simple; en una app real, se integra en un flujo CompletableFuture
```

---
## 5. ⚙️ CONFIGURACIÓN AVANZADA DE `HttpClient`

La construcción de `HttpClient` mediante `newBuilder()` permite configurar aspectos avanzados del cliente HTTP para adaptarlo a necesidades específicas.

### Métodos de `HttpClient.Builder`

| Método                                      | Descripción                                                                                 |
|---------------------------------------------|---------------------------------------------------------------------------------------------|
| `.version(Version version)`                | Define la versión predeterminada del protocolo HTTP (`HTTP_1_1`, `HTTP_2`).                |
| `.connectTimeout(Duration duration)`       | Establece el timeout para establecer la conexión.                                          |
| `.cookieHandler(CookieHandler handler)`    | Configura un manejador de cookies para gestionar automáticamente los encabezados `Set-Cookie` y `Cookie`. |
| `.executor(Executor executor)`             | Proporciona un `Executor` personalizado para ejecutar tareas asíncronas.                   |
| `.followRedirects(HttpClient.Redirect policy)` | Define la política de redirección (`ALWAYS`, `NEVER`, `NORMAL`).                     |
| `.proxy(ProxySelector proxySelector)`      | Configura un proxy para las solicitudes.                                                   |
| `.sslContext(SSLContext sslContext)`       | Define el contexto `SSL/TLS` para conexiones seguras.                                      |

```java
CookieManager cookieManager = new CookieManager();
HttpClient clientWithCustomConfig = HttpClient.newBuilder()
    .version(HttpClient.Version.HTTP_2)
    .connectTimeout(Duration.ofSeconds(5))
    .cookieHandler(cookieManager) // Habilita el manejo automático de cookies
    .build();

// Las cookies se gestionarán automáticamente en las solicitudes y respuestas.
// Puedes acceder al almacén de cookies si es necesario:
// CookieStore cookieStore = cookieManager.getCookieStore();

```

---
## 6. 🍪 TRABAJANDO CON COOKIES EN `HttpClient`

El `HttpClient` facilita el manejo de cookies a través de la interfaz `CookieHandler` y su implementación concreta `CookieManager`.

### 🔧 Clases clave:

- **`CookieHandler`**:  
  Interfaz abstracta que define un protocolo para manejar el almacenamiento y recuperación de cookies.

- **`CookieManager`**:  
  Implementación estándar de `CookieHandler`. Gestiona las cookies en un `CookieStore` (por defecto, en memoria).

### 🛠️ Uso de cookies en `HttpClient`

1. Crear una instancia de `CookieManager`.
2. Configurarla con el `HttpClient.Builder` usando `.cookieHandler(...)`.
3. El `HttpClient` se encargará automáticamente de:
    - Enviar las cookies relevantes en cada solicitud.
    - Almacenar las cookies recibidas en las respuestas.

Esto automatiza un aspecto complejo del desarrollo web que antes requería manejo manual de encabezados HTTP.

---
## 7. 🖥️↔️🌐 COMPARACIÓN CON `jQuery` (Contexto de Uso)

El documento menciona `jQuery`. Es importante entender la diferencia de contexto:

### `HttpClient` (Java - Backend)

- **Entorno**: Backend (aplicaciones Java de servidor, microservicios, desktop apps).
- **Propósito**: Realizar solicitudes HTTP desde un servidor Java hacia otros servicios o APIs.
- **Características**:  
  Soporte para:
    - HTTP/2
    - WebSockets
    - Timeouts
    - Retries
    - Gestión de conexiones

### `jQuery` (`$.ajax`, `$.post`, `$.get`) (JavaScript - Frontend)

- **Entorno**: Frontend (navegadores web).
- **Propósito**: Simplificar las operaciones AJAX desde el navegador hacia el backend.
- **Características**:
    - Abstracción de `XMLHttpRequest` o `fetch`.
    - Manipulación del DOM.
    - Gestión de eventos del navegador.

⚠️ **Conclusión**: Ambas herramientas son excelentes en sus dominios, pero no son intercambiables.  
`HttpClient` es la herramienta moderna y preferida en **Java backend** para realizar solicitudes HTTP.

---
## 8. ⚡ CHEATSHEET RÁPIDA DE `HttpClient`

| Elemento         | Descripción Breve                              | Ejemplos / Notas Clave                                             |
|------------------|------------------------------------------------|---------------------------------------------------------------------|
| `HttpClient`     | Cliente para enviar solicitudes HTTP.          | `HttpClient.newHttpClient()`, `.newBuilder()`                      |
| `HttpRequest`    | Representación inmutable de la solicitud.      | `.uri()`, `.GET()`, `.POST()`, `.header()`, `.build()`             |
| `HttpResponse`   | Representación de la respuesta recibida.       | `response.statusCode()`, `response.body()`                         |
| `BodyPublisher`  | Define el cuerpo de la solicitud (salida).     | `BodyPublishers.ofString()`, `ofFile()`, `noBody()`                |
| `BodyHandler`    | Procesa el cuerpo de la respuesta (entrada).   | `BodyHandlers.ofString()`, `ofInputStream()`, `discarding()`       |
| **Síncrono**     | Bloquea hasta recibir respuesta.               | `client.send(request, handler)`                                    |
| **Asíncrono**    | No bloqueante, usa `CompletableFuture`.        | `client.sendAsync(...).thenAccept(...)`                            |
| **Cookies**      | Manejo automático de cookies.                  | `HttpClient.newBuilder().cookieHandler(new CookieManager())`       |
| **HTTP/2**       | Soporte nativo, multiplexación, server push.   | Configurable con `.version(HttpClient.Version.HTTP_2)`             |
| **Timeout**      | Tiempo máximo para conectar/esperar respuesta. | `.connectTimeout()`, `.timeout()` (en `HttpRequest.Builder`)       |
| **Redirecciones**| Política de seguimiento de redirecciones.      | `.followRedirects(HttpClient.Redirect.ALWAYS)`                     |

---
### METADATOS DEL DOCUMENTO 📄

| Campo           | Detalles                                             |
| :-------------- |:-----------------------------------------------------|
| **Título** | Guía Rápida de HttpClient en Java (JDK 11+           |
| **Autor(es)** | Saul Echeverri                                       |
| **Versión** | 1.0.0                                                |
| **Fecha de Creación** | 05 de Junio de 2025                                  |
| **Última Actualización** | 05 de Junio de 2025                                   |
| **Notas Adicionales**  | Documento base para referencia rápida de HttpClient. |

---