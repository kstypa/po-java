package lab5.zad5Indico;

import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.IOException;
import java.util.List;

public class ImageFeatures {
    public static void main(String[] args) {
        // single example
        Indico indico = null;
        try {
            indico = new Indico("bf8c4db309fbc6da0da4070eb891e76a");
        } catch (IndicoException e) {
            e.printStackTrace();
        }
        IndicoResult single = null;
        try {
            single = indico.imageFeatures.predict(
                    "/home/karol/java/foto/kot.jpg"
            );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IndicoException e) {
            e.printStackTrace();
        }
        List<Double> result = null;
        try {
            result = single.getImageFeatures();
        } catch (IndicoException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        System.out.println(result);

        // batch example
        String[] example = {
                "/home/karol/java/foto/pies.jpg",
                "/home/karol/java/foto/pies2.jpg"
        };
        BatchIndicoResult multiple = null;
        try {
            multiple = indico.imageFeatures.predict(example);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IndicoException e) {
            e.printStackTrace();
        }
        List<List<Double>> results = null;
        try {
            results = multiple.getImageFeatures();
        } catch (IndicoException e) {
            e.printStackTrace();
        }
        System.out.println(results);
    }
}
