package ru.aston.study.task1;

import java.util.Comparator;

/**
 * Класс в котором реализованы алгоритмы быстрой сортировки, с помощью comparator (для объектов не реализующих интерфейс Comparable) и для объектов реализующих интерфейс Comparable.
 *
 * @author Andrey Bogatyrev
 */
public class Utils {
    private Utils() {
        throw new UnsupportedOperationException("Невозможно создать экземпляр класса");
    }

    /**
     * Быстрая сортировка коллекции для объектов реализующих интерфейс Comparable.
     *
     * @param list коллекция для сортировки
     * @param <T>  тип элементов коллекции
     */
    public static <T extends Comparable<? super T>> void quickSort(MyList<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    /**
     * Быстрая сортировка коллекции для объектов реализующих интерфейс Comparable.
     *
     * @param list коллекция для сортировки
     * @param min  индекс первого элемента
     * @param max  индекс последнего элемента
     * @param <T>  тип элементов коллекции
     */
    public static <T extends Comparable<? super T>> void quickSort(MyList<T> list, int min, int max) {
        if (list.size() == 0 || min >= max) return;

        //выбираем опорный элемент
        int middle = min + (max - min) / 2;
        T border = list.get(middle);

        //разделияем на подмассивы и меняем местами
        int i = min, j = max;
        while (i <= j) {

            while (list.get(i).compareTo(border) < 0) i++;
            while (list.get(j).compareTo(border) > 0) j--;
            if (i <= j) {
                T swap = list.get(i);
                list.update(i, list.get(j));
                list.update(j, swap);
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (min < j) quickSort(list, min, j);
        if (max > i) quickSort(list, i, max);
    }

    /**
     * Быстрая сортировка коллекции, с помощью comparator. Для объектов не реализующих интерфейс Comparable.
     *
     * @param list коллекция для сортировки
     * @param camp comparator компаратор необходимый для сравнения элементов
     * @param <T>  тип элементов коллекции
     */
    public static <T> void quickSort(MyList<T> list, Comparator<? super T> camp) {
        quickSort(list, 0, list.size() - 1, camp);
    }

    /**
     * Быстрая сортировка коллекции, с помощью comparator. Для объектов не реализующих интерфейс Comparable.
     *
     * @param list коллекция для сортировки
     * @param min  индекс первого элемента
     * @param max  индекс последнего элемента
     * @param camp comparator компаратор необходимый для сравнения элементов
     * @param <T>  тип элементов коллекции
     */
    public static <T> void quickSort(MyList<T> list, int min, int max, Comparator<? super T> camp) {
        if (list.size() == 0 || min >= max) return;

        //выбираем опорный элемент
        int middle = min + (max - min) / 2;
        //int border = list.get(middle);
        T border = list.get(middle);

        //разделияем на подмассивы и меняем местами
        int i = min, j = max;
        while (i <= j) {
            while (camp.compare(list.get(i), border) < 0) i++;
            while (camp.compare(list.get(j), border) > 0) j--;


            if (i <= j) {
                T swap = list.get(i);
                list.update(i, list.get(j));
                list.update(j, swap);
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (min < j) quickSort(list, min, j, camp);
        if (max > i) quickSort(list, i, max, camp);
    }
}
