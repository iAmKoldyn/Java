public class MenuItem {
    private String id;
    private String description;

    public MenuItem(String id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return id + ": " + description;
    }
}
