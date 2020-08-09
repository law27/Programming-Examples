import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;

public class makingLog {
    public static void main(String[] args) {
       LogManager lm = LogManager.getLogManager();
       Logger logger = lm.getLogger(Logger.GLOBAL_LOGGER_NAME);
       logger.log(Level.INFO, "My First Log info");
       logger.log(Level.INFO, "Another one");
    }
}
