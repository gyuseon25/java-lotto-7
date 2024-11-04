package lotto.domain;

public enum Prize {

    FIRST_PRIZE(6, 2000000000),
    SECOND_PRIZE(5, 30000000),
    THIRD_PRIZE(5, 1500000),
    FOURTH_PRIZE(4, 50000),
    FIFTH_PRIZE(3, 5000);

    private final int matchCount;
    private final int prize;

    Prize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
