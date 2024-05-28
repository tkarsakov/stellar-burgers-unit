import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTests {

    @Test
    public void valuesNoParametersReturnsAllIngredientTypes() {
        IngredientType[] expectedValues = { IngredientType.SAUCE, IngredientType.FILLING };
        Assert.assertArrayEquals("values() should return all IngredientType constants", expectedValues, IngredientType.values());
    }

    @Test
    public void valueOfValidNameReturnsCorrespondingIngredientType() {
        Assert.assertEquals("valueOf('SAUCE') should return IngredientType.SAUCE", IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        Assert.assertEquals("valueOf('FILLING') should return IngredientType.FILLING", IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOfInvalidNameThrowsIllegalArgumentException() {
        IngredientType.valueOf("INVALID");
    }
}
