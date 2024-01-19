package kata3.main;

import kata3.calculator.MeanCalculator;
import kata3.calculator.WeightHistogramCalculator;
import kata3.histogram.Histogram;
import kata3.loader.TsvFilePersonLoader;
import kata3.person.Person;
import kata3.swing.MainFrame;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        List<Person> people = TsvFilePersonLoader.with("hw_25000.tsv").load();
        Map<String, Integer> histogram = new WeightHistogramCalculator(people).calculate();
        for(String key : histogram.keySet().stream().sorted().toList()) {
            System.out.println(key + " " + histogram.get(key));
        }

        double[] weigths = new double[people.size()];
        for(int i = 0; i < people.size(); i++) {
            weigths[i] = people.get(i).getWeight();
        }


        Histogram histogram1 = new Histogram("People", "Weight (lbs)", "Percentage", weigths, 20);

        MainFrame frame = new MainFrame();
        frame.getHistogramDisplay().show(histogram1);
        frame.setVisible(true);
    }

}