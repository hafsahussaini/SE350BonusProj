package main.java;

import models.Defect;
import org.eclipse.jgit.api.errors.GitAPIException;
import visualizer.Visualizer;

import java.io.IOException;
import java.util.List;


public class Main {
    public static <GitHelperException, StaticCodeAnalyzerException> void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java Main <git_repo_url> <csv_output_file>");
            System.exit(1);
        }

        String gitRepoUrl = args[0];
        String csvOutputFile = args[1];

        try {
            main.java.GitHelper gitHelper = new main.java.GitHelper();
            gitHelper.cloneRepository(gitRepoUrl);
            List<String> javaFiles = gitHelper.getJavaFiles();

            main.java.StaticCodeAnalyzer analyzer = new main.java.StaticCodeAnalyzer();
            List<Defect> defects = analyzer.analyze(javaFiles);

            main.java.CSVHelper csvHelper = new main.java.CSVHelper();
            csvHelper.writeToCSV(defects, csvOutputFile);

            Visualizer visualizer = new Visualizer(defects);
            visualizer.show();
        } catch (GitHelperException | StaticCodeAnalyzerException | IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (GitAPIException e) {
            throw new RuntimeException(e);
        }
    }
}
