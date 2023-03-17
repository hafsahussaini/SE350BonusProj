package helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CSVHelper {
    // Defect objects include invalid code defects like type, file path, line number, and message
    private static final String[] CSV_HEADER = {"Type", "File", "Line Number", "Message"};

    // Writing a list of Defect objects to a CSV file
    // using the Apache Commons CSV library to write the data to the CSV file
    public void writeToCSV(List<Defect> defects, String outputFile) throws IOException {
        File file = new File(outputFile);
        FileWriter output = new FileWriter(file);
        // Catching errors in the file writing process
        try (CSVPrinter printer = new CSVPrinter(output, CSVFormat.DEFAULT.withHeader(CSV_HEADER))) {
            for (Defect defect : defects) {
                printer.printRecord(defect.getType(), defect.getFilePath(), defect.getLineNumber(), defect.getMessage());
            }
        }
    }
}
