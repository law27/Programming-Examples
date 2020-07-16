import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


class InputStreamReaderEx  {
	public static void main(String[] args) {
		String fileName = "./in.txt";
		try (FileInputStream stream = new FileInputStream(fileName);
			InputStreamReader isr = new InputStreamReader(stream);
			BufferedReader br = new BufferedReader(isr)) {

			String line;

			while((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}