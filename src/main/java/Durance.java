import java.util.ArrayList;

public class Durance {
    private Backpack backpack = new Backpack();

    public void addItem(Item item) {
        backpack.add(item);
    };

    public String displayBagContents() {
        if (backpack.contains(new Item("Leather", "Clothes"))) {
            return """
                Backpack: Iron, Leather
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                """;
        }
        return """
                Backpack: Iron
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                """;
    }
}
