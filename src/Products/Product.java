package Products;

public class Product {
    private int id;
    private String Name;
    private double Price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public Product(int id, String name, double price, String description) {
        this.id = id;
        Name = name;
        Price = price;
        this.description = description;
    }

    public Product(){
    }

    @Override
    public String toString() {
        return
                " Product №" + id +
                ", || Name of product: " + Name +
                ", || Price: " + Price + "$"+
                ", || Product description: " + description + "\n";
    }
}


