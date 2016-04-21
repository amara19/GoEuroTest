
package goeurotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * This class reads the JSON string from the Api Endpoint
 *
 * @author Amara Ghoufa
 */
public class InputReader {

    /** 
     * API endpoint url
     */
    private String apiEndPoint;

    public void setApiEndPoint(String apiEndPoint) {
        this.apiEndPoint = apiEndPoint;
    }

    /**
     * Return a string containing the JSON data from the JSON API endpoint
     */
    public String getJsonData() {

        String input_data = "";
        try {
            InputStream is = new URL(apiEndPoint).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            String jsonText = sb.toString();
            input_data = jsonText;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return input_data;

    }
}
