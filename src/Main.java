public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(5,10,12);
        System.out.println(triangle);
        triangle.setColor("blue");
        System.out.println(triangle);
        triangle.inputData();
        System.out.println(triangle);
    }
}
