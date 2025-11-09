package stellaBurgers;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить цену.
 */
public class Bun {

    private final String name;
    private final float price;

    /**
     * Конструктор булочки.
     * @param name название булочки
     * @param price цена булочки (должна быть >= 0)
     */
    public Bun(String name, float price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Возвращает название булочки.
     * @return название булочки
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает цену булочки.
     * @return цена булочки
     */
    public float getPrice() {
        return price;
    }

}