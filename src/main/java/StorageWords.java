import java.util.HashSet;

public class StorageWords {
    private static HashSet<String> storage = new HashSet<>();
    private static volatile boolean stop;

    public static boolean isStop() {
        return stop;
    }

    public static void setStop(boolean stop) {
        StorageWords.stop = stop;
    }

    public static HashSet<String> getStorage() {
        return storage;
    }
}
