package brains.court.people;

import console_app.tipos.personas.Cliente;
import worlds.objects.IWorldAgent;

public class Defendant extends Cliente implements IDefendant {

    public Defendant() {
    }

    public Defendant(IWorldAgent worldAgent) {
        super.worldAgent(worldAgent);
    }

}
