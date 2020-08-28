
interface MinMax<T extends Comparable<T>> {
    T min();
    T max();
}

class MyClass<T extends Comparable<T>> implements MinMax<T> {
    T[] arr;

    MyClass(T[] arr) {
        this.arr = arr;
    }

    public T min() {
        T ans = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(ans.compareTo(arr[i]) < 0) ans = arr[i];
        }
        return ans;
    }

    public T max() {
        T ans = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(ans.compareTo(arr[i]) > 0) ans = arr[i];
        }
        return ans;
    }
} 


public class GenericInterfaces {
    public static void main (String[] args) {
        Integer[] one = {1, 2, 3, 4, 5};
        String[] two = {"one", "two", "three"};
        MyClass<Integer> a = new MyClass<>(one);
        System.out.println(a.min());
        System.out.println(a.max());
        MyClass<String> b = new MyClass<>(two);
        System.out.println(b.min());
        System.out.println(b.max());
    }
}
