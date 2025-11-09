package stellaBurgers;

/**
 * Модель ингредиента.
 * Ингредиент: начинка или соус.
 * У ингредиента есть тип (начинка или соус), название и цена.
 */
public class Ingredient {

    private final IngredientType type;
    private final String name;
    private final float price;

    /**
     * Конструктор ингредиента.
     * @param type тип ингредиента (SAUCE или FILLING)
     * @param name название ингредиента
     * @param price цена ингредиента (должна быть >= 0)
     */
    public Ingredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    /**
     * Возвращает цену ингредиента.
     * @return цена ингредиента
     */
    public float getPrice() {
        return price;
    }

    /**
     * Возвращает название ингредиента.
     * @return название ингредиента
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает тип ингредиента.
     * @return тип ингредиента
     */
    public IngredientType getType() {
        return type;
    }

}