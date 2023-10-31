package brains.court.law;

public interface IPunishment extends IDamage, IFact {

    Integer lifeCounter();

    boolean executed();

    void execute();

}
