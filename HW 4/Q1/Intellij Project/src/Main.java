public class Main {

    public static void main(String[] args) {
        GTUStudent student = new GTUStudent();

        System.out.println("TEST -> \n\tReady -> Out Till Late -> Sleep -> Exercise -> Hard Work -> GRADUATE");
        System.out.println("A Clever GTU Student ->\n");
        student.outTillLate();
        student.sleep();
        student.exercise();
        student.hardWork();

        System.out.println("\nTEST 2 -> \n\tReady -> Hard Work -> GRADUATE");
        System.out.println("Another Clever GTU Student ->\n");
        student = new GTUStudent();
        student.hardWork();

        System.out.println("\nTEST 3 -> \n\tReady -> Buying a GTX 1080 -> Unable to become a rod for an axe");
        System.out.println("A Lazy GTU Student ->\n");
        student = new GTUStudent();
        student.buyingNewGpu();

        System.out.println("\nTEST 4 -> \n\tReady -> Cheating -> Unable to become a rod for an axe");
        System.out.println("Another Lazy GTU Student ->\n");
        student = new GTUStudent();
        student.cheating();

        System.out.println("\nTEST 5 -> \n\tReady -> Out Till Late -> Coffee & Work -> CHRONIC ILLNESS");
        System.out.println("An Ill GTU Student ->\n");
        student = new GTUStudent();
        student.outTillLate();
        student.coffeeAndWork();

    }
}
