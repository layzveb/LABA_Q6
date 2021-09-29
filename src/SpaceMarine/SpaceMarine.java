package SpaceMarine;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SpaceMarine implements Comparable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int health; //Значение поля должно быть больше 0
    private Boolean loyal; //Поле не может быть null
    private String achievements; //Поле может быть null
    private AstartesCategory category; //Поле не может быть null
    private Chapter chapter; //Поле может быть null

    public SpaceMarine() {

    }

    public SpaceMarine(int id, String name, Coordinates coordinates, LocalDateTime creationDate, int health, Boolean loyal, String achievements, AstartesCategory category, Chapter chapter) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.health = health;
        this.loyal = loyal;
        this.achievements = achievements;
        this.category = category;
        this.chapter = chapter;
    }


    @Override
    public String toString() {
        return new StringBuilder()
                .append("_______________________")
                .append("\n")
                .append("Id: ").append(id)
                .append("\n")
                .append("Name: ").append(name)
                .append("\n")
                .append("Coordinates: ").append(coordinates)
                .append("\n")
                .append("CreationDate: ").append(creationDate)
                .append("\n")
                .append("Health: ").append(health)
                .append("\n")
                .append("Loyal: ").append(loyal)
                .append("\n")
                .append("Category: ").append(category)
                .append("\n")
                .append((achievements == null) ? "" : "Achievements: " + achievements + "\n")
                .append((chapter == null) ? "" : "Chapter:\n" + chapter + "\n").toString();
    }

    public String getCSV() {
        return new StringBuilder()
                .append(id).append(",")
                .append(name).append(",")
                .append(coordinates.getX()).append(",")
                .append(coordinates.getY()).append(",")
                .append(creationDate).append(",")
                .append(health).append(",")
                .append(loyal).append(",")
                .append(achievements).append(",")
                .append(category).append(",")
                .append((chapter == null) ? null + "," + null :
                chapter.getName() + "," + chapter.getWorld()).toString();
    }

    @Override
    public int compareTo(Object o) {
        return this.getHealth() - ((SpaceMarine) o).getHealth();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Boolean getLoyal() {
        return loyal;
    }

    public void setLoyal(Boolean loyal) {
        this.loyal = loyal;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public AstartesCategory getCategory() {
        return category;
    }

    public void setCategory(AstartesCategory category) {
        this.category = category;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}
