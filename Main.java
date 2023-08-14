import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        String scvRoute = "src/codigos_postales_hmo";
        File scvFile = new File(scvRoute);
        BufferedReader reader = new BufferedReader(new FileReader(scvFile));

        String line = null;
        int length = 0;

        while (((line=reader.readLine())!= null)){ //obtener tamanio del array
            length++;
        }

        reader.close();
        BufferedReader secondReader = new BufferedReader(new FileReader(scvFile));

        String[] allCP = new String[length];

        for (int i = 0; i < allCP.length; i++) {
            String[] tempLine= (secondReader.readLine()).split("\t");
            allCP[i] = tempLine[0];
        }

        HashSet<String> uniqueSet = new HashSet<>();
        for (String element : allCP) {
            uniqueSet.add(element);
        }
        String[] uniqueArray = uniqueSet.toArray(new String[0]);
        int[] counter = new int[uniqueArray.length];

        for (int i = 0; i < uniqueArray.length; i++) {

            for (int j = 0; j < allCP.length; j++) {
                if (uniqueArray[i].equals(allCP[j])){
                    counter[i]++;
                }
            }
        }
        for (int i = 0; i < uniqueArray.length; i++) {
            System.out.println("CP: " + uniqueArray[i] + " tiene " + counter[i] + " asentamientos que comparten codigo postal");
        }

    }
}