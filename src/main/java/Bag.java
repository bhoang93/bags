import java.util.ArrayList;
import java.util.List;

public class Bag {
    public Integer sizeLimit = 4;
    private final ArrayList<Item> contents = new ArrayList<>();
    Category category;

    public Bag() {
        this.category = Category.NONE;
    }

    public Bag(Category category) {
        this.category = category;
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

    public void sortItemsInAlphabeticalOrder() {
        contents.sort((item1, item2) -> item1.name().compareToIgnoreCase(item2.name()));
    }

    public void add(Item item) {
        contents.add(item);
    }

    public Item moveItemAt(Integer index) {
        var lastItem = contents.get(index);
        contents.remove(lastItem);
        return lastItem;
    }

    public String bagName() {
        if (category != Category.NONE) return formattedTypeString();
        if (sizeLimit == 8) return "Backpack";
        return "Bag with no category";
    }

    private String formattedTypeString() {
        return category.toString().charAt(0) + category.toString().substring(1).toLowerCase();
    }

    public List<Item> getMatchingItems(Category category) {
        var matchingItems = contents.stream().filter(item -> item.category() == category).toList();
        contents.removeAll(matchingItems);
        return matchingItems;
    }

    public void addMatchingItems(List<Item> matchingItems) {
        contents.addAll(matchingItems);
    }
}
