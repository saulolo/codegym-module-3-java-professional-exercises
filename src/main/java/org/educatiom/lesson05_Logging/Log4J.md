# Guía Rápida de Log4j: Comandos y Funciones Principales

Esta tabla resume los conceptos clave y las funciones principales de la biblioteca Log4 (Logging).

---

## 🚀 Loggers (Registradores)

| Función/Método             | Descripción y Uso Principal                                                                                |
| :------------------------- | :--------------------------------------------------------------------------------------------------------- |
| `Logger.debug()`           | Registra un mensaje con nivel **DEBUG**. Para depuración detallada durante el desarrollo.                   |
| `Logger.info()`            | Registra un mensaje con nivel **INFO**. Para mensajes informativos sobre el progreso o eventos importantes. |
| `Logger.warn()`            | Registra un mensaje con nivel **WARN**. Para advertencias sobre situaciones inesperadas o problemas.       |
| `Logger.error()`           | Registra un mensaje con nivel **ERROR**. Para errores que no impiden el funcionamiento de la aplicación.    |
| `Logger.fatal()`           | Registra un mensaje con nivel **FATAL**. Para errores muy graves que causan el aborto de la aplicación.    |

---

## 📊 Niveles de Registro

Controlan la importancia y el filtrado de los mensajes. Los mensajes con un nivel inferior al configurado son descartados.

| Nivel   | Descripción                                                                 |
| :------ | :-------------------------------------------------------------------------- |
| `ALL`   | Registra **todos** los mensajes, el nivel más verboso.                      |
| `TRACE` | Mensajes muy detallados, para seguimiento fino.                             |
| `DEBUG` | Mensajes detallados para depuración.                                        |
| `INFO`  | Mensajes informativos simples, progreso general.                            |
| `WARN`  | Situaciones potencialmente dañinas o inesperadas.                          |
| `ERROR` | Eventos de error que aún podrían permitir la ejecución.                     |
| `FATAL` | Errores muy graves que probablemente detendrán la aplicación.               |
| `OFF`   | No registra **ningún** mensaje, el nivel menos verboso.                     |

---

## 📤 Appenders (Anexadores)

Componentes que definen dónde se guardan o envían los mensajes de registro.

| Appender           | Descripción                                                                            |
| :----------------- | :------------------------------------------------------------------------------------- |
| `Console`          | Imprime los mensajes en la consola.                                                    |
| `File`             | Envía los mensajes a un archivo.                                                       |
| `DailyRollingFile` | Envía mensajes a un archivo que se sobrescribe cíclicamente (rotación diaria).         |
| `Async`            | Permite escribir datos en otro appender de forma asíncrona.                           |
| `Socket`           | Escribe datos en un socket específico.                                                 |
| `JDBC`             | Escribe mensajes en una base de datos usando el protocolo JDBC.                        |
| `JPA`              | Escribe mensajes en una base de datos usando el protocolo JPA.                         |
| `HTTP`             | Envía eventos a través del protocolo HTTP a un servidor remoto.                        |
| `SMTP`             | Almacena mensajes en un búfer y los envía como un correo electrónico.                  |

---

## ⚙️ Configuración (Maven - Log4j 2.x)

Dependencias recomendadas para incluir Log4j 2.x en un proyecto Maven (crucial para seguridad).

| Dependencia Maven                                   | Descripción                                                                               |
| :-------------------------------------------------- | :---------------------------------------------------------------------------------------- |
| `org.apache.logging.log4j:log4j-api:2.17.1`         | La interfaz (API) de Log4j 2.x. (Usar versión segura).                                    |
| `org.apache.logging.log4j:log4j-core:2.17.1`        | La implementación principal (core) de Log4j 2.x. (Usar versión segura).                   |
| `org.apache.logging.log4j:log4j-slf4j-impl:2.17.1`  | Módulo para usar Log4j 2.x como implementación de la fachada SLF4J (muy recomendado). |

---

## 🔍 Filtros

Permiten controlar con más detalle qué mensajes se procesan o se descartan antes de ser enviados a los appenders.

| Filtro                   | Descripción                                                                                   |
| :----------------------- | :-------------------------------------------------------------------------------------------- |
| `BurstFilter`            | Controla la velocidad de eventos por segundo para un nivel específico.                      |
| `CompositeFilter`        | Combina múltiples filtros que se aplican secuencialmente.                                   |
| `DynamicThresholdFilter` | Habilita registro detallado si se encuentra cierta información o patrón.                    |
| `MapFilter`              | Permite filtrado basado en expresiones lógicas complejas sobre múltiples parámetros del evento. |
| `MarkerFilter`           | Filtra mensajes basados en etiquetas (Markers) asociadas a ellos.                           |
| `RegexFilter`            | Filtra mensajes basados en un patrón de expresión regular.                                  |

---

**⚠️ Nota de Seguridad:**
La vulnerabilidad **Log4Shell** (CVE-2021-44228) afectó a las versiones de Log4j 2.x (desde 2.0-beta9 hasta 2.14.1). Es **crucial** utilizar versiones parcheadas (como **2.17.1 o superiores**) para mitigar los riesgos de seguridad.