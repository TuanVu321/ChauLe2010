import java.io.*;

public class TestIO {

    public static void writeFile(String path, String string) {
        File file = new File(path);
        FileWriter fileWriter = null;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write(string);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void readFile(String path) {
        File file = new File(path);
        FileReader fileReader = null;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileReader = new FileReader(file);
            int i = 0;
            while ((i = fileReader.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readTextFile(String path) {
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        TestIO testIO = new TestIO();
//        testIO.writeFile("test.txt","\nxin chao");
//        testIO.writeFile("test.txt","\ntam biet");
//        testIO.readFile("test.txt");
        testIO.readTextFile("test.txt");

    }

}
