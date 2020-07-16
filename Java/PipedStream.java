import java.io.PipedInputStream;
import java.io.PipedOutputStream;


public class PipedStream {
	public static void main(String[] args) {
		String value = "This is a Very Good Example";
		byte[] buf = new byte[value.length()];
		int a = 0;
		for(char i : value.toCharArray()) {
			buf[a++] = (byte) i;
		}
		try(PipedInputStream in = new PipedInputStream();
		 PipedOutputStream out = new PipedOutputStream()) {
			in.connect(out);
			out.write(buf);
			int temp = in.read();
			while(temp != -1) {
				System.out.print((char) temp);
				temp = in.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}