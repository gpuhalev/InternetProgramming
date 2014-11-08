import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
public class Homework {
 
  public static void main(String[] args) {
 
    try {
 
	String url = "http://www.twitter.com/";
 
	URL obj;
	HttpURLConnection conn = null;
	System.out.println("Request URL ... " + url);
	boolean redirect = true;
	int status;
	while(redirect){
		obj = new URL(url);
		conn = (HttpURLConnection) obj.openConnection();
		status = conn.getResponseCode();
		System.out.println("Response Code ... " + status);
		if (status != HttpURLConnection.HTTP_OK) {
			if (status == HttpURLConnection.HTTP_MOVED_TEMP
				|| status == HttpURLConnection.HTTP_MOVED_PERM
					|| status == HttpURLConnection.HTTP_SEE_OTHER)
			redirect = true;
			url = conn.getHeaderField("Location");
			System.out.println("Redirect to URL : " + url);
		}else{
			redirect = false;
		}
	}
	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	String inputLine;
	StringBuffer html = new StringBuffer();
 
	while ((inputLine = in.readLine()) != null) {
		html.append(inputLine);
	}
	in.close();
 
	System.out.println("URL Content... \n" + html.toString());
	System.out.println("Done");
 
    } catch (Exception e) {
    	e.printStackTrace();
    }
 
  }
 
}