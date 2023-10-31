package brains.court.law;

public interface ICrime extends IDamage, IFact {

    Integer lifeCounter();

    boolean executed();

    void execute();

}
