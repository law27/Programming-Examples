import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
public class PropertyLoading {
    public static void main(String[] args) {
        Properties prop = new Properties();

        try(Reader reader = Files.newBufferedReader(Paths.get("per.properties"))) {
            prop.load(reader);
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(prop.getProperty("Name"));
        System.out.println(prop.getProperty("Age"));
        System.out.println(prop.getProperty("School"));

    }
}

