package org.example.controller;

import org.example.controller.action.ActionDraw;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.fill.NoFill;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Controller {
    private Model model;
    private MyFrame frame;
    private MyPanel panel;
    private Point2D [] pd;
    private MyShape shape;

    private ActionDraw actionDraw;

    public Controller() {
        model = new Model();
        shape = new MyShape(Color.CYAN, new Rectangle2D.Double(), new NoFill());

        panel = new MyPanel();
        panel.setController(this);

        model.addObserver(panel);

        frame = new MyFrame();
        frame.setPanel(panel);

        actionDraw = new ActionDraw(model);
        actionDraw.setSampleShape(shape);

        pd = new Point2D[2];
    }
    public void getPointOne(Point2D p){
        pd[0] = p;
    }
    public void getPointTwo(Point2D p){
        pd[1] = p;
        model.changeShape(pd);
    }

    public void mousePressed(Point point) {
        actionDraw.createShape(point);
    }

    public void mouseDragget(Point point) {
        actionDraw.stretchShape(point);
    }

    public void repaintAllModels(Graphics2D graphics) {
        model.getList().forEach(myShape -> myShape.draw(graphics));
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
}
