package lotto.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.CalculateResult;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class LottoResultCalculator {

    private static final LottoResultCalculator INSTANCE = new LottoResultCalculator();

    public static LottoResultCalculator getInstance() {
        return INSTANCE;
    }

    private LottoResultCalculator() {
        this.matchCounts = initializeMatchCounts();
    }

    private Map<CalculateResult, Integer> initializeMatchCounts() {
        Map<CalculateResult, Integer> result = new LinkedHashMap<>();
        result.put(CalculateResult.THREE_UNDER_MATCH, 0);
        result.put(CalculateResult.THREE_MATCH, 0);
        result.put(CalculateResult.FOUR_MATCH, 0);
        result.put(CalculateResult.FIVE_MATCH, 0);
        result.put(CalculateResult.FIVE_MATCH_WITH_BONUS, 0);
        result.put(CalculateResult.SIX_MATCH, 0);
        return result;
    }

    private final Map<CalculateResult, Integer> matchCounts;

    public Map<Prize, Integer> calculateResult(Lotto winningNumbers, List<Lotto> lottos, int bonus) {
        for (Lotto lotto : lottos) {
            CalculateResult calculateResult = winningNumbers.compareNumbers(lotto, bonus);
            matchCounts.replace(calculateResult, matchCounts.get(calculateResult) + 1);
        }

        return mapping(matchCounts);
    }

    public String calculateROI(long input, Map<Prize, Integer> input2) {
        double sum = calculateSum(input2);
        if (sum == 0) {
            return "0.0";
        }
        double result = 0;
        result = sum / input * 100;
        return String.format("%.1f",result);
    }

    private long calculateSum(Map<Prize, Integer> input) {
        long sum = 0;
        for (Prize key : input.keySet()) {
            sum += (key.getPrize() * input.get(key));
        }
        return sum;
    }

    private Map<Prize, Integer> mapping(Map<CalculateResult, Integer> input) {
        Map<Prize, Integer> result = new LinkedHashMap<>();
        for (CalculateResult key : input.keySet()) {
            if (key == CalculateResult.THREE_UNDER_MATCH) {
                continue;
            }
            Prize prize = Prize.fromCalculateResult(key.getMatchCount(), key.isSpecial());
            result.put(prize, input.get(key));
        }
        return result;
    }

}
