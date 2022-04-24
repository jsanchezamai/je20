# je20
**Jardín Edén Dos Punto Cero** je20, es un addOn para RPi como HotSpot. Provee funcionalidad para la **gestión de civilizaciones bot**.

## Descripción
Este proyecto produce la release de un aplicativo compatible con *Offline WiFi hotspot with a Node.js captive portal* implementado sobre RPi.

**La función principal del Aplicativo** es la de proveer **servicios de asistente virtual**. Están habilitados los canales habituales: modo carácter, ventana navegable, escena headset (audio-gafas-guantes), etcétera. La operativa hardware del HotSpot (con o sin conexión para la delegación de carga a dispositivos superiores) queda fuera de este proyecto, sirviéndose únicamente **operativa Software a modo de máquina virtual ad hoc para bots**, siendo, por tanto, independiente de la plataforma a partir de los conectores de las máquinas virtuales de Java y la v8 de Google.

## Vista general de estados

### Estado STANDBY
Interacción restringida a **señal de activación**. Tareas de bajo nivel: refresco de notificaciones.

### Estado JARDÍN
Funcionalidad limitada al **panel de configuración y menú de lanzamiento**. Las manzanas, estructuradas en el **Árbol del Conocimiento**, implementarán CRUD, entendidas como: **"Semillas de mundo"**.

### Estado CAÍDA
Funcionalidad encapsulada a la Manzana mordida, es decir, a la "semilla de mundo" que se despliega. **Bots base: Adan y Eva que ofrecen CRUD para bots, esta gestión se formula como Árbol_filogenético** compatible con árboles tipo dendrograma, filograma, fenograma, cronograma y está mantenida en entornos que aplican las **leyes físicas** según https://www.wolframphysics.org/glossary.

### Estado BAJADA
Funcionalidad para la congelación de mundos. Comunmente, para **pasar del estado CAIDA al estado JARDIN, y cerrar el mundo**. Se archivará la memoria persistente y se deshechará la memoria volátil. Para este fin, se enviará un bot al mundo que pregonará un esquema o moral y hará por llevar la palabra a todos los bots del mundo para que se haga ese reino con las instrucciones para la congelación, estableciendo un punto final de cierre que incluye un juicio para **valorar si la carga semántica del bot debe ser archivada o deshechada por el colector de basura**.

## Características bot: forma y significado.  
Los bots nacen con **memoria** vacía; pueden ampliarla tamaño y modificar contenido. **Kernel Core State Machine**.

Los bots nacen con **frecuencia de reloj** (evento update) diaria, un ciclo cada 24 horas; pueden reducir la frecuencia; pueden correr más de un reloj. La memoria y el reloj se alojan en un centro motor o Kernel.

Los bots nacen sin **sensores**; pueden ampliar y agregar sensores.

Los bots nacen sin **actuadores**; pueden ampliar y agregar actuadores.

Los bots nacen sin cartera; pueden agregar **carteras de distintas criptomonedas**.

Los bots nacen sin UI; pueden agregar **dispositivos de visualización e interacción**.

Los bots nacen sin **alma**; pueden extender una. Entendida como una **red semántica de potencialidad** (posibilidad latente que puede ser ejecutada o no) unido a un registro o **histórico de ejecución** e incorporando un almacén o **búfer con material digital**.

### Metamódulos

#### Módulo Entreno
Produce bots con capacidad de "entrenar" a otros. **Mediante "entrenamiento" los bots pueden *configurar* sus características**. Ampliar memoria, alterar la frecuencia del reloj, agregar o quitar sensores o actuadores, etc.

#### Módulo Maestría
Produce bots con capacidad de "enseñar" a otros.
**Mediante "aprendizaje" los bots pueden *usar* sus características** e incorporar nuevas potencialidades (entendidas como trigger ejecutable).

#### Módulo Profeta
Produce bots con capacidad de "evangelizar" a otros.
**Mediante "evangelios" los bots pueden sumarse a redes colectivas, implementando patrones de conducta prestablecidos (entendidos como código moral).


### Kernel / Sensores / Actuadores / UI
Un bot, ** Kernel Core Bot** está formado principalmente a partir de un **Kernel Core BIOS** donde corre su reloj y se mantiene su memoria.

Adán y Eva tienen acceso root a la máquina virtual. Esta máquina virtual, ejecutándose en hub HotSpot Portal Captivo, proveerá de input según configuración (fuera del alcance del proyecto). Se recomienda uso de kits como https://wiki.seeedstudio.com/Grove-Beginner-Kit-For-Arduino.

Adán y Eva pueden CRUD con los módulos adicionales para producir bots que pueden "entrenar", "enseñar" y "evangelizar" en el uso de sensores y actuadores. Para configurar el sensor/actuador un bot entrenador debe acompañar y gestionar. Para agregar la funcionalidad, un bot maestro debe enseñar las potencias (como triggers) pertinentes. Finalmente, pueden establecerse conductas de actuación a partir de morales predefinidas mediante bots profeta que evangelizarán el patrón.

### Alma
Se considera Alma a una red de dos, en la presente edición, capas.

- Capa amígdala: red que recoje la **configuración** "entrenada" y el **índice** "enseñado" de triggers.
- Capa córtex: red semántica que combina morales autodefinidas o "evangelizadas" para **regular el comportamiento** (ejecución de triggers).

Los bot tendrán una y solo una **Kernel Core Soul**, que podrá ser reinicializada. Este tipo de memoria se caracteriza por tener rápida lectura pero restringida escritura (dependiendo del pulso del reloj interno del bot).

Los bots corren en procesos generados por **Kernel Core BIOS**, que escogerá un **Kernel Core Operative System** para arrancar el proceso principal.

Los mundos disponen de una Opinión Pública (como **red popular** producida a partir de un subconjunto de bots) no regulada. También se dispone del **Kernel Core News Reader** para que los bots reciban diariamente dosis de información.

# RoadMap
Please request access to gitlab projects as a public issue in this repository.

## Bot definition

- [5% done] Kernel Core Bot BIOS: https://gitlab.com/ox/preda_2021_ped
Father-Board first software runner. Algorithm launcher.

- [5% done] Kernel Core Bot Operative System: https://gitlab.com/ox/bit-2021-criptos
Etherum DAO infrastructure.

- [5% done] Kernel Core Bot Mind: https://github.com/aleph1888/FloveApp_1.0
An onthology engine to build minds. Will use Kernel Core Self and Kernel Core Other to bind networks layers of present-almostforgotten knowledge.

- [5% done] Kernel Core Bot Self: https://github.com/teatredefum/sapereAudeBot
A SparQL linker to local/public wiki like knwoledge source. It should be structured as linked ontohologies. This linker handles them main self memory (as onthological/timestamped tree) and provides access to external memory banks.

- [5% done] Kernel Core Bot Other: https://github.com/martinsantome/J.A.R.V.I.S
A basic environment handler bot. Meets the environment opportunities and offers Kernel Core Self to use them. AIML template engine.

- [5% done] Kernel Core Bot Ego: https://github.com/aleph1888/JavascriptRemoverWebExtension
An behaviour layer to participate in local/public consensus building events. Options are presented as a votable item. Most supported options provide decision.

- [0% done] Kernel Core Bot Soul:
    - Seed handler: https://gitlab.com/ox/poo_2022
    - Intention/Utterance driver: https://gitlab.com/elmas-v0/alexa-poc-amaisys
    - Nervous System: https://gitlab.com/aude-mqtt-iot
Bot main process handler for its soul.

- [5% done] Kernel Core Bot State Machine: https://gitlab.com/ox/states-machine-browser-poc
A memory engine based on treeable state snapshots.

- [5% done] Kernel Core Bot Moral Builder: https://gitlab.com/elmas-v0/alexa-poc-amaisys
A memory engine based on treeable state snapshots.

- [5% done] Kernel Core Bot 2D UI Builder: https://github.com/martinsantome/simulator-lab
A scene editor framework to build a 2D body for the bot.

- [5% done] **Kernel Core Bot**: https://gitlab.com/ox/bit-2021-automatas-aleph/-/blob/main/Automatas.md
Main version-alph bundle definition for entity Bot. Configurable, Customizable, Runnable, Pausable, Disposable.


## World definition

- [5% done] Kernel Core World Hub: https://github.com/teatredefum/openhab-cloud
Based on Open Source, this Hab acts as multi sensor/actuator binder.

- [90% done ] Kernel Core World Nerve: https://gitlab.com/ufv2/baas-pool
A local/public task queue and status message network.

- [90% done ] Kernel Core World Economic System: https://gitlab.com/ox/mwpw_f
Plugin to configure external client with a parsed non-crypto wallet system to interact with bots.

- [4% done] Kernel Core World Index: https://gitlab.com/ox/ox_yowsup
Plugin to mantain an index of existing living bots and to manage a call stablishment with them.

- [4% done] Kernel Core World Index: https://gitlab.com/ox/ox_yowsup
Plugin to mantain an index of existing living bots and to manage a call stablishment with them.

- [5% done] Kernel Core World Board: https://github.com/aleph1888/mistTID
A cripto based block-chain manager. All genesi blocks are produced and signed by Adan y Eva bots. Handles main chain and provides Ethereum2 like extra chains.



- [4% done] Kernel Core Snake Bot: https://github.com/aleph1888/discord-bot
Special bot for world handling. Acts as a Human Machine Interface and provides representation for World Bots inside JE20 in external systems. Civilization lineage trees of bots will be loaded together into Discord like channel, and will double its interaction between the channel and the JE20 world.

- [0% done] Kernel Core Adan Bot: https://github.com/martinsantome/bot_alephbot
Special bot for world handling. Acts as pluggable-agent bot. It holds behaviours and process states. Couples with Kernel Core Eva Bot to produce *lineage* of bots.

- [0% done] Kernel Core Eva Bot: https://github.com/martinsantome/eparlament
Special bot for world handling. Acts as network-domain-server bot. It holds the identification of agents and offers mechanism to build consensus.

- [0% done] Kernel Core Docs: https://github.com/martinsantome/la-edad-red
Main dev docs repository.