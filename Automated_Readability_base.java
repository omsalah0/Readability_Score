package readability;

import java.text.DecimalFormat;

import static readability.Engine.*;

public class Automated_Readability_base implements readability {
    public static int age_ARI;

    @Override
    public void printableFunc(int age) {
        System.out.println("Automated Readability Index: " + score + " (about " + age + " year olds).");
    }

    @Override
    public void runnable() {
        CalculateScore();
        age_ARI = DecisionMaker();
        printableFunc(age_ARI);
    }


    public int DecisionMaker() {
        int value = (int) Math.round(score);
        int age;
        switch (value) {
            case 1:
                age = 6;
                break;
            case 2:
                age = 7;
                break;
            case 3:
                age = 9;
                break;
            case 4:
                age = 10;
                break;
            case 5:
                age = 11;
                break;
            case 6:
                age = 12;
                break;
            case 7:
                age = 13;
                break;
            case 8:
                age = 14;
                break;
            case 9:
                age = 15;
                break;
            case 10:
                age = 16;
                break;
            case 11:
                age = 17;
                break;
            case 12:
                age = 18;
                break;
            case 13:
                age = 24;
                break;
            case 14:
                age = 25;
                break;
            default:
                System.out.println("Something Error");
                return 0;
        }
        return age;
    }

    @Override
    public void CalculateScore() {

        score = 4.71 * ((double) characters / (double) words) + 0.5 * ((double) words / (double) sentences) - 21.43;
        score = Double.parseDouble(new DecimalFormat("##.##").format(score));
    }

}