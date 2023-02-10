package com.example.viewcontrollerapp;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    public TextField textField;
    public TextField textField2;
    public ListView listView;

    public ListView<String> listView2;
    public MenuButton deleteMenu;
    public MenuButton deleteMenu2;

    String newTask;
    String newTask2;
    public List<String> list = new ArrayList<String>();
    public List<String> list2 = new ArrayList<String>();


    public void initialize() {

    }
    public void enter() {
        String newTask =  textField.getText();
        list.add(newTask);
        listView.setEditable(true);
        listView.setCellFactory(TextFieldListCell.forListView());
        listView.getItems().add(newTask);
        MenuItem menuItem = new MenuItem(newTask);
        deleteMenu.getItems().add(menuItem);
        menuItem.setOnAction(actionEvent -> {
            list.remove(newTask);
            listView.getItems().remove(newTask);
            deleteMenu.getItems().remove(menuItem);
        });

    }
    public void enter2(){
        String newTask2 =  textField2.getText();
        list2.add(newTask2);
        listView2.setEditable(true);
        listView2.setCellFactory(TextFieldListCell.forListView());
        listView2.getItems().add(newTask2);
        MenuItem menuItem2 = new MenuItem(newTask2);
        deleteMenu2.getItems().add(menuItem2);
        menuItem2.setOnAction(actionEvent -> {
            list2.remove(newTask2);
            listView2.getItems().remove(newTask2);
            deleteMenu2.getItems().remove(menuItem2);

        });
    }

}