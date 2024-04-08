package personClasses;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private static int idCounter = 1;

    private Integer id;
    private String name;
    private Coordinates coordinates;
    private java.time.ZonedDateTime creationDate;
    private Long height;
    private java.util.Date birthday;
    private Color hairColor;
    private Country nationality;
    private Location location;

    public static void setIdCounter(int idCounter) {
        Person.idCounter = idCounter;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Person(String name, Coordinates coordinates, Long height, java.util.Date birthday, Color hairColor, Country nationality, Location location) {
        this.id = idCounter++;
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.coordinates = Objects.requireNonNull(coordinates, "personClasses.Coordinates cannot be null");
        this.creationDate = java.time.ZonedDateTime.now();
        this.height = height;
        this.birthday = birthday;
        this.hairColor = hairColor;
        this.nationality = Objects.requireNonNull(nationality, "Nationality cannot be null");
        this.location = Objects.requireNonNull(location, "personClasses.Location cannot be null");
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public java.time.ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Long getHeight() {
        return height;
    }

    public java.util.Date getBirthday() {
        return birthday;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "personClasses.Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", height=" + height +
                ", birthday=" + birthday +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }
}