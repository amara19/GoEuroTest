
package goeurotest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *  This class extracts the desired data fields from the JSON input file
 *  
 * @author Amara Ghoufa
 */
public class ProcessData {

    /**
     * Extract the desired data: _id, name, type, latitude and
     *  longitude of each JSON object and put them into a two-dimensional table
     *
     * @param inputData JSON String
     */
    public String[][] convertJsonDataToTable(String inputData) {

        //output table containing desired data
        String[][] outputData = null; 

        if (inputData.equals("")==false){
        JSONParser jsonParser = new JSONParser();

        JSONArray array = null;

        try {
            array = (JSONArray) jsonParser.parse(inputData);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        outputData = new String[array.size()][5];

        int i = 0;
        while (i < array.size()) {
            JSONObject obji = (JSONObject) array.get(i);
            outputData[i][0] = obji.get("_id").toString();
            outputData[i][1] = obji.get("name").toString();
            outputData[i][2] = obji.get("type").toString();
            JSONObject geoi = (JSONObject) obji.get("geo_position");
            outputData[i][3] = geoi.get("latitude").toString();
            outputData[i][4] = geoi.get("longitude").toString();
            i++;
        }
        }
        return outputData;

    }
}
