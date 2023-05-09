package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

@Tag("TaskTests")
class TaskTest {

    @Tag("CreateTask")
    @DisplayName("Test Happy Flow")
    @Test
    void testCreateTaskHappyFlow() throws ParseException {
        Task task = new Task("activitate noua", Task.getDateFormat().parse("2023-06-10 13:00"), Task.getDateFormat().parse("2023-06-11 13:00"), 0);

        //convert String to Date
        Date startTimetoDate = Task.getDateFormat().parse("2023-06-10 13:00");
        Date endTimetoDate = Task.getDateFormat().parse("2023-06-11 13:00");

        Assertions.assertEquals("activitate noua", task.getTitle());
        Assertions.assertEquals(startTimetoDate, task.getStartTime());
        Assertions.assertEquals(endTimetoDate, task.getEndTime());
        Assertions.assertEquals(0, task.getRepeatInterval());

        Task task1 = new Task("activitate noua", Task.getDateFormat().parse("2023-09-25 19:00"), Task.getDateFormat().parse("2023-09-25 19:00"), 0);

        //convert String to Date
        Date startTimetoDate1 = Task.getDateFormat().parse("2023-09-25 19:00");
        Date endTimetoDate1 = Task.getDateFormat().parse("2023-09-25 19:00");

        Assertions.assertEquals("activitate noua", task1.getTitle());
        Assertions.assertEquals(startTimetoDate1, task1.getStartTime());
        Assertions.assertEquals(endTimetoDate1, task1.getEndTime());
        Assertions.assertEquals(0, task1.getRepeatInterval());

        Task task2 = new Task("activitate noua", Task.getDateFormat().parse("2023-09-25 19:00"), Task.getDateFormat().parse("2023-09-25 23:00"), 1);

        //convert String to Date
        Date startTimetoDate2 = Task.getDateFormat().parse("2023-09-25 19:00");
        Date endTimetoDate2 = Task.getDateFormat().parse("2023-09-25 23:00");

        Assertions.assertEquals("activitate noua", task2.getTitle());
        Assertions.assertEquals(startTimetoDate2, task2.getStartTime());
        Assertions.assertEquals(endTimetoDate2, task2.getEndTime());
        Assertions.assertEquals(1, task2.getRepeatInterval());
    }

    @Tag("CreateTask")
    @DisplayName("Test End Start time error")
    @Test
    void testCreateTaskEndStartTimeError() throws ParseException {
        try {
            Task task = new Task("activitate noua", Task.getDateFormat().parse("2023-06-11 13:00"), Task.getDateFormat().parse("2023-06-10 13:00"), 0);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), "endTime before startTime");
        }

        try {
            Task task = new Task("activitate noua", Task.getDateFormat().parse("2023-06-13 13:00"), Task.getDateFormat().parse("2023-06-11 13:00"), -10);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), "endTime before startTime");
        }

        try {
            Task task = new Task("activitate noua", Task.getDateFormat().parse("2023-09-25 19:00"), Task.getDateFormat().parse("2023-09-25 18:59"), 2);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), "endTime before startTime");
        }
    }

    @Tag("CreateTask")
    @DisplayName("Test Interval Error")
    @Test
    void testCreateTaskIntervalError() throws ParseException {
        String title = "activitate noua";
        String startTime = "2023-06-10 13:00";
        String endTime = "2023-06-10 14:00";
        int interval = -5;
        try {
            Task task = new Task(title, Task.getDateFormat().parse(startTime), Task.getDateFormat().parse(endTime), interval);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), "interval not admitted");
        }

        String title1 = "activitate noua";
        String startTime1 = "2023-09-25 19:00";
        String endTime1 = "2023-09-25 23:00";
        int interval1 = -1;
        try {
            Task task = new Task(title1, Task.getDateFormat().parse(startTime1), Task.getDateFormat().parse(endTime1), interval1);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), "interval not admitted");
        }
    }
}
