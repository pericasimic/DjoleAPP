package djoleapp.controller.event.occupantevent;

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
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class ConfirmAddOcupantEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        confirmAddOcupantEvent();
    }

    public void confirmAddOcupantEvent() {

        AddOccupantPane aop = Controller.getInstance().getAddOccupantPane();
        List<Occupant> list = Controller.getInstance().getTemporaryList().getOccupants();
        ListOccupantsPane lop = Controller.getInstance().getListOccupantsPane();

        String firstName = aop.getFirstNameFld().getText();
        String lastName = aop.getLastNameFld().getText();
        String idNum = aop.getIdNumberFld().getText();
        String phone = aop.getPhoneFld().getText();
        String mail = aop.getMailFld().getText();
        String note = aop.getNoteFld().getText();

        Occupant o = new Occupant(list.size() + 1, firstName, lastName, idNum, phone, mail);

        if (!note.isEmpty() || note != null) {
            o.setNote(note);
        }

        Controller.getInstance().getTemporaryList().getOccupants().add(o);
        lop.reload();

        MainPane mp = new MainPane(Controller.getInstance().getListOccupantsPane());
        Scene scena = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);

    }
}
