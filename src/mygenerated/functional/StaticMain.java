package mygenerated.functional;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
public class StaticMain {
    public static void main(String[] args) throws IOException, ParseException {
        String s = "";
        try {
            InputStream is = new ByteArrayInputStream(s.getBytes("UTF-8"));
            (new functionalParser()).parse(is);
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}