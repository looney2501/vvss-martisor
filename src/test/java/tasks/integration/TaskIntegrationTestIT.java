package tasks.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import tasks.services.TasksService;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class TaskIntegrationTestIT {
    private ArrayTaskList tasks;
    private TasksService service;
    private java.util.Date start, end;

    private Task t1;

    @BeforeEach
    void setUp() {
        tasks = new ArrayTaskList();
        service = new TasksService(tasks);
        SimpleDateFormat sdf = Task.getDateFormat();
        try {
            start = sdf.parse("2023-05-06 11:00");
            end = sdf.parse("2023-05-06 13:00");
        } catch (ParseException e) {
            fail(e.getMessage());
        }

        String title = "title";
        t1 = new Task(title, start, end, 1);
        Task t2 = new Task(title, start, end, 2);

        tasks.add(t1);
        tasks.add(t2);
    }

    @Test
    void getObservableList() {
        var result = service.getObservableList();
        assertNotNull(result);
        assertEquals(2, result.size());
    }


    @Test
    void getIntervalInHours() {
        Task t1 = new Task("title", start, end, 3660);

        var result = service.getIntervalInHours(t1);

        assertEquals( "01:01", result);
    }

    @Test
    void formTimeUnit() {
        int unit;

        unit = 30;
        var result = service.formTimeUnit(unit);
        assertEquals("30", result);

        unit = 0;
        result = service.formTimeUnit(unit);
        assertEquals("00", result);

        unit = 3;
        result = service.formTimeUnit(unit);
        assertEquals("03", result);

        unit = -2;
        result = service.formTimeUnit(unit);
        assertEquals("0-2", result);
    }

    @Test
    void size() {
        var result = tasks.size();
        assertEquals(2, result);
    }

    @Test
    void getTask() {
        var result = tasks.getTask(0);
        assertEquals(t1, result);
    }

    @Test
    void remove() {
        var result = tasks.remove(t1);
        assertTrue(result);

        result = tasks.remove(t1);
        assertFalse(result);

        var result1 = tasks.size();
        assertEquals(1, result1);
    }
}
