public class TurboJetPayment implements TurboPayment {
    /**
     *
     * @param turboCardNo card no
     * @param turboAmount amount
     * @param destinationTurboOfCourse destination
     * @param installmentsButInTurbo installments
     * @return amount
     */
    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        System.out.println("Turbo Card No : "+turboCardNo);
        System.out.println("Turbo Amount : "+turboAmount);
        System.out.println("Destination : "+destinationTurboOfCourse);
        System.out.println("Installments Turbo : "+installmentsButInTurbo);
        return (int) turboAmount;
    }
}
