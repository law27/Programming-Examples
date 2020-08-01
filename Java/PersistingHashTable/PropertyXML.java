import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;


public class PropertyXML {
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("Name", "Rubesh");
        prop.setProperty("Age", "100");
        try(OutputStream writer = Files.newOutputStream(Paths.get("trial.xml"))) {
            prop.storeToXML(writer, "My Comment");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
    }
}
