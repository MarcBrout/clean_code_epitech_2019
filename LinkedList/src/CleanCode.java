import java.util.logging.Level;
import java.util.logging.Logger;

public class CleanCode {
    private static Logger logger = Logger.getLogger(CleanCode.class.getName());

    static int main(int argc, String[] argv) {

        logger.log(Level.ALL, "Start of the LinkedList test!");

        logger.log(Level.ALL, "Instantiating...");
        LinkedList<String> words = new LinkedList<>();

        logger.log(Level.ALL, "Adding words...");
        words.add("a");
        words.push("is");
        words.add("Linked");
        words.push("This");
        words.add("List");

        logger.log(Level.ALL, "Accessing and Testing values");
        assert words.get(0).equals("This");
        assert words.get(1).equals("is");
        assert words.get(2).equals("a");
        assert words.get(3).equals("Linked");
        assert words.get(4).equals("List");

        return 0;
    }
}
