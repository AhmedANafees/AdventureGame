public class Location {
    private String name;
    private Scene[] scenes;

    public Location(String name, Scene[] scenes) {
        this.name = name;
        this.scenes = scenes;

    }

    public String getName() {
        return this.name;
    }

    public Scene getScene(char direction) {
        for (int i = 0; i < this.scenes.length; i++) {
            if (this.scenes[i].getDirection() == direction) {
                return this.scenes[i];
            }
        }
        return null;
    }
}
