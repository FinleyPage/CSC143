import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static OnlineCourseDatabase db;
    private static CourseDataFilteringGui gui;

    public static void main(String[] args) throws FileNotFoundException {
        db = new OnlineCourseDatabase(new File("OnlineCourseDataset.csv"));
        //gui = new CourseDataFilteringGui(db);

    }
}
