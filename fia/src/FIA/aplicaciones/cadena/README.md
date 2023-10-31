# App: Simulación cadena de montaje con inteligencia fundamental de tipo Situada

La aplicación implementa una [IA Situada](src/FIA/paradigmas/situada) para modelar una cadena de montaje.

El producto mínimo viable no implementa toda la funcionalidad (Ver bajo enunciado).

- [Modelo](src/FIA/aplicaciones/cadena/cadena-modelo.ts): define una cinta con n posiciones. Una bombilla (2 estados). Un motor (5 estados).
- [Estado](src/FIA/aplicaciones/cadena/cadena-estado.ts): arranca la máquina, la mantiene funcionando y la detiene.
- [Mundo](src/FIA/aplicaciones/cadena/cadena-mundo.ts): instancia para el tiempo de ejecución.
- [Automata](src/FIA/aplicaciones/cadena/cadena-automata.ts): instanciará el mundo, esperará a su expiración y lo descargará.
- [FIA Situada](src/FIA/aplicaciones/cadena/cadena-fia.ts): implementa la aplicación.


# Log de salida



**sistema>** Escoge:
         - [0]: Modelo: FIA
         - [1]: Modelo: FIA_Genesis
         - [2]: Modelo: debil
         - [3]: Modelo: fuerte
         - [4]: Modelo: simbolica
         - [5]: Modelo: situada
**sistema>** Transfiriendo el prompt a: **Autómata CP**
**Autómata CP**> Hola soy un autómata situado. Voy a ejemplificar mi forma de razonar. Para ello operaré un serie de pasos recibiendo señales con mis sensores y enviando acciones.
**Autómata CP**> ¡Mundo iniciado!
**Autómata CP**> Hoy es el día: 1
**situada>** El mundo envía una aferencia. Voy a realizar la transición de estado.
**situada>** ¡Hecho! Le devuelvo el nuevo estado al mundo con una eferencia.
**Autómata CP**> El mundo ha recibido una eferencia. Actualizando modelo. nombre: Cadena de producción
                 -dia: 1
                 -muerte: 9
                 -pulso: 1000
                 -posicion: 0
                 -motor: PARADA
**Autómata CP**> Hoy es el día: 2
**situada>** El mundo envía una aferencia. Voy a realizar la transición de estado.
**situada>** ¡Hecho! Le devuelvo el nuevo estado al mundo con una eferencia.
**Autómata CP**> El mundo ha recibido una eferencia. Actualizando modelo. nombre: Cadena de producción
                 -dia: 2
                 -muerte: 9
                 -pulso: 1000
                 -posicion: 0
                 -motor: ARRANCAR
**Autómata CP**> Hoy es el día: 3
**situada>** El mundo envía una aferencia. Voy a realizar la transición de estado.
**situada>** ¡Hecho! Le devuelvo el nuevo estado al mundo con una eferencia.
**Autómata CP**> El mundo ha recibido una eferencia. Actualizando modelo. nombre: Cadena de producción
                 -dia: 3
                 -muerte: 9
                 -pulso: 1000
                 -posicion: 0
                 -motor: AVANZAR
**Autómata CP**> Hoy es el día: 4
**situada>** El mundo envía una aferencia. Voy a realizar la transición de estado.
**situada>** ¡Hecho! Le devuelvo el nuevo estado al mundo con una eferencia.
**Autómata CP**> El mundo ha recibido una eferencia. Actualizando modelo. nombre: Cadena de producción
                 -dia: 4
                 -muerte: 9
                 -pulso: 1000
                 -posicion: 1
                 -motor: AVANZAR
                 -iluminacion: true
**Autómata CP**> Hoy es el día: 5
**situada>** El mundo envía una aferencia. Voy a realizar la transición de estado.
**situada>** ¡Hecho! Le devuelvo el nuevo estado al mundo con una eferencia.
**Autómata CP**> El mundo ha recibido una eferencia. Actualizando modelo. nombre: Cadena de producción
                 -dia: 5
                 -muerte: 9
                 -pulso: 1000
                 -posicion: 2
                 -motor: AVANZAR
                 -iluminacion: false
**Autómata CP**> Hoy es el día: 6
**situada>** El mundo envía una aferencia. Voy a realizar la transición de estado.
**situada>** ¡Hecho! Le devuelvo el nuevo estado al mundo con una eferencia.
**Autómata CP**> El mundo ha recibido una eferencia. Actualizando modelo. nombre: Cadena de producción
                 -dia: 6
                 -muerte: 9
                 -pulso: 1000
                 -posicion: 3
                 -motor: AVANZAR
                 -iluminacion: true
**Autómata CP**> Hoy es el día: 7
**situada>** El mundo envía una aferencia. Voy a realizar la transición de estado.
**situada>** ¡Hecho! Le devuelvo el nuevo estado al mundo con una eferencia.
**Autómata CP**> El mundo ha recibido una eferencia. Actualizando modelo. nombre: Cadena de producción
                 -dia: 7
                 -muerte: 9
                 -pulso: 1000
                 -posicion: 4
                 -motor: AVANZAR
                 -iluminacion: false
**Autómata CP**> Hoy es el día: 8
**situada>** El mundo envía una aferencia. Voy a realizar la transición de estado.
**situada>** ¡Hecho! Le devuelvo el nuevo estado al mundo con una eferencia.
**Autómata CP**> El mundo ha recibido una eferencia. Actualizando modelo. nombre: Cadena de producción
                 -dia: 8
                 -muerte: 9
                 -pulso: 1000
                 -posicion: 5
                 -motor: PARAR
                 -iluminacion: true
**Autómata CP**> Hoy es el día: 9
**situada>** El mundo envía una aferencia. Voy a realizar la transición de estado.
**situada>** ¡Hecho! Le devuelvo el nuevo estado al mundo con una eferencia.
**Autómata CP**> El mundo ha recibido una eferencia. Actualizando modelo. nombre: Cadena de producción
                 -dia: 9
                 -muerte: 9
                 -pulso: 1000
                 -posicion: 0
                 -motor: FUERA_SERVICIO
                 -iluminacion: false
**Autómata CP**> ¡Mundo acabado!
**Autómata CP**> Modelo resultante:nombre: Cadena de producción
                 -dia: 9
                 -muerte: 9
                 -pulso: 1000
                 -posicion: 0
                 -motor: FUERA_SERVICIO
                 -iluminacion: false
**Autómata CP**> ¡Simulación finalizada!


# [x] Implementar demo del autómata en [FIA Situada](src/FIA/paradigmas/situada)

En la versión 0.0.1, el menú da acceso a la FIA Situada:

>
>
**sistema>** Cargando FIAs disponibles, por favor espera... 
**sistema>** Escoge:
         - [0]: Modelo: FIA
         - [1]: Modelo: FIA_Genesis
         - [2]: Modelo: debil
         - [3]: Modelo: fuerte
         - [4]: Modelo: simbolica
         - [5]: Modelo: situada                 <============
         - [6]: Modelo: conexionista
         - [99]: Not today! ¡Cerrar!, please, bye!
Escribe: 

La implementación actual implementa "**La Cadena de Montaje**". El autómata de la FIA Situada deberá mantener el **estado** y sus **transiciones** para 50 **unidades de trabajo** que desfilaran por una cadena de montaje con 100 posiciones, a la que están conectadas 5 **máquinas** con retención de unidad de trabajo (sin obstaculizar la cadena) de 2 segundos. Las 5 máquinas ejecutan la misma acción. Pero la nº5 ejecuta además un proceso especial obligado todas las unidades de trabajo.

Para cada pulso del ciclo (movimiento de la cinta), el estado deberá indicar:

- unidades de trabajo en almacen
- posiciones de la cadena ocupadas por las unidades de trabajo
- unidades de trabajo retenidas en máquina
- para cada subciclo de retención en máquina: unidad de trabajo, porcentaje trabajado.
- unidades de trabajo acabadas

En la implementación actual se incluye:

- [FIA Situada](src/FIA/paradigmas/situada/paradigma.ts): Autómata con funcionalidad eferencia/aferencia (estado de entrada, transición, estado de salida).
- [Mundo::Cadena Produccion](src/FIA/mundos/cadena-produccion.ts): Contexto de ejecución con: a) pulso absoluto (cuenta de a uno), b) pulso relativo (configurable).

Completar la ejecución implementando con logs la funcionalidad:

>
>
**sistema>** Transfiriendo el prompt a: situada
**situada>** Hola soy un autómata situado. Voy a ejemplificar mi forma de razonar. Para ello operaré un serie de pasos recibiendo señales con mis sensores y enviando acciones.
cadena> ¡Mundo iniciado!
cadena> Hoy es el día: 1
cadena> Hoy es el día: 2
cadena> Hoy es el día: 3
cadena> Hoy es el día: 4
cadena> ¡Mundo acabado!
**situada>** Modelo resultante:Modelo base. 10 días; pulso: 1 segundo
**situada>** Final de ejecución 