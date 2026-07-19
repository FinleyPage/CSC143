/**
 *
 * This contains info for a single course experience response
 *
 * @param userId                    The ID number of the user
 * @param experienceLevel           The index of the user's experience level
 * @param courseType                The index of the course type
 * @param platform                  The index of the platform type
 * @param hoursPerWeek              The hours per week taken
 * @param courseDuration            The total course duration
 * @param completionStatus          The index of the user's completion status
 * @param completionPercentage      The user's completion percentage
 * @param dropoutReason             The index of the dropout reason
 * @param satisfactionScore         The user's satisfaction score
 */
public record CourseData(String userId, byte experienceLevel,
                         byte courseType, byte platform,
                         byte hoursPerWeek, byte courseDuration,
                         byte completionStatus, byte completionPercentage,
                         byte dropoutReason, byte satisfactionScore) {}

