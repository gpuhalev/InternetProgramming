import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class Streams {
	private final static String END_MARKER = "END";
	
	public static void main(String[] args) throws IOException {
		//InputStreamEx();
		//bufferReaderEx();
		countSybmol();
	}
	
	private static void countSybmol()throws IOException {
		final String line = getLine();
		//final int countS = CountS(line, 'a');
		final int countA = CountAll(line);
		System.out.println(countA);
	}

	private static int CountAll(String line) {
		int result=0;
		for(int i = 0; i < line.length(); i++){
			final char next = line.charAt(i);
			result++;
		}
		return result;
	}

	private static int CountS(String line, char c) {
		int result=0;
		for(int i = 0; i < line.length(); i++){
			final char next = line.charAt(i);
			if (next==c){
				result++;
			}
		}
		return result;
	}

	private static String getLine() throws IOException {
		final InputStream input = System.in;
		final InputStreamReader inputStreamReader = new InputStreamReader(input);
		final BufferedReader reader = new BufferedReader(inputStreamReader);
		
		final String wholeLine = reader.readLine();
		return wholeLine;
	}

	private static void bufferReaderEx() throws IOException {
		final InputStream input = System.in;
		final InputStreamReader inputStreamReader = new InputStreamReader(input);
		final BufferedReader reader = new BufferedReader(inputStreamReader);
		
		final String wholeLine = reader.readLine();
		System.out.println(wholeLine);
		
		int count = 0;
		while(!reader.readLine().equals(END_MARKER)){
			count++;
		}
		System.out.println(count);
		
	}

	public static void InputStreamEx() throws IOException{
		InputStream input = System.in;
		
		final int b = input.read();
		System.out.println(Character.toString((char) b) + " has ASCII " + b);
		
		final byte a[] = new byte[3];
		input.read(a);
		System.out.println(new String(a));
	}
}
