package SpaceMarine;


public class Chapter{
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String world; //Поле не может быть null

    public Chapter() {
    }

    public Chapter(String name, String world) {
        this.name = name;
        this.world = world;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("\tName: ").append(name).append("\n").append("\tWorld: ").append(world).append("\n").toString();
    }
}