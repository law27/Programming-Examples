import java.util.StringJoiner;

public class StringJoinerClass {
    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add("Lawrance");
        joiner.add("Karthick");
        joiner.add("Rubesh");
        System.out.println(joiner.toString());  
        
        //StringJoiner using Chaining
        StringJoiner joiner1 = new StringJoiner(", ");
        joiner1.add("Lawrance").add("Kailas").add("Gokul");
        System.out.println(joiner1.toString());  

        StringJoiner joiner2 = new StringJoiner("], [" , "[" , "]");
        joiner2.add("Lawrance").add("Rubesh").add("Karthick");
        System.out.println(joiner2.toString());  
    
        //StringJoiner with setEmptyValue
        StringJoiner joiner3 = new StringJoiner(": ");
        joiner3.setEmptyValue("EMPTY");
        System.out.println(joiner3.toString()); 
    }
}
