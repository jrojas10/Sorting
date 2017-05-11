import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;

public class Sorting<E> {
	Long[] array;
	Long[] array2;
	int swapCounter = 0;
	int compareCounter = 0;

	public Sorting() {

	}

	protected Long[] createList(int size) {
		// creates arraylist of random numbers and random length
		ArrayList<Long> list = new ArrayList<Long>();
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			Long random = (long) r.nextInt();
			list.add(random);

		}
		return toArray(list);
	}

	private Long[] toArray(ArrayList<?> list) {
		// converts arraylist to array
		Long[] array2 = list.toArray(new Long[list.size()]);
		this.array = array2;
		return array;

	}
	protected Long[] deepCopy(){
		array2 = new Long[array.length];
		for(int i =0; i<array2.length;i++)
			array2[i] = array[i];
		return array2;
	}
	protected void print(){
		for (int i = 0; i < this.array.length; i++) {
			System.out.println(this.array[i]);
		}
	}	

	protected void print(Long[] array) {
		// prints array
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	protected void improvedBubbleSort() {
		Long[] copy = deepCopy();
		Instant start = Instant.now();
		int swapCounter = 0;
		int compareCounter = 0;
		boolean pass = true;
		for (int k = 1; k < copy.length && pass; k++) {
			pass = false;
			for (int i = 0; i < copy.length - k; i++) {
				compareCounter++;
				if (copy[i] > copy[i + 1]) {
					Long temp = copy[i];
				copy[i] = copy[i + 1];
				copy[i + 1] = temp;
					swapCounter++;
					pass = true;
				}
			}
		}
		Instant end = Instant.now();
		//print(copy);
		
		
		System.out.println("Compare counter = " + compareCounter + "\nSwap Counter = " + swapCounter);
		System.out.println("Bubble sort  time = "+Duration.between(start, end));
	}

	protected void insertionSort() {
		Long[] copy = deepCopy();
		Instant start= Instant.now();
		int swapCounter = 0;
		int compareCounter = 0;

		for (int i = 1; i < copy.length; i++) {
			Long current = copy[i];
			int k;
			for (k = i - 1; k >= 0 && copy[k] > current; k--) {
				compareCounter++;
				copy[k + 1] = copy[k];
				swapCounter++;
			}
			copy[k + 1] = current;
			swapCounter++;
		}
		Instant end = Instant.now();
	//	print(copy);
		System.out.println("Compare counter = " + compareCounter + "\nSwap Counter = " + swapCounter);
		System.out.println("Insertion sort time = "+ Duration.between(start, end));
	}

	protected void mergeSortFinal() {
		Long[] copy = deepCopy();
		Instant start = Instant.now();
		mergeSort(copy);
		Instant end = Instant.now();
	//	print(copy);
		System.out.println("Merge sort time = " + Duration.between(start, end));
		System.out.println("Compare counter = " + compareCounter);
	}

	private void mergeSort(Long[] arrayH) {

		if (arrayH.length > 1) {
			Long[] firstHalf = new Long[arrayH.length / 2];
			System.arraycopy(arrayH, 0, firstHalf, 0, arrayH.length / 2);
			mergeSort(firstHalf);

			int secondHalfLength = arrayH.length - arrayH.length / 2;
			Long[] secondHalf = new Long[secondHalfLength];
			System.arraycopy(arrayH, arrayH.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);
			merge(firstHalf, secondHalf, arrayH);
		}

	}

	private void merge(Long[] first, Long[] secondHalf, Long[] array2) {

		int curr1 = 0;
		int curr2 = 0;
		int curr3 = 0;
		while (curr1 < first.length && curr2 < secondHalf.length) {
			if (first[curr1] < secondHalf[curr2]) {
				compareCounter++;
				array2[curr3++] = first[curr1++];

			}

			else
				array2[curr3++] = secondHalf[curr2++];
		}
		while (curr1 < first.length) {
			compareCounter++;
			array2[curr3++] = first[curr1++];
		}
		while (curr2 < secondHalf.length) {
			compareCounter++;
			array2[curr3++] = secondHalf[curr2++];
		}

	}

	protected void quickSortHelper() {
		Long[] copy = deepCopy();
		Instant start= Instant.now();
		quickSort(copy);
		Instant end = Instant.now();
	//	print(copy);
		System.out.println("quick sort time = " + Duration.between(start, end));
		System.out.println("Compare counter = " + compareCounter + "\nSwap Counter = " + swapCounter);
	}

	private void quickSort(Long[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private void quickSort(Long[] array, int first, int last) {
		if (last > first) {
			int pivot = partition(array, first, last);
			quickSort(array, first, pivot - 1);
			quickSort(array, pivot + 1, last);
		}

	}

	private int partition(Long[] array, int first, int last) {

		Long pivot = array[first];
		int low = first;
		int high = last;

		while (high > low) {
			compareCounter++;
			while (low <= high && array[low] <= pivot) {
				compareCounter++;
				low++;
			}
			while (low <= high && array[high] > pivot) {
				compareCounter++;
				high--;
			}
			if (high > low) {
				compareCounter++;
				Long temp = array[high];
				array[high] = array[low];
				array[low] = temp;
			}
		}
		while (high > first && array[high] >= pivot) {
			compareCounter++;
			high--;
		}
		if (pivot > array[high]) {
			swapCounter++;
			array[first] = array[high];
			array[high] = pivot;
			return high;
		} else {
			return first;

		}

	}

	protected void gnomeSort() {
		Long[] copy = deepCopy();
		Instant start = Instant.now();
		int pos = 0;
		int swap = 0;
		int compare = 0;
		while (pos <copy.length) {
			if (pos == 0 || copy[pos] >= copy[pos - 1]) {
				compare++;
				pos = pos + 1;
			}

			else {
				swap++;
				long temp = copy[pos];
				copy[pos] = copy[pos - 1];
				copy[pos - 1] = temp;
				pos = pos - 1;
			}
		}
		Instant end = Instant.now();
	//	print(copy);
		System.out.println("Gnome sort time = " + Duration.between(start, end));
		System.out.println("Compare counter = " + compare + "\nSwap Counter = " + swap);

	}

	protected void selectionSort() {
		Long[] copy = deepCopy();
		Instant start = Instant.now();
		int swapCounter = 0;
		int compareCounter = 0;
		int i, j, first;
		int n = copy.length;

		for (i = 0; i < n - 1; i++) {
			first = i;
			for (j = i + 1; j < copy.length; j++)
				if (copy[j] < copy[first]) {
					compareCounter++;
					first = j;
				}

			Long temp = copy[i];
			copy[i] = copy[first];
			copy[first] = temp;
			swapCounter++;
		}
		Instant end = Instant.now();
	//	print(copy);
		System.out.println("Compare counter = " + compareCounter + "\nSwap Counter = " + swapCounter);
		System.out.println("Selection sort time = " + Duration.between(start, end));

	}

}