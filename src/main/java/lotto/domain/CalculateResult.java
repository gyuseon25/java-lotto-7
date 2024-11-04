package lotto.domain;

public enum CalculateResult {
    THREE_MATCH("threeMatchCount", 3),
    FOUR_MATCH("fourMatchCount", 4),
    FIVE_MATCH("fiveMatchCount", 5),
    FIVE_MATCH_WITH_BONUS("fiveMatchCountWithBonus", 7),
    SIX_MATCH("sixMatchCount", 6);

    private final String result;
    private final int matchCount;

    CalculateResult(String result, int matchCount) {
        this.result = result;
        this.matchCount = matchCount;
    }

    public String getResult() {
        return result;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static CalculateResult fromMatchCount(int count) {
        for (CalculateResult result : CalculateResult.values()) {
            if (result.getMatchCount() == count) {
                return result;
            }
        }
        return null;
    }
}
