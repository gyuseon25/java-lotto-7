package lotto.exception;

public enum ErrorMessage {
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    INVALID_INPUT_NUMBER("[ERROR] 숫자만 입력 가능합니다."),
    DUPLICATE_NUMBER("중복된 번호가 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
