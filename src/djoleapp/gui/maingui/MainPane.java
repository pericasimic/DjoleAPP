package djoleapp.gui.maingui;

import djoleapp.controller.constant.Constants;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
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
        Menu buildings = new Menu(Constants.BUILDINGS);
        Menu occupants = new Menu(Constants.OCCUPANTS);
        Menu accounts = new Menu(Constants.ACCOUNTS);
        Menu statements = new Menu(Constants.STATEMENTS);
        Menu about = new Menu(Constants.ABOUT);
        
        menuBar.getMenus().addAll(files, buildings, occupants, accounts, statements, about);
        return menuBar;
    }
    
}
