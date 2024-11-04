package lotto.domain;

public enum CalculateResult {
    THREE_UNDER_MATCH(0, false),
    THREE_MATCH(3, false),
    FOUR_MATCH(4, false),
    FIVE_MATCH(5, false),
    FIVE_MATCH_WITH_BONUS(5, true),
    SIX_MATCH(6, false);

    private final int matchCount;
    private final boolean isSpecial;

    CalculateResult(int matchCount, boolean special) {
        this.matchCount = matchCount;
        this.isSpecial = special;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public static CalculateResult getCalculateResult(int matchCount, boolean isSpecial) {
        for (CalculateResult result : CalculateResult.values()) {
            if (result.getMatchCount() == matchCount && result.isSpecial() == isSpecial) {
                return result;
            }
        }
        return null;
    }
}
