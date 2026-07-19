/**
 *
 * This contains statistics about a group of courses
 *
 * @param recordCount           the total number of records after sort
 * @param avgHrsPerWeek         the average hours per week after sort
 * @param avgCourseDuration     the average course duration after sort
 * @param avgCompletionPercent  the average course completion percent after sort
 * @param avgSatisfactionScore  the average satisfaction score after sort
 */
public record CourseStats(int recordCount, double avgHrsPerWeek,
                          double avgCourseDuration, double avgCompletionPercent,
                          double avgSatisfactionScore) {}


