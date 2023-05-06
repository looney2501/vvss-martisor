package tasks.services;

import javafx.collections.FXCollections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.ArrayTaskList;
import tasks.model.Task;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TasksServiceUnitTest {
    private ArrayTaskList tasks;
    private TasksService service;
    private java.util.Date start, end;
    private SimpleDateFormat sdf;

    @BeforeEach
    void setUp() {
        tasks = mock(ArrayTaskList.class);
        service = new TasksService(tasks);
        sdf = Task.getDateFormat();
        try {
            start = sdf.parse("2023-05-06 11:00");
            end = sdf.parse("2023-05-06 13:00");
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void getObservableList() {
        Task t1 = mock(Task.class);
        Task t2 = mock(Task.class);
        Task t3 = mock(Task.class);
        when(tasks.getAll()).thenReturn(FXCollections.observableArrayList(Arrays.asList(t1, t2, t3)));

        var result = service.getObservableList();
        assertNotNull(result);
        assertEquals(result.size(), 3);
    }

    @Test
    void getIntervalInHours() {
        Task t1 = new Task("title", start, end, 3660);

        var result = service.getIntervalInHours(t1);

        assertEquals(result, "01:01");
    }
}
