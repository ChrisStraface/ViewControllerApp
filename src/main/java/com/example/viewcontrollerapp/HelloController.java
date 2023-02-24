package com.example.viewcontrollerapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public void initialize() throws Exception {
    restoreData();
    }
    public void enter() {
        String newTask =  textField.getText();
        ArrayList<String> temporaryList = new ArrayList<>(listView.getItems());
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

    public void saveData() throws Exception {
        FileOutputStream fileOut =
                new FileOutputStream("SavedTaskList");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        ArrayList<String> temporaryList = new ArrayList<>(listView.getItems());
        out.writeObject(temporaryList);
        ArrayList<String> temporaryList2 = new ArrayList<>(listView2.getItems());
        out.writeObject(temporaryList2);
        out.close();
        fileOut.close();
    }
    public void restoreData() throws Exception {
        FileInputStream fileIn = new FileInputStream("SavedTaskList");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        list = (ArrayList<String>) in.readObject();
        ObservableList tempObservableList = FXCollections.observableArrayList(list);
        listView.setItems(tempObservableList);
        list2 = (ArrayList<String>) in.readObject();
        ObservableList tempObservableList2 = FXCollections.observableArrayList(list2);
        listView2.setItems(tempObservableList2);
        for (Object newTask : tempObservableList) {
            MenuItem menuItem = new MenuItem((String)newTask);
            deleteMenu.getItems().add(menuItem);
        }
        for (Object newTask2 : tempObservableList2) {
            MenuItem menuItem2 = new MenuItem((String)newTask2);
            deleteMenu2.getItems().add(menuItem2);
        }
        in.close();
        fileIn.close();
    }

}