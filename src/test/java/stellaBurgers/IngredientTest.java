package stellaBurgers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import static constant.Omega.OMEGA;

/**
 * Параметризованные тесты для класса Ingredient.
 */
@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    /**
     * Параметры для тестирования различных ингредиентов.
     */
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {IngredientType.FILLING, "cheese", 102f},
                {IngredientType.SAUCE, "Spicy", 50f}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    /**
     * Тест получения названия ингредиента.
     */
    @Test
    public void getName() {
        String actualName = ingredient.getName();
        assertEquals(name, actualName);
    }

    /**
     * Тест получения типа ингредиента.
     */
    @Test
    public void getType() {
        IngredientType actualType = ingredient.getType();
        assertEquals(type, actualType);
    }

    /**
     * Тест получения цены ингредиента.
     */
    @Test
    public void getPrice() {
        float actualPrice = ingredient.getPrice();
        assertEquals(price, actualPrice, OMEGA);
    }
}
