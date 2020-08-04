package djoleapp.controller.event.occupantevent;

import djoleapp.business.Factory;
import djoleapp.business.model.Occupant;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.occupantgui.AddOccupantPane;
import djoleapp.gui.maingui.occupantgui.ListOccupantsPane;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class ConfirmAddOcupantEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        confirmAddOcupantEvent();
    }

    public void confirmAddOcupantEvent() {

        AddOccupantPane aop = Controller.getInstance().getAddOccupantPane();
        List<Occupant> list = Controller.getInstance().getTemporaryList().getOccupants();
        ListOccupantsPane lop = Controller.getInstance().getListOccupantsPane();

        long id = Factory.getFacade().readId() + 1;
        String firstName = aop.getFirstNameFld().getText();
        String lastName = aop.getLastNameFld().getText();
        String idNum = aop.getIdNumberFld().getText();
        String phone = aop.getPhoneFld().getText();
        String mail = aop.getMailFld().getText();
        String note = aop.getNoteFld().getText();

        if (Factory.getFacade().addOccupant(id, firstName, lastName, idNum, phone, mail, note)) {
            Factory.getFacade().writeId(id);
            lop.reload();
            MainPane mp = new MainPane(Controller.getInstance().getListOccupantsPane());
            Scene scena = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
            Controller.getInstance().getPrimaryStage().setScene(scena);
        } else {
            return;
        }

    }
}
