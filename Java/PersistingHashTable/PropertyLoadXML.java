import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyLoadXML {
    public static void main(String[] args) {
        Properties prop = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("trial.xml"))) {
            prop.loadFromXML(in);
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(prop.getProperty("Name"));
        System.out.println(prop.getProperty("Age"));
        
    }
}
