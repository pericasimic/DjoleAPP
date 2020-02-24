package djoleapp.controller.event;

import djoleapp.controller.event.adminevent.AddAdminEvent;
import djoleapp.controller.event.adminevent.LoginEvent;
import djoleapp.controller.event.adminevent.LogoutEvent;
import djoleapp.controller.event.adminevent.SaveEvent;
import djoleapp.controller.event.buildingevent.AddBankAccountBuildEvent;
import djoleapp.controller.event.buildingevent.AddBuildingEvent;
import djoleapp.controller.event.buildingevent.AddOccupantBuildingEvent;
import djoleapp.controller.event.buildingevent.BankDetailsBuildingEvent;
import djoleapp.controller.event.buildingevent.ListBuildingEvent;
import djoleapp.controller.event.buildingevent.ShowSelectBuildTableEvent;
import djoleapp.controller.event.occupantevent.AddOccupantEvent;
import djoleapp.controller.event.occupantevent.ConfirmAddOcupantEvent;
import djoleapp.controller.event.occupantevent.DetailsOccupantEvent;
import djoleapp.controller.event.occupantevent.ListOccupantEvent;

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
    private BankDetailsBuildingEvent bankDetailsBuildingEvent = null;
    private ShowSelectBuildTableEvent showSelectBuildTableEvent = null;
    private AddBankAccountBuildEvent addBankAccountBuildEvent = null;
    private ListOccupantEvent listOccupantEvent = null;
    private DetailsOccupantEvent detailsOccupantEvent = null;
    private AddOccupantBuildingEvent addOccupantBuildingEvent = null;
    private AddOccupantEvent addOccupantEvent = null;
    private ConfirmAddOcupantEvent confirmAddOcupantEvent = null;

    public ManagerEvent() {

        loginEvent = new LoginEvent();
        logoutEvent = new LogoutEvent();
        addAdminEvent = new AddAdminEvent();
        saveEvent = new SaveEvent();
        addBuildingEvent = new AddBuildingEvent();
        listBuildingEvent = new ListBuildingEvent();
        bankDetailsBuildingEvent = new BankDetailsBuildingEvent();
        showSelectBuildTableEvent = new ShowSelectBuildTableEvent();
        addBankAccountBuildEvent = new AddBankAccountBuildEvent();
        listOccupantEvent = new ListOccupantEvent();
        detailsOccupantEvent = new DetailsOccupantEvent();
        addOccupantBuildingEvent = new AddOccupantBuildingEvent();
        addOccupantEvent = new AddOccupantEvent();
        confirmAddOcupantEvent = new ConfirmAddOcupantEvent();
    }

    public ConfirmAddOcupantEvent getConfirmAddOcupantEvent() {
        return confirmAddOcupantEvent;
    }

    public AddOccupantEvent getAddOccupantEvent() {
        return addOccupantEvent;
    }

    public ListBuildingEvent getListBuildingEvent() {
        return listBuildingEvent;
    }

    public AddOccupantBuildingEvent getAddOccupantBuildingEvent() {
        return addOccupantBuildingEvent;
    }

    
    public DetailsOccupantEvent getDetailsOccupantEvent() {
        return detailsOccupantEvent;
    }

    public ListOccupantEvent getListOccupantEvent() {
        return listOccupantEvent;
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

    public BankDetailsBuildingEvent getBankDetailsBuildingEvent() {
        return bankDetailsBuildingEvent;
    }

    public ShowSelectBuildTableEvent getShowSelectBuildTableEvent() {
        return showSelectBuildTableEvent;
    }

    public AddBankAccountBuildEvent getAddBankAccountBuildEvent() {
        return addBankAccountBuildEvent;
    }
    
    
}
