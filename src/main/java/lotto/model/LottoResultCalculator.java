package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.CalculateResult;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.dto.CompareResult;

public class LottoResultCalculator {

    private static final LottoResultCalculator INSTANCE = new LottoResultCalculator();

    public static LottoResultCalculator getInstance() {
        return INSTANCE;
    }

    private LottoResultCalculator() {
        this.matchCounts = initializeMatchCounts();
    }

    private Map<String, Integer> initializeMatchCounts() {
        Map<String, Integer> result = new HashMap<>();
        result.put(CalculateResult.THREE_MATCH.getResult(), 0);
        result.put(CalculateResult.FOUR_MATCH.getResult(), 0);
        result.put(CalculateResult.FIVE_MATCH.getResult(), 0);
        result.put(CalculateResult.FIVE_MATCH_WITH_BONUS.getResult(), 0);
        result.put(CalculateResult.SIX_MATCH.getResult(), 0);
        return result;
    }

    private final Map<String, Integer> matchCounts;

    public Map<Prize, Integer> calculateResult(Lotto winningNumbers, List<Lotto> lottos, int bonus) {
        for (Lotto lotto : lottos) {
            CompareResult compareResult = winningNumbers.compareNumbers(lotto, bonus);
            String calculateResult = compareResult.getResult().getResult();
            if (calculateResult != null) {
                matchCounts.put(calculateResult, matchCounts.get(calculateResult) + 1);
            }
        }
        return mapping(matchCounts);
    }

    public double calculateROI(long input, Map<Prize, Integer> input2) {
        double sum = calculateSum(input2);
        double result = 0;
        result = ((sum - input) / input) * 100;
        return result;
    }

    private long calculateSum(Map<Prize, Integer> input) {
        long sum = 0;
        for (Prize key : input.keySet()) {
            sum += ((long) key.getPrize() * input.get(key));
        }
        return sum;
    }

    private Map<Prize, Integer> mapping(Map<String, Integer> input) {
        Map<Prize, Integer> result = new HashMap<>();
        for (String key : input.keySet()) {
            Prize prize = Prize.fromMatchCount(input.get(key));
            result.put(prize, input.get(key));
        }
        return result;
    }

}
