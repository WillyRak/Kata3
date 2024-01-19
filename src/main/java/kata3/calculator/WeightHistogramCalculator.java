package kata3.calculator;

import kata3.person.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightHistogramCalculator implements HistogramCalculator{

    private final List<Person> people;
    private static final int BIN_SIZE = 20;

    public WeightHistogramCalculator (List<Person> people) {
        this.people = people;
    }

    @Override
    public Map<String, Integer> calculate() {

        Map<String, Integer> result = new HashMap<>();
        for(Person person : people) {
            String key = toBin(person.getWeight());
            result.put(key, result.getOrDefault(key, 0) + 1);
        }
        return result;
    }

    private String toBin(double weight) {
        return low(weight) + "-" + high(weight);
    }

    private int low(double weight) {
        return (int) (weight / BIN_SIZE) * BIN_SIZE;
    }

    private int high(double weight) {
        return low(weight) + BIN_SIZE;
    }
}
