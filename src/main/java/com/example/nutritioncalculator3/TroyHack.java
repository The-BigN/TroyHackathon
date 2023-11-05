package Users.noahl.IdeaProjects.troyhack;
import java.util.Scanner;

public class TroyHack {
    public static void main(String[] args)
    {
        float weight, height, bmi, heightsquared;
        Scanner scan = new Scanner(System.in);
        System.out.println("Input Height: ");
        height = scan.nextInt();
        System.out.println("Input Weight: ");
        weight = scan.nextInt();

        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);

        heightsquared = height * height;

        System.out.println("Height squared: " + heightsquared);

        bmi = (weight/heightsquared) * 703;

        System.out.printf("BMI is: " + "%,.2f", bmi);

    }
}
