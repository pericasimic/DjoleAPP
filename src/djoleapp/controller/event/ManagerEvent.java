package djoleapp.controller.event;

import djoleapp.business.model.AccountCalculation;
import djoleapp.controller.event.adminevent.AddAdminEvent;
import djoleapp.controller.event.adminevent.LoginEvent;
import djoleapp.controller.event.adminevent.LogoutEvent;
import djoleapp.controller.event.adminevent.SaveEvent;
import djoleapp.controller.event.buildingevent.AddBankAccountBuildEvent;
import djoleapp.controller.event.buildingevent.AddBuildingEvent;
import djoleapp.controller.event.buildingevent.AddCommonEvent;
import djoleapp.controller.event.buildingevent.AddIndependentEvent;
import djoleapp.controller.event.buildingevent.AddOccupantBuildingEvent;
import djoleapp.controller.event.buildingevent.AddSectionEvent;
import djoleapp.controller.event.buildingevent.BackListSeparateSections;
import djoleapp.controller.event.buildingevent.BankDetailsBuildingEvent;
import djoleapp.controller.event.buildingevent.ConfirmAddCommonEvent;
import djoleapp.controller.event.buildingevent.ConfirmAddIndEvent;
import djoleapp.controller.event.buildingevent.ConfirmAddSeparateEvent;
import djoleapp.controller.event.buildingevent.ConfirmEditSeparateEvent;
import djoleapp.controller.event.buildingevent.DetailsCommonSectionEvent;
import djoleapp.controller.event.buildingevent.DetailsIndependentEvent;
import djoleapp.controller.event.buildingevent.DetailsSeparateEvent;
import djoleapp.controller.event.buildingevent.EditSeparationEvent;
import djoleapp.controller.event.buildingevent.ListBuildingEvent;
import djoleapp.controller.event.buildingevent.RemoveBankAccountEvent;
import djoleapp.controller.event.buildingevent.RemoveBuildingEvent;
import djoleapp.controller.event.buildingevent.RemoveBuildingOccupantEvent;
import djoleapp.controller.event.buildingevent.RemoveCommonEvent;
import djoleapp.controller.event.buildingevent.RemoveIndSectionEvent;
import djoleapp.controller.event.buildingevent.RemoveSeparateSectionEvent;
import djoleapp.controller.event.buildingevent.SearchBuildingEvent;
import djoleapp.controller.event.buildingevent.ShowSelectBuildTableEvent;
import djoleapp.controller.event.financeevent.AccountCalculationDetailsEvent;
import djoleapp.controller.event.financeevent.BackAccountCalEvent;
import djoleapp.controller.event.financeevent.CreatePdfCalculaionEvent;
import djoleapp.controller.event.occupantevent.AddAccountOccupantEvent;
import djoleapp.controller.event.occupantevent.AddOccupantEvent;
import djoleapp.controller.event.occupantevent.BackAddAccountOccupantEvent;
import djoleapp.controller.event.occupantevent.ConfirmAddAccountOccupantEvent;
import djoleapp.controller.event.occupantevent.ConfirmAddOcupantEvent;
import djoleapp.controller.event.occupantevent.DetailsOccupantEvent;
import djoleapp.controller.event.occupantevent.ListOccupantEvent;
import djoleapp.controller.event.occupantevent.RemoveUserEvent;
import djoleapp.controller.event.occupantevent.SearchUserEvent;
import djoleapp.controller.event.occupantevent.SelectOccupantEvent;
import djoleapp.controller.event.occupantevent.ShowSelectListsOccupantEvent;

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
    private SelectOccupantEvent selectOccupantEvent = null;
    private AddAccountOccupantEvent addAccountOccupantEvent = null;
    private BackAddAccountOccupantEvent backAddAccountOccupantEvent = null;
    private ConfirmAddAccountOccupantEvent confirmAddAccountOccupantEvent = null;
    private AddSectionEvent addSectionEvent = null;
    private ConfirmAddSeparateEvent confirmAddSeparateEvent = null;
    private DetailsSeparateEvent detailsSeparateEvent = null;
    private EditSeparationEvent editSeparationEvent = null;
    private SearchBuildingEvent searchBuildingEvent = null;
    private RemoveBuildingEvent removeBuildingEvent = null;
    private RemoveBankAccountEvent removeBankAccountEvent = null;
    private BackListSeparateSections backListSeparateSections = null;
    private RemoveSeparateSectionEvent removeSeparateSectionEvent = null;
    private ConfirmEditSeparateEvent confirmEditSeparateEvent = null;
    private DetailsIndependentEvent detailsIndependentEvent = null;
    private AddIndependentEvent addIndependentEvent = null;
    private ConfirmAddIndEvent confirmAddIndEvent = null;
    private RemoveIndSectionEvent removeIndSectionEvent = null;
    private DetailsCommonSectionEvent detailsCommonSectionEvent = null;
    private AddCommonEvent addCommonEvent = null;
    private RemoveCommonEvent removeCommonEvent = null;
    private ConfirmAddCommonEvent confirmAddCommonEvent = null;
    private RemoveBuildingOccupantEvent removeBuildingOccupantEvent = null;
    private SearchUserEvent searchUserEvent = null;
    private RemoveUserEvent removeUserEvent = null;
    private ShowSelectListsOccupantEvent showSelectListsOccupantEvent = null;
    private BackAccountCalEvent backAccountCalEvent = null;
    private AccountCalculationDetailsEvent accountCalculationDetailsEvent = null;
    private CreatePdfCalculaionEvent createPdfCalculaionEvent = null;

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
        selectOccupantEvent = new SelectOccupantEvent();
        addAccountOccupantEvent = new AddAccountOccupantEvent();
        backAddAccountOccupantEvent = new BackAddAccountOccupantEvent();
        confirmAddAccountOccupantEvent = new ConfirmAddAccountOccupantEvent();
        addSectionEvent = new AddSectionEvent();
        confirmAddSeparateEvent = new ConfirmAddSeparateEvent();
        detailsSeparateEvent = new DetailsSeparateEvent();
        editSeparationEvent = new EditSeparationEvent();
        searchBuildingEvent = new SearchBuildingEvent();
        removeBuildingEvent = new RemoveBuildingEvent();
        removeBankAccountEvent = new RemoveBankAccountEvent();
        backListSeparateSections = new BackListSeparateSections();
        removeSeparateSectionEvent = new RemoveSeparateSectionEvent();
        confirmEditSeparateEvent = new ConfirmEditSeparateEvent();
        detailsIndependentEvent = new DetailsIndependentEvent();
        addIndependentEvent = new AddIndependentEvent();
        confirmAddIndEvent = new ConfirmAddIndEvent();
        removeIndSectionEvent = new RemoveIndSectionEvent();
        detailsCommonSectionEvent = new DetailsCommonSectionEvent();
        addCommonEvent = new AddCommonEvent();
        removeCommonEvent = new RemoveCommonEvent();
        confirmAddCommonEvent = new ConfirmAddCommonEvent();
        removeBuildingOccupantEvent = new RemoveBuildingOccupantEvent();
        searchUserEvent = new SearchUserEvent();
        removeUserEvent = new RemoveUserEvent();
        showSelectListsOccupantEvent = new ShowSelectListsOccupantEvent();
        backAccountCalEvent = new BackAccountCalEvent();
        accountCalculationDetailsEvent = new AccountCalculationDetailsEvent();
        createPdfCalculaionEvent = new CreatePdfCalculaionEvent();
    }

    public AccountCalculationDetailsEvent getAccountCalculationDetailsEvent() {
        return accountCalculationDetailsEvent;
    }

    public CreatePdfCalculaionEvent getCreatePdfCalculaionEvent() {
        return createPdfCalculaionEvent;
    }

    public void getAccountCalculationDetailsEvent(AccountCalculation accountCalculation) {
        accountCalculationDetailsEvent.showAccountCalculation(accountCalculation);
    }

    public BackAccountCalEvent getBackAccountCalEvent() {
        return backAccountCalEvent;
    }

    public ShowSelectListsOccupantEvent getShowSelectListsOccupantEvent() {
        return showSelectListsOccupantEvent;
    }

    public RemoveUserEvent getRemoveUserEvent() {
        return removeUserEvent;
    }

    public SearchUserEvent getSearchUserEvent() {
        return searchUserEvent;
    }

    public RemoveBuildingOccupantEvent getRemoveBuildingOccupantEvent() {
        return removeBuildingOccupantEvent;
    }

    public ConfirmAddCommonEvent getConfirmAddCommonEvent() {
        return confirmAddCommonEvent;
    }

    public void setRemoveCommonEvent(RemoveCommonEvent removeCommonEvent) {
        this.removeCommonEvent = removeCommonEvent;
    }

    public RemoveCommonEvent getRemoveCommonEvent() {
        return removeCommonEvent;
    }

    public AddCommonEvent getAddCommonEvent() {
        return addCommonEvent;
    }

    public DetailsCommonSectionEvent getDetailsCommonSectionEvent() {
        return detailsCommonSectionEvent;
    }

    public RemoveIndSectionEvent getRemoveIndSectionEvent() {
        return removeIndSectionEvent;
    }

    public ConfirmAddIndEvent getConfirmAddIndEvent() {
        return confirmAddIndEvent;
    }

    public AddIndependentEvent getAddIndependentEvent() {
        return addIndependentEvent;
    }

    public DetailsIndependentEvent getDetailsIndependentEvent() {
        return detailsIndependentEvent;
    }

    public ConfirmEditSeparateEvent getConfirmEditSeparateEvent() {
        return confirmEditSeparateEvent;
    }

    public RemoveSeparateSectionEvent getRemoveSeparateSectionEvent() {
        return removeSeparateSectionEvent;
    }

    public BackListSeparateSections getBackListSeparateSections() {
        return backListSeparateSections;
    }

    public RemoveBankAccountEvent getRemoveBankAccountEvent() {
        return removeBankAccountEvent;
    }

    public RemoveBuildingEvent getRemoveBuildingEvent() {
        return removeBuildingEvent;
    }

    public SearchBuildingEvent getSearchBuildingEvent() {
        return searchBuildingEvent;
    }

    public EditSeparationEvent getEditSeparationEvent() {
        return editSeparationEvent;
    }

    public DetailsSeparateEvent getDetailsSeparateEvent() {
        return detailsSeparateEvent;
    }

    public ConfirmAddSeparateEvent getConfirmAddSeparateEvent() {
        return confirmAddSeparateEvent;
    }

    public AddSectionEvent getAddSectionEvent() {
        return addSectionEvent;
    }

    public ConfirmAddAccountOccupantEvent getConfirmAddAccountOccupantEvent() {
        return confirmAddAccountOccupantEvent;
    }

    public BackAddAccountOccupantEvent getBackAddAccountOccupantEvent() {
        return backAddAccountOccupantEvent;
    }

    public AddAccountOccupantEvent getAddAccountOccupantEvent() {
        return addAccountOccupantEvent;
    }

    public SelectOccupantEvent getSelectOccupantEvent() {
        return selectOccupantEvent;
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
