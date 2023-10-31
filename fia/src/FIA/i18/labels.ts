
export const i18_ME = {

    ME_LABEL: "sistema",

}

export const i18 = {

    ME_LABEL: i18_ME.ME_LABEL,

    FIA_CIENTIFICA_LABEL: "cientifica",
    FIA_CONEXIONISTA_LABEL: "conexionista",
    FIA_SIMBOLICA_LABEL: "simbolica",
    FIA_SITUADA_LABEL: "situada",
    FIA_CIENTIFICA_FUERTE_LABEL: "fuerte",
    FIA_CIENCITICA_DEBIL_LABEL: "debil",

    SISTEMA: {
        STARTING_LABEL: "Arrancando el sistema"
    },

    MENU_HEADER_LABEL: `Escoge:`,
    MENU_PROMPT_DATA_LABEL: `Escribe:`,

    EXIT_PROMT_LABEL: "Not today! ¡Cerrar!, please, bye!",

    LOOP: {
        LOAD_FIA_LABEL: "Cargando FIAs disponibles, por favor espera... ",
        LAUNCH_FIA_LABEL: "Transfiriendo el prompt a",
        NOT_INIT_LABEL: "¡No estoy inicializada, por favor, instánciame!",
    },

    IDLE_STATE_LABEL: "Nada qué hacer! Cierro!",

    TURING: {
        AGENT: "turing-tester",
        TEST_LABEL: "Para ser fuerte, debes ser como un humano. Si no, serás débil. Razona lo siguiente: ¿eres humano?",
        TEST_START_LABEL: "iniciar test-turing",
        TEST_STOP_LABEL: "¡Test concluído!"
    },

    SITUADA: {
        SIMULATION_START: "Hola soy un autómata situado. Voy a ejemplificar mi forma de razonar. Para ello operaré un serie de pasos recibiendo señales con mis sensores y enviando acciones.",
        SIMULATION_BODY: "Modelo resultante",
        SIMULATION_END: "¡Simulación finalizada!",
        AUTOMATA: {
            NOMBRE: "situada.automata",
            RECEPCION_AFERENCIA_LABEL: "El mundo envía una aferencia. Voy a realizar la transición de estado.",
            ENVIO_EFERENCIA_LABEL: "¡Hecho! Le devuelvo el nuevo estado al mundo con una eferencia.",
        },
        CADENA: {
            NOMBRE: "situada.automata"
        }
    },

    MUNDO: {
        INICIO_LABEL: "¡Mundo iniciado!",
        FIN_LABEL: "¡Mundo acabado!",

        DIA_LABEL: "Hoy es el día:",

        EJEMPLOS_CADENA_LABEL: "cadena",

        AFERENCIA: {
            RECEPCION_LABEL: "El mundo ha recibido una eferencia. Actualizando modelo."
        }
    },

    APPS: {
        CADENA: {

            NOMBRE: "cadena-app",

            SIMULATION_START: "Esta aplicación simula una cadena de producción. ¡Arrancando simulación!",
            SIMULATION_BODY: "Modelo resultante",
            SIMULATION_END: "¡La aplicación ha concluído y se cierra!",

            SITUADA: {
                NOMBRE: "cadena.situada",

                SIMULATION_START: "Hola soy un autómata situado. Voy a ejemplificar mi forma de razonar. Para ello operaré un serie de pasos recibiendo señales con mis sensores y enviando acciones.",
                SIMULATION_BODY: "Modelo resultante",
                SIMULATION_END: "¡Simulación finalizada!",
                AUTOMATA: {

                    NOMBRE: "cadena.situada.automata",

                    RECEPCION_AFERENCIA_LABEL: "El mundo envía una aferencia. Voy a realizar la transición de estado.",
                    ENVIO_EFERENCIA_LABEL: "¡Hecho! Le devuelvo el nuevo estado al mundo con una eferencia.",
                }
            },

            SIMBOLICA: {

                NOMBRE: "cadena.simbolica",

                SIMULATION_START: "Proceso SIMBOLICO no inicializado, y no participará en la simulación",
                SIMULATION_BODY: "Modelo resultante",
                SIMULATION_END: "¡Simulación finalizada!",
            },

        }
    }

}
