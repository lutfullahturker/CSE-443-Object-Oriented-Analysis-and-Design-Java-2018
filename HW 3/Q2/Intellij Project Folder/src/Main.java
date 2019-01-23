public class Main {

    public static void main(String[] args) {
        EMail addressBook = new GroupEMail("gtu@gtu.edu.tr","All GTU Members");

        EMail CSE = new GroupEMail("gtuCse@gtu.edu.tr","GTU CSE Mail Group");
        EMail EL = new GroupEMail("gtuEl@gtu.edu.tr","GTU EL Mail Group");

        CSE.addEmail(new PersonalEMail("eaptoula@gtu.edu.tr","Erchan Aptoula"));
        CSE.addEmail(new PersonalEMail("malidede@gtu.edu.tr","Muhammed Ali Dede"));
        CSE.addEmail(new PersonalEMail("akgul@gtu.edu.tr","Yusuf Sinan Akgul"));

        EMail fourthGrade = new GroupEMail("cseFourthGrade@gtu.edu.tr","GTU CSE 4. Grade Students");
        fourthGrade.addEmail(new PersonalEMail("lturker@gtu.edu.tr","Lutfullah Turker"));
        fourthGrade.addEmail(new PersonalEMail("bakten@gtu.edu.tr","Burak Akten"));
        fourthGrade.addEmail(new PersonalEMail("fberber@gtu.edu.tr","Furkan Berber"));
        CSE.addEmail(fourthGrade);

        EL.addEmail(new PersonalEMail("saksoy@gtu.edu.tr","Serkan Aksoy"));

        addressBook.addEmail(new PersonalEMail("maslan@gtu.edu.tr","GTU Rector Muhammed Hasan ASLAN"));
        addressBook.addEmail(EL);
        addressBook.addEmail(CSE);

        System.out.println(addressBook.toString());

    }
}
