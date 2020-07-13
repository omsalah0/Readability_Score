package readability;

import java.text.DecimalFormat;

import static readability.Engine.*;

public class Coleman_Liau extends Automated_Readability_base implements readability {
    public static int age_Coleman;
    @Override
    public void printableFunc(int age) {
        System.out.println("Coleman–Liau index: " +score+" (about "+age+" year olds).");
    }

    @Override
    public void runnable() {
        CalculateScore();
        age_Coleman = DecisionMaker();
        printableFunc(age_Coleman);
    }

    @Override
    public void CalculateScore() {
        Double L = (double) characters / (double) words * 100;
        Double S = (double) sentences / (double) words * 100;
        score = 0.0588 * L - 0.296 * S - 15.8;
        score = Double.parseDouble(new DecimalFormat("##.##").format(score));

    }
}
