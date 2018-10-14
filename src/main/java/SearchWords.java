import java.io.*;

public class SearchWords extends Thread {

    private File file;

    public SearchWords(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {
            for (;;) {
                String s = reader.readLine();
                if (s == null)
                    break;
                String[] words = s.split("\\s+");

                for (String word:words) {
                    synchronized (StorageWords.getStorage()) {
                        if(!StorageWords.isStop())
                            Util.proverkaNaNalichie(word);

                        if(!StorageWords.isStop())
                            Util.proverkaNaValidnost(word);

                        if(!StorageWords.isStop()){
                            Util.addWord(word);
                        } else
                            return;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + file + " не найден");
        } catch (IOException e){
            System.out.println("Ошибка чтения файла " + file);
        }
    }
}
