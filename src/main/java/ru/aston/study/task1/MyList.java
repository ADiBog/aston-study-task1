package ru.aston.study.task1;

import java.util.Comparator;

/**
 * Интерфейст MyList, содержащий методы, которые необходимо реализовать в классе MyListImpl.
 *
 * @param <E> тип элементов коллекции
 * @author Andrey Bogatyrev
 */
public interface MyList<E> {//Iterable для работы с arraylist

    /**
     * Добавление элемента в конец списка.
     *
     * @param element значение элемента, которое мы ходим добавить
     * @return true если элемент успешно добавлен
     */
    boolean add(E element); //добавление

    /**
     * Добавление элемента по индексу.
     *
     * @param index   индекс ячейки в которую мы хотим добавить элемент
     * @param element значение элемента, которое мы ходим добавить
     * @return true если элемент успешно добавлен
     */
    public boolean add(int index, E element);

    /**
     * Удаление элемента по индексу.
     *
     * @param index индекс ячейки из которой мы хотим удалить элемент
     */
    void delete(int index); //удаление по индексу

    /**
     * Получение элемента по индексу.
     *
     * @param index индекс ячейки из которой мы хотим получить элемент
     * @return возвращает значение элемента в соответствующей ячейке
     */
    E get(int index);//получение по индексу

    /**
     * Получение размера коллекции.
     *
     * @return возвращает количество добавленных в коллекцию элементов
     */
    int size();//получение размера

    /**
     * Обновление значения элемента по индексу.
     *
     * @param index   индекс ячейки в которой мы хотим обновить значение элемент
     * @param element новое значение элемента
     */
    void update(int index, E element);//обновление значения по индексу

    /**
     * Очистка коллекции.
     */
    void clear();

    /**
     * Сортировка коллекции.
     *
     * @param comparator компаратор для сортировки
     */
    void sort(Comparator<E> comparator);
}