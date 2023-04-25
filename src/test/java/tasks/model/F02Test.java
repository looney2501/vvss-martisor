package tasks.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.ParseException;
import java.util.Date;

@Tag("NextTimeAfter")
public class F02Test {
    @Tag("NextTimeAfter")
    @DisplayName("Test null response")
    @ParameterizedTest
    @CsvSource({"2023-04-02 22:00,2023-04-01 19:00,2023-04-02 19:00,true,100",
            "2023-04-02 22:00,2023-04-01 19:00,2023-04-02 22:00,true,100",
            "2023-03-02 22:00,2023-04-01 19:00,2023-04-10 19:00,false,100"})
    void testF02NullResponse(String current,String startTime, String endTime,boolean active, int interval) throws ParseException {
        Task task = new Task();
        task.setTitle("activitate noua");
        task.setStartTime(Task.getDateFormat().parse(startTime));
        task.setEndTime(Task.getDateFormat().parse(endTime));
        task.setInterval(interval);
        if (active) {
            task.setActive(true);
        } else {
            task.setActive(false);
        }

        Assertions.assertEquals(null,
                task.nextTimeAfter(Task.getDateFormat().parse(current)));
    }

    @Tag("NextTimeAfter")
    @DisplayName("Test start time response")
    @ParameterizedTest
    @CsvSource({"2023-03-02 22:00,2023-04-01 19:00,2023-04-10 22:00,true,0",
            "2023-03-02 22:00,2023-04-01 19:00,2023-04-10 22:00,true,100",
            "2023-04-01 19:30,2023-04-01 19:00,2023-04-10 22:00,true,3600"})
    void testF02STimeResponse(String current,String startTime, String endTime,boolean active, int interval) throws ParseException {
        Task task = new Task("activitate noua",Task.getDateFormat().parse(startTime),Task.getDateFormat().parse(endTime),interval);
        if (active) {
            task.setActive(true);
        } else {
            task.setActive(false);
        }

        Assertions.assertEquals(Task.getDateFormat().parse(startTime),
                task.nextTimeAfter(Task.getDateFormat().parse(current)));
    }

    @Tag("OtherResponse")
    @DisplayName("Test Other Response Error")
    @Test
    void testF02OtherResponse() throws ParseException {
        String title2 = "activitate noua";
        String current2 = "2023-04-01 21:00";
        String startTime2 = "2023-04-01 19:00";
        String endTime2 = "2023-04-10 22:00";
        int interval2 = 100;
        Task task2 = new Task(title2,Task.getDateFormat().parse(startTime2),Task.getDateFormat().parse(endTime2),interval2);
        task2.setActive(true);

        Assertions.assertEquals(Task.getDateFormat1().parse("2023-04-01 21:01:40"),
                task2.nextTimeAfter(Task.getDateFormat().parse(current2)));


        String title = "activitate noua";
        String current = "2023-04-01 21:00";
        String startTime = "2023-04-01 19:00";
        String endTime = "2023-04-01 22:00";
        int interval = 3600;
        Task task = new Task(title,Task.getDateFormat().parse(startTime),Task.getDateFormat().parse(endTime),interval);
        task.setActive(true);

        Assertions.assertEquals(Task.getDateFormat().parse("2023-04-01 22:00"),
                task.nextTimeAfter(Task.getDateFormat().parse(current)));

        String title1 = "activitate noua";
        String current1 = "2023-04-01 21:30";
        String startTime1 = "2023-04-01 19:00";
        String endTime1 = "2023-04-01 22:00";
        int interval1 = 3600;
        Task task1 = new Task(title1,Task.getDateFormat().parse(startTime1),Task.getDateFormat().parse(endTime1),interval1);
        task1.setActive(true);

        Assertions.assertEquals(Task.getDateFormat().parse("2023-04-01 21:00"),
                task1.nextTimeAfter(Task.getDateFormat().parse(current1)));
    }
}
