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
        
        MenuItem buildingList = new MenuItem(Constants.MENU_ITEM_BUILDING_LIST);
        buildingList.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        buildingList.setOnAction(Controller.getInstance().getManagerEvent().getListBuildingEvent());
        MenuItem detailsBuilding = new MenuItem(Constants.MENU_ITEM_BUILDING_DETAILS);
        detailsBuilding.setAccelerator(new KeyCodeCombination(KeyCode.B, KeyCombination.CONTROL_DOWN));
        detailsBuilding.setOnAction(Controller.getInstance().getManagerEvent().getBankDetailsBuildingEvent());
        
        buildings.getItems().addAll(buildingList, detailsBuilding);
        
        Menu occupants = new Menu(Constants.OCCUPANTS);
        
        MenuItem occupantsList = new MenuItem(Constants.MENU_ITEM_OCCUPANT_LIST);
        occupantsList.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        occupantsList.setOnAction(Controller.getInstance().getManagerEvent().getListOccupantEvent());
        MenuItem detailsOccupant = new MenuItem(Constants.MENU_ITEM_OCCUPANT_DETAILS);
        detailsOccupant.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN));
        detailsOccupant.setOnAction(Controller.getInstance().getManagerEvent().getDetailsOccupantEvent());
        
        occupants.getItems().addAll(occupantsList, detailsOccupant);
        
        Menu accounts = new Menu(Constants.ACCOUNTS);
        Menu statements = new Menu(Constants.STATEMENTS);
        Menu about = new Menu(Constants.ABOUT);
        
        menuBar.getMenus().addAll(files, buildings, occupants, accounts, statements, about);
        return menuBar;
    }
    
}
