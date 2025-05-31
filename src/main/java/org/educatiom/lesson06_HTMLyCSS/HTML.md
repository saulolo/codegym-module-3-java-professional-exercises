# 🎨 Guía Esencial de CSS: Dale Estilo a Tu Web

CSS (Cascading Style Sheets) es el alma visual de la web. Mientras HTML construye la estructura, CSS se encarga de que todo luzca increíble. Es el lenguaje que separa el contenido (HTML) de su presentación, haciendo tu código más limpio, fácil de mantener y adaptable.

---

## 🧱 1. La Anatomía de una Regla CSS

Una regla CSS es la unidad fundamental para aplicar estilos. Cada regla consta de un **selector** (quién) y un **bloque de declaraciones** (cómo).

| **Componente** | **Descripción**                                                 | **Ejemplo**            |
|----------------|------------------------------------------------------------------|-------------------------|
| Selector       | Indica a qué elemento(s) HTML se aplicarán los estilos.         | `p`, `.clase`, `#id`   |
| Declaración    | Propiedad: Valor; Define una característica específica.         | `color: blue;`         |
| Propiedad      | Característica a modificar (ej. `font-size`, `background-color`). | `font-size`            |
| Valor          | Ajuste específico para la propiedad (ej. `16px`, `red`).        | `16px`                 |

---

## 🧪 Ejemplo Básico:

```css
p {
    color: blue;        /* El color del texto de los párrafos será azul */
    font-size: 16px;    /* El tamaño de la fuente será de 16 píxeles */
}
