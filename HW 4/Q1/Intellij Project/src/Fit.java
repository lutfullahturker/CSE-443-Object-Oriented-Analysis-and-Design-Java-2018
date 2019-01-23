public class Fit implements State {
    private GTUStudent student;

    public Fit(GTUStudent student) {
        this.student = student;
    }

    @Override
    public void coffeeAndWork() {
        System.out.println("Don't  drink a coffee after doing  sport.");
    }

    @Override
    public void sleep() {
        System.out.println("Don't  sleep after doing  sport.");
    }

    @Override
    public void outTillLate() {
        System.out.println("Unsupported State for Fit");
    }

    @Override
    public void buyingNewGpu() {
        System.out.println("Unsupported State for Fit");
    }

    @Override
    public void cheating() {
        System.out.println("Unsupported State for Fit");
    }

    @Override
    public void exercise() {
        System.out.println("You shouldn't do sport for a long time.");
    }

    @Override
    public void hardWork() {
        System.out.println("You have to work hard in GTU.");
        student.setState(student.getGraduate());
    }
}
