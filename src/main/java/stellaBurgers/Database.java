package stellaBurgers;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс с методами по работе с базой данных.
 * Хранит доступные булочки и ингредиенты для бургеров.
 */
public class Database {

    private final List<Bun> buns = new ArrayList<>();
    private final List<Ingredient> ingredients = new ArrayList<>();

    /**
     * Конструктор базы данных.
     * Инициализирует список доступных булочек и ингредиентов.
     */
    public Database() {
        // Инициализация булочек
        buns.add(new Bun("black bun", 100));
        buns.add(new Bun("white bun", 200));
        buns.add(new Bun("red bun", 300));

        // Инициализация соусов
        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));

        // Инициализация начинок
        ingredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        ingredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));
    }

    /**
     * Возвращает список доступных булочек.
     * @return список булочек
     */
    public List<Bun> availableBuns() {
        return new ArrayList<>(buns);
    }

    /**
     * Возвращает список доступных ингредиентов.
     * @return список ингредиентов
     */
    public List<Ingredient> availableIngredients() {
        return new ArrayList<>(ingredients);
    }

}
