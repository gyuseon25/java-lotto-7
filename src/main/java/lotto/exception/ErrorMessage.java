package lotto.exception;

public enum ErrorMessage {
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    INVALID_INPUT_NUMBER("[ERROR] 숫자만 입력 가능합니다."),
    DUPLICATE_NUMBER("[ERROR] 중복된 번호가 있습니다."),
    INVALID_NUMBER_BOUNDARY("[ERROR] 1부터 45까지의 숫자만 입력 가능합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 당첨 번호와 중복되는 유효하지 않은 보너스 번호입니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
