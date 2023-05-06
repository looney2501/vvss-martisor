package tasks.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import tasks.services.TasksService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ArrayTaskListIntegrationTestIT {
    private ArrayTaskList tasks;
    private TasksService service;
    //private java.util.Date start, end;
    //private SimpleDateFormat sdf;

    @BeforeEach
    void setUp() {
        tasks = new ArrayTaskList();
        service = new TasksService(tasks);
        /*sdf = Task.getDateFormat();
        try {
            start = sdf.parse("2023-05-06 11:00");
            end = sdf.parse("2023-05-06 13:00");
        } catch (ParseException e) {
            fail(e.getMessage());
        }*/
    }

    @Test
    void getObservableList() {
        Task t1 = mock(Task.class);
        Task t2 = mock(Task.class);

        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t2);

        var result = service.getObservableList();
        assertNotNull(result);
        assertEquals(3, result.size());
    }

    /*
    @Test
    void getIntervalInHours() {
        Task t1 = new Task("title", start, end, 3660);

        var result = service.getIntervalInHours(t1);

        assertEquals(result, "01:01");
    }*/

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
}
