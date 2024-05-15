package src.main.java.dramaplays.model;

public class Play {

    public String name;
    public String type;

    public Play(String name, String type) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
        this.name = name;
        this.type = type;
    }
}



