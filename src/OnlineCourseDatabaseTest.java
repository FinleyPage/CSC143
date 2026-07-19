import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("no comment")
class OnlineCourseDatabaseTest {
    OnlineCourseDatabase db;
    CourseDataFilteringGui gui;
    @org.junit.jupiter.api.BeforeEach
    void setUp() throws FileNotFoundException {
        db = new OnlineCourseDatabase(new File("OnlineCourseDataset.csv"));
        gui = new CourseDataFilteringGui(db);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getCourseRecordString() {
        assertEquals("[U0500, Working Professional, Non-Tech, Coursera, 6, 22, In Progress, 85, No Dropout, 5]", db.getCourseRecordString(db.getCourseRecordAt(499)));
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(500, db.size());
    }

    @org.junit.jupiter.api.Test
    void getExperienceLevelOptions() {
        String[] ls = new String[3];
        ls[0] = "Fresher";
        ls[1] = "Student";
        ls[2] = "Working Professional";
        assertArrayEquals(ls, db.getExperienceLevelOptions());
    }

    @org.junit.jupiter.api.Test
    void getCourseTypeOptions() {
        String[] ls = new String[2];
        ls[0] = "Tech";
        ls[1] = "Non-Tech";
        assertArrayEquals(ls, db.getCourseTypeOptions());
    }

    @org.junit.jupiter.api.Test
    void getPlatformOptions() {
        String[] ls = new String[5];
        ls[0] = "Skillshare";
        ls[1] = "edX";
        ls[2] = "Coursera";
        ls[3] = "Udemy";
        ls[4] = "YouTube";
        assertArrayEquals(ls, db.getPlatformOptions());
    }

    @org.junit.jupiter.api.Test
    void getCompletionStatusOptions() {
        String[] ls = new String[3];
        ls[0] = "Completed";
        ls[1] = "Dropped";
        ls[2] = "In Progress";
        assertArrayEquals(ls, db.getCompletionStatusOptions());
    }

    @org.junit.jupiter.api.Test
    void getDropoutReasonOptions() {
        String[] ls = new String[4];
        ls[0] = "No Dropout";
        ls[1] = "Time Constraint";
        ls[2] = "Too Difficult";
        ls[3] = "Lost Interest";
        assertArrayEquals(ls, db.getDropoutReasonOptions());
    }

    @org.junit.jupiter.api.Test
    void calcFilteredAverages() {
    }

    @org.junit.jupiter.api.Test
    void iterator() {
    }
}