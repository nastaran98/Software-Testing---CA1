import java.util.List;

public class Course {
    int id;
    List<Integer> pre;

    public Course(int id, List<Integer> pre) {
        this.id = id;
        this.pre = pre;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getPre() {
        return pre;
    }
}
