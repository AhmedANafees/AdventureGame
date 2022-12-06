import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Scene {
    private BufferedImage image;
    private char direction;
    private boolean isBlocked;
    private String nextLocationName;
    private char nextDirection;

    public Scene(String filename, char direction, boolean isBlocked, String nextLocationName, char nextDirection) {
        this.direction = direction;
        this.isBlocked = isBlocked;
        this.nextLocationName = nextLocationName;
        this.nextDirection = nextDirection;
        // load the picture
        this.image = null;
      
        
        try {
            // try to load the pictures from file
            this.image = ImageIO.read(new File("images/" + filename));
        } catch (Exception e) {
            // print ou the error
            e.printStackTrace();
        }
        

    }

    public BufferedImage getImage() {
        return this.image;
    }

    public char getDirection() {
        return this.direction;
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public String getNextLocation() {
        return this.nextLocationName;
    }

    public char getNextDirection() {
        return this.nextDirection;
    }
}
