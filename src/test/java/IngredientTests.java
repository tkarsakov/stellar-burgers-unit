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
        Assert.assertEquals("getType() didn't return correct ingredient type", mockType, mockIngredient.getType());
    }

    @Test
    public void getNameNoParametersReturnsMockIngredientName() {
        Mockito.when(mockIngredient.getName()).thenReturn("Mock Ingredient");
        Assert.assertEquals("getName() didn't return correct ingredient name", "Mock Ingredient", mockIngredient.getName());
    }

    @Test
    public void getPriceNoParametersReturnsMockIngredientPrice() {
        Mockito.when(mockIngredient.getPrice()).thenReturn(3.5f);
        Assert.assertEquals("getPrice() didn't return correct price", 3.5f, mockIngredient.getPrice(), 0.0f);
    }

    @Test
    public void setTypeUpdatedTypeReturnsUpdatedMockIngredientType() {
        IngredientType updatedType = IngredientType.FILLING;
        mockIngredient.type = updatedType;
        Mockito.when(mockIngredient.getType()).thenReturn(updatedType);
        Assert.assertEquals("setType() should set correct type", updatedType, mockIngredient.getType());
    }

    @Test
    public void setNameUpdatedNameReturnsUpdatedMockIngredientName() {
        mockIngredient.name = "Mockman";
        Mockito.when(mockIngredient.getName()).thenReturn("Mockman");
        Assert.assertEquals("setName() should set correct name", "Mockman", mockIngredient.getName());
    }

    @Test
    public void setPriceUpdatedPriceReturnsUpdatedMockIngredientPrice() {
        mockIngredient.price = 4.5f;
        Mockito.when(mockIngredient.getPrice()).thenReturn(4.5f);
        Assert.assertEquals("setPrice() should set correct price", 4.5f, mockIngredient.getPrice(), 0.0f);
    }
}
