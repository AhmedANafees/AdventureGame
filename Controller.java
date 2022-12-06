import java.io.File;
import java.util.Scanner;

public class Controller {
    // initilized varibles
    private Map map;
    private Location currentLocation;
    private char currentDirection;
    private View theView;

    public Controller(String filename, View theView) {
        this.theView = theView;
        // read in form a file
        Scanner input = null;
        try {
            input = new Scanner(new File(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // file is ready for reading
        int totalLocations = input.nextInt();
        // move down a row
        input.nextLine();
        // move down
        String currentLocation = input.nextLine();

        char currentdirection = input.nextLine().charAt(0);
        Location[] locationArray = new Location[totalLocations];
        for (int i = 0; i < locationArray.length; i++) {
            // read the name of the location
            String locationName = input.nextLine();
            Scene scene[] = new Scene[4];
            for (int j = 0; j < 4; j++) {
                // read + create scenes
                currentDirection = input.next().charAt(0);
                filename = input.next();
                boolean isBlocked = input.nextBoolean();
                String nextLocationName;
                char nextDirection;
                if (isBlocked == false) {
                    nextLocationName = input.next();
                    nextDirection = input.next().charAt(0);
                } else {
                    nextLocationName = null;
                    nextDirection = ' ';
                }
                input.nextLine();
                // add scenes to array
                scene[j] = new Scene(filename, currentDirection, isBlocked, nextLocationName, nextDirection);
            }
            // make location and add location to it
            locationArray[i] = new Location(locationName, scene);

            locationArray[i] = new Location(locationName, scene);
            if (locationArray[i].getName().equals(currentLocation)) {
                this.currentLocation = locationArray[i];
                System.out.println("set");
            }
        }
        this.map = new Map(locationArray);
        this.currentDirection = currentdirection;
        this.theView.setImage(this.currentLocation.getScene(this.currentDirection).getImage());
    }

    public void turnLeft() {
        if (this.currentDirection == 'N') {
            this.currentDirection = 'W';
            this.theView.setImage(this.currentLocation.getScene(this.currentDirection).getImage());
        } else if (this.currentDirection == 'E') {
            this.currentDirection = 'N';
            this.theView.setImage(this.currentLocation.getScene(this.currentDirection).getImage());
        } else if (this.currentDirection == 'S') {
            this.currentDirection = 'E';
            this.theView.setImage(this.currentLocation.getScene(this.currentDirection).getImage());
        } else if (this.currentDirection == 'W') {
            this.currentDirection = 'S';
            this.theView.setImage(this.currentLocation.getScene(this.currentDirection).getImage());
        }
    }

    public void turnRight() {
        if (this.currentDirection == 'N') {
            this.currentDirection = 'E';
            this.theView.setImage(this.currentLocation.getScene(this.currentDirection).getImage());
        } else if (this.currentDirection == 'E') {
            this.currentDirection = 'S';
            this.theView.setImage(this.currentLocation.getScene(this.currentDirection).getImage());
        } else if (this.currentDirection == 'S') {
            this.currentDirection = 'W';
            this.theView.setImage(this.currentLocation.getScene(this.currentDirection).getImage());
        } else if (this.currentDirection == 'W') {
            this.currentDirection = 'N';
            this.theView.setImage(this.currentLocation.getScene(this.currentDirection).getImage());
        }
    }

    public void moveForward() {
        if (!this.currentLocation.getScene(this.currentDirection).isBlocked()) {

            this.currentLocation = this.map
                    .getLocation(this.currentLocation.getScene(this.currentDirection).getNextLocation());
            if (this.currentLocation.getScene(this.currentDirection).getNextDirection() != ' ') {
                this.currentDirection = this.currentLocation.getScene(this.currentDirection).getNextDirection();
            }
        }

        this.theView.setImage(this.currentLocation.getScene(this.currentDirection).getImage());
    }
}