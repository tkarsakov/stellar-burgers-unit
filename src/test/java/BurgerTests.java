import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class BurgerTests {

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsBunGetsCorrectBun() {
        Bun bun = new Bun("Bunny", 10.5f);
        burger.setBuns(bun);
        Assert.assertEquals("Buns are not equal", bun, burger.bun);
    }

    @Test
    public void addIngredientIngredientGetsCorrectIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Saucy", 10.5f);
        burger.addIngredient(ingredient);
        Assert.assertEquals("More than one ingredient added", 1, burger.ingredients.size());
        Assert.assertEquals("Incorrect ingredient added", ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientIngredientEnsuresItsRemoved() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Saucy", 10.5f);
        burger.addIngredient(ingredient);
        Assert.assertEquals("More than one ingredient added", 1, burger.ingredients.size());
        burger.removeIngredient(0);
        Assert.assertEquals("Ingredient not removed", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTwoIngredientsEnsuresItsMoved() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Saucy", 10.5f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Filly", 11.5f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ingredient moved to incorrect position", ingredient1, burger.ingredients.get(1));
        Assert.assertEquals("Ingredient moved to incorrect position", ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceBunTwoIngredientsGetsCorrectPrice() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Saucy", 10.5f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Filly", 11.5f);
        Bun bun = new Bun("Bunny", 10f);
        burger.addIngredient(ingredient1);
        burger.setBuns(bun);
        burger.addIngredient(ingredient2);
        Assert.assertEquals(42f, burger.getPrice(), 0f);
    }

    @Test
    public void getReceiptBunTwoIngredientsGetsCorrectReceipt() {
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Saucy", 10.5f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Filly", 11.5f);
        Bun bun = new Bun("Bunny", 10f);
        burger.addIngredient(ingredient1);
        burger.setBuns(bun);
        burger.addIngredient(ingredient2);
        String expectedReceipt = String.format("(==== %s ====)%n", bun.getName())
                + String.format("= %s %s =%n", ingredient1.getType().toString().toLowerCase(),
                ingredient1.getName()) + String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(),
                ingredient2.getName()) + String.format("(==== %s ====)%n", bun.getName()) + String.format("%nPrice: %f%n", 42f);
        Assert.assertEquals("Receipts are different", expectedReceipt, burger.getReceipt());
    }
}
