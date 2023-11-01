# App: Simulación cadena de montaje con inteligencia fundamental de tipo Situada

La aplicación implementa una [IA Situada](src/FIA/paradigmas/situada) para modelar una cadena de montaje.

El producto mínimo viable no implementa toda la funcionalidad (Ver bajo enunciado).

- [Modelo](src/FIA/aplicaciones/cadena/cadena-modelo.ts): define una cinta con n posiciones. Una bombilla (2 estados). Un motor (5 estados).
- [Estado](src/FIA/aplicaciones/cadena/cadena-estado.ts): arranca la máquina, la mantiene funcionando y la detiene.
- [Mundo](src/FIA/aplicaciones/cadena/cadena-mundo.ts): instancia para el tiempo de ejecución.
- [Automata](src/FIA/aplicaciones/cadena/cadena-automata.ts): instanciará el mundo, esperará a su expiración y lo descargará.
- [FIA Situada](src/FIA/aplicaciones/cadena/cadena-fia.ts): implementa la aplicación.


## Log de salida Situada

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


# APP: Simulación con Red Simbólica.Semantica Red

Aunque el grafo de la red semántica puede construirse de distintas manera, se ha implementado una modelización sin código, vía json.

La implementación actual define la red semántica en el [fichero de traducciones i18](src/FIA/i18/labels.ts) ver nodo APPS.CADENA.SIMBOLICA.DOMINIO.

En la inicialización, la [FIA RedSemántica](src/FIA/paradigmas/simbolica/modelos/formal/sistema/semantica.ts) interpreta el fichero y monta la red base.

La red inicializa los nodos hoja y sus arcos principales:

```ts
    cargar(red: any, entidades: IGrafo[]) {
        /**
         * Añadir entidades maestras
         */
        Object.keys(red.ENTIDADES).forEach(i => {

        /**
         * Añadir entidades del arco "subclase-de"
         */
        Object.keys(red.ARCOS.ESTRUCTURALES.SUBCLASE).forEach(clase_hija => {

        /**
        * Añadir entidades del arco "parte-de"
        */
        Object.keys(red.ARCOS.ESTRUCTURALES.PARTE).forEach(clase_padre => {

        /**
        * Añadir entidades del arco "instancia-de"
        */
        Object.keys(red.ARCOS.ESTRUCTURALES.INSTANCIA).forEach(clase_hija => {


        /**
        * Añadir entidades del arco "descriptivo"
        */
        Object.keys(red.ARCOS.DESCRIPTIVOS).forEach(clase_padre => {

    }

```

Una vez cargada la red, puede usarse el [método probar del modelo](src/FIA/aplicaciones/cadena/simbolica/formal/cadena-fia-red-semantica.ts) inferencias con el formato de ejemplo de abajo. Las inferencias se lanzarán una a una.

```ts
const casos = [
            {
                instancia: {
                    robot_1: "robot"
                }
            },
            {
                subclase: {
                    robot_1: "criptoselladora"
                }
            },
            {
                parte: {
                    propiedad_cripta: "objeto_1"
                }
            },
            {
                tarea_cadena_robot_objeto: {
                    encadenar : {
                        tarea: "tarea_1",
                        cadena: "cadena_1",
                        robot: "robot_1",
                        objeto: "objeto_1",
                        almacen: "almacen_1"
                    }
                }
            }
        ];

        await this.modelo.probar(casos);
```
## Log 

```
sistema> Transfiriendo el prompt a: cadena-app
cadena-app> Esta aplicación simula una cadena de producción. ¡Arrancando simulación!
cadena.simbolica.red> Creando la red semántica...
cadena.simbolica.semantica.red> Agregando entidad: tarea
cadena.simbolica.semantica.red> Agregando entidad: robot
cadena.simbolica.semantica.red> Agregando entidad: objeto
cadena.simbolica.semantica.red> Agregando entidad: propiedad
cadena.simbolica.semantica.red> Agregando entidad: cadena
cadena.simbolica.semantica.red> Agregando entidad: almacen
cadena.simbolica.semantica.red> Agregando arco subclase/clase: reponedor/robot
cadena.simbolica.semantica.red> Agregando arco subclase/clase: criptoselladora/robot
cadena.simbolica.semantica.red> Agregando arco subclase/clase: parseadora/robot
cadena.simbolica.semantica.red> Agregando arco subclase/clase: objeto_criptosellable/objeto
cadena.simbolica.semantica.red> Agregando arco subclase/clase: objeto_parseable/objeto
cadena.simbolica.semantica.red> Agregando arco subclase/clase: objeto_compuesto/objeto
cadena.simbolica.semantica.red> Agregando arco parte/clase: tarea_cadena_robot_objeto/robot
cadena.simbolica.semantica.red> Agregando arco parte/clase: tarea_robot_objeto/robot
cadena.simbolica.semantica.red> Agregando arco parte/clase: tarea_robot_objeto_propiedad/robot
cadena.simbolica.semantica.red> Agregando arco parte/clase: propiedad_estado/objeto
cadena.simbolica.semantica.red> Agregando arco parte/clase: propiedad_cripta/objeto_criptosellable
cadena.simbolica.semantica.red> Agregando arco parte/clase: propiedad_cadena/objeto_parseable
cadena.simbolica.semantica.red> Agregando arco parte/clase: objeto_parseable/objeto_compuesto
cadena.simbolica.semantica.red> Agregando arco parte/clase: objeto_criptosellable/objeto_compuesto
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: cadena/cadena_1
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: almacen/almacen_1
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: almacen/entrada
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: almacen/salida
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: almacen/basura
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: reponedor/reponerdor
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: criptoselladora/robot_1
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: criptoselladora/robot_2
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: parseadora/robot_3
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: parseadora/robot_4
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: objeto_parseable/objeto_1
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: objeto_criptosellable/objeto_2
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: objeto_parseable/objeto_3
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: objeto_compuesto/objeto_4
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: propiedad/propiedad_cripta
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: propiedad/propiedad_cadena
cadena.simbolica.semantica.red> Agregando arco instancia hija/padre: estado/propiedad_estado
cadena.simbolica.semantica.red> Agregando arco descriptivo destino/origen: desencadenar/tarea_cadena_robot_objeto_almacen
cadena.simbolica.semantica.red> Agregando arco descriptivo destino/origen: encadenar/tarea_cadena_robot_objeto_almacen
cadena.simbolica.semantica.red> Agregando arco descriptivo destino/origen: deshechar/tarea_robot_objeto_almacen
cadena.simbolica.semantica.red> Agregando arco descriptivo destino/origen: operar/tarea_robot_objeto_propiedad
cadena.simbolica.red> Modelo resultante:
	 - (grafo) -tarea; arcos
	 - (grafo) -robot; arcos
	 - (grafo) -objeto; arcos
	 - (grafo) -propiedad; arcos
	 - (grafo) -cadena; arcos
	 - (grafo) -almacen; arcos
	 - (grafo) -reponedor; arcos
		 - <reponedor> es subclase de <robot>
	 - (grafo) -criptoselladora; arcos
		 - <criptoselladora> es subclase de <robot>
	 - (grafo) -parseadora; arcos
		 - <parseadora> es subclase de <robot>
	 - (grafo) -objeto_criptosellable; arcos
		 - <objeto_criptosellable> es subclase de <objeto>
		 - <objeto_compuesto> tiene la parte: <objeto_criptosellable>
	 - (grafo) -objeto_parseable; arcos
		 - <objeto_parseable> es subclase de <objeto>
		 - <objeto_compuesto> tiene la parte: <objeto_parseable>
	 - (grafo) -objeto_compuesto; arcos
		 - <objeto_compuesto> es subclase de <objeto>
	 - (grafo) -tarea_cadena_robot_objeto; arcos
		 - <robot> tiene la parte: <tarea_cadena_robot_objeto>
	 - (grafo) -tarea_robot_objeto; arcos
		 - <robot> tiene la parte: <tarea_robot_objeto>
	 - (grafo) -tarea_robot_objeto_propiedad; arcos
		 - <robot> tiene la parte: <tarea_robot_objeto_propiedad>
	 - (grafo) -propiedad_estado; arcos
		 - <objeto> tiene la parte: <propiedad_estado>
		 - <propiedad_estado> es instancia de <estado>
	 - (grafo) -propiedad_cripta; arcos
		 - <objeto_criptosellable> tiene la parte: <propiedad_cripta>
		 - <propiedad_cripta> es instancia de <propiedad>
	 - (grafo) -propiedad_cadena; arcos
		 - <objeto_parseable> tiene la parte: <propiedad_cadena>
		 - <propiedad_cadena> es instancia de <propiedad>
	 - (grafo) -cadena_1; arcos
		 - <cadena_1> es instancia de <cadena>
	 - (grafo) -almacen_1; arcos
		 - <almacen_1> es instancia de <almacen>
	 - (grafo) -entrada; arcos
		 - <entrada> es instancia de <almacen>
	 - (grafo) -salida; arcos
		 - <salida> es instancia de <almacen>
	 - (grafo) -basura; arcos
		 - <basura> es instancia de <almacen>
	 - (grafo) -reponerdor; arcos
		 - <reponerdor> es instancia de <reponedor>
	 - (grafo) -robot_1; arcos
		 - <robot_1> es instancia de <criptoselladora>
	 - (grafo) -robot_2; arcos
		 - <robot_2> es instancia de <criptoselladora>
	 - (grafo) -robot_3; arcos
		 - <robot_3> es instancia de <parseadora>
	 - (grafo) -robot_4; arcos
		 - <robot_4> es instancia de <parseadora>
	 - (grafo) -objeto_1; arcos
		 - <objeto_1> es instancia de <objeto_parseable>
	 - (grafo) -objeto_2; arcos
		 - <objeto_2> es instancia de <objeto_criptosellable>
	 - (grafo) -objeto_3; arcos
		 - <objeto_3> es instancia de <objeto_parseable>
	 - (grafo) -objeto_4; arcos
		 - <objeto_4> es instancia de <objeto_compuesto>
	 - (grafo) -estado; arcos
	 - (grafo) -tarea_cadena_robot_objeto_almacen; arcos
	 - (grafo) -desencadenar; arcos
		 - Tarea: <desencadenar>. Agente <robot>: <tarea> <objeto> entre <almacen> y <cadena>.
	 - (grafo) -encadenar; arcos
		 - Tarea: <encadenar>. Agente <robot>: <tarea> <objeto> entre <almacen> y <cadena>.
	 - (grafo) -tarea_robot_objeto_almacen; arcos
	 - (grafo) -deshechar; arcos
		 - Tarea: <deshechar>. Agente <robot>: <tarea>: <objeto> al lugar <almacen>.
	 - (grafo) -operar; arcos
		 - Tarea: <operar>. Agente <robot>: <tarea>: <propiedad> de <objeto>
cadena.simbolica.semantica.red> Se van a lanzar una serie de inferencias sobre la red...:
cadena.simbolica.semantica.red>
	 - Lanzando caso: :0
cadena.simbolica.semantica.red> Creada regla::0:instancia
                     {"base":{"inferencias_relacion":{"parametros":{"base":{"instancia":{"robot_1":"robot"}}},"contexto":{"arcos":{"estado":[]}}}}}

cadena.simbolica.semantica.red>
	 - Lanzando caso: :1
cadena.simbolica.semantica.red> Creada regla::1:subclase
                     {"base":{"inferencias_relacion":{"parametros":{"base":{"subclase":{"robot_1":"criptoselladora"}}},"contexto":{"arcos":{"estado":[]}}}}}

cadena.simbolica.semantica.red>
	 - Lanzando caso: :2
cadena.simbolica.semantica.red> Creada regla::2:parte
                     {"base":{"inferencias_relacion":{"parametros":{"base":{"parte":{"propiedad_cripta":"objeto_1"}}},"contexto":{"arcos":{"estado":[]}}}}}

cadena.simbolica.semantica.red>
	 - Lanzando caso: :3
cadena.simbolica.semantica.red> Creada regla::3:tarea_cadena_robot_objeto
                     {"base":{"inferencias_relacion":{"parametros":{"base":{"tarea_cadena_robot_objeto":{"encadenar":{"tarea":"tarea_1","cadena":"cadena_1","robot":"robot_1","objeto":"objeto_1","almacen":"almacen_1"}}}},"contexto":{"arcos":{"estado":[]}}}}}

cadena.simbolica.semantica.red>
	 - Evaluando caso: :{"dominio":{"base":{"inferencias_relacion":{"parametros":{"base":{"instancia":{"robot_1":"robot"}}},"contexto":{"arcos":{"estado":[]}}}}},"claveDominio":"inferencias_relacion","claveContexto":"contexto","claveEntrada":"parametros","claveSalida":"evaluacion"}
cadena.simbolica.semantica.red>
	 - Evaluando caso: :{"dominio":{"base":{"inferencias_relacion":{"parametros":{"base":{"subclase":{"robot_1":"criptoselladora"}}},"contexto":{"arcos":{"estado":[]}}}}},"claveDominio":"inferencias_relacion","claveContexto":"contexto","claveEntrada":"parametros","claveSalida":"evaluacion"}
cadena.simbolica.semantica.red>
	 - Evaluando caso: :{"dominio":{"base":{"inferencias_relacion":{"parametros":{"base":{"parte":{"propiedad_cripta":"objeto_1"}}},"contexto":{"arcos":{"estado":[]}}}}},"claveDominio":"inferencias_relacion","claveContexto":"contexto","claveEntrada":"parametros","claveSalida":"evaluacion"}
cadena.simbolica.semantica.red>
	 - Evaluando caso: :{"dominio":{"base":{"inferencias_relacion":{"parametros":{"base":{"tarea_cadena_robot_objeto":{"encadenar":{"tarea":"tarea_1","cadena":"cadena_1","robot":"robot_1","objeto":"objeto_1","almacen":"almacen_1"}}}},"contexto":{"arcos":{"estado":[]}}}}},"claveDominio":"inferencias_relacion","claveContexto":"contexto","claveEntrada":"parametros","claveSalida":"evaluacion"}
cadena.simbolica.semantica.red> Test de la red semántica finalizado:
cadena-app> ¡Simulación finalizada!¡La aplicación ha concluído y se cierra!
```
