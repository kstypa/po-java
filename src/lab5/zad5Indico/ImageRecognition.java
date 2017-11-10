package lab5.zad5Indico;

import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ImageRecognition {
    public ImageRecognition() throws IndicoException, IOException {
    }

    static Indico indico;

    static {
        try {
            indico = new Indico("bf8c4db309fbc6da0da4070eb891e76a");
        } catch (IndicoException e) {
            e.printStackTrace();
        }
    }

    public static String single() throws IndicoException, IOException {
        // single example

        IndicoResult single = indico.imageRecognition.predict(
                "/home/karol/java/foto/kot.jpg"
        );
        Map<String, Double> result = single.getImageRecognition();
        return getMax(result);
    }

    private static String getMax(Map<String, Double> result) {
        double max = 0;
        String maxname = "";
        for (Map.Entry<String, Double> n : result.entrySet()) {
            if(n.getValue() > max) {
                max = n.getValue();
                maxname = n.getKey();
            }
        }
        return maxname;
    }
//    System.out.println(result);

    public String[] listFilesForFolder(final File folder) {
        Vector<String> filesVector = new Vector<>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                filesVector.add(fileEntry.getName());
            }
        }
        return filesVector.toArray(new String[filesVector.size()]);
    }

    // batch example
    public static List<String> batch(String[] dir) throws IndicoException, IOException {
        BatchIndicoResult multiple = indico.imageRecognition.predict(dir);
        List<Map<String, Double>> results = multiple.getImageRecognition();
        List<String> folders = new LinkedList<>();
        for(Map<String, Double> m : results) {
            folders.add(getMax(m));
        }
        return folders;
    }



//    System.out.println(results);
}
