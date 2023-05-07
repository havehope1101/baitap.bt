import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;


public class BaiTap2 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        File folder = new File("src/datavanban");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try {
                    BufferedReader br = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
                    String line = null;
                    while (true) {
                        line = br.readLine();
                        if (line == null) {
                            break;
                        } else {
                            System.out.println(line);
                            sb.append(line);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }



            }
        }
        DemKyTuTrongData.DemKyTu(sb);
    }

    class DemKyTuTrongData {
        static void DemKyTu(StringBuilder sb) {
            int counter[] = new int[100000];
            int len = sb.length();
            Map<Character, Integer> unsortMap = new HashMap<Character, Integer>();

            for (int i = 0; i < len; i++)
                counter[sb.charAt(i)]++;
            char array[] = new char[sb.length()];
            for (int i = 0; i < len; i++) {
                array[i] = sb.charAt(i);
                int flag = 0;
                for (int j = 0; j <= i; j++) {
                    if (sb.charAt(i) == array[j])
                        flag++;

                }

//                if (flag == 1)
//                    System.out.println("so lan xuat hien cua " + sb.charAt(i)
//                            + " trong chuoi:" + counter[sb.charAt(i)]);
                unsortMap.put(sb.charAt(i), counter[sb.charAt(i)]);
            }
            Map<Character, Integer> sortedMap = sortByValue(unsortMap);
            printMap(sortedMap);
        }
            public static Map<Character, Integer> sortByValue(Map<Character, Integer> unsortMap) {

                // 1. Convert Map to List of Map
                List<Map.Entry<Character, Integer>> list =
                        new LinkedList<Map.Entry<Character, Integer>>(unsortMap.entrySet());

                // 2. Sort list with Collections.sort(), provide a custom Comparator
                //    Try switch the o1 o2 position for a different order
                Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
                    public int compare(Map.Entry<Character, Integer> o1,
                                       Map.Entry<Character, Integer> o2) {
                        return (o2.getValue()).compareTo(o1.getValue());
                    }
                });

                // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
                Map<Character, Integer> sortedMap = new LinkedHashMap<Character, Integer>();
                for (Map.Entry<Character, Integer> entry : list) {
                    sortedMap.put(entry.getKey(), entry.getValue());
                }
                return sortedMap;
            }
            public static <K, V> void printMap(Map<K, V> map) {


                for (Map.Entry<K, V> entry : map.entrySet()) {

//                    System.out.println("Key : " + entry.getKey()
//                            + " Value : " + entry.getValue());

                }
                for(int i=1;i<11;i++) {
                    Map.Entry<K, V> firstEntry = map.entrySet().iterator().next();
                    K firstKey = firstEntry.getKey();
                    V firstValue = firstEntry.getValue();

                    System.out.println("Ki tu xuat hien nhieu thu " +i + " la: "+ firstKey);
                    System.out.println("so luong phan tu la: " + firstValue);

                    map.remove(firstKey);
                }
        }
    }


}