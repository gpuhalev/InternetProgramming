import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Text {
	
	public static void main(String[] args) throws IOException {

		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int c = 0;
		while((c = buffer.read()) != -1) {
			char line = (char) c;
			String text = String.valueOf(line);
			System.out.print(text.toUpperCase());
		}

	}
}
