import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap vao canh a");
        double a = scanner.nextDouble();
        System.out.println("nhap vao canh b");
        double b = scanner.nextDouble();
        System.out.println("nhap vao canh c");
        double c = scanner.nextDouble();
        check(a,b,c);
    }

    private static void check(double a, double b, double c) {
        try {
            if(a<0||b<0||c<0||a+b<c||a+c<b||b+c<a){
                throw new Exception();
            }else{
                System.out.println("3 canh tren la 3 canh tam giac");
            }
        } catch (Exception e) {
            System.out.println("Loi");
        }
    }


}
