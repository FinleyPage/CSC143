import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class OnlineCourseDatabase implements OnlineCourseDatabaseInterface, Iterable<CourseData> {
    private ArrayList<CourseData> courseData = new ArrayList<CourseData>();
    private ArrayList<String> experienceLevelList = new ArrayList<String>(5);
    private ArrayList<String> courseTypeList = new ArrayList<String>(5);
    private ArrayList<String> platformList = new ArrayList<String>(5);
    private ArrayList<String> completionStatusList = new ArrayList<String>(5);
    private ArrayList<String> dropoutReasonList = new ArrayList<String>(5);

    public OnlineCourseDatabase(File dbFile) throws FileNotFoundException {
        // Find sublist data
        Scanner scanner = new Scanner(dbFile);
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            for (int idx = 0; idx < parts.length; idx++) {
                if (!experienceLevelList.contains(parts[1])) {
                    experienceLevelList.add(parts[1]);
                }
                if (!courseTypeList.contains(parts[2])) {
                    courseTypeList.add(parts[2]);
                }
                if (!platformList.contains(parts[3])) {
                    platformList.add(parts[3]);
                }
                if (!completionStatusList.contains(parts[6])) {
                    completionStatusList.add(parts[6]);
                }
                if (!dropoutReasonList.contains(parts[8])) {
                    dropoutReasonList.add(parts[8]);
                }
            }
        }
        Scanner scanner1 = new Scanner(dbFile);
        scanner1.nextLine();
        while (scanner1.hasNextLine()) {
            String line = scanner1.nextLine();
            String[] parts = line.split(",");
            courseData.add(new CourseData(parts[0],
                    (byte) experienceLevelList.indexOf(parts[1]),
                    (byte) courseTypeList.indexOf(parts[2]),
                    (byte) platformList.indexOf(parts[3]),
                    (byte) Integer.parseInt(parts[4]),
                    (byte) Integer.parseInt(parts[5]),
                    (byte) completionStatusList.indexOf(parts[6]),
                    (byte) Integer.parseInt(parts[7]),
                    (byte) dropoutReasonList.indexOf(parts[8]),
                    (byte) Integer.parseInt(parts[9])
            ));
        }

        //TODO: REMOVE DEBUG MAYBE FIX DUPLICATE SCANNERS
        System.out.println(experienceLevelList);
        System.out.println(courseTypeList);
        System.out.println(platformList);
        System.out.println(completionStatusList);
        System.out.println(dropoutReasonList);
        for (CourseData data : courseData) {
            System.out.println(data);
        }
    }

    /**
     * Retrieves the course record at the specified index in the database
     *
     * @param index the index of the desired rouse record
     * @return the course record at the specified position
     */
    @Override
    public CourseData getCourseRecordAt(int index) {
        return courseData.get(index);
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
        return String.format("[%s], [%s], [%s], [%s], [%d], [%d], [%s], [%d], [%s], [%d]",
                course.userId(),
                experienceLevelList.get(course.experienceLevel()),
                courseTypeList.get(course.courseType()),
                platformList.get(course.platform()),
                course.hoursPerWeek(),
                course.courseDuration(),
                completionStatusList.get(course.completionStatus()),
                course.completionPercentage(),
                dropoutReasonList.get(course.dropoutReason()),
                course.satisfactionScore()
                );
    }

    /**
     * Returns the number of records managed by the system
     *
     * @return number of course records managed by the system
     */
    @Override
    public int size() {
        return courseData.size();
    }

    /**
     * Creates and returns an array representing all possible experience level options
     *
     * @return array containing options
     */
    @Override
    public String[] getExperienceLevelOptions() {
        String[] experienceLevelOptions = new String[experienceLevelList.size()];
        for (int idx = 0; idx < experienceLevelList.size(); idx++) {
            experienceLevelOptions[idx] = experienceLevelList.get(idx);
        }
        return experienceLevelOptions;
    }

    /**
     * Creates and returns an array representing all possible course type options
     *
     * @return array containing options
     */
    @Override
    public String[] getCourseTypeOptions() {
        String[] courseTypeOptions = new String[courseTypeList.size()];
        for (int idx = 0; idx < courseTypeList.size(); idx++) {
            courseTypeOptions[idx] = courseTypeList.get(idx);
        }
        return courseTypeOptions;
    }

    /**
     * Creates and returns an array representing all possible platformList options
     *
     * @return array containing options
     */
    @Override
    public String[] getPlatformOptions() {
        String[] platformTypeOptions = new String[platformList.size()];
        for (int idx = 0; idx < platformList.size(); idx++) {
            platformTypeOptions[idx] = platformList.get(idx);
        }
        return platformTypeOptions;
    }

    /**
     * Creates and returns an array representing all possible completion status options
     *
     * @return array containing options
     */
    @Override
    public String[] getCompletionStatusOptions() {
        String[] completionStatusOptions = new String[completionStatusList.size()];
        for (int idx = 0; idx < completionStatusList.size(); idx++) {
            completionStatusOptions[idx] = completionStatusList.get(idx);
        }
        return completionStatusOptions;
    }

    /**
     * Creates and returns an array representing all dropout options
     *
     * @return array containing options
     */
    @Override
    public String[] getDropoutReasonOptions() {
        String[] dropoutReasonOptions = new String[dropoutReasonList.size()];
        for (int idx = 0; idx < dropoutReasonList.size(); idx++) {
            dropoutReasonOptions[idx] = dropoutReasonList.get(idx);
        }
        return dropoutReasonOptions;
    }

    /**
     * Calculates and returns statistics based on filtered results
     *
     * @param experienceLevelIndex  index of the experience level to filter, or -1 for no filtering on this field
     * @param courseTypeIndex       index of the course type to filter, or -1 for no filtering on this field
     * @param platformIndex         index of the platformList to filter, or -1 for no filtering on this field
     * @param completionStatusIndex index of the completion status to filter, or -1 for no filtering on this field
     * @param dropoutReasonIndex    index of the dropout reason to filter, or -1 for no filtering on this field
     * @return statistics for the results of filtering operation.  If filtering results in no records, will contain
     * a count of 0 and other stats set to -1.0
     */
    @Override
    public CourseStats calcFilteredAverages(byte experienceLevelIndex, byte courseTypeIndex, byte platformIndex, byte completionStatusIndex, byte dropoutReasonIndex) {
        ArrayList<CourseData> filteredCourseData = new ArrayList<CourseData>();
        filteredCourseData.addAll(courseData);
        for (CourseData data : filteredCourseData) {
            if (getExperienceLevelOptions()[0] == experienceLevelIndex) {

            }
        }
        CourseStats stats = new CourseStats();
    }

    /**
     * @return
     */
    @Override
    public Iterator<CourseData> iterator() {
        return null;
    }
}
