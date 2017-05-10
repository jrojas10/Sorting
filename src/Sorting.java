import java.util.ArrayList;
import java.util.Random;

public class Sorting<E> {
	Long[] array;

	public Sorting() {

	}

	protected Long[] createList(int size) {
		ArrayList<Long> list = new ArrayList<Long>();
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			Long random = (long) r.nextInt();
			list.add(random);

		}
		return toArray(list);
	}

	private Long[] toArray(ArrayList<?> list) {
		Long[] array2 = list.toArray(new Long[list.size()]);
		// Double[] array = new Double[list.size()];
		// array = (Double[]) list.toArray(array);
		this.array = array2;
		return array;

	}

	protected void print() {
		for (int i = 0; i < this.array.length; i++) {
			System.out.println(this.array[i]);
		}
	}

	protected void improvedBubbleSort() {
		long nanoStart = System.nanoTime();
		int swapCounter = 0;
		int compareCounter = 0;
		boolean pass = true;
		for (int k = 1; k < this.array.length && pass; k++) {
			pass = false;
			for (int i = 0; i < this.array.length - k; i++) {
				compareCounter++;
				if (this.array[i] > this.array[i + 1]) {
					Long temp = this.array[i];
					this.array[i] = this.array[i + 1];
					this.array[i + 1] = temp;
					swapCounter++;
					pass = true;
				}
			}
		}
		long nanoEnd = System.nanoTime();
		print();

		System.out.println("Compare counter = " + compareCounter + "\nSwap Counter = " + swapCounter);
		System.out.println("Bubble sort time = " + (nanoEnd - nanoStart) + " nano seconds");
	}

	protected void insertionSort() {
		long nanoStart = System.nanoTime();
		int swapCounter = 0;
		int compareCounter = 0;

		for (int i = 1; i < this.array.length; i++) {
			Long current = this.array[i];
			int k;
			for (k = i - 1; k >= 0 && this.array[k] > current; k--) {
				compareCounter++;
				this.array[k + 1] = this.array[k];
				swapCounter++;
			}
			this.array[k + 1] = current;
			swapCounter++;
		}
		long nanoEnd = System.nanoTime();
		print();
		System.out.println("Compare counter = " + compareCounter + "\nSwap Counter = " + swapCounter);
		System.out.println("Insertion sort time = " + (nanoEnd - nanoStart) + " nano seconds");
	}

	protected void mergeSortFinal() {
		long nanoStart = System.nanoTime();
		mergeSort(this.array);
		long nanoEnd = System.nanoTime();
		print();
		System.out.println("Merge sort time = " + (nanoEnd - nanoStart) + " nano seconds");
	}

	private void mergeSort(Long[] arrayH) {

		int swapCounter = 0;
		int compareCounter = 0;
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
			if (first[curr1] < secondHalf[curr2])
				array2[curr3++] = first[curr1++];
			else
				array2[curr3++] = secondHalf[curr2++];
		}
		while (curr1 < first.length)
			array2[curr3++] = first[curr1++];

		while (curr2 < secondHalf.length)
			array2[curr3++] = secondHalf[curr2++];

	}
}