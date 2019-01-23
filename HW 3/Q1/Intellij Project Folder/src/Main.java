public class Main {

    public static void main(String[] args) {
        ModernPayment modernPayment = new CreditCardModernPayment();
        TurboPayment turboPayment = new TurboJetPayment();
        TurboPaymentAdaptor turboPaymentAdaptor = new TurboPaymentAdaptor(turboPayment);

        System.out.println("Modern Payment --> \n");
        modernPayment.pay("4516123458754",(float)386.8,"dest","6");

        System.out.println("\nTurbo Payment Adaptor  --> \n");
        turboPaymentAdaptor.pay("4516123458754",(float)386.8,"dest","6");
    }
}
