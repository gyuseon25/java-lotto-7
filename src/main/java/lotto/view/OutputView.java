package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class OutputView {

    private final static OutputView INSTANCE = new OutputView();

    public static OutputView getInstance() {
        return INSTANCE;
    }

    private OutputView() {
    }

    public void printLottoLists(List<Lotto> lottoLists) {
        System.out.println(lottoLists.size()+"개를 구매했습니다.");
        for (Lotto lotto : lottoLists) {
            printLotto(lotto);
            System.out.println();
        }
        System.out.println();
    }

    public void printResults(Map<Prize, Integer> matchCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Prize p : matchCounts.keySet()) {
            int matchCount = p.getMatchCount();
            String prize = p.getPrizeString();
            int count = matchCounts.get(p);
            if(p == Prize.SECOND_PRIZE) {
                System.out.println(matchCount + "개 일치, 보너스 볼 일치 (" + prize + ") - " + count + "개");
                continue;
            }
            System.out.println(matchCount + "개 일치 (" + prize + ") - " + count + "개");
        }
    }

    public void printROI(String input) {
//        double result = Math.round(input * 100) / 100.0;
        System.out.println("총 수익률은 " + input + "%입니다.");
    }


    private void printLotto(Lotto lotto) {
        System.out.print("[");
        System.out.print(printNumbers(lotto.getNumbers()));
        System.out.print("]");
    }

    private String printNumbers(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
            if (i != numbers.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
