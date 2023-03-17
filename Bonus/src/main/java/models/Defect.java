package models;

public class Defect {
    private String filePath;
    private String rule;
    private String description;

    public Defect(String filePath, String rule, String description) {
        this.filePath = filePath;
        this.rule = rule;
        this.description = description;
    }

    // getters and setters
}
