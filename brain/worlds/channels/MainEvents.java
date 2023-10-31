package worlds.channels;

import java.util.HashMap;
import java.util.Map;
import console_app.servicios.Io;
import worlds.channels.ground.GroundChannelChecker;
import worlds.channels.sound.SoundChannelChecker;
import worlds.channels.vision.VisionChannelChecker;

public enum MainEvents {
    GroundChannel(Io.MAIN_EVENTS_GROUND_CHANNEL, 1, new GroundChannelChecker()),
    VisionChannel(Io.MAIN_EVENTS_VISION_CHANNEL, 50, new VisionChannelChecker()),
    SoundChannel(Io.MAIN_EVENTS_SOUND_CHANNEL, 25, new SoundChannelChecker());

    private static final Map<String, MainEvents> BY_LABEL = new HashMap<>();
    private static final Map<Integer, MainEvents> BY_ATOMIC_NUMBER = new HashMap<>();
    private static final Map<EventChecker, MainEvents> BY_CHECKER = new HashMap<>();

    static {
        for (MainEvents e : values()) {
            BY_LABEL.put(e.label, e);
            BY_ATOMIC_NUMBER.put(e.atomicNumber, e);
            BY_CHECKER.put(e.checker, e);
        }
    }

    public final String label;
    public final int atomicNumber;
    public final EventChecker checker;

    private MainEvents(String label, int atomicNumber, EventChecker checker) {
        this.label = label;
        this.atomicNumber = atomicNumber;
        this.checker = checker;
    }

    public static MainEvents valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    public static MainEvents valueOfAtomicNumber(int number) {
        return BY_ATOMIC_NUMBER.get(number);
    }

    public static MainEvents checkIfCanReceive(EventChecker checker) {
        return BY_CHECKER.get(checker);
    }
}