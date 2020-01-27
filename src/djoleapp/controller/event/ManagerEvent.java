package djoleapp.controller.event;

import djoleapp.controller.event.adminevent.AddAdminEvent;
import djoleapp.controller.event.adminevent.LoginEvent;
import djoleapp.controller.event.adminevent.LogoutEvent;
import djoleapp.controller.event.adminevent.SaveEvent;
import djoleapp.controller.event.buildingevent.AddBuildingEvent;
import djoleapp.controller.event.buildingevent.ListBuildingEvent;

/**
 *
 * @author perica.simic
 */
public class ManagerEvent {

    private LoginEvent loginEvent = null;
    private LogoutEvent logoutEvent = null;
    private AddAdminEvent addAdminEvent = null;
    private SaveEvent saveEvent = null;
    private AddBuildingEvent addBuildingEvent = null;
    private ListBuildingEvent listBuildingEvent = null;
    

    public ManagerEvent() {

        loginEvent = new LoginEvent();
        logoutEvent = new LogoutEvent();
        addAdminEvent = new AddAdminEvent();
        saveEvent = new SaveEvent();
        addBuildingEvent = new AddBuildingEvent();
        listBuildingEvent = new ListBuildingEvent();
    }

    public ListBuildingEvent getListBuildingEvent() {
        return listBuildingEvent;
    }

    public LoginEvent getLoginEvent() {
        return loginEvent;
    }

    public LogoutEvent getLogoutEvent() {
        return logoutEvent;
    }

    public AddAdminEvent getAddAdminEvent() {
        return addAdminEvent;
    }

    public SaveEvent getSaveEvent() {
        return saveEvent;
    }

    public AddBuildingEvent getAddBuildingEvent() {
        return addBuildingEvent;
    }
    
    
    
}