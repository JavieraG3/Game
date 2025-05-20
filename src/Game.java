public class Game {
    private String name;
    private String category;
    private int price;
    private int quality;

    Game(String name, String category, int price, int quality) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quality = quality;
    }

    void setName(String name) {
        this.name = name;
    }

    void setCategory(String category) {
        this.category = category;
    }

    void setPrice(int price) {
        this.price = price;
    }

    void setQuality(int quality) {
        this.quality = quality;
    }

    String getName() {
        return this.name;
    }

    String getCategory() {
        return this.category;
    }

    int getPrice() {
        return this.price;
    }

    int getQuality() {
        return this.quality;
    }
}
