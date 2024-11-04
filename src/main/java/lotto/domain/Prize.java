package lotto.domain;

public enum Prize {

    FIRST_PRIZE(6, 2000000000, "2,000,000,000원"),
    SECOND_PRIZE(7, 30000000, "30,000,000원"),
    THIRD_PRIZE(5, 1500000, "1,500,000원"),
    FOURTH_PRIZE(4, 50000, "50,000원"),
    FIFTH_PRIZE(3, 5000, "5,000원");

    private final int matchCount;
    private final int prize;
    private final String prizeString;

    Prize(int matchCount, int prize, String prizeString) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.prizeString = prizeString;
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

    public static Prize fromMatchCount(int count) {
        for (Prize prize : Prize.values()) {
            if (prize.getMatchCount() == count) {
                return prize;
            }
        }
        return null;
    }
}
