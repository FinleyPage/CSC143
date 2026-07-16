import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class OnlineCourseDatabase implements OnlineCourseDatabaseInterface, Iterable<CourseData> {
    private ArrayList<CourseData> courseData;

    public OnlineCourseDatabase(File dbFile) throws FileNotFoundException {
        ArrayList<String> experienceLevel = new ArrayList<String>(5);
        ArrayList<String> courseType = new ArrayList<String>(5);
        ArrayList<String> platform = new ArrayList<String>(5);
        ArrayList<String> completionStatus = new ArrayList<String>(5);
        ArrayList<String> dropoutReason = new ArrayList<String>(5);


        // Find sublist data
        Scanner scanner = new Scanner(dbFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            for (int idx = 0; idx < parts.length; idx++) {
                if (!experienceLevel.contains(parts[1])) {
                    experienceLevel.add(parts[1]);
                }
                if (!courseType.contains(parts[2])) {
                    courseType.add(parts[2]);
                }
                if (!platform.contains(parts[3])) {
                    platform.add(parts[3]);
                }
                if (!completionStatus.contains(parts[6])) {
                    completionStatus.add(parts[6]);
                }
                if (!dropoutReason.contains(parts[8])) {
                    dropoutReason.add(parts[8]);
                }
            }
        }
            // Load course results data
    }

    /**
     * Retrieves the course record at the specified index in the database
     *
     * @param index the index of the desired rouse record
     * @return the course record at the specified position
     */
    @Override
    public CourseData getCourseRecordAt(int index) {
        return null;
    }

    /**
     * Retrieves a course record with all student option indexes turned into descriptive strings.
     * For example, with the last row of data in the sample file, this string would be returned:
     * "[U0500, Working Professional, Non-Tech, Coursera, 6, 22, In Progress, 85, No Dropout, 5]"
     *
     * @param course online course record to render
     * @return human-readable, complete representation of the course record
     */
    @Override
    public String getCourseRecordString(CourseData course) {
        return "";
    }

    /**
     * Returns the number of records managed by the system
     *
     * @return number of course records managed by the system
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Creates and returns an array representing all possible experience level options
     *
     * @return array containing options
     */
    @Override
    public String[] getExperienceLevelOptions() {
        return new String[0];
    }

    /**
     * Creates and returns an array representing all possible course type options
     *
     * @return array containing options
     */
    @Override
    public String[] getCourseTypeOptions() {
        return new String[0];
    }

    /**
     * Creates and returns an array representing all possible platform options
     *
     * @return array containing options
     */
    @Override
    public String[] getPlatformOptions() {
        return new String[0];
    }

    /**
     * Creates and returns an array representing all possible completion status options
     *
     * @return array containing options
     */
    @Override
    public String[] getCompletionStatusOptions() {
        return new String[0];
    }

    /**
     * Creates and returns an array representing all dropout options
     *
     * @return array containing options
     */
    @Override
    public String[] getDropoutReasonOptions() {
        return new String[0];
    }

    /**
     * Calculates and returns statistics based on filtered results
     *
     * @param experienceLevelIndex  index of the experience level to filter, or -1 for no filtering on this field
     * @param courseTypeIndex       index of the course type to filter, or -1 for no filtering on this field
     * @param platformIndex         index of the platform to filter, or -1 for no filtering on this field
     * @param completionStatusIndex index of the completion status to filter, or -1 for no filtering on this field
     * @param dropoutReasonIndex    index of the dropout reason to filter, or -1 for no filtering on this field
     * @return statistics for the results of filtering operation.  If filtering results in no records, will contain
     * a count of 0 and other stats set to -1.0
     */
    @Override
    public CourseStats calcFilteredAverages(byte experienceLevelIndex, byte courseTypeIndex, byte platformIndex, byte completionStatusIndex, byte dropoutReasonIndex) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Iterator<CourseData> iterator() {
        return null;
    }
}
