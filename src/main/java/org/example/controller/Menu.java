package org.example.controller;


import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.shape.factory.MenuState;
import org.example.model.shape.factory.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


public class Menu extends MenuState {
    private static Menu instance;
    private JMenuBar menuBar;
    private ActionDraw actionDraw;
    private Model model;
    private MyShape shape;



    public MenuState getState() {
        return state;
    }

    public void setState(MenuState state) {
        this.state = state;
    }

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
        JMenu colorMenu = createColorMenu();
        menuBar.add(shapeMenu);
        menuBar.add(colorMenu);

        return menuBar;
    }


    private JMenu createShapeMenu() {

        JMenu shapeMenu = new JMenu("Фигура");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem square = new JRadioButtonMenuItem("Прямоугольник");
        square.addActionListener(e -> state.setType(ShapeType.RECTANGULAR));
        shapeMenu.add(square);
        group.add(square);
        JRadioButtonMenuItem ellipse = new JRadioButtonMenuItem("Эллипс");
        ellipse.addActionListener(e -> state.setType(ShapeType.ELLIPSE));
        shapeMenu.add(ellipse);
        group.add(ellipse);
        return shapeMenu;
    }
    private JMenu createColorMenu() {
        JMenu colorMenu = new JMenu("Цвет");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Синий");
        blue.addActionListener(e -> state.setColor(Color.BLUE));
        colorMenu.add(blue);
        group.add(blue);
        JRadioButtonMenuItem red = new JRadioButtonMenuItem("Красный");
        red.addActionListener(e -> state.setColor(Color.RED));
        colorMenu.add(red);
        group.add(red);
        JRadioButtonMenuItem orange = new JRadioButtonMenuItem("Оранжевый");
        orange.addActionListener(e -> state.setColor(Color.ORANGE));
        colorMenu.add(orange);
        group.add(orange);
        JRadioButtonMenuItem green = new JRadioButtonMenuItem("Зелёный");
        green.addActionListener(e -> state.setColor(Color.GREEN));
        colorMenu.add(green);
        group.add(green);
        JRadioButtonMenuItem cyan = new JRadioButtonMenuItem("Бирюзовый");
        cyan.addActionListener(e -> state.setColor(Color.CYAN));
        colorMenu.add(cyan);
        group.add(cyan);
        return colorMenu;
    }
    private JMenu createActionMenu() {
        JMenu actionMenu = new JMenu("Действие");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem move = new JRadioButtonMenuItem("Движение");
        move.addActionListener(e -> state.setAction(new ActionDraw(model, shape)));
        actionMenu.add(move);
        group.add(move);
        JRadioButtonMenuItem draw = new JRadioButtonMenuItem("Движение");
        draw.addActionListener(e -> state.setAction(new ActionDraw(model, shape)));
        actionMenu.add(draw);
        group.add(draw);
    }

    public void setActionDraw(ActionDraw actionDraw) {
        this.actionDraw = actionDraw;
    }
}
