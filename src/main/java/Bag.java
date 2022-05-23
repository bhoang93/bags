import java.util.ArrayList;

public class Bag {
    public final Integer sizeLimit;
    private final ArrayList<Item> contents = new ArrayList<>();
    private final String type;

    public Bag() {
        this.type = "Bag with no category";
        this.sizeLimit = 4;
    }

    public Bag(String type, Integer sizeLimit) {
        this.type = type;
        this.sizeLimit = sizeLimit;
    }

    public Integer size() {
        return contents.size();
    }

    public String getContentsOfBag() {
        if (contents.isEmpty()) return "empty\n";

        var string = new StringBuilder();

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

    public void sort() {
        contents.sort((item1, item2) -> item1.name().compareToIgnoreCase(item2.name()));
    }

    public void add(Item item) {
        contents.add(item);
    }

    public Item moveLastItem() {
        var lastItem = contents.get(contents.size() - 1);
        contents.remove(lastItem);
        return lastItem;
    }

    public String type() {
        return type;
    }
}
