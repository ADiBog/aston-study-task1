package ru.aston.study.task1;

public class Application {
    public static void main(String[] args) {

        MyListImpl<Integer> listInt = new MyListImpl<>();
        listInt.add(4);
        listInt.add(17);
        listInt.add(8);
        listInt.add(10);

        for (int i = 0; i < listInt.size(); i++) {
            System.out.println(listInt.get(i));
        }

    }
}
