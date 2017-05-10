import java.util.ArrayList;

public class Sorting {

	public Sorting() {

	}

	protected Integer[] toArray(ArrayList<?> list) {
		Integer[] array = list.toArray(new Integer[list.size()]);
		// Double[] array = new Double[list.size()];
		// array = (Double[]) list.toArray(array);
		return array;

	}

	protected void print(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

//	protected void bubbleSort(Integer[] array) {
//		for (int k = 1; k < array.length; k++) {
//			for (int i = 0; i < array.length - k; i++) {
//				if (array[i] > array[i + 1]) {
//					int temp = array[i + 1];
//					array[i + 1] = array[i];
//					array[i] = temp;
//				}
//			}
//		}
//
//	}

	protected void improvedBubbleSort(Integer[] array) {
		int swapCounter = 0;
		int compareCounter = 0;
		boolean pass = true;
		for (int k = 1; k < array.length && pass; k++) {
			pass = false;
			for (int i = 0; i < array.length - k; i++) {
				compareCounter++;
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swapCounter++;
					pass = true;
				}
			}
		}
		System.out.println("Compare counter = " + compareCounter + "\nSwap Counter = " + swapCounter);
	}
}
