package lab4.zad4Algorithm;

public class AlgoMain {
    public static void main(String[] args) {
        ROT11 rot11 = new ROT11();
        String name = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String encrypted = rot11.encrypt(name);
        System.out.println(encrypted);
        String decrypted = rot11.decrypt(encrypted);
        System.out.println(decrypted);
    }
}
