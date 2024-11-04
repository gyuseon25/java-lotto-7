package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
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

    public List<Lotto> getLottoNumbers(int count) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoNumbers.add(generateLottoNumbers());
        }
        return lottoNumbers;
    }

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

    private Lotto generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private int checkBonus(int bonus) {
        if (this.numbers.contains(bonus)) {
            return 7;
        }
        return 5;
    }
}
