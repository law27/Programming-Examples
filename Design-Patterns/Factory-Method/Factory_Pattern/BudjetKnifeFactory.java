package Factory_Pattern;

public class BudjetKnifeFactory extends KnifeFactory {
    Knife knife;
    public Knife createKnife(String type) {
        if(type.equals("home")) {
            knife = new BudjetKnifeHomeUse();
        } else if(type.equals("hotel")) {
            knife = new BudjetKnifeHotelUse();
        } else {
            knife = null;
        }
        knife.sharpening();
        knife.polishing();
        knife.packaging();
        return knife;
    }
}
