package worlds.channels.ground;

import worlds.JardinEden;
import worlds.channels.MainEvents;
import worlds.channels.sound.SoundChannelChecker;
import worlds.channels.vision.VisionChannelChecker;
import worlds.objects.IWorldObject;
import worlds.physics.Vector3;

public class WalkTo implements IGroundChannelEvent {

    private static int MOVE_FACTOR = 50;

    /**
     * Unidimensional searcher over X axis to get close enough to see the target.
     * @param searcher
     * @param target
     */
    public static Integer searchToVision(Integer direction, IWorldObject searcher, IWorldObject target) {

        if (searcher == null) return 0;

        if (canSee(searcher, target)) {

            return 0;

        } else {

            walk(searcher, direction);
        }

        return direction;

    }

    /**
     * Unidimensional searcher over X axis to get close enough to talk to target
     * @param searcher
     * @param target
     */
    public static Integer searchToSound(Integer direction, IWorldObject searcher, IWorldObject target) {

        if (searcher == null) return 0;

        if (canTalk(searcher, target)) {

            return 0;

        } else {

            walk(searcher, direction);
        }

        return direction;

    }

    private static void walk(IWorldObject searcher, int direction) {
        // go to one edge and back to the other till found the target...
        float x = searcher.position().getX();

        if ( x > JardinEden.DIMENSION ) {
            direction = -1;
        } else if (x < JardinEden.DIMENSION * -1) {
            direction = 1;
        }

        if(direction == 1 && x > 0) {
            x = MOVE_FACTOR * -1;
        } else if(direction == -1 && x > 0) {
            x = MOVE_FACTOR * 1;
        } else if(direction == 1 && x < 0) {
            x = MOVE_FACTOR * -1;
        } else if(direction == -1 && x < 0) {
            x = MOVE_FACTOR * -1;
        } else {
            x = MOVE_FACTOR * (direction * -1);
        }

        Vector3 p = searcher.position();
        p.subtract(new Vector3(x, p.getY(), p.getZ()));

    }

    private static boolean canSee(IWorldObject searcher, IWorldObject target) {

        if (target == null) {
            return false;
        } else {

            VisionChannelChecker checker = new VisionChannelChecker();
            checker.waEmitter(searcher);
            return MainEvents.VisionChannel.checker.check(searcher, target);
        }
    }

    private static boolean canTalk(IWorldObject searcher, IWorldObject target) {
        if (target == null) {
            return false;
        } else {

            SoundChannelChecker checker = new SoundChannelChecker();
            checker.waEmitter(searcher);
            return MainEvents.SoundChannel.checker.check(searcher, target);
        }
    }
}
