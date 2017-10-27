package lab3.zad5Mail;

public class EmailMain {
    public static void main(String[] args) {
        System.out.println("Wysyłanie wiadomości testowej");
        EmailMessage wiadomosc = EmailMessage.builder()
                .addFrom("informatyka.4b@gmail.com")
                .addTo("bury09@gmail.com")
                .addTo("kstypa@student.agh.edu.pl")
                .addSubject("Mail testowy")
                .addContent("Brak tresci")
                .build();

        wiadomosc.send();
    }
}
