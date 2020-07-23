package Factory_Pattern;

public class Main {
    public static void main(String[] args) {
       KnifeFactory factory = new BudjetKnifeFactory();
       Knife knife = factory.createKnife("home");
       knife = factory.createKnife("hotel"); 
    }
}
