package personClasses;

import java.util.Objects;

public class Location {
    private static final int MAX_NAME_LENGTH = 929;

    private long x;
    private Integer y;
    private String name;

    public Location(long x, Integer y, String name) {
        this.x = x;
        this.y = Objects.requireNonNull(y, "Y coordinate cannot be null");
        this.name = Objects.requireNonNull(name, "personClasses.Location name cannot be null");
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("personClasses.Location name exceeds maximum length");
        }
    }

    // Getters and Setters

    @Override
    public String toString() {
        return "personClasses.Location{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}