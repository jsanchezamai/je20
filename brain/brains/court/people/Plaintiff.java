package brains.court.people;

import brains.court.decision.Decision;
import brains.court.law.Fact;
import console_app.servicios.Io;
import console_app.tipos.personas.Cliente;
import worlds.objects.IWorldAgent;
import worlds.objects.WorldAgent;

public class Plaintiff extends Cliente implements IPlaintiff {

    public Plaintiff(IWorldAgent worldAgent) {
        super.worldAgent(worldAgent);
    }

    public Plaintiff() {
        super.worldAgent(
            new WorldAgent(
                Io.NO_NAME,
                new Fact(new Decision())
            )
        );
    }

}
