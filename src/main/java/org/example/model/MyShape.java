package org.example.model;

import org.example.model.fill.Fill;
import org.example.model.fill.FillBehavior;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class MyShape implements Cloneable{
    private Color color;
    private RectangularShape shape;
    private FillBehavior fb;

    public MyShape(RectangularShape shape) {
        this.shape = shape;
        color = Color.GRAY;
        fb = new Fill();
        fb.setColor(color);
        fb.serShape(shape);
    }

    public MyShape() {
        color = Color.BLUE;
        shape = new Rectangle2D.Double();
        fb = new Fill();
        fb.setColor(color);
        fb.serShape(shape);
    }

    public MyShape(Color color, RectangularShape shape, FillBehavior fb) {
        this.color = color;
        this.shape = shape;
        this.fb = fb;
        this.fb.serShape(shape);
        this.fb.setColor(color);
    }

    public void setFb(FillBehavior fb) {
        this.fb = fb;
        fb.serShape(shape);
        fb.setColor(color);
    }

    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }

    public void setFrame(Point2D[] pd) {
        shape.setFrameFromDiagonal(pd[0], pd[1]);
    }

    public void draw(Graphics2D g) {
        Paint paint = g.getPaint();
        g.setColor(color);
        fb.serShape(shape);
        fb.draw(g);
        g.setPaint(paint);
    }

    @Override
    public MyShape clone() {
        MyShape clone = new MyShape();
        clone.color = this.color;
        clone.fb = this.fb;
        clone.setShape((RectangularShape) this.shape.clone());
        return clone;
    }

}
