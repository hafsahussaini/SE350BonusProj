package main.java;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import com.example.codeanalyzer.Defect;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.utils.SourceRoot;

public class StaticCodeAnalyzer {
    public List<Defect> analyzer(List<String> javaFiles) {
        List<Defect> defects = new ArrayList<>();
        for (String javaFile : javaFiles) {
            String sourceCode = csvHelper.readFile(javaFile);
            List<String> lines = Arrays.asList(sourceCode.split("\n"));
            int lineNum = 1;
            for (String line : lines) {
                String trimmedLine = line.trim();
                if (trimmedLine.startsWith("//")) {
                    continue;
                }
                if (trimmedLine.contains("System.out.print") || trimmedLine.contains("System.err.print")) {
                    Defect defect = new Defect();
                    defect.setFileName(javaFile);
                    defect.setLineNum(lineNum);
                    defect.setDefectType(DefectType.PRINT_STATEMENT);
                    defects.add(defect);
                }
                if (trimmedLine.contains("Thread.sleep(")) {
                    Defect defect = new Defect();
                    defect.setFileName(javaFile);
                    defect.setLineNum(lineNum);
                    defect.setDefectType(DefectType.SLEEP_STATEMENT);
                    defects.add(defect);
                }
                if (trimmedLine.contains("new Random(")) {
                    Defect defect = new Defect();
                    defect.setFileName(javaFile);
                    defect.setLineNum(lineNum);
                    defect.setDefectType(DefectType.RANDOM_STATEMENT);
                    defects.add(defect);
                }
                lineNum++;
            }
        }
        return defects;
    }

}
