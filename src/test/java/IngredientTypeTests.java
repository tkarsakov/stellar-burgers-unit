import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTests {

    @Test
    public void valuesNoParametersReturnsAllIngredientTypes() {
        IngredientType[] expectedValues = { IngredientType.SAUCE, IngredientType.FILLING };
        assertArrayEquals("values() should return all IngredientType constants", expectedValues, IngredientType.values());
    }

    @Test
    public void valueOfValidNameReturnsCorrespondingIngredientType() {
        assertEquals("valueOf('SAUCE') should return IngredientType.SAUCE", IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals("valueOf('FILLING') should return IngredientType.FILLING", IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOfInvalidNameThrowsIllegalArgumentException() {
        IngredientType.valueOf("INVALID");
    }
}
