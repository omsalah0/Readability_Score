package readability;

import java.text.DecimalFormat;

import static readability.Engine.*;

public class SMOG_index extends Automated_Readability_base implements readability {
    public static int age_SMOG;

    @Override
    public void printableFunc(int age) {
        System.out.println("Simple Measure of Gobbledygook: " + score + " (about " + age + " year olds).");
    }

    @Override
    public void runnable() {
        CalculateScore();
        age_SMOG = DecisionMaker();
        printableFunc(age_SMOG);

    }


    @Override
    public void CalculateScore() {
        double sqer = polysyllables * ((double) 30 / (double) sentences);
        score = 1.043 * Math.sqrt(sqer) + 3.1291;
        score = Double.parseDouble(new DecimalFormat("##.##").format(score));
    }
}
