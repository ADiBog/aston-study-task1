package ru.aston.study.task1;

import java.util.Iterator;
import java.util.*;

/**
 * Класс MyListImpl реализующий интерфейс MyList.
 *
 * @param <E> тип элементов коллекции
 * @author Andrey Bogatyrev
 */
public class MyListImpl<E> implements MyList<E> {

    private E[] values;

    public E[] getValues() {
        return values;
    }

    public int elementsNumber = 0;


    public MyListImpl() {
        values = (E[]) new Object[10];
    }

    @Override
    public boolean add(E element) {
        if (elementsNumber < values.length) {
            values[elementsNumber] = element;
            elementsNumber++;
            return true;
        } else if (elementsNumber == values.length) {


            E[] tempValues = values;
            values = (E[]) new Object[(tempValues.length * 3) / 2 + 1];
            System.arraycopy(tempValues, 0, values, 0, tempValues.length);
            values[elementsNumber] = element;
            elementsNumber++;
            return true;


        }

        return true;
    }


    public boolean add(int index, E element) {
        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException("В коллекции отсутсвует нужный вам индекс");

        E[] tempValues = values;
        values = (E[]) new Object[tempValues.length + 1];
        System.arraycopy(tempValues, 0, values, 0, index);
        values[index] = element;
        System.arraycopy(tempValues, index, values, index + 1, tempValues.length - index);
        elementsNumber++;
        return true;


    }


    @Override
    public void delete(int index) {
        border(index);

        E[] tempValues = values;
        values = (E[]) new Object[tempValues.length - 1];
        System.arraycopy(tempValues, 0, values, 0, index);
        System.arraycopy(tempValues, index + 1, values, index, tempValues.length - index - 1);


    }


    @Override
    public E get(int index) {
        border(index);
        return values[index];
    }


    @Override
    public int size() {
        return elementsNumber;
    }


    @Override
    public void update(int index, E element) {
        border(index);
        values[index] = element;
    }


    @Override
    public void clear() {
        values = (E[]) new Object[10];
        elementsNumber = 0;
    }


    @Override
    public void sort(Comparator<E> comparator) {
        Utils.quickSort(this, comparator);
        /*Arrays.sort((E[]) values, 0, elementsNumber, comparator);*/
    }

    /**
     * Проверка, что индекс не выходит за пределы коллекции
     *
     * @param index индекс, который нужно проверить
     */
    private void border(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("В коллекции отсутствует нужный вам индекс");
        }
    }


}




