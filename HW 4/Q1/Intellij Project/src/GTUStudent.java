public class GTUStudent implements State{
    private State currentState;
    private State illness;
    private State needSleep;
    private State ready;
    private State axe;
    private State fit;
    private State graduate;


    public GTUStudent() {
        this.axe = new RodForAnAxe(this);
        this.fit = new Fit(this);
        this.graduate = new Graduate(this);
        this.illness = new ChronicIllness(this);
        this.needSleep = new NeedingSleep(this);
        this.ready = new Ready(this);
        this.currentState = this.ready;
    }

    /**
     * tüm geçişler için currentState in o geçişi temsil eden fonksiyonunu çağırırız.
     */
    @Override
    public void coffeeAndWork() {
        currentState.coffeeAndWork();
    }

    @Override
    public void sleep() {
        currentState.sleep();
    }

    @Override
    public void outTillLate() {
        currentState.outTillLate();
    }

    @Override
    public void buyingNewGpu() {
        currentState.buyingNewGpu();
    }

    @Override
    public void cheating() {
        currentState.cheating();
    }

    @Override
    public void exercise() {
        currentState.exercise();
    }

    @Override
    public void hardWork() {
        currentState.hardWork();
    }

    /**
     * State değişirken ekrana yapılan değişiklik yazılır.
     * @param state geçiş yapılacak state i belirtir.
     */
    public void setState(State state){
        this.currentState = state;
        if (state instanceof Ready)
            System.out.println("Current State ->  Ready");
        else if (state instanceof Fit)
            System.out.println("Current State ->  Fit");
        else if (state instanceof Graduate)
            System.out.println("Current State ->  Graduate");
        else if (state instanceof NeedingSleep)
            System.out.println("Current State ->  Needing Sleep");
        else if (state instanceof ChronicIllness)
            System.out.println("Current State ->  Chronic Illness");
        else if (state instanceof RodForAnAxe)
            System.out.println("Current State ->  Unable to become a rod for an axe");
        else
            System.out.println("Current State ->  Unknown State");
    }

    public State getIllness() {
        return illness;
    }

    public State getNeedSleep() {
        return needSleep;
    }

    public State getReady() {
        return ready;
    }

    public State getAxe() {
        return axe;
    }

    public State getFit() {
        return fit;
    }

    public State getGraduate() {
        return graduate;
    }
}
