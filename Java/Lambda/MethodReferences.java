interface StringOp {
    public String exec(String in);
}

class Upper {
    public static String func(String in) {
        return in.toUpperCase();
    }
}

class Helper {
    public static String helper(StringOp op, String in) {
        return op.exec(in);
    }
}

public class MethodReferences {
    public static void main (String[] args) {
        String ans = Helper.helper(Upper::func, "lawrance");
        System.out.println(ans);
    }
}
