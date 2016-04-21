
package goeurotest;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class writes the data extracted in a CSV file
 *
 * @author Amara Ghoufa
 */
public class OutputWriter {

    private String csvOutPath;// the path of the output csv file

    /**
     *   Write a two-dimensional table of strings to a csv file.
     *   Path of this file is stored in the variable "csv_out_path"
     * 
     *   @param inputData input array of string
     */
    public void writeInCsv(String[][] inputData) {

        try {
            FileWriter writer = new FileWriter(this.csvOutPath);

            if (inputData != null) {
                int i = 0;
                while (i < inputData.length) {
                    writer.append(inputData[i][0]);
                    writer.append(',');
                    writer.append(inputData[i][1]);
                    writer.append(',');
                    writer.append(inputData[i][2]);
                    writer.append(',');
                    writer.append(inputData[i][3]);
                    writer.append(',');
                    writer.append(inputData[i][4]);
                    writer.append(',');
                    writer.append('\n');
                    i++;
                }
                writer.flush();
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCsvOutPath(String csvOutPath) {
        this.csvOutPath = csvOutPath;
    }

}
