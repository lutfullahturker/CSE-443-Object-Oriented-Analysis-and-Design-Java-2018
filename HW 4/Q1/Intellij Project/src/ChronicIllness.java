public class ChronicIllness implements State{
    private GTUStudent student;

    public ChronicIllness(GTUStudent student) {
        this.student = student;
    }

    @Override
    public void coffeeAndWork() {
        System.out.println("You are ill. I hope you'll get better soon.");
    }

    @Override
    public void sleep() {
        System.out.println("You are ill. I hope you'll get better soon.");
    }

    @Override
    public void outTillLate() {
        System.out.println("You are ill. I hope you'll get better soon.");
    }

    @Override
    public void buyingNewGpu() {
        System.out.println("You are ill. I hope you'll get better soon.");
    }

    @Override
    public void cheating() {
        System.out.println("You are ill. I hope you'll get better soon.");
    }

    @Override
    public void exercise() {
        System.out.println("You are ill. I hope you'll get better soon.");
    }

    @Override
    public void hardWork() {
        System.out.println("You are ill. I hope you'll get better soon.");
    }
}
