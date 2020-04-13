import java.io.*;

public class CopyFile {
    public static void copy(String path, String targer){
        File file = new File(path);
        File target = new File(targer);
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        if(target.exists()){
            System.out.println("file chuyen toi da ton tai");
            System.exit(0);
        }else{
            try {
                target.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!file.exists()){
            System.out.println("Khong co file nay");
            System.exit(0);
        }else{
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                bufferedWriter = new BufferedWriter(new FileWriter(target));
                String line;
                while((line=bufferedReader.readLine())!=null){
                    System.out.println(line);
                    bufferedWriter.write(line+"\n");
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    bufferedReader.close();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        CopyFile cp = new CopyFile();
        cp.copy("test.txt", "test4.txt");
    }
}
