import java.awt.Point;
import java.awt.*;
import javax.swing.*;
/**
* A fish has a position and an image associated with it.
* Get the image of the fish from the same directory as the one where the byte code of the Fish class is.
* @author Gladys Monagan
* @version November 3, 2017
*/ 
public class Fish
{
   /**
   * Name of the file used to draw the fish: images comes from SwingSet2
   */
   public static final String FISH_NAME = "fish.gif";
   // public static final String FISH_NAME = "fish_small.gif";


   private ImageIcon fishIcon;

   // the icons' dimensions
   private int width;
   private int height;

   // current position
   Point current;

   /**
   * Creates a fish and places it so that the upper left hand corner 
   * of the fish image is at the origin.
   */
   public Fish()
   {
      this(0, 0);
   }
   /**
   * Creates the fish and places it so that the upper left hand corner 
   * of the fish image is at the position (x, y)
   * @param x x-coordinate of upper left hand corner of the image
   * @param y y-coordinate of the upper left hand corner of the image
   */
   public Fish(int x, int y)
   {
      current = new Point(x, y);
      fishIcon = new ImageIcon(getClass().getResource(FISH_NAME));
      width = fishIcon.getIconWidth();
      height = fishIcon.getIconHeight();
   }
   /**
   * Paints the fish image at the current position.
   * @param the current component that will be used for drawing
   * @param g the graphics environment
   */
   public void draw(Component comp, Graphics g)
   {
      fishIcon.paintIcon(comp, g, current.x, current.y);
   }

   /**
   * Sets pt to be the upper left hand corner of the image, 
   * pt becomes the current position.
   * @param pt the point that will be used for placing the icon
   */
   public void setPosition(Point pt)
   {
      current = pt;
   }

   /**
   * Sets the x coordinate of the upper left hand corner of the image
   * @param x the x coordinate of the current position which is used
   * as the upper left hand corner of the fish image
   */
   public void setX(int x)
   {
      current.x = x;
   }
   /**
   * Sets the y coordinate of the upper left hand corner of the image
   * @param y the y coordinate of the current position which is used
   * as the upper left hand corner of the fish image
   */ 
   public void setY(int y)
   {
      current.y = y;
   }

   /**
   * @return the current position which is upper left hand corner of the image
   */
   public Point getPosition()
   {
      return current;
   }

   /**
   * @return the width of the image
   */ 
   public int getWidth()
   {
      return width;
   }
   
   /**
   * @return the height of the image
   */ 
   public int getHeight()
   {
      return height;
   }

}