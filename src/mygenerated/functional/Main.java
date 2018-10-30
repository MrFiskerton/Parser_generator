package mygenerated.functional;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.text.ParseException;
public class Main {
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