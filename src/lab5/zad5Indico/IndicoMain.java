package lab5.zad5Indico;

import io.indico.api.utils.IndicoException;

import java.io.IOException;

public class IndicoMain {
    public static void main(String[] args) {
        try {
            ImageRecognition.single();
        } catch (IndicoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
