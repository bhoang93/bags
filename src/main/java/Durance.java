import java.util.ArrayList;

public class Durance {
    private Backpack backpack = new Backpack();

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
        ArrayList<Item> contents = backpack.getContents();
        for (int i = 0; i < contents.size(); i++) {
            String itemName = contents.get(i).name();
            string.append(itemName);

            var notLastItem = i != contents.size() - 1;
            if (notLastItem) {
                string.append(", ");
            }
        }
        string.append("\n");
        return string.toString();
    }
}
