package lotto.domain;

public enum Prize {

    FIRST_PRIZE(6, 2000000000, "2,000,000,000원", false),
    SECOND_PRIZE(5, 30000000, "30,000,000원", true),
    THIRD_PRIZE(5, 1500000, "1,500,000원", false),
    FOURTH_PRIZE(4, 50000, "50,000원", false),
    FIFTH_PRIZE(3, 5000, "5,000원", false);

    private final int matchCount;
    private final int prize;
    private final String prizeString;
    private final boolean isSpecial;

    Prize(int matchCount, int prize, String prizeString, boolean isSpecial) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.prizeString = prizeString;
        this.isSpecial = isSpecial;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getPrizeString() {
        return prizeString;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public static Prize fromCalculateResult(int matchCount, boolean isSpecial) {
        for (Prize prize : Prize.values()) {
            if (prize.getMatchCount() == matchCount && prize.isSpecial() == isSpecial) {
                return prize;
            }
        }
        return null;
    }
}
