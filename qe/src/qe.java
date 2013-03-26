import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


public class qe {
	public static void main(String args[]) {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://words.bighugelabs.com/api/2/e5a7c737c76fe034ae104afb2b601141/English/");
		HttpResponse response = null;
		try {
			response = client.execute(request);
		} catch (ClientProtocolException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		// Get the response
		BufferedReader rd = null;
		try {
			rd = new BufferedReader
					(new InputStreamReader(response.getEntity().getContent()));
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String line = "";
		try {
			while ((line = rd.readLine()) != null) {
				//String mult[] = line.split("|");
				System.out.println(line.substring(line.lastIndexOf('|') + 1));
				System.out.println(line+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}
