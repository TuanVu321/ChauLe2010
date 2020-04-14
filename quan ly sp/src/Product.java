import java.io.Serializable;

public class Product implements Serializable {
    private int code;
    private String name;
    private String made;
    private double price;
    private String desc;

    public Product() {
    }

    public Product(int code, String name, String made, double price, String desc) {
        this.code = code;
        this.name = name;
        this.made = made;
        this.price = price;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", made='" + made + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                '}';
    }
}
