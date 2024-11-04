package lotto.dto;

import lotto.domain.CalculateResult;

public class CompareResult {
    private CalculateResult result;

    public CompareResult(CalculateResult result) {
        this.result = result;
    }

    public CalculateResult getResult() {
        return result;
    }


}
