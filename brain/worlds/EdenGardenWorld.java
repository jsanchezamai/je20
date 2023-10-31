package worlds;

import java.util.List;
import bots.IBot;
import console_app.interfaces.pantallas.IOpcion;
import console_app.servicios.Io;
import console_app.tipos.entidades.Opcion;
import sequences.main.OfferAppleDecision;
import things.IThing;
import worlds.physics.Vector3m;
import bots.Bot;
import brains.codes.hammurabi.HammurabiBrain;
import brains.codes.random.RandomBrain;
import brains.court.law.DecisionState;
import brains.court.people.Defendant;

public class EdenGardenWorld extends World {

    public IBot adan;
    public IBot snake;
    public IBot eva;

    public IThing tree;
    private OfferAppleDecision offerApple;

    public List<IOpcion> opciones() {

        opciones.clear();

        if (offerApple == null) {
            opciones.add(new Opcion(Io.EDENGARDEN_OPTIONS_SNAKE_TO_TEMP_EVE, "2"));
        } else {
            opciones.add(new Opcion(
                Io.EDENGARDEN_OPTIONS_SNAKE_TO_TEMP_EVE_WAITING + Io.EDENGARDEN_OPTIONS_STOPIT, "2"));
        }

        // opciones.add(tree.opcion());

        // opciones.add(adan.opcion());
        opciones.add(eva.opcion());

        IOpcion so = snake.opcion();
        opciones.add(so);

        if (offerApple != null && offerApple.state() != DecisionState.Abandon) {
            so.etiqueta(String.format(Io.SUBSTATE_LABEL, offerApple.crime().toString()));

            for (String logLine: offerApple.log()) {
                opciones.add(new Opcion(logLine, "-", false));
            }
        }


        return opciones;
    }

    public EdenGardenWorld() {

    }

    @Override
    public void create() {

        name(Io.TITULO_APP);

        RandomBrain random = new RandomBrain();
        snake = new Bot(random, Io.BOT_SNAKE_NAME, fact());
        snake.position(new Vector3m(-100, 0, 0));
        snake.brain().goToSleep();
        bots.add(snake);

        /*tree = new Thing(Io.THING_WISDOM_TREE);
        tree.position(new Vector3m(0, 0, 0));
        things.add(tree);*/

        HammurabiBrain hammurabi = new HammurabiBrain();
        eva = new Bot(hammurabi, Io.BOT_EVE_NAME, fact());
        eva.position(new Vector3m(100, 0, 0));
        eva.brain().goToSleep();
        bots.add(eva);

        /*PredictiveBrain predictive = new PredictiveBrain();
        adan = new Bot(predictive, Io.BOT_ADAN_NAME, fact());
        adan.position(new Vector3m(100, 0, 0));
        adan.brain().goToSleep();
        bots.add(adan);*/

    }

	public void SendSnakeToTempEve() {

        offerApple = new OfferAppleDecision();
        offerApple.defendant(new Defendant(eva));

        snake.startToThink(offerApple);

    }

    public void StopSnakeToTempEve() {

        if (offerApple == null) return;
        snake.brain().stopToThink(offerApple);

    }

}
