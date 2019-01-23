public class RodForAnAxe implements State{
    private GTUStudent student;

    public RodForAnAxe(GTUStudent student) {
        this.student = student;
    }


    @Override
    public void coffeeAndWork() {
        System.out.println("It is waste of time to messing with you.");
    }

    @Override
    public void sleep() {
        System.out.println("It is waste of time to messing with you.");
    }

    @Override
    public void outTillLate() {
        System.out.println("It is waste of time to messing with you.");
    }

    @Override
    public void buyingNewGpu() {
        System.out.println("It is waste of time to messing with you.");
    }

    @Override
    public void cheating() {
        System.out.println("It is waste of time to messing with you.");
    }

    @Override
    public void exercise() {
        System.out.println("It is waste of time to messing with you.");
    }

    @Override
    public void hardWork() {
        System.out.println("It is waste of time to messing with you.");
    }
}
