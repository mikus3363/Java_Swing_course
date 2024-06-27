package kursJava;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class NonComponentMain {

    public static Shape createRectangle(final double width,
                                        final double height) {
        return new Rectangle2D.Double(0, 0, width, height);
    }

    public static Shape createEllipse(final double width,
                                      final double height) {
        return new Ellipse2D.Double(0, 0, width, height);
    }

    public static Shape createCircle(final double radius) {
        return createEllipse(radius + radius, radius + radius);
    }

    public static class MoveableShapeHolder {
        private final Shape shape;
        private final Paint paint;
        private final Rectangle2D originalBounds;
        private double offsetX, offsetY;

        public MoveableShapeHolder(final Shape shape,
                                   final Paint paint) {
            this.shape = Objects.requireNonNull(shape);
            this.paint = paint;
            offsetX = offsetY = 0;
            originalBounds = shape.getBounds2D();
        }

        public void paint(final Graphics2D g2d) {
            final AffineTransform originalAffineTransform = g2d.getTransform();
            final Paint originalPaint = g2d.getPaint();
            g2d.translate(offsetX, offsetY);
            if (paint != null)
                g2d.setPaint(paint);
            g2d.fill(shape);
            g2d.setPaint(originalPaint);
            g2d.setTransform(originalAffineTransform);
        }

        public void moveTo(final double newBoundsCenterX,
                           final double newBoundsCenterY) {
            offsetX = newBoundsCenterX - originalBounds.getCenterX();
            offsetY = newBoundsCenterY - originalBounds.getCenterY();
        }

        public void moveBy(final double dx,
                           final double dy) {
            offsetX += dx;
            offsetY += dy;
        }

        public boolean contains(final Point2D pt) {
            return shape.contains(pt.getX() - offsetX, pt.getY() - offsetY);
        }

        public Point2D getTopLeft() {
            return new Point2D.Double(offsetX + originalBounds.getX(), offsetY + originalBounds.getY());
        }

        public Point2D getCenter() {
            return new Point2D.Double(offsetX + originalBounds.getCenterX(), offsetY + originalBounds.getCenterY()); //Like 'getTopLeft' but with adding half the size.
        }

        public Point2D getBottomRight() {
            return new Point2D.Double(offsetX + originalBounds.getMaxX(), offsetY + originalBounds.getMaxY()); //Like 'getTopLeft' but with adding the size of the bounds.
        }
    }

    public static class DrawPanel extends JPanel {

//        private class MouseDrag extends MouseAdapter {
//            private MoveableShapeHolder current;
//            private Point origin;
//            private Point2D center;
//
//            @Override
//            public void mousePressed(final MouseEvent e) {
//                current = null;
//                center = null;
//                final Point evtLoc = e.getPoint();
//                for (final MoveableShapeHolder moveable: moveables)
//                    if (moveable.contains(evtLoc))
//                        current = moveable; //Keep the last moveable found to contain the click point! It's important to be the last one, because the later the moveable appears in the collection, the closer to top its layer.
//
//                if (current != null) { //If a shape was clicked...
//
//                    //Initialize MouseDrag's state:
//                    origin = e.getPoint();
//                    center = current.getCenter();
//
//                    //Move to topmost layer:
//                    moveables.remove(current); //Remove from its current position.
//                    moveables.add(current); //Move to last (topmost layer).
//
//                    //Rapaint panel:
//                    repaint();
//                }
//            }
//
//            @Override
//            public void mouseDragged(final MouseEvent e) {
//                if (current != null) { //If we are dragging something (and not empty space), then:
//                    current.moveTo(center.getX() + e.getX() - origin.x, center.getY() + e.getY() - origin.y);
//                    repaint();
//                }
//            }
//
//            @Override
//            public void mouseReleased(final MouseEvent e) {
//                current = null;
//                origin = null;
//                center = null;
//            }
//        }

        private final LinkedHashSet<MoveableShapeHolder> moveables;

        public DrawPanel() {
            moveables = new LinkedHashSet<>();
            //final MouseAdapter ma = new MouseDrag();
            //super.addMouseMotionListener(ma);
            //super.addMouseListener(ma);
        }

        /**
         * Warning: all operations on the returned value must be made on the EDT.
         * @return
         */
        public Collection<MoveableShapeHolder> getMoveables() {
            return moveables;
        }

        @Override
        protected void paintComponent(final Graphics g) {
            super.paintComponent(g);
            moveables.forEach(moveable -> moveable.paint((Graphics2D) g)); //Topmost moveable is painted last.
        }

        @Override
        public Dimension getPreferredSize() {
            if (isPreferredSizeSet())
                return super.getPreferredSize();
            final Dimension preferredSize = new Dimension();
            moveables.forEach(moveable -> {
                final Point2D max = moveable.getBottomRight();
                preferredSize.width = Math.max(preferredSize.width, (int) Math.ceil(max.getX()));
                preferredSize.height = Math.max(preferredSize.height, (int) Math.ceil(max.getY()));
            });
            return preferredSize;
        }
    }

    private static void createAndShowGUI() {
        final DrawPanel drawPanel = new DrawPanel();
        final Collection<MoveableShapeHolder> moveables = drawPanel.getMoveables();

        MoveableShapeHolder moveable = new MoveableShapeHolder(createRectangle(100, 50), Color.RED);
        moveable.moveTo(100, 75);
        moveables.add(moveable);

//        moveable = new MoveableShapeHolder(createCircle(40), Color.GREEN);
//        moveable.moveTo(125, 100);
//        moveables.add(moveable);
//
//        moveable = new MoveableShapeHolder(createRectangle(25, 75), Color.BLUE);
//        moveable.moveTo(125, 75);
//        moveables.add(moveable);

        final JFrame frame = new JFrame("Click to drag");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(drawPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
