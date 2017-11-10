package lab4.zad4Algorithm;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Polybius implements Algorithm {
    public String encrypt(String input) {
        String readyString = input.replaceAll("\\W", "");
        readyString = readyString.toUpperCase();
        readyString = readyString.replace('J', 'I');

        Map<Character, String> polybiusMap = new TreeMap<>();
        polybiusMap.put('A', "11");
        polybiusMap.put('B', "12");
        polybiusMap.put('C', "13");
        polybiusMap.put('D', "14");
        polybiusMap.put('E', "15");
        polybiusMap.put('F', "21");
        polybiusMap.put('G', "22");
        polybiusMap.put('H', "23");
        polybiusMap.put('I', "24");
        polybiusMap.put('K', "25");
        polybiusMap.put('L', "31");
        polybiusMap.put('M', "32");
        polybiusMap.put('N', "33");
        polybiusMap.put('O', "34");
        polybiusMap.put('P', "35");
        polybiusMap.put('Q', "41");
        polybiusMap.put('R', "42");
        polybiusMap.put('S', "43");
        polybiusMap.put('T', "44");
        polybiusMap.put('U', "45");
        polybiusMap.put('V', "51");
        polybiusMap.put('W', "52");
        polybiusMap.put('X', "53");
        polybiusMap.put('Y', "54");
        polybiusMap.put('Z', "55");

        StringBuilder output = new StringBuilder();

        for(char n : readyString.toCharArray())
            output.append(polybiusMap.get(n));

        return output.toString();
    }

    public String decrypt(String input) {
        final String[][] polybiusSquare = new String[][] {
            {"A", "B", "C", "D", "E"},
            {"F", "G", "H", "I", "K"},
            {"L", "M", "N", "O", "P"},
            {"Q", "R", "S", "T", "U"},
            {"V", "W", "X", "Y", "Z"}
        };

        StringBuilder output = new StringBuilder();

        for(int i = 0; i < input.length(); i += 2) {
            int row = Integer.parseInt(input.substring(i, i+1)) - 1;
            int col = Integer.parseInt(input.substring(i+1, i+2)) - 1;
            output.append(polybiusSquare[row][col]);
        }

        return output.toString();
    }
}