package ru.aston.study.task1;

import org.junit.jupiter.api.*;

/**
 * Модульный тест для {@link Utils}
 *
 * @author Andrey Bogatyrev
 */
class UtilsTest {
    private static final MyListImpl<Integer> listInt = new MyListImpl<>();

    @BeforeEach
    void setup() {
        listInt.add(4);
        listInt.add(17);
        listInt.add(8);
        listInt.add(10);
    }

    @AfterEach
    void cleanUp() {
        listInt.clear();
    }

    @Test
    @DisplayName("Should Sort work")
    void testSort() {
        //given
        MyListImpl<Integer> expectedResult = new MyListImpl<>();
        expectedResult.add(4);
        expectedResult.add(8);
        expectedResult.add(10);
        expectedResult.add(17);

        //when
        Utils.quickSort(listInt);

        //then
        for (int i = 0; i < expectedResult.size(); i++) {
            Assertions.assertEquals(listInt.get(i), expectedResult.get(i));
        }

    }

    @Test
    @DisplayName("Should Sort work")
    void testSortThisComparator() {
        //given
        MyListImpl<Integer> expectedResult = new MyListImpl<>();
        expectedResult.add(4);
        expectedResult.add(8);
        expectedResult.add(10);
        expectedResult.add(17);

        //when
        Utils.quickSort(listInt, Integer::compareTo);

        //then
        for (int i = 0; i < expectedResult.size(); i++) {
            Assertions.assertEquals(listInt.get(i), expectedResult.get(i));
        }

    }
}
