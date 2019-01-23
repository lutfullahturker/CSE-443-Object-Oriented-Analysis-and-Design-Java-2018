public abstract class EMail {
    private String eMail;
    private String name;

    /**
     * Returns the owner name of e-mail
     * @return mail owner name
     */
    String getName() {
        return name;
    }

    /**
     * Sets the owner name of e-mail
     * @param name mail owner name
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * returns e-mail
     * @return e-mail String
     */
    String getEMail() {
        return eMail;
    }

    /**
     * Sets e-mail
     * @param eMail e-mail String
     */
    void setEMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * Print Function for all e-mails
     * @return a String contains that owner name and mail or mails of mail group
     */
    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

    /**
     * Adds an Email to a MailGroup
     * @param eMail mail that will add
     */
    public void addEmail(EMail eMail){
        throw new UnsupportedOperationException();
    }

    /**
     * Removes an Email from a MailGroup
     * @param eMail mail that will  remove
     */
    public void removeEmail(EMail eMail){
        throw new UnsupportedOperationException();
    }

    /**
     * Getter for an Email in a MailGroup
     * @param index index of Mail
     * @return EMail
     */
    public EMail getChildEmail(int index){
        throw new UnsupportedOperationException();
    }
}
