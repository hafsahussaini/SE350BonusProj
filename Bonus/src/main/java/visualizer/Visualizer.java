package visualizer;

import models.Defect;

import java.util.List;

// Here I was going to visualize the defects found by the static code analyzer...
public class Visualizer {
    private List<Defect> defects;

    public Visualizer(List<Defect> defects) {
        this.defects = defects;
    }

    public void show() {
        // ...using the JFreeChart library
    }
}
