import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BagsShould {

    public static final Item LEATHER = new Item("Leather", Category.CLOTHES);
    public static final Item SILK = new Item("Silk", Category.CLOTHES);
    private static final Item IRON = new Item("Iron", Category.METAL);
    public static final Item CHERRY_BLOSSOM = new Item("Cherry Blossom", Category.HERBS);
    public static final Item MARIGOLD = new Item("Marigold", Category.HERBS);
    public static final Item COPPER = new Item("Copper", Category.METAL);
    public static final Item GOLD = new Item("Gold", Category.METAL);
    public static final Item WOOL = new Item("Wool", Category.CLOTHES);

    @Test
    void add_iron_to_the_backpack() {
        Durance durance = new Durance();
        durance.addItem(IRON);
        String result = durance.displayBagContents();
        String expected = """
                Backpack: Iron
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                """;

        assertEquals(expected, result);
    }

    @Test
    void add_iron_and_leather_to_the_backpack() {
        Durance durance = new Durance();
        durance.addItem(IRON);
        durance.addItem(LEATHER);
        String result = durance.displayBagContents();
        String expected = """
                Backpack: Iron, Leather
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                """;

        assertEquals(expected, result);
    }

    @Test
    void add_three_items_to_the_backpack() {
        Durance durance = new Durance();
        durance.addItem(CHERRY_BLOSSOM);
        durance.addItem(IRON);
        durance.addItem(LEATHER);
        String result = durance.displayBagContents();
        String expected = """
                Backpack: Cherry Blossom, Iron, Leather
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                """;

        assertEquals(expected, result);
    }

    @Test
    void add_three_items_to_the_backpack_and_organise_into_correct_order() {
        Durance durance = new Durance();

        durance.addItem(IRON);
        durance.addItem(CHERRY_BLOSSOM);
        durance.addItem(LEATHER);

        durance.organiseBags();

        String result = durance.displayBagContents();
        String expected = """
                Backpack: Cherry Blossom, Iron, Leather
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                """;

        assertEquals(expected, result);
    }

    @Test
    void add_nine_items_and_have_eight_in_the_backpack_and_one_in_the_bag() {
        Durance durance = new Durance();

        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);

        durance.organiseBags();

        String result = durance.displayBagContents();
        String expected = """
                Backpack: Leather, Leather, Leather, Leather, Leather, Leather, Leather, Leather
                Bag with no category: Leather
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                """;

        assertEquals(expected, result);
    }

    @Test
    void add_ten_items_and_have_eight_in_the_backpack_and_two_in_the_bag() {
        Durance durance = new Durance();

        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);

        durance.organiseBags();

        String result = durance.displayBagContents();
        String expected = """
                Backpack: Leather, Leather, Leather, Leather, Leather, Leather, Leather, Leather
                Bag with no category: Leather, Leather
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                """;

        assertEquals(expected, result);
    }

    @Test
    void add_13_items_and_have_right_order_in_third_bag() {
        Durance durance = new Durance();

        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(LEATHER);
        durance.addItem(COPPER);

        durance.organiseBags();

        String result = durance.displayBagContents();
        String expected = """
                Backpack: Leather, Leather, Leather, Leather, Leather, Leather, Leather, Leather
                Bag with no category: Leather, Leather, Leather, Leather
                Bag with no category: Copper, Leather
                Bag with no category: empty
                Bag with no category: empty
                """;

        assertEquals(expected, result);
    }

    @Test
    void move_iron_to_metal_bag_when_organised() {
        var metalBag = new Bag(Category.METAL);
        var regularBag = new Bag();
        Durance durance = new Durance(metalBag, regularBag, regularBag, regularBag);

        durance.addItem(new Item("Iron", Category.METAL));

        durance.organiseBags();

        String result = durance.displayBagContents();
        String expected = """
                Backpack: empty
                Metal: Iron
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                """;

        assertEquals(expected, result);
    }

    @Test
    void move_marigold_to_herbs_bag_when_organised() {
        var herbsBag = new Bag(Category.HERBS);
        var regularBag = new Bag();
        Durance durance = new Durance(herbsBag, regularBag, regularBag, regularBag);

        durance.addItem(MARIGOLD);

        durance.organiseBags();

        String result = durance.displayBagContents();
        String expected = """
                Backpack: empty
                Herbs: Marigold
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                """;

        assertEquals(expected, result);
    }

    @Test
    void move_both_marigold_to_herb_bag_organised() {
        var herbsBag = new Bag(Category.HERBS);
        var regularBag = new Bag();
        Durance durance = new Durance(herbsBag, regularBag, regularBag, regularBag);

        durance.addItem(IRON);
        durance.addItem(MARIGOLD);
        durance.addItem(MARIGOLD);

        durance.organiseBags();

        String result = durance.displayBagContents();
        String expected = """
                Backpack: Iron
                Herbs: Marigold, Marigold
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                """;

        assertEquals(expected, result);
    }

    @Test
    void acceptance_test() {
        var metalsBag = new Bag(Category.METAL);
        var weaponsBag = new Bag(Category.WEAPONS);
        var regularBag = new Bag();
        Durance durance = new Durance(metalsBag, regularBag, weaponsBag, regularBag);

        durance.addItem(LEATHER);
        durance.addItem(IRON);
        durance.addItem(COPPER);
        durance.addItem(MARIGOLD);
        durance.addItem(WOOL);
        durance.addItem(GOLD);
        durance.addItem(SILK);
        durance.addItem(COPPER);
        durance.addItem(COPPER);
        durance.addItem(CHERRY_BLOSSOM);

        var presortedResult = durance.displayBagContents();

        var expectedPreSorted = """
                Backpack: Leather, Iron, Copper, Marigold, Wool, Gold, Silk, Copper
                Metal: Copper, Cherry Blossom
                Bag with no category: empty
                Weapons: empty
                Bag with no category: empty
                """;

        assertEquals(expectedPreSorted, presortedResult);

        durance.organiseBags();

        var sortedResult = durance.displayBagContents();

        var expectedSorted = """
                Backpack: Cherry Blossom, Iron, Leather, Marigold, Silk, Wool
                Metal: Copper, Copper, Copper, Gold
                Bag with no category: empty
                Weapons: empty
                Bag with no category: empty
                """;

        assertEquals(expectedSorted, sortedResult);
    }
}
