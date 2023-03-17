package models;

/*
    This Defect class will represent a single defect or
    error thats found in the code. It's pretty boring and
    just has fields getters and setters to break down the
    specific defect.
 */
public class Defect {
    private String filePath;
    private String rule;
    private String description;

    public Defect(String filePath, String rule, String description) {
        this.filePath = filePath;
        this.rule = rule;
        this.description = description;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
