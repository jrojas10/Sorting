import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> list10 = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int d = r.nextInt();
			System.out.println(d);
			list10.add(d);

		}

		// ArrayList<Long> list100 = new ArrayList<Long>();
		// for (int i = 0; i < 100; i++) {
		// Long d = r.nextLong() * 100;
		// System.out.println(d);
		// list100.add(d);
		//
		// }

		System.out.println();

		Sorting s = new Sorting();
		Integer[] bubbleList10 = s.toArray(list10);
		// Integer[] insertionList10 = s.toArray(list10);
		// s.bubbleSort(bubbleList10);
		// s.print(bubbleList10);
		System.out.println("Bubble Sort");
		long nanoStart = System.nanoTime();

		s.improvedBubbleSort(bubbleList10);
		long nanoEnd = System.nanoTime();

		System.out.println("Bubble sort time = " + (nanoEnd - nanoStart) + " nano seconds");

		s.print(bubbleList10);
		//long miliseconds = System.currentTimeMillis();
		// long seconds = TimeUnit.MILLISECONDS.toSeconds(miliseconds);

		System.exit(0);
	}

}
