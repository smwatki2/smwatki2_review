package main.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

/**
 * main method for running the program.
 * @author amehlhas
 *
 */
final class Main {
	/**
	 * All methods should have a Javadoc according to STYLE.
	 * @param args command-line arguments
	 * @throws Exception as per typical main specifications
	 */
	public static void main(final String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String accStr;  
		String choice;
		
		if (args.length == 0) {
			accStr = "20";
			choice = "1";
			
		}
		else{
			System.out.println("Enter your string of numbers: ");
			accStr = br.readLine();
			
			System.out.println("Initial String: ");
			System.out.println(accStr);
			
			System.out.println("Choose Algorithm: ");
			choice = br.readLine();
		}
		SortDemoData data = new SortDemoData();
		
		try {

			data.initializeArray(accStr);

		
			StringBuffer outputBuf = data.runAlgo(Integer.valueOf(choice).intValue());
			
			System.out.println("Result: ");
			System.out.println(outputBuf.toString());
		
		 } catch (NoSuchElementException e) {
			 System.out.println("Not enough numbers.");
	     } catch (NumberFormatException e) {
	    	 System.out.println("Please only use integer values. ");
	     } catch (NegativeArraySizeException e) {
	    	 System.out.println("Negative Array Size.");
	     }  
		
	
	}
    
}
