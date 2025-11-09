package stellaBurgers;

import java.util.List;

/**
 * Главный класс приложения для демонстрации работы с бургерами.
 */
public class Praktikum {

    /**
     * Точка входа в приложение.
     * Демонстрирует создание бургера, добавление ингредиентов и формирование чека.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Инициализация базы данных
        Database database = new Database();

        // Создание нового бургера
        Burger burger = new Burger();

        // Получение списков доступных булочек и ингредиентов
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();

        // Сборка бургера: установка булочки
        burger.setBuns(buns.get(0));

        // Добавление ингредиентов
        burger.addIngredient(ingredients.get(1)); // sour cream
        burger.addIngredient(ingredients.get(4)); // dinosaur
        burger.addIngredient(ingredients.get(3)); // cutlet
        burger.addIngredient(ingredients.get(5)); // sausage

        // Перемещение ингредиента
        burger.moveIngredient(2, 1);

        // Удаление ингредиента
        burger.removeIngredient(3);

        // Вывод чека
        System.out.println(burger.getReceipt());
    }

}