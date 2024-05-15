import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseTest {

    public static boolean hasPassedPre(List<Record> rec, Course course) {
        for (int i = 0; i < course.getPre().size(); i++) {
            boolean prePassed = false;
            for (int j = 0; j < rec.size(); j++) {
                if (rec.get(j).getCourseId() != course.getPre().get(i))
                    continue;
                if (rec.get(j).getGrade() >= 10 && (!rec.get(j).isMehman || rec.get(j).getGrade() >= 12)) {
                    prePassed = true;
                    break;
                }
            }
            if (!prePassed)
                return false;
        }
        return true;
    }

    @Test
    public void testHasPassedPre_AllPrePassed() {
        List<Record> records = new ArrayList<>(Arrays.asList(
            new Record(1, 101, 10, false),
            new Record(1, 102, 12, false)
        ));
        Course course = new Course(201, Arrays.asList(101, 102));
        assertTrue(hasPassedPre(records, course));
    }

    @Test
    public void testHasPassedPre_OnePreNotPassed() {
        List<Record> records = new ArrayList<>(Arrays.asList(
            new Record(1, 101, 10, false),
            new Record(1, 102, 9, false)
        ));
        Course course = new Course(201, Arrays.asList(101, 102));
        assertFalse(hasPassedPre(records, course));
    }

    @Test
    public void testHasPassedPre_AllPrePassedWithMehman() {
        List<Record> records = new ArrayList<>(Arrays.asList(
            new Record(1, 101, 12, true),
            new Record(1, 102, 13, true)
        ));
        Course course = new Course(201, Arrays.asList(101, 102));
        assertTrue(hasPassedPre(records, course));
    }

    @Test
    public void testHasPassedPre_OnePreNotPassedWithMehman() {
        List<Record> records = new ArrayList<>(Arrays.asList(
            new Record(1, 101, 12, true),
            new Record(1, 102, 11, true)
        ));
        Course course = new Course(201, Arrays.asList(101, 102));
        assertFalse(hasPassedPre(records, course));
    }

    @Test
    public void testHasPassedPre_NoPreRequired() {
        List<Record> records = new ArrayList<>(Arrays.asList(
            new Record(1, 101, 10, false)
        ));
        Course course = new Course(201, new ArrayList<>());
        assertTrue(hasPassedPre(records, course));
    }

    @Test
    public void testHasPassedPre_NoRecords() {
        List<Record> records = new ArrayList<>();
        Course course = new Course(201, Arrays.asList(101, 102));
        assertFalse(hasPassedPre(records, course));
    }

    // تست‌های اضافی
    @Test
    public void testHasPassedPre_EmptyPrerequisites() {
        List<Record> records = new ArrayList<>(Arrays.asList(
            new Record(1, 101, 10, false),
            new Record(1, 102, 12, false)
        ));
        Course course = new Course(201, new ArrayList<>());
        assertTrue(hasPassedPre(records, course));
    }

    @Test
    public void testHasPassedPre_AllPreFailed() {
        List<Record> records = new ArrayList<>(Arrays.asList(
            new Record(1, 101, 8, false),
            new Record(1, 102, 7, false)
        ));
        Course course = new Course(201, Arrays.asList(101, 102));
        assertFalse(hasPassedPre(records, course));
    }

    @Test
    public void testHasPassedPre_MultipleTerms() {
        List<Record> records = new ArrayList<>(Arrays.asList(
            new Record(1, 101, 10, false),
            new Record(2, 102, 12, false)
        ));
        Course course = new Course(201, Arrays.asList(101, 102));
        assertTrue(hasPassedPre(records, course));
    }

    @Test
    public void testHasPassedPre_SinglePrePassed() {
        List<Record> records = new ArrayList<>(Arrays.asList(
            new Record(1, 101, 10, false)
        ));
        Course course = new Course(201, Arrays.asList(101));
        assertTrue(hasPassedPre(records, course));
    }

    @Test
    public void testHasPassedPre_SinglePreFailed() {
        List<Record> records = new ArrayList<>(Arrays.asList(
            new Record(1, 101, 8, false)
        ));
        Course course = new Course(201, Arrays.asList(101));
        assertFalse(hasPassedPre(records, course));
    }

    @Test
    public void testHasPassedPre_ExactBoundaryNonMehman() {
        List<Record> records = new ArrayList<>(Arrays.asList(
            new Record(1, 101, 10, false)
        ));
        Course course = new Course(201, Arrays.asList(101));
        assertTrue(hasPassedPre(records, course));
    }

    @Test
    public void testHasPassedPre_ExactBoundaryMehman() {
        List<Record> records = new ArrayList<>(Arrays.asList(
            new Record(1, 101, 12, true)
        ));
        Course course = new Course(201, Arrays.asList(101));
        assertTrue(hasPassedPre(records, course));
    }

    @Test
    public void testHasPassedPre_BelowBoundaryMehman() {
        List<Record> records = new ArrayList<>(Arrays.asList(
            new Record(1, 101, 11, true)
        ));
        Course course = new Course(201, Arrays.asList(101));
        assertFalse(hasPassedPre(records, course));
    }

    @Test
    public void testHasPassedPre_MultipleRecordsSameCourse() {
        List<Record> records = new ArrayList<>(Arrays.asList(
            new Record(1, 101, 8, false),
            new Record(2, 101, 10, false)
        ));
        Course course = new Course(201, Arrays.asList(101));
        assertTrue(hasPassedPre(records, course));
    }
}
