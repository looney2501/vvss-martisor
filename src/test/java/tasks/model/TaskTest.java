package tasks.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@Tag("TaskTests")
class TaskTest {

    @Tag("CreateTask")
    @DisplayName("Test Happy Flow")
    @ParameterizedTest
    @CsvSource({"activitate noua,2023-06-10 13:00,2023-06-11 13:00,0",
            "activitate noua,2023-09-25 19:00,2023-09-25 19:00,0",
            "activitate noua,2023-09-25 19:00,2023-09-25 23:00,1"})
    void testCreateTaskHappyFlow(String title,String startTime, String endTime, int interval) throws ParseException {
        Task task = new Task(title,Task.getDateFormat().parse(startTime),Task.getDateFormat().parse(endTime),interval);

        //convert String to Date
        Date startTimetoDate = Task.getDateFormat().parse(startTime);
        Date endTimetoDate = Task.getDateFormat().parse(endTime);

        Assertions.assertEquals(title,task.getTitle());
        Assertions.assertEquals(startTimetoDate,task.getStartTime());
        Assertions.assertEquals(endTimetoDate,task.getEndTime());
        Assertions.assertEquals(interval,task.getRepeatInterval());
    }

    @Tag("CreateTask")
    @DisplayName("Test End Start time error")
    @ParameterizedTest
    @CsvSource({"activitate noua,2023-06-11 13:00,2023-06-10 13:00,0",
            "activitate noua,2023-06-13 13:00,2023-06-11 13:00,-10",
            "activitate noua,2023-09-25 19:00,2023-09-25 18:59,2"})
    void testCreateTaskEndStartTimeError(String title,String startTime, String endTime, int interval) throws ParseException {
        try{
            Task task = new Task(title,Task.getDateFormat().parse(startTime),Task.getDateFormat().parse(endTime),interval);
        }catch(IllegalArgumentException e) {
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
        try{
            Task task = new Task(title,Task.getDateFormat().parse(startTime),Task.getDateFormat().parse(endTime),interval);
        }catch(IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), "interval not admitted");
        }

        String title1 = "activitate noua";
        String startTime1 = "2023-09-25 19:00";
        String endTime1 = "2023-09-25 23:00";
        int interval1 = -1;
        try{
            Task task = new Task(title1,Task.getDateFormat().parse(startTime1),Task.getDateFormat().parse(endTime1),interval1);
        }catch(IllegalArgumentException e) {
            Assertions.assertEquals(e.getMessage(), "interval not admitted");
        }
    }
}
