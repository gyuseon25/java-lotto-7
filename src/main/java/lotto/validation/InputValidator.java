package lotto.validation;

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
        for (String split : splits) {
            checkNumber(split);
        }
    }

    public void checkNumber(String input) {
        if (!input.matches("[0-9]")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER.getMessage());
        }
    }
}
