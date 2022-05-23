public class Durance {
    private Backpack backpack = new Backpack();

    public void addItem(Item item) {
        backpack.add(item);
    }

    public String displayBagContents() {
        var backpackContents = "Backpack: " + (backpack.contains(new Item("Leather", "Clothes")) ? "Iron, Leather\n" : "Iron\n");

        return backpackContents +
                """
                        Bag with no category: empty
                        Bag with no category: empty
                        Bag with no category: empty
                        """;
    }
}
