package readability;

import java.text.DecimalFormat;

import static readability.Engine.*;

public class FleschKincaid extends Automated_Readability_base implements readability {

    public static int age_FK;

    @Override
    public void printableFunc(int age) {
        System.out.println("Flesch–Kincaid readability tests: " + score + " (about " + age + " year olds).");
    }

    @Override
    public void runnable() {
        CalculateScore();
        age_FK = DecisionMaker();
        printableFunc(age_FK);
    }


    @Override
    public void CalculateScore() {
        score = 0.39 * ((double) words / (double) sentences) + 11.8 * ((double) syllables / (double) words) - 15.59;
        score = Double.parseDouble(new DecimalFormat("##.##").format(score));
    }
}
