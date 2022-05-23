import java.util.ArrayList;

public class Durance {
    private final ArrayList<Item> backpack = new ArrayList<Item>();
    private ArrayList<Item> bag1 = new ArrayList<Item>();

    public void addItem(Item item) {
        backpack.add(item);
    }

    public String displayBagContents() {
        var backpackContents = getContentsOfBackpack();
        var bag1Contents = bag1.size() > 0 ? "Bag with no category: Leather\n" : "Bag with no category: empty\n";

        return backpackContents + bag1Contents +
                """
                        Bag with no category: empty
                        Bag with no category: empty
                        """;
    }

    private String getContentsOfBackpack() {
        var string = new StringBuilder("Backpack: ");

        for (int i = 0; i < backpack.size(); i++) {
            String itemName = backpack.get(i).name();
            string.append(itemName);

            var notLastItem = i != backpack.size() - 1;
            if (notLastItem) {
                string.append(", ");
            }
        }
        string.append("\n");
        return string.toString();
    }

    public void organiseBags() {
        if (backpack.size() == 9) {
            bag1.add(backpack.get(8));
            backpack.remove(8);
        }
        backpack.sort((item1, item2) -> item1.name().compareToIgnoreCase(item2.name()));
    }
}
