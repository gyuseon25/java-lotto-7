package lotto.domain;

import java.util.List;
import lotto.dto.CompareResult;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public CompareResult compareNumbers(Lotto lotto, int bonus) {
        int matchCount = 0;
        for (int number : lotto.numbers) {
            if (this.numbers.contains(number)) {
                matchCount++;
            }
        }
        if (matchCount == 5) {
            checkBonus(bonus);
        }
        return new CompareResult(CalculateResult.fromMatchCount(matchCount));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    private int checkBonus(int bonus) {
        if (this.numbers.contains(bonus)) {
            return 7;
        }
        return 5;
    }
}
