public class PersonalEMail extends EMail {
    public PersonalEMail(String eMail,String name) {
        setEMail(eMail);
        setName(name);
    }

    /**
     * Print Function for PersonalEmail
     * @return a String that contains owner name of eMail and eMail
     */
    @Override
    public String toString() {
        return getEMail() + " -> " + getName();
    }
}
