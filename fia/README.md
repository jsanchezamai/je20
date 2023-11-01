# Bienvenida a FIA y TLP

Saludos, te presenta este repositorio un estudiante...

Dentro de la **Ingeniería Informática**, este repositorio contiene material relativo a las asignaturas:

- **FIA**, fundamentos de inteligencia artificial
- **TLP**, teoría de los lenguajes de programación

La *Prueba de Evaluación a Distancia* (PEC) de FIA es en *Prolog* y la de *TLP* en *Haskell*. En ambos casos se trata de *programación declarativa*. No se encuentra aquí la solución a las prácticas del curso académico 2023-24 (si acaso se subirán en junio) sino material de apoyo y profundización.

Como se ha indicado, alejándonos del contenido concreto de las PECs (al que volveremos en febrero para ceñirnos a la confección), hoy, finales de otoño, anticipándonos, me he cuestionado dos objetos:

- Comprender cuáles son los fundamentos de la inteligencia artificial
- Desarrollar un lenguaje (o un traductor, o un compilador, o un IDE, o un framework,...) que permita programar sistemas inteligentes.

Los manuales de referencia son:

- Inteligencia Artificial, JT Palma Méndez y R. Marín Morales (McGrawHill)
- Teoría de los lenguajes de programación, de F. López Ostenero y AMª García Serrano (Editorial Ramón Areces)

Volveré sobre esta introducción, la concretaré las próximas semanas.

Dicho esto, manos a la obra,...

# Este repositorio: el lenguaje AlephScript

El proyecto desarrollado en la [carpeta FIA](src/FIA) implementará (o servirá de apoyo y extensión) la PED de la asignatura mediante una modelización de las distintas IAs usando *programación estructurada, orientada a objetos y eventos*. El objeto de la PED (aún no ha salido el enunciado) será previsiblemente implementar **un árbol de búsquedas** y un **sistema de reglas básico**. De forma similar, la de TLP será implementar un pequeño **algoritmo de gestión o manejo de estados**. Ambas serán, como se indicó, usando prolog (**paradigma lógico**) y haskell (**paradigma funcional**), ambos, **programación declarativa**. También se indicó que el contenido de este repositorio excederá a los otros paradigmas de programación.

Generalmente, alejándose desde el lenguaje máquina, y siempre volviendo a él como ahora ocurre con [WebAssembly](https://www.velneo.com/blog/por-que-todo-el-mundo-esta-hablando-de-web-assembly#:~:text=El%20código%20de%20WebAssembly%20se,los%20que%20se%20puede%20ejecutar.) (que ejecuta código binario en el navegador, ¡¡¡¡¡junto a javascript!!!!!!!), distintas capas se superponen exigiendo además de compilador, traductor o intérprete. En nuestro caso, siguiendo estas capas, para modelizar sistemas inteligentes proponemos **usar Typescript** que es un lenguaje transpilado-traducido-compilado (**transpilado**: de typescript a javascript; **traducido**: de javascript a c++; **compilado**: de c++ a binario) y agregar una cuarta etapa en la secuencia.

El objetivo, por tanto, será usar programación estructurada, orientada a objetos y eventos para modelizar un lenguaje que pueda usarse desde los paradigmas declarativos a la hora de representar procesos inteligentes. Por supuesto, a no ser que salte al Proyecto Final de Grado, el ámbito de esta pretensión se limita a lo didáctico, pedagógico, siempre con miras a la entrega de las PECs y los exámenes.

Buscando los elementos mínimos de este lenguaje, he identificado casos de uso como:

- Modelizar [un mundo](src/FIA/mundos) con agentes y cosas. Ponerlo en marcha y agregarle inercias.
- Instanciar un [autómata de un tipo concreto de inteligencia](src/FIA/paradigmas) y solicitarle una actuación en ese mundo.
- Un [motor de ejecución](src/FIA/engine/kernel/runtime.ts) capaz de correrlos.

He identificado tipos fundamentales de IA, a saber:

- [Situada](src/FIA/paradigmas/situada): redes lógicas (máquinas de estado);
- [Simbólica](src/FIA/paradigmas/simbolica): (hechos y reglas) redes semánticas y marcos;
- [Conexionista](src/FIA/paradigmas/conexionista): tiras de tokens y redes neuronales reductoras o transformadoras.

Además, desde un [punto de vista científico](src/FIA/paradigmas/cientifica), esta inteligencia puede ser:

- Fuerte: imita al humano (pasa el [test de turing](src/FIA/agents/turing-test.ts)).
- Débil: resuelve problemas concretos o limitados.

El plan de estas dos semanas ha sido montar el setup y arrancar las primeras interfaces. A parte de empezar a conocer los puntos calientes de ambas asignaturas, aquí en el repositorio traje un [preset Typescript NodeJs](package.json), dispuse las intefaces mínimas, un [menú para consola](src/FIA/navigation), el [archivo de traducciones](src/FIA/i18), y armé un primer prototipo del núcleo-nodo principal de este "nuevo" lenguaje sobre Typescript que buscamos. Se trata del [Bloque Génesis](src/FIA/genesis-block.ts) una primera "entidad mínima" de nuestro lenguaje, por ejemplo:

Arrancando [AlephRuntime](src/FIA/engine)...

```ts
    const rt = new Runtime();
    rt.start();
    await rt.demo();
```
Cargando unidades de inteligencia en la runtime:
```ts

    static threads: iFIA[] = [];

    start() {

        const fia = new FIA();
        Runtime.threads.push(fia);

        const gb = new GenesisBlock();
        Runtime.threads.push(gb);

        Runtime.threads.push(IACientifica.fiaDebil);
        Runtime.threads.push(IACientifica.fiaFuerte);
        Runtime.threads.push(IASimbolica.fiaSimbolica);
        Runtime.threads.push(IASituada.fiaSituada);
            Runtime.threads.push(IASituadaCadenaProduccion.fiaCadena);
        Runtime.threads.push(IAConexionista.fiaConexionista);

    }
```

Cediéndole el tiempo de CPU a una inteligencia:

```ts
                        const fia = Runtime.threads[index];

                        console.clear();
                        console.log(systemMessage(`${i18.LOOP.LAUNCH_FIA_LABEL}: ${fia.nombre}`));

                        if (fia.runAsync) {

                            const instancia = await fia.instanciar();
                            console.log(agentMessage(fia.nombre, instancia));

                        } else {
                            console.log(agentMessage(fia.nombre, fia.imprimir()));
                        }
```
Llamaré a este [lenguaje AlephScript](src/FIA) y, de momento, se encuentra ya en su versión: 0.0.0.0.0.0.0.0.1 con el nombre de versión "FIA".

```
**sistema>** Se está ejecutando AlephRuntime, la máquina virtual que corre el lenguaje AlephScript...
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
```

# Quincena 1ra

Una vez armado el prototipo de lenguaje (v001), ¿cómo usarlo?

Vamos a implementar una cadena de producción mediante este lenguaje.

Sigo en su [README]src/FIA/aplicaciones/cadena/README.md)...
