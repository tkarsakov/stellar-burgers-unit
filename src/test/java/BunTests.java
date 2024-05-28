import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTests {

    private final String bunName;
    private final float bunPrice;
    private final Bun bun;

    public BunTests(String bunName, float bunPrice, Bun bun) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.bun = bun;
    }

    @Parameterized.Parameters
    public static Object[][] getBun() {
        return new Object[][]{
                {"Bunny", 10.5f, new Bun("Bunny", 10.5f)},
                {"Bunner", 1000.12f, new Bun("Bunner", 1000.12f)}
        };
    }

    @Test
    public void getNameNoParametersGetsCorrectName() {
        Assert.assertEquals("Names are not equal", bunName, bun.getName());
    }

    @Test
    public void getPriceNoParametersGetsCorrectPrice() {
        Assert.assertEquals(bunPrice, bun.getPrice(), 0f);
    }
}
