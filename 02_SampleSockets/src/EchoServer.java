import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EchoServer {

	public static final int SERVER_PORT = 44012;
	
	private class ClientHandler extends Thread {
		private final Socket clientSocket;
		
		public ClientHandler(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {
			try {
				handleClient(clientSocket);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private void handleClient(final Socket clientSocket) throws IOException, ParseException {
			//get I/O streams
			final InputStream inputStream = clientSocket.getInputStream();
			final OutputStream outputStream = clientSocket.getOutputStream();
			
			final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			final BufferedReader in = new BufferedReader(inputStreamReader);
			
			final PrintWriter out = new PrintWriter(outputStream);

			final String readLine = in.readLine();
			
			if(readLine.equals("END")){
				started = false;
			}else{
				Date formatedInput = dateParser(readLine);
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				out.println("The days between today and " + dateFormat.format(formatedInput) + " are " +getDaysBetween(formatedInput));
				out.flush();
			}
			clientSocket.close();
		}
		
	}
	
	private boolean started;

	public static void main(String[] args) throws IOException {
		new EchoServer().run();
	}
	
	public void run() throws IOException {
		started = true;
		final ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
		
		while (started) {
			final Socket clientSocket = serverSocket.accept();
			new ClientHandler(clientSocket).start();
		}
		serverSocket.close();
	}

	public Date dateParser(String inputDate) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateStr = formatter.parse(inputDate);
		return dateStr;
	}
	
	public int getDaysBetween(Date date2){
		Calendar cal1 = new GregorianCalendar();
	    Calendar cal2 = new GregorianCalendar();
		Date date1 = new Date();
		
		cal1.setTime(date1);
		cal2.setTime(date2);
		
		int toReturn = daysUses(cal1.getTime(),cal2.getTime());
		
		return toReturn;
	}

	private int daysUses(Date date1, Date date2) {
		return (int)( (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
	}
}