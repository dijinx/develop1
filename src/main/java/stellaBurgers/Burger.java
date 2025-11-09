package stellaBurgers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Модель бургера.
 * Бургер состоит из булочек и ингредиентов (начинка или соус).
 * Ингредиенты можно перемещать и удалять.
 * Можно распечать чек с информацией о бургере.
 */
public class Burger {

    private Bun bun;
    private final List<Ingredient> ingredients = new ArrayList<>();

    /**
     * Устанавливает булочки для бургера (верхняя и нижняя одинаковые).
     * @param bun булочка
     */
    public void setBuns(Bun bun) {
        this.bun = bun;
    }

    /**
     * Добавляет ингредиент в бургер.
     * @param ingredient ингредиент для добавления
     */
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    /**
     * Удаляет ингредиент по индексу.
     * @param index индекс ингредиента для удаления
     */
    public void removeIngredient(int index) {
        if (index >= 0 && index < ingredients.size()) {
            ingredients.remove(index);
        }
    }

    /**
     * Перемещает ингредиент с одной позиции на другую.
     * @param index текущая позиция ингредиента
     * @param newIndex новая позиция ингредиента
     */
    public void moveIngredient(int index, int newIndex) {
        if (index >= 0 && index < ingredients.size() && 
            newIndex >= 0 && newIndex <= ingredients.size()) {
            ingredients.add(newIndex, ingredients.remove(index));
        }
    }

    /**
     * Вычисляет общую стоимость бургера.
     * @return общая цена (булочки * 2 + все ингредиенты)
     */
    public float getPrice() {
        if (bun == null) {
            return 0.0f;
        }
        float price = bun.getPrice() * 2;

        for (Ingredient ingredient : ingredients) {
            price += ingredient.getPrice();
        }

        return price;
    }

    /**
     * Формирует чек с информацией о бургере.
     * @return строковое представление чека
     */
    public String getReceipt() {
        if (bun == null) {
            return "Burger is not assembled yet.";
        }
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", 
                ingredient.getType().toString().toLowerCase(), ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format(Locale.US, "%nPrice: %.2f%n", getPrice()));

        return receipt.toString();
    }

    /**
     * Возвращает булочку бургера (для тестов).
     * @return булочка бургера
     */
    public Bun getBun() {
        return bun;
    }

    /**
     * Возвращает список ингредиентов (для тестов).
     * @return список ингредиентов
     */
    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }

}
