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
Los bots nacen con **memoria** vacía; pueden ampliarla tamaño y modificar contenido.

Los bots nacen con **frecuencia de reloj** (evento update) diaria, un ciclo cada 24 horas; pueden reducir la frecuencia; pueden correr más de un reloj. La memoria y el reloj se alojan en un centro motor o Kernel.

Los bots nacen sin **sensores**; pueden ampliar y agregar sensores.

Los bots nacen sin **actuadores**; pueden ampliar y agregar actuadores.

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
Un bot está formado principalmente a partir de un Kernel donde corre su reloj y se mantiene su memoria.

Adán y Eva tienen acceso root a la máquina virtual. Esta máquina virtual, ejecutándose en hub HotSpot Portal Captivo, proveerá de input según configuración (fuera del alcance del proyecto). Se recomienda uso de kits como https://wiki.seeedstudio.com/Grove-Beginner-Kit-For-Arduino.

Adán y Eva pueden CRUD con los módulos adicionales para producir bots que pueden "entrenar", "enseñar" y "evangelizar" en el uso de sensores y actuadores. Para configurar el sensor/actuador un bot entrenador debe acompañar y gestionar. Para agregar la funcionalidad, un bot maestro debe enseñar las potencias (como triggers) pertinentes. Finalmente, pueden establecerse conductas de actuación a partir de morales predefinidas mediante bots profeta que evangelizarán el patrón.

### Alma
Se considera Alma a una red de dos, en la presente edición, capas.

- Capa amígdala: red que recoje la **configuración** "entrenada" y el **índice** "enseñado" de triggers.
- Capa córtex: red semántica que combina morales autodefinidas o "evangelizadas" para **regular el comportamiento** (ejecución de triggers).

