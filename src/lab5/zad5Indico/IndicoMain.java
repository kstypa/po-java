package lab5.zad5Indico;

import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class IndicoMain {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("No input directory given");
            System.exit(1);
        }

        String dir = args[0];
        while (dir.endsWith("/") || dir.endsWith("\\"))
            dir = dir.substring(0, dir.length() - 1);
        System.out.println(dir);

        try {
            List<String> folders = ImageRecognition.batch(new File(args[0]));
            boolean created;
            int createdNumber = 0;
            for(String n : folders) {
                created = new File(dir + "/" + n).mkdirs();
                if(created)
                    ++createdNumber;
            }
            System.out.println(Integer.toString(createdNumber) + " directories created");

            String[] filesArray = ImageRecognition.fileListArray(new File(dir));
            boolean moved;
            int movedNumber = 0;
            for(int i = 0; i < filesArray.length; ++i) {
                File file = new File(filesArray[i]);
                moved = file.renameTo(new File(file.getParent() + "/" + folders.get(i) + "/" + file.getName()));
                if(!moved)
                    System.out.println("Failed moving file " + file.getName());
                else
                    ++movedNumber;
            }
            System.out.println(movedNumber + " out of " + filesArray.length + " files moved");

        } catch (IndicoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String[] test = ImageRecognition.fileListArray(new File("C:\\Users\\Karol\\Desktop\\pec"));
//        for (String n : test) {
//            System.out.println(n);
//        }
    }
}
