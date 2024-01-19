package kata3.swing;

import kata3.histogram.HistogramDisplay;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private HistogramDisplay histogramDisplay;

    public MainFrame() {
        setTitle("Histogram");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        add(createHistogramDisplay());
    }

    private Component createHistogramDisplay() {
        PanelHistogramDisplay display = new PanelHistogramDisplay();
        histogramDisplay = display;
        return display;
    }

    public HistogramDisplay getHistogramDisplay() {
        return histogramDisplay;
    }
}
