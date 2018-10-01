package generator;

import java.io.File;
import java.io.IOException;

/**
 * Created by mrfiskerton on 26.01.2018.
 */
public class Main {
    public static void main(String[] args) {
        final String baseDir = "./src/";
        if (args.length < 1) {
            System.out.println("Please provide grammar name in format *.in");
            return;
        }

        String[] parts = args[0].split("[.]");
        File file = new File(baseDir + "mygenerated/" + parts[0]);
        if (!file.getParentFile().exists()) {
            if (file.getParentFile().mkdirs()) {
                System.out.println("Directory " + file.getParentFile() + " is created.");
            } else {
                System.out.println("Failed to create directory! " + file.getParentFile());
            }
        }

        ParserGenerator parserGenerator = new ParserGenerator(file);
        try {
            parserGenerator.generate(new File(baseDir + "mygrammars/" + args[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
