public class Ready implements State {
    /**
     * Gerekli durumlarda state de değişiklik yapabilmek için öğrenci objesini alır.
     */
    private GTUStudent student;

    public Ready(GTUStudent student) {
        this.student = student;
    }

    @Override
    public void coffeeAndWork() {
        System.out.println("You need to sleep before drink a coffe and work.");
    }

    @Override
    public void sleep() {
        System.out.println("You should not sleep at this time.");
    }

    @Override
    public void outTillLate() {
        System.out.println("You Need to sleep.");
        student.setState(student.getNeedSleep());
    }

    @Override
    public void buyingNewGpu() {
        System.out.println("Do not play games with the GTX 1080 for too long.");
        student.setState(student.getAxe());
    }

    @Override
    public void cheating() {
        System.out.println("Shameless Cheater !!");
        student.setState(student.getAxe());
    }

    @Override
    public void exercise() {
        System.out.println("Do sport regularly.");
        student.setState(student.getFit());
    }

    @Override
    public void hardWork() {
        System.out.println("You have to work hard in GTU.");
        student.setState(student.getGraduate());
    }
}
