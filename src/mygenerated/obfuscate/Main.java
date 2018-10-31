package mygenerated.obfuscate;
import generator.Tree;
import java.util.*;
import java.io.*;
import java.text.ParseException;
public class Main {
	public static void main(String[] args) throws IOException, ParseException {
		String s = "";
		try {
			InputStream is = new ByteArrayInputStream(s.getBytes("UTF-8"));
			(new obfuscateParser()).parse(is);
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}