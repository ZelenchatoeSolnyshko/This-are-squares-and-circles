package org.example.controller;

import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.fill.Fill;
import org.example.model.fill.NoFill;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Controller {
    private static Controller instanse;

    public static Controller getInstanse() {
        if(instanse == null)
        {
            instanse = new Controller();
        }
        return instanse;
    }

    private Model model;
    private MyFrame frame;
    private MyPanel panel;
    private Point2D firstPoint;
    private Point2D secondPoint;
    private ActionDraw action;

    public Controller() {
        model = new Model();
        MyShape sampleShape = new MyShape(new Rectangle2D.Double());
        Fill fill = new Fill();
        fill.setColor(Color.cyan);
        sampleShape.setFb(fill);
        action = new ActionDraw(model, sampleShape);
        MyPanel panel = new MyPanel(this, action);
        model.addObserver(panel);
        frame = new MyFrame();
        frame.setPanel(panel);
    }
    public void getPointOne(Point2D p){
        action.createShape((Point) p);
    }
    public void getPointTwo(Point2D p){
        action.stretchShape((Point) p);
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
}
