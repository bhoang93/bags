import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Durance {
    private ArrayList<Item> backpack = new ArrayList<Item>();

    public void addItem(Item item) {
        backpack.add(item);
    }

    public String displayBagContents() {
        var backpackContents = getContentsOfBackpack();

        return backpackContents +
                """
                        Bag with no category: empty
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
        backpack.sort((item1, item2) -> item1.name().compareToIgnoreCase(item2.name()));
    }
}
