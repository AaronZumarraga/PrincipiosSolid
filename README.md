## README para los principios de diseño aplicados

### 1. **Principio de Inversión de Dependencias (DIP)**

#### Descripción:
El **Principio de Inversión de Dependencias (DIP)** es uno de los principios SOLID y establece que:
- Las clases de alto nivel no deben depender de las clases de bajo nivel. Ambas deben depender de abstracciones (como interfaces o clases abstractas).
- Las abstracciones no deben depender de los detalles. Los detalles deben depender de las abstracciones.

#### Reflexión:
En el código original, la clase `PaymentProcessor` dependía directamente de una implementación concreta (`CreditCardPayment`), lo que la hacía difícil de extender o modificar. Si se quisiera agregar un nuevo método de pago, como `PayPalPayment`, sería necesario modificar la clase `PaymentProcessor`, lo cual va en contra del principio DIP.

Al refactorizar, creamos la interfaz `PaymentMethod` y cambiamos la clase `PaymentProcessor` para que dependiera de esta interfaz, en lugar de una implementación concreta. Ahora, `PaymentProcessor` puede aceptar cualquier clase que implemente `PaymentMethod`, como `CreditCardPayment`, `PayPalPayment` o `CryptoPayment`, sin necesidad de modificar `PaymentProcessor`. Esto hace que el código sea más flexible y fácil de extender, siguiendo el principio DIP.

---

### 2. **Principio de Abierto/Cerrado (OCP)**

#### Descripción:
El **Principio de Abierto/Cerrado (OCP)** establece que una clase debe estar **abierta para la extensión, pero cerrada para la modificación**. Esto significa que el comportamiento de una clase puede ser extendido sin modificar su código fuente.

#### Reflexión:
En el código original, si queríamos agregar nuevos métodos de pago (como `PayPalPayment` o `CryptoPayment`), tendríamos que modificar la clase `PaymentProcessor` directamente, lo cual viola el principio OCP, ya que modificamos el código existente para adaptarlo a nuevas funcionalidades.

Al refactorizar, creamos la interfaz `PaymentMethod` y permitimos que las clases de pago (`CreditCardPayment`, `PayPalPayment`, `CryptoPayment`) implementaran esta interfaz. `PaymentProcessor` ya no necesita ser modificado para manejar nuevos métodos de pago, ya que puede trabajar con cualquier implementación de `PaymentMethod`. Esto cumple con el principio OCP, ya que agregamos nuevas funcionalidades sin cambiar el código existente.

---

### 3. **Principio de Segregación de Interfaces (ISP)**

#### Descripción:
El **Principio de Segregación de Interfaces (ISP)** establece que **no se debe forzar a una clase a implementar interfaces que no va a utilizar**. Es mejor tener interfaces específicas que estén diseñadas para las necesidades concretas de las clases.

#### Reflexión:
En el código original, la clase `PaymentProcessor` estaba utilizando una dependencia directa de `CreditCardPayment`, lo que obligaba a que cualquier clase de pago tuviera que implementar todos los métodos de pago, aunque no los necesitara (por ejemplo, `charge()` para un método de pago que no requiere recarga).

Al aplicar el principio ISP, refactorizamos el código para que `PaymentMethod` se dividiera en dos interfaces más específicas: `Turnable` (para dispositivos que pueden encenderse y apagarse) y `Chargeable` (para aquellos que pueden ser recargados). Así, cada clase de pago solo implementa los métodos que necesita, y no se ve obligada a implementar métodos que no son relevantes para su comportamiento. Esto reduce el acoplamiento y aumenta la coherencia del diseño.

---

### 4. **Principio de Sustitución de Liskov (LSP)**

#### Descripción:
El **Principio de Sustitución de Liskov (LSP)** establece que los objetos de una clase derivada deben ser sustituibles por objetos de la clase base sin alterar el comportamiento correcto del programa.

#### Reflexión:
En el código original, no existía un control adecuado de la sustitución de objetos para los diferentes métodos de pago. Al usar el principio LSP en la refactorización, definimos una interfaz común `PaymentMethod` que garantiza que todos los métodos de pago implementen el mismo contrato. Así, `PaymentProcessor` puede aceptar cualquier tipo de pago, como `CreditCardPayment`, `PayPalPayment` o `CryptoPayment`, sin necesidad de preocuparse por el tipo específico de pago. No importa si el objeto es un `CreditCardPayment` o un `PayPalPayment`; ambos pueden ser usados de la misma manera en `PaymentProcessor`, lo que respeta el principio de sustitución de Liskov.

---

### 5. **Principio de Responsabilidad Única (SRP)**

#### Descripción:
El **Principio de Responsabilidad Única (SRP)** establece que una clase debe tener **una sola razón para cambiar**, es decir, debe tener solo una responsabilidad.

#### Reflexión:
En el código original, la clase `PaymentProcessor` tenía dos responsabilidades:
1. Procesar el pago.
2. Definir y gestionar el tipo de pago (en este caso, solo `CreditCardPayment`).

Al refactorizar, separamos la responsabilidad de definir el tipo de pago en clases concretas como `CreditCardPayment`, `PayPalPayment` y `CryptoPayment`. `PaymentProcessor` ahora se encarga exclusivamente de procesar el pago, sin tener que preocuparse por los detalles de cómo se realiza el pago o qué tipo de pago se está utilizando. Esto asegura que cada clase tenga una única razón para cambiar, respetando el principio SRP.

---

## Conclusión

Con esta refactorización, hemos hecho que el código sea más **flexible**, **extensible** y **mantenible**. Cada principio de diseño SOLID se ha aplicado para mejorar la calidad del código y garantizar que sea más fácil de entender, extender y modificar en el futuro. Gracias a estos principios, el sistema ahora está mejor estructurado para agregar nuevas funcionalidades (por ejemplo, nuevos métodos de pago) sin necesidad de modificar el código existente. 

Este enfoque asegura que el código sea menos propenso a errores y sea mucho más robusto en el largo plazo, mejorando la escalabilidad y la facilidad de mantenimiento.
