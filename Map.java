public class Map {
    private Location[] locations;

    public Map(Location[] locations) {
        this.locations = locations;
    }

    public Location getLocation(String name) {
        for (int i = 0; i < this.locations.length; i++) {
            if (this.locations[i].getName().equals(name)) {
                return this.locations[i];
            }
        }
        return null;
    }
}
