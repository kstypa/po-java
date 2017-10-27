package lab4.zad4Algorithm;

public class ROT11 implements Algorithm {
    public String encrypt(String input) {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            int c = input.charAt(i);
            if(c >= 'a' && c <= 'z')
                c = (c - 97 + 11) % 26 + 97;
            else if(c >= 'A' && c <='Z')
                c = (c - 65 + 11) % 26 + 65;
            output.append(Character.toChars(c));
        }
        return output.toString();
    }

    public String decrypt(String input) {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            int c = input.charAt(i);
            if(c >= 'a' && c <= 'z')
                c = Math.floorMod((c - 97 - 11), 26) + 97;
            else if(c >= 'A' && c <='Z')
                c = Math.floorMod((c - 65 - 11), 26) + 65;
            output.append(Character.toChars(c));
        }
        return output.toString();
    }
}
