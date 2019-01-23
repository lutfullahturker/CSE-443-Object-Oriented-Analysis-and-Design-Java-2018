public class NeedingSleep implements State {
    private GTUStudent student;

    public NeedingSleep(GTUStudent student) {
        this.student = student;
    }

    @Override
    public void coffeeAndWork() {
        System.out.println("Don't drink much coffee.");
        student.setState(student.getIllness());
    }

    @Override
    public void sleep() {
        System.out.println("Wake up. Get ready for the day.");
        student.setState(student.getReady());
    }

    @Override
    public void outTillLate() {
        System.out.println("Firstly, Wake up and be Ready.");
    }

    @Override
    public void buyingNewGpu() {
        System.out.println("Firstly, Wake up and be Ready.");
    }

    @Override
    public void cheating() {
        System.out.println("Firstly, Wake up and be Ready.");
    }

    @Override
    public void exercise() {
        System.out.println("Firstly, Wake up and be Ready.");
    }

    @Override
    public void hardWork() {
        System.out.println("Firstly, Wake up and be Ready.");
    }
}
