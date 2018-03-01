package generator;

import java.io.File;
import java.io.IOException;

/**
 * Created by mrfiskerton on 26.01.2018.
 */
public class Main {
    public static void main(String[] args) {
        String baseDir = "./src/";
        if (args.length < 1) {
            System.out.println("Please provide grammar name in format *.in");
            return;
        }

        String[] parts = args[0].split("[.]");
        File file = new File(baseDir + "generated/" + parts[0]);
        if (!file.getParentFile().mkdirs()) {
            System.out.println("Can't make dir.");
        }

        ParserGenerator parserGenerator = new ParserGenerator(file);
        try {
            parserGenerator.generate(new File(baseDir + "mygrammars/" + args[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
