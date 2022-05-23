import java.util.ArrayList;

public class Durance {
    private ArrayList<Bag> bags = new ArrayList<>();

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

    public Durance(Bag firstBag, Bag secondBag, Bag thirdBag, Bag fourthBag) {
        Bag backpack = new Bag("Backpack", 8);

        bags.add(backpack);
        bags.add(firstBag);
        bags.add(secondBag);
        bags.add(thirdBag);
        bags.add(fourthBag);
    }

    public void addItem(Item item) {
        bags.get(0).add(item);

        for (int i = 0; i < bags.size() - 1; i++) {
            Bag firstBag = bags.get(i);
            Bag secondBag = bags.get(i + 1);
            moveExcessItems(firstBag, secondBag);
        }
    }

    public String displayBagContents() {
        var bagsContents = new StringBuilder();

        for (Bag bag : bags) {
            bagsContents.append(bag.type()).append(": ").append(bag.getContentsOfBag());
        }

        return bagsContents.toString();
    }

    public void organiseBags() {
        for (Bag bag: bags) {
            bag.sort();
        }
    }

    private void moveExcessItems(Bag firstBag, Bag secondBag) {
        while (firstBag.size() > firstBag.sizeLimit) {
            secondBag.add(firstBag.moveLastItem());
        }
    }
}
