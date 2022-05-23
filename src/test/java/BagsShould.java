import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BagsShould {
    @Test
    void name() {
        Durance durance = new Durance();
        durance.addItem(new Item("Iron", "Metal"));
        String result = durance.displayBagContents();
        String expected = """
                Backpack: Iron
                Bag with no category: empty
                Bag with no category: empty
                Bag with no category: empty
                """;

        assertEquals(expected, result);
    }
}
