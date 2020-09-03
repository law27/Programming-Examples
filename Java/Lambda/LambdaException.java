import java.util.function.BiConsumer;

public class Main {
	public static void main(String[] args) {
		 int[] arr = { 1, 2, 3, 4};
		 int key = 0;
		 printIt(arr, key, wrapperLambda((i , k) -> System.out.println(i / k)));
	}
	
	public static void printIt(int[] arr,int key, BiConsumer<Integer, Integer> conusmer) {
		for(int i : arr) {
			conusmer.accept(i, key);
		}
	}
	
	public static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (i, k) -> {
			try {
				System.out.println(i / k);
			} catch(Exception ex) {
				System.out.println(ex.getLocalizedMessage());
			}
		};
	}
}
