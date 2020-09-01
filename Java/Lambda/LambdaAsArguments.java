

interface StringFunc {
    public String convert(String in);
}


class StringExecuter {
    
    public static String execute(StringFunc in, String inputStr) {
        return in.convert(inputStr);
    }

}

public class LambdaAsArguments {
    public static void main (String[] args) {
        String a = StringExecuter.execute( str -> str.toUpperCase(), "Lawrance");
        System.out.println(a);
    }
}
