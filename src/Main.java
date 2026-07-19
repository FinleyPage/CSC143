import java.io.File;
import java.io.FileNotFoundException;

@SuppressWarnings("no comment")
public class Main {
    private static OnlineCourseDatabase db;
    private static CourseDataFilteringGui gui;

    public static void main(String[] args) throws FileNotFoundException {
        db = new OnlineCourseDatabase(new File("OnlineCourseDataset.csv"));
        gui = new CourseDataFilteringGui(db);

    }
}
