import java.util.ArrayList;

public class Durance {
    private final ArrayList<Item> backpack = new ArrayList<Item>();
    private ArrayList<Item> bag1 = new ArrayList<Item>();
    private ArrayList<Item> bag2 = new ArrayList<Item>();
    private ArrayList<Item> bag3 = new ArrayList<Item>();
    private ArrayList<Item> bag4 = new ArrayList<Item>();

    public void addItem(Item item) {
        backpack.add(item);
    }

    public String displayBagContents() {
        var backpackContents = "Backpack: " + getContentsOfBag(backpack);
        var bag1Contents = "Bag with no category: " + getContentsOfBag(bag1);
        var bag2Contents = "Bag with no category: " + getContentsOfBag(bag2);
        var bag3Contents = "Bag with no category: " + getContentsOfBag(bag3);
        var bag4Contents = "Bag with no category: " + getContentsOfBag(bag4);

        return backpackContents + bag1Contents + bag2Contents + bag3Contents + bag4Contents;
    }

    private String getContentsOfBag(ArrayList<Item> bag) {
        if (bag.isEmpty()) return "empty\n";

        var string = new StringBuilder();

        for (int i = 0; i < bag.size(); i++) {
            String itemName = bag.get(i).name();
            string.append(itemName);

            var notLastItem = i != bag.size() - 1;
            if (notLastItem) {
                string.append(", ");
            }
        }
        string.append("\n");
        return string.toString();
    }

    public void organiseBags() {
        while(backpack.size() > 8) {
            bag1.add(backpack.get(backpack.size() - 1));
            backpack.remove(backpack.size() - 1);
        }
        backpack.sort((item1, item2) -> item1.name().compareToIgnoreCase(item2.name()));
    }
}
