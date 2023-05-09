package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ArrayTaskListUnitTest {
    private ArrayTaskList taskList;

    @BeforeEach
    void setUp() {
        taskList = new ArrayTaskList();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        Task t1 = mock(Task.class);

        assertEquals(taskList.size(), 0);

        taskList.add(t1);

        assertEquals(taskList.size(), 1);
    }

    @Test
    void remove() {
        Task t1 = mock(Task.class);

        taskList.add(t1);

        assertEquals(taskList.size(), 1);

        taskList.remove(t1);

        assertEquals(taskList.size(), 0);
    }
}
