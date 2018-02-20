package test.java;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.Item;
import main.java.SortAlgos;
import main.java.SortDemoData;

class AlgoTest {

    /**
     * sameSize checks that the given array and the output array have the same size
     */
    @Test
    public void sameSize() {
        SortDemoData data = new SortDemoData();
        data.initializeArray("2 3 4");
        Item[] copyOfMyArray = new Item[data.myArray.length];
        System.arraycopy(
                data.myArray, 0, copyOfMyArray, 0, data.myArray.length);
        
        SortAlgos.bubbleSort(data.myArray);
        
        assertTrue(data.myArray.length == copyOfMyArray.length);
    }
    
    /**
     * emptyArray checks that the method throws a NullPointer for a given null array
     */
    @Test
    public void emptyArray() {
        assertThrows(NullPointerException.class,
                ()->{
                    Item[] myArray = null;
                    SortAlgos.bubbleSort(myArray);
                });
    }

    /**
     * correctSort checks that the array is sorted correctly at the end
     */
    @Test
    public void correctSort() {
        Item [] array = new Item[3];
        array[0] = new Item(5);
        array[1] = new Item(4);
        array[2] = new Item(3);
        SortAlgos.bubbleSort(array);
        System.out.println(array[0].getKey());
        assertTrue(array[0].getKey() == 3);
        assertTrue(array[1].getKey() == 4);
        assertTrue(array[2].getKey() == 5);
    }
}

