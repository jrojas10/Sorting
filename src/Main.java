import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;
import java.time.Duration;

public class Main {

	public static void main(String[] args) {

		Sorting s = new Sorting();
	
		s.createList(1000); // creates unsorted array
	//	s.improvedBubbleSort(); //sorts and prints swaps and compares
		//s.insertionSort();
		s.mergeSortFinal();
	

		System.exit(0);
	}

}