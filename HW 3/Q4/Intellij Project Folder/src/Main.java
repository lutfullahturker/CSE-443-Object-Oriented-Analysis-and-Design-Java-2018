import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DiscreteTransformSolver solver =null;
        int choice =0;
        String filename = null;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.println("Press '1' for to use DFT\nPress '2' for to use DCT\nPress '-1' for exit from application");
                choice = sc.nextInt();
                if (choice == 1 || choice == 2) {
                    System.out.println("Please enter a filename to make DFT or DCT (test.txt)");
                    filename = sc.next();
                }
                switch (choice) {
                    case 1:
                        solver = new DFT(filename);
                        break;
                    case 2:
                        solver = new DCT(filename);
                        break;
                    case -1:
                        System.out.println("Thanks for using our app.");
                        continue;
                    default:
                        System.out.println("Wrong character was entered! Try Again.");
                        continue;
                }
                solver.solveTemplateMethod();
                System.out.println("\nOperation is finished and 'output.txt' file created. You are redirecting to main menu ...");
            } catch (InputMismatchException e){
                System.out.println("Wrong character was entered! Try Again.");
                sc.next();
            }
        } while (choice != -1);


    }
}
