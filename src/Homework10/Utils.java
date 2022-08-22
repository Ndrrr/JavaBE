package Homework10;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Utils {
    private static HttpURLConnection conn;
    private static String apiKey;
    private static Dotenv dotenv;
    static {
        dotenv = Dotenv.configure().load();
        apiKey = dotenv.get("NAME_GENERATOR_API_KEY");
    }
    // If you don't have an API key or proper internet connection
    // You should use hard coded version
    public static String getRandomName(char gender, boolean hardCoded) {
        if(hardCoded){
            return getHardCodedRandomName(gender);
        }

        BufferedReader reader;
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
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            else {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
        return names[gender%2][(int)(Math.random()*100)%names.length];
    }
}
