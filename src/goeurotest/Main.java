package goeurotest;

/**
 * This is the main class. It contains the main(String[] args) method.
 *
 * @author Amara Ghoufa
 */
public class Main {

    /**
     * This is the main(String[] args) method.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String apiEndPoint = args[0];

        InputReader inputReader = new InputReader();
        ProcessData processData = new ProcessData();
        OutputWriter outputWriter = new OutputWriter();

        //set api end point url
        inputReader.setApiEndPoint(apiEndPoint);
        //get json data
        String jsonData = inputReader.getJsonData();

        //process input json data: extract desired fields
        String[][] processedData = processData.convertJsonDataToTable(jsonData);

        //set output file
        outputWriter.setCsvOutPath("C:\\csv_out.csv");
        //write extracted data in the csv file
        outputWriter.writeInCsv(processedData);

    }
}
