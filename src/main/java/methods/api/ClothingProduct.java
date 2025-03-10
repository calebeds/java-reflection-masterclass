package methods.api;

public class ClothingProduct extends Product {
    private Size size;
    private String color;

    public Size getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
