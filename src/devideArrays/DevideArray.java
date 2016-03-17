package devideArrays;

public class DevideArray {

	static void devideArray(int[] arr1, int[] arr2) {
		int[] arr3 = new int[Math.max(arr1.length, arr2.length)];
		for (int i = 0; i < arr3.length; ++i) {
			try {
				arr3[i] = arr1[i] / arr2[i];
				System.out.print(arr3[i] + ", ");
			} catch (ArrayIndexOutOfBoundsException exception) {
				arr3[i] = -1;
				System.out.print(arr3[i] + ", ");
			} catch (ArithmeticException exception) {
				arr3[i] = 0;
				System.out.print(arr3[i] + ", ");
			}

		}

	}

}
