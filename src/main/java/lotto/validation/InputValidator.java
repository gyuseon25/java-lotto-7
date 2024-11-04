package lotto.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;

public class InputValidator {

    private static final InputValidator INSTANCE = new InputValidator();

    public static InputValidator getInstance() {
        return INSTANCE;
    }

    private InputValidator() {
    }

    public int validateAmount(String input) {
        checkNumber(input);
        int amount = Integer.parseInt(input);

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }

        return (amount / 1000);
    }

    public void validateWinningNumbers(String input) {
        String[] splits = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String split : splits) {
            checkNumber(split);
            numbers.add(Integer.parseInt(split));
        }
        checkDuplicate(numbers);
        checkNumberBoundary(numbers);
    }

    public void validateBonusNumber(String input, List<Integer> numbers) {
        checkNumber(input);
        int bonus = Integer.parseInt(input);
        checkNumberBoundary(List.of(bonus));
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    public void checkNumber(String input) {
        if (!input.matches("[0-9]")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER.getMessage());
        }
    }

    private void checkDuplicate(List<Integer> input) {
        Set<Integer> set = new HashSet<Integer>(input);
        if (set.size() != input.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void checkNumberBoundary(List<Integer> input) {
        for (Integer i : input) {
            if (i < 1 || i > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_BOUNDARY.getMessage());
            }
        }
    }

}
