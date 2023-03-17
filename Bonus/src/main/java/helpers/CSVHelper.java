package main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CSVHelper {
    private static final String[] CSV_HEADER = {"Type", "File", "Line Number", "Message"};

    public void writeToCSV(List<Defect> defects, String outputFile) throws IOException {
        File file = new File(outputFile);
        FileWriter output = new FileWriter(file);

        try (CSVPrinter printer = new CSVPrinter(output, CSVFormat.DEFAULT.withHeader(CSV_HEADER))) {
            for (Defect defect : defects) {
                printer.printRecord(defect.getType(), defect.getFilePath(), defect.getLineNumber(), defect.getMessage());
            }
        }
    }
}
