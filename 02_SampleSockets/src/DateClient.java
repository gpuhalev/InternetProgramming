import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class DateClient {

	private static final String SERVER = "localhost";
	private final String request;

	public DateClient(String request) {
		 this.request = request;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter date: ");
		System.out.println("(yyyy-MM-dd format)");
		
		final InputStream input = System.in;
		final InputStreamReader inputStreamReader = new InputStreamReader(input);
		final BufferedReader reader = new BufferedReader(inputStreamReader);
		
		final String request = reader.readLine();
		
		final DateClient echoClient = new DateClient(request);
		final String response = echoClient.send();
		
		System.out.println("Response: " + response);
	}

	private String send() throws UnknownHostException, IOException {
		final Socket clientSocket = new Socket(SERVER, DateServer.SERVER_PORT);
		final InputStream inputStream = clientSocket .getInputStream();
		final OutputStream outputStream = clientSocket.getOutputStream();
		
		final InputStreamReader inputStreamReader =
			new InputStreamReader(inputStream);
		final BufferedReader in = new BufferedReader(inputStreamReader);
		
		final PrintWriter out = new PrintWriter(outputStream);
		
		out.println(request);
		out.flush();
		
		final String result = in.readLine();
		
		clientSocket.close();
		
		return result;
	}

}