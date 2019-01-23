public class Graduate implements State {
    private GTUStudent student;

    public Graduate(GTUStudent student) {
        this.student = student;
    }

    @Override
    public void coffeeAndWork() {
        System.out.println("Congratulations ! You Graduated from University");
    }

    @Override
    public void sleep() {
        System.out.println("Congratulations ! You Graduated from University");
    }

    @Override
    public void outTillLate() {
        System.out.println("Congratulations ! You Graduated from University");
    }

    @Override
    public void buyingNewGpu() {
        System.out.println("Congratulations ! You Graduated from University");
    }

    @Override
    public void cheating() {
        System.out.println("Congratulations ! You Graduated from University");
    }

    @Override
    public void exercise() {
        System.out.println("Congratulations ! You Graduated from University");
    }

    @Override
    public void hardWork() {
        System.out.println("Congratulations ! You Graduated from University");
    }
}
