package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.CalculateResult;
import lotto.domain.Lotto;
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

    public Map<String, Integer> calculateResult(Lotto winningNumbers, List<Lotto> lottos, int bonus) {
        for (Lotto lotto : lottos) {
            CompareResult compareResult = winningNumbers.compareNumbers(winningNumbers, bonus);
            String calculateResult = compareResult.getResult().getResult();
            if (calculateResult != null) {
                matchCounts.put(calculateResult, matchCounts.get(calculateResult) + 1);
            }
        }
        return matchCounts;
    }

}
