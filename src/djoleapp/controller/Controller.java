package djoleapp.controller;

import djoleapp.business.model.AccountCalculation;
import djoleapp.business.model.BusinessSpace;
import djoleapp.business.model.Flat;
import djoleapp.business.model.Garage;
import djoleapp.business.model.IndependentSection;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ParkingBox;
import djoleapp.business.model.ParkingSpace;
import djoleapp.business.model.SeparateSection;
import djoleapp.business.storage.TemporaryList;
import djoleapp.controller.event.ManagerEvent;
import djoleapp.gui.LoginPane;
import djoleapp.gui.admingui.AddAdminPane;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.finance.AccountCalculationPane;
import djoleapp.gui.maingui.buildinggui.AddCommonPane;
import djoleapp.gui.maingui.buildinggui.AddIndependentPane;
import djoleapp.gui.maingui.buildinggui.AddSeparatePane;
import djoleapp.gui.maingui.buildinggui.BankDetailsBildingPane;
import djoleapp.gui.maingui.buildinggui.OccupantDetailsBuildingPane;
import djoleapp.gui.maingui.buildinggui.BuildingDetailsPane;
import djoleapp.gui.maingui.buildinggui.DetailsCommonPane;
import djoleapp.gui.maingui.buildinggui.DetailsIndependentPane;
import djoleapp.gui.maingui.buildinggui.DetailsSeparatePane;
import djoleapp.gui.maingui.buildinggui.EditSeparatePane;
import djoleapp.gui.maingui.buildinggui.ListBuildingsPane;
import djoleapp.gui.maingui.buildinggui.ListCommonSectionPane;
import djoleapp.gui.maingui.buildinggui.ListIndependentSectionsPane;
import djoleapp.gui.maingui.buildinggui.ListSeparateSectionsPane;
import djoleapp.gui.maingui.buildinggui.TableCommon;
import djoleapp.gui.maingui.buildinggui.TableIndependent;
import djoleapp.gui.maingui.buildinggui.TableSection;
import djoleapp.gui.maingui.buildinggui.TopHBoxBuildingPane;
import djoleapp.gui.maingui.finance.CalculationPane;
import djoleapp.gui.maingui.finance.EditCalculationPane;
import djoleapp.gui.maingui.finance.TableCalculations;
import djoleapp.gui.maingui.occupantgui.AddAccountOccupantPane;
import djoleapp.gui.maingui.occupantgui.AddOccupantPane;
import djoleapp.gui.maingui.occupantgui.EditOccupantPane;
import djoleapp.gui.maingui.occupantgui.ListOccupantsPane;
import djoleapp.gui.maingui.occupantgui.SelectOcupantPane;
import djoleapp.gui.maingui.occupantgui.TableOccupant;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {

    private static Controller instance = null;
    private Stage primaryStage;
    private Stage temporaryStage;
    private Scene loginScene;
    private LoginPane loginPane;
    private AddAdminPane addAdminPane;
    private MainPane mainPane;
    private ListBuildingsPane listBuildingsPane;
    private BankDetailsBildingPane bankDetailsBildingPane;
    private TopHBoxBuildingPane topHBoxBuildingPane;
    private BuildingDetailsPane buildingDetailsPane;
    private OccupantDetailsBuildingPane occupantDetailsBuildingPane;
    private ListOccupantsPane listOccupantsPane;
//    private TableOccupant tableOccupant;
    private TableSection tableSection;
    private TableIndependent tableIndependent;
    private TableCommon tableCommon;
    private TemporaryList temporaryList;
    private AddOccupantPane addOccupantPane;
    private AddAccountOccupantPane addAccountOccupantPane;
    private SelectOcupantPane selectOcupantPane;
    private ListSeparateSectionsPane listSeparateSectionsPane;
    private ListIndependentSectionsPane listIndependentSectionsPane;
    private ListCommonSectionPane listCommonSectionPane;
    private AddSeparatePane addSeparatePane;
    private Occupant temporaryOccupant;
    private AccountCalculation temporaryAccountCalculation;
    private Flat temporaryFlat;
    private ParkingBox temporaryParkingBox;
    private ParkingSpace temporaryParkingSpace;
    private Garage temporaryGarage;
    private BusinessSpace temporaryBusinesssSpace;
    private SeparateSection temporarySeparateSection;
    private IndependentSection temporaryIndependentSection;
    private DetailsSeparatePane detailsSeparatePane;
    private EditSeparatePane editSeparatePane;
    private DetailsIndependentPane detailsIndependentPane;
    private AddIndependentPane addIndependentPane;
    private DetailsCommonPane detailsCommonPane;
    private AddCommonPane addCommonPane;
    private TableCalculations tableCalculations;
    private AccountCalculationPane accountCalculationPane;
    private CalculationPane calculationPane;
    private EditCalculationPane editCalculationPane;
    private EditOccupantPane editOccupantPane;
    private double pricePerMonthFlat = 7.82;
    private double pricePerMonthBox = 4.69;
    private double pricePerMonthSpace = 5.69;
    private double pricePerMonthGarage = 10;
    private double pricePerMonthBusiness = 6.82;
    private final ManagerEvent managerEvent = new ManagerEvent();

    public Controller() {
    }

    public static Controller getInstance() {

        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public EditOccupantPane getEditOccupantPane() {
        return editOccupantPane;
    }

    public void setEditOccupantPane(EditOccupantPane editOccupantPane) {
        this.editOccupantPane = editOccupantPane;
    }
    
    public void setEditCalculationPane(EditCalculationPane editCalculationPane) {
        this.editCalculationPane = editCalculationPane;
    }

    public EditCalculationPane getEditCalculationPane() {
        return editCalculationPane;
    }

    public AccountCalculation getTemporaryAccountCalculation() {
        return temporaryAccountCalculation;
    }

    public void setTemporaryAccountCalculation(AccountCalculation temporaryAccountCalculation) {
        this.temporaryAccountCalculation = temporaryAccountCalculation;
    }


    public void setCalculationPane(CalculationPane calculationPane) {
        this.calculationPane = calculationPane;
    }

    public CalculationPane getCalculationPane() {
        return calculationPane;
    }

    public void setAccountCalculationPane(AccountCalculationPane accountCalculationPane) {
        this.accountCalculationPane = accountCalculationPane;
    }

    public AccountCalculationPane getAccountCalculationPane() {
        return accountCalculationPane;
    }

    public void setTableCalculations(TableCalculations tableCalculations) {
        this.tableCalculations = tableCalculations;
    }

    public TableCalculations getTableCalculations() {
        return tableCalculations;
    }

    public void setAddCommonPane(AddCommonPane addCommonPane) {
        this.addCommonPane = addCommonPane;
    }

    public AddCommonPane getAddCommonPane() {
        return addCommonPane;
    }

    public void setListCommonSectionPane(ListCommonSectionPane listCommonSectionPane) {
        this.listCommonSectionPane = listCommonSectionPane;
    }

    public ListCommonSectionPane getListCommonSectionPane() {
        return listCommonSectionPane;
    }

    public DetailsCommonPane getDetailsCommonPane() {
        return detailsCommonPane;
    }

    public void setDetailsCommonPane(DetailsCommonPane detailsCommonPane) {
        this.detailsCommonPane = detailsCommonPane;
    }
    

    public TableCommon getTableCommon() {
        return tableCommon;
    }

    public void setTableCommon(TableCommon tableCommon) {
        this.tableCommon = tableCommon;
    }

    public void setAddIndependentPane(AddIndependentPane addIndependentPane) {
        this.addIndependentPane = addIndependentPane;
    }

    public AddIndependentPane getAddIndependentPane() {
        return addIndependentPane;
    }

    public void setDetailsIndependentPane(DetailsIndependentPane detailsIndependentPane) {
        this.detailsIndependentPane = detailsIndependentPane;
    }

    public DetailsIndependentPane getDetailsIndependentPane() {
        return detailsIndependentPane;
    }

    public void setListIndependentSectionsPane(ListIndependentSectionsPane listIndependentSectionsPane) {
        this.listIndependentSectionsPane = listIndependentSectionsPane;
    }

    public ListIndependentSectionsPane getListIndependentSectionsPane() {
        return listIndependentSectionsPane;
    }

    public void setTemporaryIndependentSection(IndependentSection temporaryIndependentSection) {
        this.temporaryIndependentSection = temporaryIndependentSection;
    }

    public IndependentSection getTemporaryIndependentSection() {
        return temporaryIndependentSection;
    }

    public void setTableIndependent(TableIndependent tableIndependent) {
        this.tableIndependent = tableIndependent;
    }

    public TableIndependent getTableIndependent() {
        return tableIndependent;
    }

    public void setEditSeparatePane(EditSeparatePane editSeparatePane) {
        this.editSeparatePane = editSeparatePane;
    }

    public EditSeparatePane getEditSeparatePane() {
        return editSeparatePane;
    }

    public DetailsSeparatePane getDetailsSeparatePane() {
        return detailsSeparatePane;
    }

    public ParkingSpace getTemporaryParkingSpace() {
        return temporaryParkingSpace;
    }

    public void setTemporaryParkingSpace(ParkingSpace temporaryParkingSpace) {
        this.temporaryParkingSpace = temporaryParkingSpace;
    }

    public SeparateSection getTemporarySeparateSection() {
        return temporarySeparateSection;
    }

    public void setTemporarySeparateSection(SeparateSection temporarySeparateSection) {
        this.temporarySeparateSection = temporarySeparateSection;
    }

    public Garage getTemporaryGarage() {
        return temporaryGarage;
    }

    public void setTemporaryGarage(Garage temporaryGarage) {
        this.temporaryGarage = temporaryGarage;
    }

    public BusinessSpace getTemporaryBusinesssSpace() {
        return temporaryBusinesssSpace;
    }

    public void setTemporaryBusinesssSpace(BusinessSpace temporaryBusinesssSpace) {
        this.temporaryBusinesssSpace = temporaryBusinesssSpace;
    }

    public void setDetailsSeparatePane(DetailsSeparatePane detailsSeparatePane) {
        this.detailsSeparatePane = detailsSeparatePane;
    }

    public Flat getTemporaryFlat() {
        return temporaryFlat;
    }

    public void setTemporaryFlat(Flat temporaryFlat) {
        this.temporaryFlat = temporaryFlat;
    }

    public ParkingBox getTemporaryParkingBox() {
        return temporaryParkingBox;
    }

    public void setTemporaryParkingBox(ParkingBox temporaryParkingBox) {
        this.temporaryParkingBox = temporaryParkingBox;
    }

    public AddSeparatePane getAddSeparatePane() {
        return addSeparatePane;
    }

    public void setAddSeparatePane(AddSeparatePane addSeparatePane) {
        this.addSeparatePane = addSeparatePane;
    }

    public AddAccountOccupantPane getAddAccountOccupantPane() {
        return addAccountOccupantPane;
    }

    public void setAddAccountOccupantPane(AddAccountOccupantPane addAccountOccupantPane) {
        this.addAccountOccupantPane = addAccountOccupantPane;
    }

    public ListSeparateSectionsPane getListSeparateSectionsPane() {
        return listSeparateSectionsPane;
    }

    public void setListSeparateSectionsPane(ListSeparateSectionsPane listSeparateSectionsPane) {
        this.listSeparateSectionsPane = listSeparateSectionsPane;
    }

    public TableSection getTableSection() {
        return tableSection;
    }

    public void setTableSection(TableSection tableSection) {
        this.tableSection = tableSection;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Stage getTemporaryStage() {
        return temporaryStage;
    }

    public void setTemporaryStage(Stage temporaryStage) {
        this.temporaryStage = temporaryStage;
    }

    public void setSelectOcupantPane(SelectOcupantPane selectOcupantPane) {
        this.selectOcupantPane = selectOcupantPane;
    }

    public SelectOcupantPane getSelectOcupantPane() {
        return selectOcupantPane;
    }

    public void setAddOccupantPane(AddOccupantPane addOccupantPane) {
        this.addOccupantPane = addOccupantPane;
    }

    public AddOccupantPane getAddOccupantPane() {
        return addOccupantPane;
    }

    public AddAdminPane getAddAdminPane() {
        return addAdminPane;
    }

    public ListOccupantsPane getListOccupantsPane() {
        return listOccupantsPane;
    }

    public void setListOccupantsPane(ListOccupantsPane listOccupantsPane) {
        this.listOccupantsPane = listOccupantsPane;
    }

//    public void setTableOccupant(TableOccupant tableOccupant) {
//        this.tableOccupant = tableOccupant;
//    }

//    public TableOccupant getTableOccupant() {
//        return tableOccupant;
//    }

    public void setAddAdminPane(AddAdminPane addAdminPane) {
        this.addAdminPane = addAdminPane;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public LoginPane getLoginPane() {
        return loginPane;
    }

    public void setLoginPane(LoginPane loginPane) {
        this.loginPane = loginPane;
    }

    public MainPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(MainPane mainPane) {
        this.mainPane = mainPane;
    }

    public Scene getLoginScene() {
        return loginScene;
    }

    public void setLoginScene(Scene loginScene) {
        this.loginScene = loginScene;
    }

    public ManagerEvent getManagerEvent() {
        return managerEvent;
    }

    public TemporaryList getTemporaryList() {
        return temporaryList;
    }

    public void setTemporaryList(TemporaryList temporaryList) {
        this.temporaryList = temporaryList;
    }

    public ListBuildingsPane getListBuildingsPane() {
        return listBuildingsPane;
    }

    public void setListBuildingsPane(ListBuildingsPane listBuildingsPane) {
        this.listBuildingsPane = listBuildingsPane;
    }

    public BankDetailsBildingPane getBankDetailsBildingPane() {
        return bankDetailsBildingPane;
    }

    public void setBankDetailsBildingPane(BankDetailsBildingPane bankDetailsBildingPane) {
        this.bankDetailsBildingPane = bankDetailsBildingPane;
    }

    public TopHBoxBuildingPane getTopHBoxBuildingPane() {
        return topHBoxBuildingPane;
    }

    public void setTopHBoxBuildingPane(TopHBoxBuildingPane topHBoxBuildingPane) {
        this.topHBoxBuildingPane = topHBoxBuildingPane;
    }

    public BuildingDetailsPane getBuildingDetailsPane() {
        return buildingDetailsPane;
    }

    public void setBuildingDetailsPane(BuildingDetailsPane buildingDetailsPane) {
        this.buildingDetailsPane = buildingDetailsPane;
    }

    public OccupantDetailsBuildingPane getOccupantDetailsBuildingPane() {
        return occupantDetailsBuildingPane;
    }

    public void setOccupantDetailsBuildingPane(OccupantDetailsBuildingPane occupantDetailsBuildingPane) {
        this.occupantDetailsBuildingPane = occupantDetailsBuildingPane;
    }

    public Occupant getTemporaryOccupant() {
        return temporaryOccupant;
    }

    public void setTemporaryOccupant(Occupant temporaryOccupant) {
        this.temporaryOccupant = temporaryOccupant;
    }

    public double getPricePerMonthFlat() {
        return pricePerMonthFlat;
    }

    public void setPricePerMonthFlat(double pricePerMonthFlat) {
        this.pricePerMonthFlat = pricePerMonthFlat;
    }

    public double getPricePerMonthBox() {
        return pricePerMonthBox;
    }

    public void setPricePerMonthBox(double pricePerMonthBox) {
        this.pricePerMonthBox = pricePerMonthBox;
    }

    public double getPricePerMonthSpace() {
        return pricePerMonthSpace;
    }

    public void setPricePerMonthSpace(double pricePerMonthSpace) {
        this.pricePerMonthSpace = pricePerMonthSpace;
    }

    public double getPricePerMonthGarage() {
        return pricePerMonthGarage;
    }

    public void setPricePerMonthGarage(double pricePerMonthGarage) {
        this.pricePerMonthGarage = pricePerMonthGarage;
    }

    public double getPricePerMonthBusiness() {
        return pricePerMonthBusiness;
    }

    public void setPricePerMonthBusiness(double pricePerMonthBusiness) {
        this.pricePerMonthBusiness = pricePerMonthBusiness;
    }

}
