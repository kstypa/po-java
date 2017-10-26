package lab3.zad5Mail;

import java.util.LinkedList;

public class EmailMessage {

    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional

    protected EmailMessage(String from,
                         LinkedList<String> to,
                         String subject,
                         String content,
                         String mimeType,
                         LinkedList<String> cc,
                         LinkedList<String> bcc) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.mimeType = mimeType;
        this.cc = cc;
        this.bcc = bcc;
    }

    public static class Builder {
        private String from;
        private LinkedList<String> to = new LinkedList<>();
        private String subject;
        private String content;

        public void addFrom(String from) {
            this.from = from;
        }

        public void addTo(String to) {
            this.to.add(to);
        }

        public void addSubject(String subject) {
            this.subject = subject;
        }

        public void addContent(String content) {
            this.content = content;
        }

        public EmailMessage build() {
            return new EmailMessage(from, to, subject, content, "", new LinkedList<>(), new LinkedList<>());
        }

    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }
}
