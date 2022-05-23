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
            Item item = contents.get(i);
            string.append(item.name());
            if (i != contents.size() - 1) {
                string.append(", ");
            }
        }
        string.append("\n");
        return string.toString();
    }
}
