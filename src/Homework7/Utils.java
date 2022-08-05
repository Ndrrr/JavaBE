package Homework7;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class Utils {
    private static HttpURLConnection conn;
    private static String apiKey;
    private static Dotenv dotenv;
    static {
        dotenv = Dotenv.configure().load();
        apiKey = dotenv.get("NAME_GENERATOR_API_KEY");
    }

    //
    // If you don't have an API key or proper internet connection
    // You should use hard coded version
    //
    // You can use the following link for key
    // https://parser.name/api/generate-random-name/
    //
    public static String getRandomName(char gender, boolean hardCoded) {
        if(hardCoded){
            return getHardCodedRandomName(gender);
        }

        BufferedReader reader = null;
        StringBuilder responseContent = new StringBuilder();
        String line;
        try{
            URL url = new URL("https://api.parser.name/?api_key=" + apiKey + "&endpoint=generate&gender=" + gender + "\n");
            conn = (HttpURLConnection) url.openConnection();

            // Request setup
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            // Test if the response from the server is successful
            int status = conn.getResponseCode();

            if (status >= 300) {
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                throw new RuntimeException("Connection was unsuccessfull");
            }
            else{
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }

            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }


            //System.out.println(responseContent.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(reader!=null)
                reader.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            conn.disconnect();
        }

        return parseJsonToHumanName(responseContent.toString());
    }

    private static String parseJsonToHumanName(String responseBody) {
        JSONObject data = new JSONObject(responseBody);
        JSONObject humanName = data.getJSONArray("data").getJSONObject(0).getJSONObject("name");
        String firstName = humanName.getJSONObject("firstname").getString("name_ascii");
        return firstName.substring(0,1).toUpperCase() + firstName.substring(1);
    }

    private static String getHardCodedRandomName(char gender ) {
        String[][] names = new String[][]{
                {"Elizabeth", "Anna", "Lana", "Rebecca"},
                {"Elijah", "John", "Stephan", "Klaus"}};
        Random rand = new Random();
        return names[gender%2][Math.abs(rand.nextInt()%names.length)];
    }
}
