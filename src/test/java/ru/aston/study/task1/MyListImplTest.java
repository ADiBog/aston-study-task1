package ru.aston.study.task1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;

/**
 * Модульный тест для {@link MyListImpl}
 *
 * @author Andrey Bogatyrev
 */
public class MyListImplTest {

    private final MyListImpl<String> list = new MyListImpl<>();

    @BeforeEach
    void setup() {
        list.add("Строка1");
        list.add("Строка2");
        list.add("Строка3");
        list.add("Строка4");
    }

    @AfterEach
    void cleanUp() {
        list.clear();
    }

    @Test
    @DisplayName("Should add element to end of the list")
    void testAdd() {
        //given
        var toAdd = "Строка";

        //when
        list.add(toAdd);

        //then
        Assertions.assertEquals(list.get(4), toAdd);
    }

    @ParameterizedTest
    @MethodSource("testAddByIndexData")
    @DisplayName("Should add element by index to the list")
    void testAddByIndex(Integer index) {
        //given
        var toAdd = "Строка";

        //when
        list.add(index, toAdd);

        //then
        Assertions.assertEquals(list.get(index), toAdd);
    }

    @Test
    @DisplayName("Should not add element by index to the list")
    void testAddByIndexFailed() {
        //given
        var index = 1337;
        var toAdd = "Строка";

        //then
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add(index, toAdd));
    }

    @Test
    @DisplayName("Should delete element by index from the list")
    void testDeleteByIndex() {
        //given
        var index = 2;

        //when
        list.delete(index);

        //then
        Assertions.assertEquals(list.get(index), "Строка4");
    }

    @ParameterizedTest
    @MethodSource("testDeleteByIndexData")
    @DisplayName("Should not delete element by index from the list")
    void testNotDeleteByIndex(Integer index) {

        //then
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.delete(index));
    }

    @Test
    @DisplayName("Should get element by index from the list")
    void testGet() {
        //given
        var index = 2;

        //when
        list.get(index);

        //then
        Assertions.assertEquals(list.get(index), "Строка3");
    }

    @ParameterizedTest
    @MethodSource("testNotGetData")
    @DisplayName("Should not get element by index from the list")
    void testNotGet(Integer index) {
        //then
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(index));
    }

    @Test
    @DisplayName("Should get size of the list")
    void testGetSize() {
        //given
        var expectedResult = 4;

        //when
        var result = list.size();

        //then
        Assertions.assertEquals(result, expectedResult);
    }

    @Test
    @DisplayName("Should update element by index from the list")
    void testUpdate() {
        //given
        var index = 2;
        var element = "Строка";

        //when
        list.update(index, element);

        //then
        Assertions.assertEquals(list.get(index), element);
    }

    @ParameterizedTest
    @MethodSource("testNotUpdateData")
    @DisplayName("Should not update element by index from the list")
    void testNotUpdate(Integer index) {
        //given
        var element = "Строка";

        //then
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.update(index, element));
    }

    @Test
    @DisplayName("Should clear list")
    void testClearList() {
        //given
        var expectedResult = 0;

        //when
        list.clear();

        //then
        Assertions.assertEquals(list.size(), expectedResult);
    }

    @Test
    @DisplayName("Should sort work")
    void testSort() {
        //given
        var expectedResult = new MyListImpl<>();
        expectedResult.add("Строка1");
        expectedResult.add("Строка2");
        expectedResult.add("Строка3");
        expectedResult.add("Строка4");

        //when
        list.sort(String::compareTo);

        //then
        for (int i = 0; i < expectedResult.size(); i++) {
            Assertions.assertEquals(list.get(i), expectedResult.get(i));
        }

    }

    private static List<Integer> testAddByIndexData() {
        return List.of(2, 4);
    }

    private static List<Integer> testDeleteByIndexData() {
        return List.of(-1, 4);
    }

    private static List<Integer> testNotGetData() {
        return List.of(-1, 4);
    }

    private static List<Integer> testNotUpdateData() {
        return List.of(-1, 4);
    }
}
