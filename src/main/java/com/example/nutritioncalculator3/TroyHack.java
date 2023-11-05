package Users.noahl.IdeaProjects.troyhack;
import java.util.Scanner;
import java.lang.String;

public class TroyHack {
    public static void main(String []args){
    bmi(180,72, 21, 1, "Low");
    }

    public static void bmi(float weight, float height, float age, float gender, String activitylvl)
    {
        String ActivityLevel = new String();
        float pweight, pheight, bmi, heightsquared, p_age, bmr;
        pweight = weight;
        pheight = height;
        p_age = age;
        ActivityLevel = activitylvl;

        Scanner scan = new Scanner(System.in);

        heightsquared = pheight * pheight;

        bmi = (pweight/heightsquared) * 703;

        System.out.printf("BMI is: " + "%,.2f", bmi);

        //1 is male 0 is female :)

        if (gender == 1 && ActivityLevel == "Low")
        {
            bmr = (float) ((float) (((10 * (pweight / 2.204)) + (6.25 * pheight * 2.54) - (5 * p_age) + 5)) * 1.1);
            System.out.printf("BMR is: " + "%,.2f", bmr);

        }
        else if (gender == 0 && ActivityLevel == "None")
        {
            bmr = (float) ((10 * (pweight / 2.204)) + (6.25 * pheight * 2.54) - (5 * p_age) + 5);
            System.out.printf("BMR is: " + "%,.2f", bmr);

        }
        else if (gender == 1 && ActivityLevel == "Med")
        {
            bmr = (float) ((float) (((10 * (pweight / 2.204)) + (6.25 * pheight * 2.54) - (5 * p_age) + 5)) * 1.4);
            System.out.printf("BMR is: " + "%,.2f", bmr);

        }
        else if (gender == 1 && ActivityLevel == "High")
        {
            bmr = (float) ((float) (((10 * (pweight / 2.204)) + (6.25 * pheight * 2.54) - (5 * p_age) + 5)) * 1.65);
            System.out.printf("BMR is: " + "%,.2f", bmr);

        }
        if (gender == 0 && ActivityLevel == "Low")
        {
            bmr = (float) ((float) (((10 * (pweight / 2.204)) + (6.25 * pheight * 2.54) - (5 * p_age) - 161)) * 1.1);
            System.out.printf("BMR is: " + "%,.2f", bmr);

        }
        else if (gender == 0 && ActivityLevel == "Med")
        {
            bmr = (float) ((float) (((10 * (pweight / 2.204)) + (6.25 * pheight * 2.54) - (5 * p_age) - 161)) * 1.4);
            System.out.printf("BMR is: " + "%,.2f", bmr);

        }
        else if (gender == 0 && ActivityLevel == "High")
        {
            bmr = (float) ((float) (((10 * (pweight / 2.204)) + (6.25 * pheight * 2.54) - (5 * p_age) - 161)) * 1.65);
            System.out.printf("BMR is: " + "%,.2f", bmr);

        }
        else if (gender == 0 && ActivityLevel == "None")
        {
            bmr = (float) ((10 * (pweight / 2.204)) + (6.25 * pheight * 2.54) - (5 * p_age) - 161);
            System.out.printf("BMR is: " + "%,.2f", bmr);

        }

    }
}
