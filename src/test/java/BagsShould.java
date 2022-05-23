import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BagsShould {
    @Test
    void add_iron_to_the_backpack() {
        Durance durance = new Durance();
        durance.addItem(new Item("Iron", "Metal"));
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
        durance.addItem(new Item("Iron", "Metal"));
        durance.addItem(new Item("Leather", "Clothes"));
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
        durance.addItem(new Item("Cherry Blossom", "Herbs"));
        durance.addItem(new Item("Iron", "Metal"));
        durance.addItem(new Item("Leather", "Clothes"));
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

        durance.addItem(new Item("Iron", "Metal"));
        durance.addItem(new Item("Cherry Blossom", "Herbs"));
        durance.addItem(new Item("Leather", "Clothes"));

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

        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));

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

        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));
        durance.addItem(new Item("Leather", "Clothes"));

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
}
