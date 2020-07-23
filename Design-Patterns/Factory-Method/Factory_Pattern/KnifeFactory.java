package Factory_Pattern;

public abstract class KnifeFactory {
    public boolean IsAvailable() {
        return true;
    }
    
    public abstract Knife createKnife(String type);
}
