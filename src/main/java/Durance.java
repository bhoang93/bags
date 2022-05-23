import java.util.ArrayList;

public class Durance {
    private ArrayList<Bag> bags = new ArrayList<Bag>();

    public Durance() {
        Bag backpack = new Bag("Backpack", 8);
        Bag bag1 = new Bag(4);
        Bag bag2 = new Bag(4);
        Bag bag3 = new Bag(4);
        Bag bag4 = new Bag(4);

        bags.add(backpack);
        bags.add(bag1);
        bags.add(bag2);
        bags.add(bag3);
        bags.add(bag4);
    }

    public void addItem(Item item) {
        bags.get(0).add(item);

        for (int i = 0; i < bags.size() - 1; i++) {
            Bag firstBag = bags.get(i);
            Bag secondBag = bags.get(i + 1);
            moveContents(firstBag, secondBag);
        }
    }

    public String displayBagContents() {
        var contentsString = new StringBuilder();

        for (Bag bag : bags) {
            contentsString.append(bag.type()).append(": ").append(bag.getContentsOfBag());
        }

        return contentsString.toString();
    }

    public void organiseBags() {
        bags.get(0).sort();
    }

    private void moveContents(Bag firstBag, Bag secondBag) {
        while (firstBag.size() > firstBag.sizeLimit) {
            secondBag.add(firstBag.moveLastItem());
        }
    }
}
