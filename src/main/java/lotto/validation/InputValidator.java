package lotto.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;
import lotto.view.InputView;

public class InputValidator {

    private static final InputValidator INSTANCE = new InputValidator();
    private final InputView inputView;


    public static InputValidator getInstance() {
        return INSTANCE;
    }

    private InputValidator() {
        inputView = InputView.getInstance();
    }

    public int validateAmount(String input) {

        if (!checkAmount(input)) {
            inputView.readAmount();
        }

        int amount = Integer.parseInt(input);

        if (amount % 1000 != 0) {
//            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
            System.out.println(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
            inputView.readAmount();
        }

        return (amount / 1000);
    }

    public void validateWinningNumbers(String input) {
        String[] splits = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String split : splits) {
            if (!checkNumber(split)) {
                inputView.readWinningNumbers();
            }
            numbers.add(Integer.parseInt(split));
        }
        if (!checkDuplicate(numbers)) {
            inputView.readWinningNumbers();
        }
        ;
        if (!checkNumberBoundary(numbers)) {
            inputView.readWinningNumbers();
        }
    }

    public void validateBonusNumber(String input, List<Integer> numbers) {
        if (!checkNumber(input)) {
            inputView.readBonusNumber();
        }
        ;
        int bonus = Integer.parseInt(input);
        if (!checkNumberBoundary(List.of(bonus))) {
            inputView.readBonusNumber();
        }
        ;
        if (numbers.contains(bonus)) {
//            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
            System.out.println(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
            inputView.readBonusNumber();
        }
    }


    public boolean checkNumber(String input) {
        if (!input.matches("[0-9]")) {
//            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER.getMessage());
            System.out.println(ErrorMessage.INVALID_INPUT_NUMBER.getMessage());
            return false;
        }
        return true;
    }

    private boolean checkAmount(String input) {
        try {
//            if (input.isEmpty()) {
//                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER.getMessage());
//            }
            int a = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER.getMessage());
            System.out.println(ErrorMessage.INVALID_INPUT_NUMBER.getMessage());
            return false;
        }
    }

    private boolean checkDuplicate(List<Integer> input) {
        Set<Integer> set = new HashSet<Integer>(input);
        if (set.size() != input.size()) {
//            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            System.out.println(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            return false;
        }
        return true;
    }

    private boolean checkNumberBoundary(List<Integer> input) {
        for (Integer i : input) {
            if (i < 1 || i > 45) {
//                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_BOUNDARY.getMessage());
                System.out.println(ErrorMessage.INVALID_NUMBER_BOUNDARY.getMessage());
                return false;
            }
        }
        return true;
    }

}
