package Factory_Pattern;

public abstract class Knife {
    public void packaging() {
        System.out.println("Packaging...");  
    }

    public abstract void sharpening();
    public abstract void polishing();
}
