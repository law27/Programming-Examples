import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
public class ByteArrayStream{

	public static void main(String[] args) {
		String value = "This is a Very Good Example";
		int a = 0;
		byte[] buf = new byte[value.length()];
        for(char i : value.toCharArray()) {
        	buf[a++] = (byte) i;
        }
		try(ByteArrayInputStream stream = new ByteArrayInputStream(buf)) {
			int printVal = stream.read();
			while(printVal != -1) {
				System.out.print((char) printVal);
				printVal = stream.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try(ByteArrayOutputStream stream = new ByteArrayOutputStream(); 
			OutputStream out = new FileOutputStream("./test.txt") ) {
			stream.write(buf);
			stream.writeTo(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}				