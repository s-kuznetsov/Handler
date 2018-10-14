
public class Util {

    public static void proverkaNaNalichie(String s){
        if (StorageWords.getStorage().contains(s)) {
            StorageWords.setStop(true);
            System.out.println("Найден дубликат: " + s);
        }
    }

    public static void proverkaNaValidnost(String word){
        if (!word.matches("^[А-яёЁ(:)@%^0-9,.\\-'/«»!&?\"]+") || word.equals("")) {
            System.out.println("Невалидное слово: " +/*из файла " + file + ":  */  word);
            StorageWords.setStop(true);
        }
    }

    public static void addWord(String s){
        StorageWords.getStorage().add(s);
        System.out.println("Добавлено слово: " + /*из файла  + file +:   */  s);
    }
}
