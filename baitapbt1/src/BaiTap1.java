import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;


public class BaiTap1 {
    public static void main(String[] args)  {
        StringBuilder sb = new StringBuilder();
        File f = new File("E:/download/Bai-tap/Bai tap/File/Data bai van/baivan1.txt");
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(),StandardCharsets.UTF_8);
            String line = null;
            while(true) {
                line = br.readLine();
                if(line==null){
                    break;
                }else{
                    System.out.println(line);
                    sb.append(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DemKyTuTrongDoanVan.DemKyTu(sb);
    }

    class DemKyTuTrongDoanVan {
        static void DemKyTu(StringBuilder sb)
        {
            int counter[] = new int[10000];
            int len = sb.length();
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
                if (flag == 1)
                    System.out.println("so lan xuat hien cua " + sb.charAt(i)
                            + " trong chuoi:" + counter[sb.charAt(i)]);
            }
        }
    }
}

