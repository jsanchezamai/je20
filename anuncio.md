JRED: "Un sistema operativos para provincias de la Aldea Global"

JRED-Elementos: "Navegador de Metaversos Ontológicos".

Spot:

*[Voz en off, presentación powerpoint]*  
Imagina...
- https://www.cnet.com/home/smart-home/raspberry-pi-as-cheap-nas-solution/  
ó:  
- https://query.wikidata.org/querybuilder  
ó:  
- https://query.wikidata.org

*[Voz en off, primer plano del narrador]*  
... es decir, imagina que, en línea, tienes toooodas las wikipedias en todos los idiomas;
o, en modo local, que tienes una wikipedia vacía lista para empezar, o, puntos medios,
pongamos que has inicializado una wiki que contenga "un filtrado por los milenios del Holoceno".

*[Voz en off, presentación powerpoint]*  
Imagina...
... un servicio con tres funciones:
- Pasado: archivo de big-data (enlazado al NAS)
- Presente: gestión de sensores, enviando stream de datos al "Pasado" organizados en Channels Aleph.
    - https://wiki.seeedstudio.com/Grove-Beginner-Kit-For-Arduino/#install-the-arduino-ide
    - Ver apartado extras plugins para el "Presente"
- Futuro: navegador app para metaversos. Por ahora sobre VR Chat.

*[Voz en off, plano medio]*  
Lo prometido es deuda: "Apartado extras plugins para el 'Presente'":

 - **Plugin sparql** para captar **inputs desde rdf** (ejemplo: de una wiki, recorrer una línea temporal con un timer simulando el paso del tiempo, etc.)
- **Plugin udon** para captar inputs **desde automatizaciones Unity** (página personal colaborador activo de VR Chat Udon https://vowgan.booth.pm)
- Kit para **Things** (WordSubjects) y **Bots** (WorldAgents), como formas de WoldObjects en **World**. Compatible con **VR Chat SDK3**. Incluye 3 **Channels Aleph**: "Ground, Vision, Sound" que permiten implementar LODS (zonas de influencia y raycasting) y conectar sus **streams** al "Pasado".
- Kit de **Brains para Bots**. Incluye:
    - Stack de BrainStates como máquina pila de estados que tiene bucle de vida en "b->c->d->b" si estados: 
        a) No nato, b) Dormido, c) Despierto, d) Pensando, e) En Coma, f) Muerto.
    - GenericTree de Facts como grafo de "hechos" registrados en memoria. Los facts registran objetos de tipo Decision.
- Kit de **Concience para Brains**: Implementado al estilo un cogito como nodo raíz de un **grafo** desde donde ergo/sum (luego/existo) (trigger/action) se mantiene una **ThreadPool** gestora convencional de **Listeners**, para Subscription sobre un **Content como Objeto** genérico.
- **Plugin para Brains**: Sistema de **Corte para gestión de Juicios** con procesos que emulan al alguacil, al escriba, al juez, etcétera. **Definición de Decisión como aglutinador de los elementos necesarios**: demandante/querellado, fiscal/defensor, acusación/veredicto, etc.
- Librerías de **Motores de decisión**. Cuando los jueces o jurados quieran emitir juicio, usarán un elemento de esta librería usando como Inferencia el objeto Decision correspondiente. **Preset kit**: Hammurabi (ojo por ojo), random (aleatorio), onnx (modelo predictivo).
