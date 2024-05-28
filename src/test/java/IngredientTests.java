import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTests {

    @Mock
    private Ingredient mockIngredient;

    @Before
    public void setUp(){}

    @Test
    public void getTypeNoParametersReturnsMockIngredientType() {
        IngredientType mockType = IngredientType.SAUCE;
        Mockito.when(mockIngredient.getType()).thenReturn(mockType);
        Assert.assertEquals(mockType, mockIngredient.getType());
    }

    @Test
    public void getNameNoParametersReturnsMockIngredientName() {
        Mockito.when(mockIngredient.getName()).thenReturn("Mock Ingredient");
        Assert.assertEquals("Mock Ingredient", mockIngredient.getName());
    }

    @Test
    public void getPriceNoParametersReturnsMockIngredientPrice() {
        Mockito.when(mockIngredient.getPrice()).thenReturn(3.5f);
        Assert.assertEquals(3.5f, mockIngredient.getPrice(), 0.0f);
    }

    @Test
    public void setTypeUpdatedTypeReturnsUpdatedMockIngredientType() {
        IngredientType updatedType = IngredientType.FILLING;
        mockIngredient.type = updatedType;
        Mockito.when(mockIngredient.getType()).thenReturn(updatedType);
        Assert.assertEquals(updatedType, mockIngredient.getType());
    }

    @Test
    public void setNameUpdatedNameReturnsUpdatedMockIngredientName() {
        mockIngredient.name = "Mockman";
        Mockito.when(mockIngredient.getName()).thenReturn("Mockman");
        Assert.assertEquals("Mockman", mockIngredient.getName());
    }

    @Test
    public void setPriceUpdatedPriceReturnsUpdatedMockIngredientPrice() {
        mockIngredient.price = 4.5f;
        Mockito.when(mockIngredient.getPrice()).thenReturn(4.5f);
        Assert.assertEquals(4.5f, mockIngredient.getPrice(), 0.0f);
    }
}
