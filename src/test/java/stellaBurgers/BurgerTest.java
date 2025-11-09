package stellaBurgers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static constant.Omega.OMEGA;

/**
 * Тесты для класса Burger с использованием Mockito.
 */
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientFiling, ingredientSauce;

    @Before
    public void setUp() {
        // Настройка мок-объекта булочки
        when(bun.getName()).thenReturn("Simple bun");
        when(bun.getPrice()).thenReturn(2.25f);

        // Настройка мок-объекта начинки
        when(ingredientFiling.getPrice()).thenReturn(0.55f);
        when(ingredientFiling.getName()).thenReturn("cutlet");
        when(ingredientFiling.getType()).thenReturn(IngredientType.FILLING);

        // Настройка мок-объекта соуса
        when(ingredientSauce.getPrice()).thenReturn(0.45f);
        when(ingredientSauce.getName()).thenReturn("Spicy");
        when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);

        // Инициализация бургера
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFiling);
        burger.addIngredient(ingredientSauce);
    }

    /**
     * Тест установки булочки в бургер.
     */
    @Test
    public void setBuns() {
        assertSame(bun, burger.getBun());
    }

    /**
     * Тест добавления ингредиентов в бургер.
     */
    @Test
    public void addIngredient() {
        int expectedSize = 2;
        assertEquals(expectedSize, burger.getIngredients().size());
    }

    /**
     * Тест удаления ингредиента из бургера.
     */
    @Test
    public void removeIngredient() {
        burger.removeIngredient(1);
        int expectedSize = 1;
        assertEquals(expectedSize, burger.getIngredients().size());
    }

    /**
     * Тест перемещения ингредиента в бургере.
     */
    @Test
    public void moveIngredient() {
        burger.moveIngredient(0, 1);
        int expectedIndex = 1;
        assertEquals(expectedIndex, burger.getIngredients().indexOf(ingredientFiling));
    }

    /**
     * Тест проверки вызова методов получения цены при расчете стоимости бургера.
     */
    @Test
    public void verifyBurgerCompositionPrice() {
        burger.getPrice();
        verify(bun).getPrice();
        verify(ingredientSauce).getPrice();
        verify(ingredientFiling).getPrice();
    }

    /**
     * Тест корректности расчета цены бургера.
     */
    @Test
    public void getCorrectBurgerPrice() {
        float expectedBurgerPrice = (bun.getPrice() * 2) + ingredientSauce.getPrice() + ingredientFiling.getPrice();
        assertEquals(expectedBurgerPrice, burger.getPrice(), OMEGA);
    }

    /**
     * Тест формирования чека бургера.
     */
    @Test
    public void getBurgerReceipt() {
        String burgerReceipt = burger.getReceipt();
        // Обновляем ожидаемый чек с учетом нового формата (%.2f вместо %f)
        String expectedBurgerReceipt = "(==== Simple bun ====)\r\n= filling cutlet =\r\n= sauce Spicy =\r\n(==== Simple bun ====)\r\n\r\nPrice: 5.50\r\n";
        assertEquals(expectedBurgerReceipt, burgerReceipt);
    }

    /**
     * Тест получения цены бургера без булочки (null case).
     */
    @Test
    public void getPriceWithoutBun() {
        Burger emptyBurger = new Burger();
        float expectedPrice = 0.0f;
        assertEquals(expectedPrice, emptyBurger.getPrice(), OMEGA);
    }

    /**
     * Тест получения чека бургера без булочки (null case).
     */
    @Test
    public void getReceiptWithoutBun() {
        Burger emptyBurger = new Burger();
        String expectedMessage = "Burger is not assembled yet.";
        assertEquals(expectedMessage, emptyBurger.getReceipt());
    }

    /**
     * Тест удаления ингредиента с невалидным индексом.
     */
    @Test
    public void removeIngredientWithInvalidIndex() {
        int initialSize = burger.getIngredients().size();
        burger.removeIngredient(-1); // отрицательный индекс
        assertEquals(initialSize, burger.getIngredients().size());
        
        burger.removeIngredient(100); // индекс больше размера
        assertEquals(initialSize, burger.getIngredients().size());
    }

    /**
     * Тест перемещения ингредиента с невалидными индексами.
     */
    @Test
    public void moveIngredientWithInvalidIndex() {
        Ingredient firstIngredient = burger.getIngredients().get(0);
        burger.moveIngredient(-1, 1); // отрицательный индекс
        assertEquals(0, burger.getIngredients().indexOf(firstIngredient));
        
        burger.moveIngredient(100, 1); // индекс больше размера
        assertEquals(0, burger.getIngredients().indexOf(firstIngredient));
    }
}
