import java.io.CharArrayReader;
import java.io.CharArrayWriter;



public class CharArrayReaderWriter {
	public static void main(String[] args) {
		String value = "This is a Good Example";
		try(CharArrayReader reader = new CharArrayReader(value.toCharArray())) {
			int a = reader.read();
			while(a != -1) {
				System.out.print((char) a);
				a = reader.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//Other Classes Unicode Streams are
/*
	1] StringReader -> StringWriter
	2] PipedReader -> PipedWriter
	3] InputStreamReader -> OutputStreamWriter
	4] FileReader -> FileWriter
*/