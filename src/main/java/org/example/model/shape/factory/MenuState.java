package org.example.model.shape.factory;

import org.example.controller.ActionDraw;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class MenuState {
    private boolean fill;
    private Color color;
    private ShapeType type;
    private ActionDraw action;

    public MenuState() {
        color = Color.cyan;
        type = ShapeType.RECTANGULAR;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ShapeType getType() {
        return type;
    }

    public void setType(ShapeType type) {
        this.type = type;
    }

    public ActionDraw getAction() {
        return action;
    }

    public void setAction(ActionDraw action) {
        this.action = action;
    }
}
