import java.io.File;

public class Main {
    public static void main(String[] args) {
        for (String arg : args) {
            new SearchWords(new File("src\\main\\resources\\" + arg)).start();
        }
    }
}
