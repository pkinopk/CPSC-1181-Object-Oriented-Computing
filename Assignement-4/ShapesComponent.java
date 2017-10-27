//~ import java.awt.Graphics;
//~ import java.awt.Graphics2D;
//~ import java.awt.Polygon;
//~ import java.awt.Color;
//~ import java.awt.Font;
//~ import java.awt.BasicStroke;
//~ import java.awt.Stroke;
import java.awt.*;
//~ import java.awt.geom.Ellipse2D;
//~ import java.awt.geom.Point2D;
//~ import java.awt.geom.Line2D;
//~ import java.awt.geom.Arc2D.Double;
import java.awt.geom.*;

import javax.swing.JComponent;

// author: Gladys Monagan
// showing how some of the primitives work
// not meant as a sample of good programming but more as 'trying stuff out'
// students asked for it to be released but it's not particularly 
// object oriented and there are enough 'magic numbers' to infuriate any marker
// and you know what happens then .... 
// January 24, 2017

public class ShapesComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      // recover Graphics2D
      Graphics2D g2 = (Graphics2D) g;

      // upper left hand corner of the ellipse is at the origin
      final int ELLIPSE_WIDTH = 200;
      final int ELLIPSE_HEIGHT = 100;
      Ellipse2D.Double e = new Ellipse2D.Double(0,0, 
                           ELLIPSE_WIDTH, ELLIPSE_HEIGHT);
      g2.setColor(Color.MAGENTA);
      g2.fill(e);

      final int X_POS = 400;
      final int Y_POS = 100;
      g2.setFont(new Font("SansSerif", Font.BOLD, 32));
      // 0 is for red, 10 is for green, 255 is for blue
      g2.setColor(new Color(0, 10, 255));
      g2.drawString("drawString", X_POS, Y_POS);

      Line2D.Double longLine = new Line2D.Double(X_POS, Y_POS, X_POS+300, Y_POS);
      g2.setColor(Color.BLACK); // Color.BLACK is an object of type Object
      g2.setStroke(new BasicStroke(2.0f)); // f because a float is required
      g2.draw(longLine); 

      double x0 = 100.0, y0 = 200.0;
      Point2D.Double pt0 = new Point2D.Double(x0,y0);      
      double x1 = 500.0, y1 = 400.0;
      Point2D.Double pt1 = new Point2D.Double(x1, y1);
      // another way of converting the double 10 to a float
      BasicStroke thickStroke = new BasicStroke((float) 10.0);
      g2.setColor(Color.RED);
      g2.setStroke(thickStroke);
      g2.draw(new Line2D.Double(pt0, pt1));
      pt0.setLocation(x0, y1);
      pt1.setLocation(x1, y0);
      g2.setColor(Color.YELLOW);
      // the yellow line draws over the red line we had just drawn
      g2.draw(new Line2D.Double(pt0, pt1));
      
      //  The overall width and height of the full ellipse of 
      // which this arc is a partial section.
      double width = x1 - x0;
      double height = y1 - y0;
      // (x0, y0) is the upper left hand corner of the arc's framing rectangle
      g2.setColor(Color.ORANGE);
      Arc2D.Double arc = new Arc2D.Double(x0,  y0, width, height, 45, 90, Arc2D.PIE);
      g2.fill(arc);
      g2.setStroke(new BasicStroke(1.0f));
      g2.setColor(Color.BLACK);
      g2.draw(arc);
   }  
}