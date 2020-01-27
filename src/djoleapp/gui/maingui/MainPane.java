package djoleapp.gui.maingui;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {
    
    public MainPane(){
        this.setTop(getMenuBar());
    }
    
    public MainPane(Node center){
        this.setCenter(center);
        this.setTop(getMenuBar());
    }
    
    private MenuBar getMenuBar(){
        MenuBar menuBar = new MenuBar();
        
        Menu files = new Menu(Constants.FILE);
        
        MenuItem print = new MenuItem(Constants.PRINT);
        print.setAccelerator(new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN));
        
        MenuItem save = new MenuItem(Constants.SAVE);
        save.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        save.setOnAction(Controller.getInstance().getManagerEvent().getSaveEvent());
        
        MenuItem exit = new MenuItem(Constants.EXIT);
        exit.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        exit.setOnAction(Controller.getInstance().getManagerEvent().getLogoutEvent());
        
        files.getItems().addAll(print, save, exit);
        
        Menu buildings = new Menu(Constants.BUILDINGS);
        
        MenuItem buildingList = new MenuItem(Constants.BUILDINGS_LIST);
        buildingList.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        buildingList.setOnAction(Controller.getInstance().getManagerEvent().getListBuildingEvent());
        
        buildings.getItems().addAll(buildingList);
        
        Menu occupants = new Menu(Constants.OCCUPANTS);
        Menu accounts = new Menu(Constants.ACCOUNTS);
        Menu statements = new Menu(Constants.STATEMENTS);
        Menu about = new Menu(Constants.ABOUT);
        
        menuBar.getMenus().addAll(files, buildings, occupants, accounts, statements, about);
        return menuBar;
    }
    
}
