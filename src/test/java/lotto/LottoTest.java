package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.validation.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @Test
    void 구입금액이_1000원_단위가_아니라면_예외가_발생한다() {
        InputValidator inputValidator = InputValidator.getInstance();
        assertThatThrownBy(() -> inputValidator.validateAmount("8100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_숫자가_아니라면_예외가_발생한다() {
        InputValidator inputValidator = InputValidator.getInstance();
        assertThatThrownBy(() -> inputValidator.validateAmount("test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_잘못된_값_입력시_예외가_발생한다() {
        InputValidator inputValidator = InputValidator.getInstance();
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1!2!3!4!5!6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_중복된_번호_입력시_예외가_발생한다() {
        InputValidator inputValidator = InputValidator.getInstance();
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_1부터_45외의_숫자를_입력시_예외가_발생한다() {
        InputValidator inputValidator = InputValidator.getInstance();
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,4,5,47"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호와_같은_보너스번호_입력시_예외가_발생한다() {
        InputValidator inputValidator = InputValidator.getInstance();
        assertThatThrownBy(() -> inputValidator.validateBonusNumber("3", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
