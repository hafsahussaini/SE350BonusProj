package main;

/*
    References:
        https://www.sachinsf.com/how-to-use-pmd-code-analyzer-with-intellij/
        https://sourceforge.net/projects/jfreechart/
 */

public class Main {

    // Using the GitHelper class to clone the Git repository to a local directory
    String remoteRepoUrl = "https://github.com/hafsahussaini/JavaHelloWorld.git";
    String localRepoPath = "/path/to/local/repo";
//    GitHelper.cloneRepository(remoteRepoUrl, localRepoPath);

    // Performing the static code analysis on the source code using the StaticCodeAnalyzer
    String sourceCodePath = "/path/to/local/repo/src";
//    List<Defect> defects = StaticCodeAnalyzer.analyzeCode(sourceCodePath);

    // Storing results in a CSV file
    String outputCsvPath = "/path/to/output.csv";
//    CSVHelper.writeDefectsToCSV(outputCsvPath, defects);

    // Visualizing analysis results using the JFreeChart library
    String inputCsvPath = "/path/to/output.csv";
//    JFreeChart chart = Visualizer.createBarChart(inputCsvPath);


}