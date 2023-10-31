package brains.court.decision;

import java.util.HashMap;
import java.util.Map;

import console_app.servicios.Io;

public interface IBrainState {

    public BrainStates state();

    public IConcience concience();

    public void state(BrainStates state);

    public enum BrainStates {
        Unborn(Io.BRAINSTATE_UNBORN, 0, 1.008f),
        AliveSleep(Io.BRAINSTATE_ALIVE_SLEEP, 10000, 4.0026f),
        AliveAwake(Io.BRAINSTATE_ALIVE_AWAKE, 1000, 20.180f),
        AliveImaging(Io.BRAINSTATE_ALIVE_IMAGINING, 2000, 1.008f),
        AliveRemembering(Io.BRAINSTATE_ALIVE_REMEMBERING, 3000, 4.0026f),
        Dead(Io.BRAINSTATE_DEAD, 0, 20.180f);

        private static final Map<String, BrainStates> BY_LABEL = new HashMap<>();
        private static final Map<Integer, BrainStates> BY_ATOMIC_NUMBER = new HashMap<>();
        private static final Map<Float, BrainStates> BY_ATOMIC_WEIGHT = new HashMap<>();

        static {
            for (BrainStates e : values()) {
                BY_LABEL.put(e.label, e);
                BY_ATOMIC_NUMBER.put(e.atomicNumber, e);
                BY_ATOMIC_WEIGHT.put(e.atomicWeight, e);
            }
        }

        public final String label;
        public final int atomicNumber;
        public final float atomicWeight;

        private BrainStates(String label, int atomicNumber, float atomicWeight) {
            this.label = label;
            this.atomicNumber = atomicNumber;
            this.atomicWeight = atomicWeight;
        }

        public static BrainStates valueOfLabel(String label) {
            return BY_LABEL.get(label);
        }

        public static BrainStates valueOfAtomicNumber(int number) {
            return BY_ATOMIC_NUMBER.get(number);
        }

        public static BrainStates valueOfAtomicWeight(float weight) {
            return BY_ATOMIC_WEIGHT.get(weight);
        }
    }

}