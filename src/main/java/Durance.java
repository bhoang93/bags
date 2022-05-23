public class Durance {
    private final Bag backpack = new Bag(8);
    private Bag bag1 = new Bag(4);
    private Bag bag2 = new Bag(4);
    private Bag bag3 = new Bag(4);
    private Bag bag4 = new Bag(4);

    public void addItem(Item item) {
        backpack.add(item);
    }

    public String displayBagContents() {
        var backpackContents = "Backpack: " + backpack.getContentsOfBag();
        var bag1Contents = "Bag with no category: " + bag1.getContentsOfBag();
        var bag2Contents = "Bag with no category: " + bag2.getContentsOfBag();
        var bag3Contents = "Bag with no category: " + bag3.getContentsOfBag();
        var bag4Contents = "Bag with no category: " + bag4.getContentsOfBag();

        return backpackContents + bag1Contents + bag2Contents + bag3Contents + bag4Contents;
    }

    public void organiseBags() {
        moveContents(backpack, bag1);
        moveContents(bag1, bag2);

        backpack.sort();
    }

    private void moveContents(Bag firstBag, Bag secondBag) {
        while (firstBag.size() > firstBag.sizeLimit) {
            secondBag.add(firstBag.moveLastItem());
        }
    }


}
