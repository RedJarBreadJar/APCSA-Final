import java.util.Scanner;

public class MyClass
{
    public static void main(String[] args)
    {
        Scanner iput = new Scanner(System.in);
        System.out.println("Enter the seed: ");

        int seed = iput.nextInt();

        new Window(seed);
    }
}