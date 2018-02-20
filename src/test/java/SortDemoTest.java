package test.java;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.Item;
import main.java.SortAlgos;
import main.java.SortDemoData;

class SortDemoTest {

    SortDemoData data = new SortDemoData();


    /**
    * testNewAccountsType checks for valid input types in the 1st parameter
    */
    @Test
    public void testNumber() {
       data.initializeArray("20");
       assertTrue(data.myArray.length == 20);
       
       data.initializeArray("30");
       assertTrue(data.myArray.length == 30);
       
       data.initializeArray("0");
       assertTrue(data.myArray.length == 0);
    }


    /**
     * testNewAccountsType checks for valid input types in the 1st parameter
     */
    @Test
    public void negativeArraySize() {
        assertThrows(NegativeArraySizeException.class,
                ()->{
                    data.initializeArray("-3"); 
                });
    }
    
    /**
     * testNewAccountsType checks for valid input types in the 1st parameter
     */
    @Test
    public void NonIntegerValue() {
        assertThrows(NumberFormatException.class,
                ()->{
                    data.initializeArray("5.5 7 9");
                });
    }
    
    /**
     * testNewAccountsType checks for valid input types in the 1st parameter
     */
    @Test
    public void NoSuchElem() {
        assertThrows(java.util.NoSuchElementException.class,
                ()->{
                    data.initializeArray("");
                }); 
    }
    
    /**
     * testNewAccountsType checks for valid input types in the 1st parameter
     */
    @Test
    public void NoNumber() {
        assertThrows(NumberFormatException.class,
                ()->{
                    data.initializeArray("5 8 y 4"); 
                }); 
         
    }
    
    /**
     * testNewAccountsType checks for valid input types in the 1st parameter
     */
    @Test
    public void SameNumber() {
        data.initializeArray("5 5 64 4 4");  
        
        SortDemoData data2 = new SortDemoData();
        data2.initializeArray("5 64 4");
        assertTrue(data.myArray.length == 3);
        assertTrue(data.myArray[0].getKey() == data2.myArray[0].getKey() );
        assertTrue(data.myArray[1].getKey() == data2.myArray[1].getKey() );
        assertTrue(data.myArray[2].getKey() == data2.myArray[2].getKey() );
    }
    
    
    // TODO: Include your test cases below
    
    
    /**
     * wrongChoice checks that if the input for runAlgo is smaller than 0, or greater than 5 Bubble sort is used
     * Boundary cases -10, -1, 0 (should use Bubble Sort anyway), 6, 100
     */
    @Test
    public void wrongChoice() {
        data.initializeArray("5 8 5 4");  
        data.runAlgo(-10);
        assertTrue(data.algo.equals("Bubble Sort"));
        data.runAlgo(-1);
        assertTrue(data.algo.equals("Bubble Sort"));
        data.runAlgo(0);
        assertTrue(data.algo.equals("Bubble Sort"));
        data.runAlgo(6);
        assertTrue(data.algo.equals("Bubble Sort"));
        data.runAlgo(100);
        assertTrue(data.algo.equals("Bubble Sort"));
    }
    
    /**
     * correctAlgo checks that choices 0-5 lead to the correct used algorithm
     */
    @Test
    public void correctAlgo() {
        data.initializeArray("5 8 4");  
        data.runAlgo(0);
        assertTrue(data.algo.equals("Bubble Sort"));
        data.runAlgo(1);
        assertTrue(data.algo.equals("Selection Sort"));
        data.runAlgo(2);
        assertTrue(data.algo.equals("Insertion Sort"));
        data.runAlgo(3);
        assertTrue(data.algo.equals("Merge Sort"));
        data.runAlgo(4);
        assertTrue(data.algo.equals("Quick Sort"));
        data.runAlgo(5);
        assertTrue(data.algo.equals("Heap Sort"));
    }

  
    /**
     * correctAttribute checks that the attribute in data is always the correct algorithm
     */
    @Test
    public void correctAttribute() {
        data.initializeArray("5 8 5 4");  
        data.runAlgo(0);
        assertTrue(data.algo.equals("Bubble Sort"));
        data.runAlgo(1);
        assertTrue(data.algo.equals("Selection Sort"));
        data.runAlgo(2);
        assertTrue(data.algo.equals("Insertion Sort"));
        data.runAlgo(3);
        assertTrue(data.algo.equals("Merge Sort"));
        data.runAlgo(4);
        assertTrue(data.algo.equals("Quick Sort"));
        data.runAlgo(5);
        assertTrue(data.algo.equals("Heap Sort"));
    }

}
