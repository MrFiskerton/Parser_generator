package mygenerated.functional;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class FunctionalTestRun {
    public static void main(String[] args) throws IOException, ParseException {
        final String baseDir = "./src/";

        File file = new File(baseDir + "/mygenerated/functional/tests.in");

        try {
            InputStream is = new FileInputStream(file);
            (new functionalParser()).parse(is);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}