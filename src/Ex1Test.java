import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
//
public class Ex1Test {
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }

        @Test
        void int2NumberTest() {

            assertEquals("101", Ex1.int2Number(5, 2));
            assertEquals("A", Ex1.int2Number(10, 16));
            assertEquals("12", Ex1.int2Number(5, 3));
            assertEquals("5", Ex1.int2Number(5, 10));

            assertEquals("", Ex1.int2Number(-5, 2));
            assertEquals("", Ex1.int2Number(10, 1));
            assertEquals("", Ex1.int2Number(10, 17));
        }

        @Test
        void maxIndexTest() {

            String[] arr1 = {"0b2", "1b2", "10b2", "11b2"};
            assertEquals(3, Ex1.maxIndex(arr1));

            String[] arr2 = {"b5", "3b3", "123bbA", "ab5"};
            assertEquals(-1, Ex1.maxIndex(arr2));

            String[] arr3 = {"1010b2"};
            assertEquals(10, Ex1.maxIndex(arr3));

            String[] arr4 = {"b5", "101b2", "123bbA", "ab5"};
            assertEquals(5, Ex1.maxIndex(arr4));
        }

    @Test
    void testInvalidBase() {

        String invalidBase1 = "1b1";
        int result1 = Ex1.number2Int(invalidBase1);
        assertEquals(-1, result1);

        String invalidBase2 = "117";
        int result2 = Ex1.number2Int(invalidBase2);
        assertEquals(-1, result2);
    }


    }
