package kata3.loader;

import kata3.person.Person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class TsvFilePersonLoader implements PersonLoader{

    private final File file;

    public TsvFilePersonLoader(File file) {
        this.file = file;
    }

    public static PersonLoader with(String file) {
        return new TsvFilePersonLoader(new File(file));
    }

    @Override
    public List<Person> load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            return reader.lines()
                    .skip(1)
                    .map(this::toPerson)
                    .collect(Collectors.toList());
        }catch (IOException e){
            return Collections.emptyList();
        }
    }

    private Person toPerson(String s) {
        String[] columns = s.split("\t");
        return new Person(
                parseInt(columns[0]),
                parseDouble(columns[1]),
                parseDouble(columns[2])
        );
    }
}
