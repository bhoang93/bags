import java.util.ArrayList;

public class Backpack {
    private final ArrayList<Item> contents = new ArrayList<>();

    public void add(Item item) {
        contents.add(item);
    }

    public Boolean contains(Item item) {
        return contents.contains(item);
    }

    public ArrayList<Item> getContents() {
        return contents;
    }
}
