package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static final Parser INSTANCE = new Parser();

    public static Parser getInstance() {
        return INSTANCE;
    }

    private Parser() {
    }

    public List<Integer> parseWinningNumbers(String input) {
        String[] splits = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String split : splits) {
            numbers.add(Integer.parseInt(split));
        }
        return numbers;
    }
}
