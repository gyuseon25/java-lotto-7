package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void duplicate(List<Integer> numbers) {
        Set<Integer> duplicates = new HashSet<>(numbers);
        if (numbers.size() != duplicates.size()) {
            throw new IllegalArgumentException("[ERROR] 로또에 중복된 숫자는 들어갈 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현
    public CalculateResult compareNumbers(Lotto lotto, int bonus) {
        int matchCount = 0;
        boolean isSpecial = false;
        for (int number : lotto.numbers) {
            if (this.numbers.contains(number)) {
                matchCount++;
            }
        }
        if (matchCount == 5) {
            isSpecial = lotto.checkBonus(bonus);
        }
        if (matchCount < 3) {
            return CalculateResult.getCalculateResult(0, false);
        }
        return CalculateResult.getCalculateResult(matchCount, isSpecial);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    private boolean checkBonus(int bonus) {
        return this.numbers.contains(bonus);
    }
}
