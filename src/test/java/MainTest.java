import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @After
    public void clearAll(){
        StorageWords.getStorage().clear();
        StorageWords.setStop(false);
    }

    @Test
    public void addWordTest(){
        Util.addWord("Word");
        Util.addWord("Name");
        assertEquals(2, StorageWords.getStorage().size());
    }

    @Test
    public void proverkaNaValidnostTest1(){
        Util.proverkaNaValidnost("QWERTY");
        assertTrue(StorageWords.isStop());
    }

    @Test
    public void proverkaNaValidnostTest2(){
        Util.proverkaNaValidnost("АБВГ1@4%^:");
        assertTrue(!StorageWords.isStop());
    }

    @Test
    public void proverkaNaNalichieTest3(){
        Util.addWord("Word");
        Util.addWord("Name");
        assertTrue(!StorageWords.isStop());
        Util.proverkaNaNalichie("Word");
        assertTrue(StorageWords.isStop());
    }

}
