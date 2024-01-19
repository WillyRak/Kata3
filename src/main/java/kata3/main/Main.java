package kata3.main;

import kata3.calculator.MeanCalculator;
import kata3.calculator.WeightHistogramCalculator;
import kata3.loader.TsvFilePersonLoader;
import kata3.person.Person;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        List<Person> people = TsvFilePersonLoader.with("hw_25000.tsv").load();
        Map<String, Integer> histogram = new WeightHistogramCalculator(people).calculate();
        for(String key : histogram.keySet().stream().sorted().toList()) {
            System.out.println(key + " " + histogram.get(key));
        }



    }

}