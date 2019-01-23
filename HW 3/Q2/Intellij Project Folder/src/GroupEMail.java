import java.util.ArrayList;

public class GroupEMail extends EMail{
    private ArrayList<EMail> mailList;

    public GroupEMail(String eMail,String name) {
        mailList = new ArrayList<>();
        setEMail(eMail);
        setName(name);
    }

    @Override
    public void addEmail(EMail eMail) {
        mailList.add(eMail);
    }

    @Override
    public void removeEmail(EMail eMail) {
        mailList.remove(eMail);
    }

    @Override
    public EMail getChildEmail(int index) {
        return mailList.get(index);
    }

    /**
     *
     * @return a String that contains owner names and eMails of MailList elements
     */
    @Override
    public String toString() {
        StringBuilder mailsString = new StringBuilder("Mail Group -> " + getEMail() + " -> " + getName() + "\n{\n");
        for (EMail eMail : mailList) {
            mailsString.append("\t").append(eMail.toString()).append("\n");
        }
        mailsString.append("}");
        return mailsString.toString();
    }
}
