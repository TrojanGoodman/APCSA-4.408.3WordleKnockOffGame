import java.awt.*;
import java.awt.Rectangle;
import javax.swing.*;

import java.net.URI;
import java.net.URL;

public class swing {

  public static void main(String[] args) throws Exception {

    JOptionPane.showMessageDialog(null, "Hello World");

    // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    // Part 1 of 4
    System.out.println("Part 1 of 4 -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

    // Run the following. DONE: modify it to print “Hello, name!”, displaying the
    // name that the user typed in.

    String name = JOptionPane.showInputDialog("What is your name?");
    System.out.println("Hello, " + name + "!");

    // In addition to saying “Hello, name!” in the console, can you say "Hello,
    // name!" in a JOptionPane MessageDialog?
    // DONE: say "Hello, name!" in a JOptionPane MessageDialog

    JOptionPane.showMessageDialog(null, "Hello, " + name + "!");

    // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    // Part 2 of 4
    System.out.println("Part 2 of 4 -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

    // DONE: Write code so that the dialog continues with the message
    // “My name is Hal! What would you like me to do?” Discard the user’s input and
    // display a message such as I'm sorry, Dave. I'm afraid I can't do that.
    // Replace Dave with the name that was provided by the user. Display the "I'm
    // sorry" message using a JOptionPane MessageDialog.

    JOptionPane.showInputDialog("My name is Hal! What would you like me to do?");
    JOptionPane.showMessageDialog(null,
        "I'm sorry, " + name + ". I'm afraid I can't do that.");

    // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    // Part 3 of 4
    System.out.println("Part 3 of 4 -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

    // Run the following. DONE: modify it to show a different greeting and image.
    // Look up your own image on the internet!

    // Examples...
    // URI imageUri = new URI("https://www.oracle.com/a/pr/img/rc94-news-logo.png");
    // URI imageUri = new URI("https://docs.oracle.com/cd/E19199-01/816-6873/sun.gif");
    // URI imageUri = new URI("https://blogs.oracle.com/wp-content/uploads/sites/108/2025/11/Java-horz-clr-16-1.png");
    
    URI imageUri = new URI("https://upload.wikimedia.org/wikipedia/commons/3/3f/LogoJava.svg");
    URL imageLocation = imageUri.toURL();
    ImageIcon icon = new ImageIcon(imageLocation);
    JOptionPane.showMessageDialog(null, "Welcome, " + name + "!", "Title",
        JOptionPane.PLAIN_MESSAGE, icon);

    // -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    // Part 4 of 4
    System.out.println("Part 4 of 4 -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

    // In this exercise, you will explore a simple way of visualizing a Rectangle
    // object. The setBounds method of the JFrame class moves a frame window to a
    // given rectangle. Complete the following program to visually show the
    // translate method of the Rectangle class.

    // **NOTE**: In computer science, the y-axis is inverted and 0,0 is in the
    // top-left corner of the screen.

    // Construct a frame and show it
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    // DONE: Construct a rectangle and set the frame bounds

    Rectangle rect = new Rectangle(100, 100, 300, 200);
    frame.setBounds(rect);

    JOptionPane.showMessageDialog(frame, "Click OK to move the box");

    // DONE: Move the rectangle and set the frame bounds again

    rect.translate(100, 50);
    frame.setBounds(rect);

    JOptionPane.showMessageDialog(frame, "Click OK to move the box AGAIN!!!!!");

    // DONE: Translate the rectangle again and set the frame bounds
    // again

    rect.translate(100, 50);
    frame.setBounds(rect);
  }
}