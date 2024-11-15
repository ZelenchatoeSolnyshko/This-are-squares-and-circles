package org.example.controller;

import lombok.Getter;
import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;

public class ActionDraw {
    private MyShape sampleShape;
    @Getter
    private MyShape shape;
    private Point2D firstPoint;
    private Point2D secondPoint;
    private Model model;

    public ActionDraw(Model model, MyShape shape) {
        this.model = model;
        this.shape = shape;
    }

    public void stretchShape(Point point) {
        secondPoint = point;
        shape.setFrame(firstPoint, secondPoint);
        model.update();
    }
    public void createShape(Point point) {
        firstPoint = point;
        shape = shape.clone();
        model.createCurrentShape(shape);
        model.update();
    }
}
