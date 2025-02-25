import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.URI;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Scanner; 

class MainGET {
	public static void main(String[] args) {
	
			try
		{
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://api.opensensemap.org/boxes/5dbc164301d62a001a87f8ac"))
				.header("Content-Type", "application/json")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		//System.out.println(response.body());
		
Scanner sc = new Scanner(response.body());
String inline ="";
while(sc.hasNext())
{
inline+=sc.nextLine();
}
System.out.println(inline);
sc.close();

		JSONParser parse = new JSONParser();
		JSONObject jobj = (JSONObject)parse.parse(inline);
		//Store the JSON object in JSON array as objects (For level 1 array element i.e Results)
			JSONArray jsonarr_1 = (JSONArray) jobj.get("sensors");
			System.out.println("Elements under sensors array: " + jsonarr_1.size());
			//Get data for Results array
			for(int i=0;i<jsonarr_1.size();i++)
			{
								//Get the index of the JSON object and print the values as per the index
				JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
				//Store the JSON object in JSON array as objects (For level 2 array element i.e Address Components)
				JSONArray jsonarr_2 = (JSONArray) jsonobj_1.get("address_components");
				System.out.println("Elements under results array");
				System.out.println("\nPlace id: " +jsonobj_1.get("place_id"));
				System.out.println("Types: " +jsonobj_1.get("types"));
				//Get data for the Address Components array
				System.out.println("Elements under address_components array");
				System.out.println("The long names, short names and types are:");
				for(int j=0;j<jsonarr_2.size();j++)
				{
					//Same just store the JSON objects in an array
					//Get the index of the JSON objects and print the values as per the index
					JSONObject jsonobj_2 = (JSONObject) jsonarr_2.get(j);
					//Store the data as String objects
					String str_data1 = (String) jsonobj_2.get("long_name");
					System.out.println(str_data1);
					String str_data2 = (String) jsonobj_2.get("short_name");
					System.out.println(str_data2);
					System.out.println(jsonobj_2.get("types"));
					System.out.println("\n");
				
				}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
