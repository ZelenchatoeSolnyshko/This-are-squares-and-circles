package org.example.controller;

import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.shape.factory.MenuState;
import org.example.model.shape.factory.MyShapeFactory;
import org.example.model.shape.fill.Fill;
import org.example.view.MyFrame;
import org.example.view.MyPanel;


import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

public class Controller extends MenuState {
    private static Controller instanse;

    public static synchronized Controller getInstanse() {
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
    private MyShape sampleShape;

    /*public MenuState getState() {
        return state;

}

    public void setState(MenuState state) {
        this.state = state;
    }*/
    private MenuState menu;

    public Controller() {
        menu = new MenuState();
        MyShapeFactory sFactory = MyShapeFactory.getInstance();
        sFactory.config(menu);
        model = new Model();
        action = new ActionDraw(model, sampleShape);
        menu.setAction(action);
        MyPanel panel = new MyPanel(this);
        model.addObserver(panel);
        frame = new MyFrame();
        frame.setPanel(panel);
        Menu menuController = Menu.getInstance();
        menuController.setState(menu);
        menuController.setActionDraw(action);
        frame.setJMenuBar(menuController.createMenuBar());
        frame.revalidate();
    }
    public void getPointOne(Point2D p){
        action.mousePressed(p);
    }
    public void getPointTwo(Point2D p){
        action.mouseDragged(p);
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
}
