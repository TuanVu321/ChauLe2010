import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManageProduct {
    public static void creatArr() {

    }


    public static void writeFile(String path, List<Product> arr, int code, String name, String made, double price, String desc) {

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            Product product = new Product(code, name, made, price, desc);
            arr.add(product);
            arrToFile(arr, objectOutputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        }

    }

    private static void arrToFile(List<Product> arr, ObjectOutputStream objectOutputStream) throws IOException {
        for (Product pr : arr) {
            objectOutputStream.writeObject(pr);
        }
    }

    public static void readFile(String path) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                Product product = (Product) objectInputStream.readObject();
                System.out.println(product);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void findCode(String path, int code) {
        List<Product> arr = fileToArr(path);
        for (Product product : arr) {
            if (product.getCode() == code) {
                System.out.println("ket qua tim duoc la: " + product);
            }
        }
    }

    public static void delete(String path, int code) {
        List<Product> arr = fileToArr(path);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getCode() == code) {
                arr.remove(i);
            }
        }
        arrToFile("danh sach.txt", arr);
    }

    public static void change(String path, int code, int codeFix, String name, String made, double price, String desc) {
        List<Product> arr = fileToArr(path);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getCode() == code) {
               arr.get(i).setCode(codeFix);
                arr.get(i).setName(name);
                arr.get(i).setMade(made);
                arr.get(i).setPrice(price);
                arr.get(i).setDesc(desc);
            }
        }
        arrToFile("danh sach.txt", arr);
    }


    public static List<Product> fileToArr(String path) {
        List<Product> findByCode = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                Product product = (Product) objectInputStream.readObject();
                findByCode.add(product);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return findByCode;
    }

    private static void arrToFile(String path, List<Product> findByCode) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Product pr : findByCode) {
                objectOutputStream.writeObject(pr);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ManageProduct manageProduct = new ManageProduct();
        List<Product> products = new ArrayList<>();
        Product product = new Product(01, "Book1", "China", 1000, "sach giao khoa");
        Product product1 = new Product(02, "Book2", "Taiwan", 2000, "truyen");
        products.add(product);
        products.add(product1);
        manageProduct.writeFile("danh sach.txt", products, 03, "Book3", "japan", 3000, "truyen");
        manageProduct.readFile("danh sach.txt");
        manageProduct.findCode("danh sach.txt", 02);
        manageProduct.delete("danh sach.txt", 02);
        manageProduct.readFile("danh sach.txt");
        manageProduct.change("danh sach.txt", 03, 04, "Book4", "apan", 4000, "tryen");
        manageProduct.readFile("danh sach.txt");
    }
}
