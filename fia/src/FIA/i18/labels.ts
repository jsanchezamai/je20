
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

    SIMBOLICA: {
        SEMANTICA: {
            NOMBRE: "red-semantica"
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

                SEMANTICA: {
                    NOMBRE: "cadena.simbolica.semantica.red"
                },

                SIMULATION_START: "Creando la red semántica...",
                SIMULATION_BODY: "Modelo resultante",
                SIMULATION_END: "¡Simulación finalizada!",

                AGREGANDO_ENTIDADES_LABEL: "Agregando entidad: ",
                AGREGANDO_ARCOS_SUBCLASES_LABEL: "Agregando arco subclase/clase: ",
                AGREGANDO_ARCOS_PARTE_LABEL: "Agregando arco parte/clase: ",
                AGREGANDO_ARCOS_INSTANCIA_LABEL: "Agregando arco instancia hija/padre: ",
                AGREGANDO_ARCOS_DESCRIPTIVOS_LABEL: "Agregando arco descriptivo destino/origen: ",

                DOMINIO: {
                    ENTIDADES: {
                        tarea: "tarea",
                        robot: "robot",
                        objeto: "objeto",
                        propiedad: "propiedad"
                    },
                    ARCOS: {
                        DESCRIPTIVOS: {
                            tarea_cadena_robot_objeto: {
                                texto: "<tarea>: <clave>. <info>",
                                coger: "Tomar un objeto de la cinta",
                                devolver: "Devolver un objeto a la cinta"
                            },
                            tarea_robot_objeto:  {
                                texto: "<tarea>: <clave>. <info>",
                                deshecha: "Tirar un objeto (no devolverlo a la cinta)"
                            },
                            tarea_robot_objeto_propiedad:  {
                                texto: "<tarea>: <clave>. <info>",
                                operar: "Aplicar trabajos a un objeto"
                            }
                        },
                        ESTRUCTURALES: {
                            INSTANCIA: {
                                texto: "<clave> es instancia de <valor>",
                                robot_1: { criptoselladora: "criptoselladora"},
                                robot_2: { criptoselladora: "criptoselladora"},
                                robot_3: { parseadora: "parseadora"},
                                robot_4: { parseadora: "parseadora"},

                                objeto_1: { objeto_parseable: "objeto_parseable"},
                                objeto_2: { objeto_criptosellable: "objeto_criptosellable"},
                                objeto_3: { objeto_parseable: "objeto_parseable"},
                                objeto_4: { objeto_compuesto: "objeto_compuesto"},

                                propiedad_cripta: { propiedad: "propiedad"},
                                propiedad_cadena: { propiedad: "propiedad"},
                                propiedad_estado: { estado: "estado" }
                            },
                            PARTE: {
                                texto: "<clave> tiene la parte: <valor>",
                                robot: {
                                    tarea_cadena_robot_objeto: "tarea",
                                    tarea_robot_objeto: "tarea",
                                    tarea_robot_objeto_propiedad: "tarea",
                                },
                                objeto: {
                                    propiedad_estado: "propiedad"
                                },
                                objeto_criptosellable: {
                                    propiedad_cripta: "propiedad"
                                },
                                objeto_parseable: {
                                    propiedad_cadena: "propiedad"
                                },
                                objeto_compuesto: {
                                    objeto_parseable: "objeto",
                                    objeto_criptosellable: "objeto"
                                }
                            },
                            SUBCLASE: {
                                texto: "<clave> es subclase de <valor>",

                                criptoselladora: { robot: "robot" },
                                parseadora: { robot: "robot" },

                                objeto_criptosellable: { objeto: "objeto" },
                                objeto_parseable: { objeto: "objeto" },

                                objeto_compuesto: { objeto: "objeto" }

                            }
                        }
                    }
                },

                RED: {

                    NOMBRE: "cadena.simbolica.red",

                    RECEPCION_AFERENCIA_LABEL: "El mundo envía una aferencia. Voy a realizar la transición de estado.",
                    ENVIO_EFERENCIA_LABEL: "¡Hecho! Le devuelvo el nuevo estado al mundo con una eferencia.",
                }
            },

        }
    }

}
