package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskUnitTest {
    private Task task;
    private Date start, end;
    private SimpleDateFormat sdf;

    @BeforeEach
    void setUp() {
        sdf = Task.getDateFormat();
        try {
            start = sdf.parse("2023-05-06 11:00");
            end = sdf.parse("2023-05-06 13:00");
        } catch (ParseException e) {
            fail(e.getMessage());
        }
        task = new Task("tema lab", start, end, 1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTitle() {
        assertEquals("tema lab", task.getTitle(), "Task title name should be \'tema lab\'");
    }

    @Test
    void createTask() {
        Task task1 = new Task("lab", start, end, 1);
        assertNotEquals(task1, null);
        assertEquals(task1.getTitle(), "lab");
        assertEquals(task1.getStartTime(), start);
        assertEquals(task1.getEndTime(), end);
        assertEquals(task1.getRepeatInterval(), 1);
    }
}
