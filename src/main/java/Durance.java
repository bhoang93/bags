import java.util.ArrayList;

public class Durance {
    private ArrayList<Bag> bags = new ArrayList<>();

    public Durance() {
        Bag backpack = new Backpack();
        Bag bag1 = new Bag();
        Bag bag2 = new Bag();
        Bag bag3 = new Bag();
        Bag bag4 = new Bag();

        bags.add(backpack);
        bags.add(bag1);
        bags.add(bag2);
        bags.add(bag3);
        bags.add(bag4);
    }

    public Durance(Bag firstBag, Bag secondBag, Bag thirdBag, Bag fourthBag) {
        Backpack backpack = new Backpack();

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
            bagsContents.append(bag.bagName()).append(": ").append(bag.getContentsOfBag());
        }

        return bagsContents.toString();
    }

    public void organiseBags() {
        for (Bag bag: bags) {
            if (bag.type != Category.NONE) {
                bag.add(bags.get(0).moveLastItem());
            }
            bag.sort();
        }
    }

    private void moveExcessItems(Bag firstBag, Bag secondBag) {
        while (firstBag.size() > firstBag.sizeLimit) {
            secondBag.add(firstBag.moveLastItem());
        }
    }
}
