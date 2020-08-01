import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.io.Reader;

public class Property {
    public static void main(String[] args) {
        Properties property = new Properties();
        property.setProperty("Name", "Lawrance");
        property.setProperty("Age", "18");
        try(Writer writer = Files.newBufferedWriter(Paths.get("trial.properties"))) {
            property.store(writer, "Nice Try");
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        try(Reader reader = Files.newBufferedReader(Paths.get("trial.properties"))) {
            Properties prop = new Properties();
            prop.load(reader);
            System.out.println(prop.getProperty("Name"));
            System.out.println(prop.getProperty("Age"));  
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
