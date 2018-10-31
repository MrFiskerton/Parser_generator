package mygenerated.obfuscate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class ObfuscateTestRun {
    public static void main(String[] args) throws IOException, ParseException {
        final String baseDir = "./src/";

        File file = new File(baseDir + "/mygenerated/obfuscate/tests.in");

        try {
            InputStream is = new FileInputStream(file);
            (new obfuscateParser()).parse(is);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}