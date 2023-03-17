package visualizer;

import models.Defect;

import java.util.List;

public class Visualizer {
    private List<Defect> defects;

    public Visualizer(List<Defect> defects) {
        this.defects = defects;
    }

    public void show() {
        // Visualize the defects using a chosen library (e.g. JFreeChart or Excel)
        // This could include filtering or sorting options
    }
}
