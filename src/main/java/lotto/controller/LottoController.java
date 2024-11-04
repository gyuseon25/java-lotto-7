package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoResultCalculator;
import lotto.model.Parser;
import lotto.validation.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private InputValidator inputValidator;
    private Parser parser;
    private LottoNumberGenerator lottoNumberGenerator;
    private LottoResultCalculator lottoResultCalculator;

    private static final LottoController INSTANCE = new LottoController();

    public static LottoController getInstance() {
        return INSTANCE;
    }

    private LottoController() {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
        inputValidator = InputValidator.getInstance();
        parser = Parser.getInstance();
        lottoNumberGenerator = LottoNumberGenerator.getInstance();
        lottoResultCalculator = LottoResultCalculator.getInstance();
    }

    public void run() {
        String input1 = inputView.readAmount();
        int amount = inputValidator.validateAmount(input1);

        List<Lotto> lottoLists = lottoNumberGenerator.getLottoNumbers(amount);
        outputView.printLottoLists(lottoLists);

        String input2 = inputView.readWinningNumbers();
        inputValidator.validateWinningNumbers(input2);
        Lotto winningNumbers = parser.parseWinningNumbers(input2);
        System.out.println();

        String input3 = inputView.readBonusNumber();
        inputValidator.validateBonusNumber(input3, winningNumbers.getNumbers());
        int bonus = Integer.parseInt(input3.trim());
        System.out.println();

        Map<Prize, Integer> matchCount = lottoResultCalculator.calculateResult(winningNumbers, lottoLists,
                bonus);
        outputView.printResults(matchCount);

        String roi = lottoResultCalculator.calculateROI(Long.parseLong(input1), matchCount);
        outputView.printROI(roi);

    }
}
