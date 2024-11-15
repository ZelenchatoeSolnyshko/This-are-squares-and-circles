package org.example.controller;


import lombok.Setter;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.shape.factory.MenuState;
import org.example.model.shape.factory.ShapeType;

import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


public class Menu {
    private static Menu instance;
    private JMenuBar menuBar;
    private ActionDraw actionDraw;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    private Model model;

    public MenuState getState() {
        return state;
    }

    public void setState(MenuState state) {
        this.state = state;
    }

    @Setter
    private MenuState state;
    private Menu(){
        menuBar = createMenuBar();
    }
    public static Menu getInstance(){
        if (instance == null){
            instance = new Menu();
        }
        return instance;
    }
    public JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu shapeMenu = createShapeMenu();
        menuBar.add(shapeMenu);

        return menuBar;
    }


    private JMenu createShapeMenu() {

        JMenu shapeMenu = new JMenu("Фигура");
        ButtonGroup group = new ButtonGroup();
        //поменять на фабрику
        JRadioButtonMenuItem square = new JRadioButtonMenuItem("Прямоугольник");
        square.addActionListener(e -> state.setType(ShapeType.RECTANGULAR));
        /*    MyShape sampleShape = actionDraw.getShape();
            sampleShape.setShape(new Rectangle2D.Double());
        });*/
        shapeMenu.add(square);
        group.add(square);
        JRadioButtonMenuItem ellipse = new JRadioButtonMenuItem("Эллипс");
        ellipse.addActionListener(e -> state.setType(ShapeType.ELLIPSE));
       /*     MyShape sampleShape = actionDraw.getShape();
            sampleShape.setShape(new Ellipse2D.Double());
        });*/
        shapeMenu.add(ellipse);
        group.add(ellipse);
        return shapeMenu;
    }

    public void setActionDraw(ActionDraw actionDraw) {
        this.actionDraw = actionDraw;
    }
}
