public class Record {
    int termId;
    int courseId;
    double grade;
    boolean isMehman;

    public Record(int termId, int courseId, double grade, boolean isMehman) {
        this.termId = termId;
        this.courseId = courseId;
        this.grade = grade;
        this.isMehman = isMehman;
    }

    public int getTermId() {
        return termId;
    }

    public int getCourseId() {
        return courseId;
    }

    public double getGrade() {
        return grade;
    }

    public boolean isMehman() {
        return isMehman;
    }
}
