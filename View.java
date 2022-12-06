import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Creates the main screen that displays everything
 * 
 * @author Mr. Lamont
 */
public class View extends JFrame implements ActionListener {

  // all the parts on the screen
  private PicturePanel picturePanel;
  private JButton forward;
  private JButton turnRight;
  private JButton turnLeft;
  private Controller controller;

  /**
   * Constructor for the main screen
   */
  public View() {
    // create and add everything to the screen
    initializeComponents();
    this.controller = new Controller("pics.txt", this);
  }

  /**
   * Create and add all parts to the screen
   */
  private void initializeComponents() {
    // set the size of our JFrame
    this.setSize(800, 600);

    // create the JPanel with a BoarderLayout
    JPanel mainPanel = new JPanel(new BorderLayout());

    // create the different buttons
    this.forward = new JButton("Forward");
    this.turnLeft = new JButton("Turn Left");
    this.turnRight = new JButton("Turn Right");

    // add the actionListeners
    this.forward.addActionListener(this);
    this.turnLeft.addActionListener(this);
    this.turnRight.addActionListener(this);

    // set action commands
    this.forward.setActionCommand("forward");
    this.turnLeft.setActionCommand("left");
    this.turnRight.setActionCommand("right");

    // create the picture panel
    this.picturePanel = new PicturePanel();

    // add all components in the correct spot
    mainPanel.add(this.turnRight, BorderLayout.LINE_END);
    mainPanel.add(this.forward, BorderLayout.PAGE_END);
    mainPanel.add(this.turnLeft, BorderLayout.LINE_START);
    mainPanel.add(this.picturePanel, BorderLayout.CENTER);

    // add panel to the frame
    this.add(mainPanel);
    // set the X in the corner to close things down
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    // show the frame
    this.setVisible(true);
  }

  /**
   * Sets the image to display on the sceen
   * 
   * @param image the image to display
   */
  public void setImage(BufferedImage image) {
    this.picturePanel.setImage(image);
  }

  /**
   * The method called when a button is pressed
   * 
   * @param e The actionEvent created from the button press
   */
  public void actionPerformed(ActionEvent e) {
    // determine the action command
    String command = e.getActionCommand();
    // use a switch case to do the movement
    if (command.equals("forward")) {
      // code to move forward
      controller.moveForward();

    } else if (command.equals("right")) {
      // code to turn right
      controller.turnRight();
    } else if (command.equals("left")) {
      // code to turn left
      controller.turnLeft();
    }

  }

}