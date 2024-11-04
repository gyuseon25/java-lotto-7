package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class LottoNumberGenerator {
    private static final LottoNumberGenerator INSTANCE = new LottoNumberGenerator();

    public static LottoNumberGenerator getInstance() {
        return INSTANCE;
    }

    private LottoNumberGenerator() {
    }

    public List<Lotto> getLottoNumbers(int count) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoNumbers.add(generateLottoNumbers());
        }
        return lottoNumbers;
    }

    private Lotto generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
