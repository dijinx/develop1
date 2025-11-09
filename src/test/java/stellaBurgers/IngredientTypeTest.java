package stellaBurgers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Тесты для перечисления IngredientType.
 */
public class IngredientTypeTest {

    /**
     * Тест количества значений в перечислении.
     */
    @Test
    public void countValues() {
        assertEquals(2, IngredientType.values().length);
    }

    /**
     * Тест получения значения SAUCE по строке.
     */
    @Test
    public void sauceValueOf() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    /**
     * Тест получения значения FILLING по строке.
     */
    @Test
    public void fillingValueOf() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    /**
     * Тест порядкового номера SAUCE (должен быть 0).
     */
    @Test
    public void checkIngredientTypeSauceIndexIs0(){
        assertEquals(0, IngredientType.SAUCE.ordinal());
    }

    /**
     * Тест порядкового номера FILLING (должен быть 1).
     */
    @Test
    public void checkIngredientTypeFillingIndexIs1(){
        assertEquals(1, IngredientType.FILLING.ordinal());
    }
}