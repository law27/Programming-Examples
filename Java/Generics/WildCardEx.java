class TwoD {
    int x;
    int y;

    TwoD(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ThreeD extends TwoD{
    int z;

    ThreeD(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}

class FourD extends ThreeD {
    int a;

    FourD(int x, int y, int z, int a) {
        super(x, y, z);
        this.a = a;
    }
}

class Coords<T extends TwoD> {
    T[] arr;

    Coords(T[] o) {
        arr = o;
    }
}

class BoundedWildCard {
    public static void printXY(Coords<? extends TwoD> obj) {
        System.out.println("Two Dimensional");
        for(int i = 0; i < obj.arr.length; i++) {
            System.out.println(obj.arr[i].x + " " + obj.arr[i].y);
        }
    } 

    public static void printXYZ(Coords<? extends ThreeD> obj) {
        System.out.println("Three Dimensional");
        for(int i = 0; i < obj.arr.length; i++) {
            System.out.println(obj.arr[i].x + " " + obj.arr[i].y +
                   " " + obj.arr[i].z);
        }
    } 

    public static void printXYZA(Coords<? extends FourD> obj) {
        System.out.println("Four Dimensional");
        for(int i = 0; i < obj.arr.length; i++) {
            System.out.println(obj.arr[i].x + " " + obj.arr[i].y +
                   " " + obj.arr[i].z + " " + obj.arr[i].a);
        }
    } 

    
}

public class WildCardEx {
    public static void main (String[] args) {
        Coords<TwoD> one = new Coords<>(new TwoD[]{new TwoD(1,0), new TwoD(2,4)});
        BoundedWildCard.printXY(one);
        Coords<ThreeD> two = new Coords<>(new ThreeD[]{new ThreeD(1,0,1), new ThreeD(2,1,4)});
        BoundedWildCard.printXYZ(two);
        Coords<FourD> three = new Coords<>(new FourD[]{new FourD(1,0,2,1), new FourD(2,3,1,4)});
        BoundedWildCard.printXYZA(three);
    }
}
