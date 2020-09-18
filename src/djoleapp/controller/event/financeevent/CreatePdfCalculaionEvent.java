package djoleapp.controller.event.financeevent;

import djoleapp.business.model.AccountCalculation;
import djoleapp.controller.Controller;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class CreatePdfCalculaionEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        createPdfCalEvent();
    }

    public void createPdfCalEvent() {

        AccountCalculation ac = Controller.getInstance().getTemporaryAccountCalculation();

        try {
            PDDocument pDDocument = PDDocument.load(new File("pdf-java.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();

            PDField field1 = pDAcroForm.getField("platilac");
            PDField field2 = pDAcroForm.getField("svrha");
            PDField field3 = pDAcroForm.getField("primalac");
            PDField field4 = pDAcroForm.getField("sifra");
            PDField field5 = pDAcroForm.getField("valuta");
            PDField field6 = pDAcroForm.getField("iznos");
            PDField field7 = pDAcroForm.getField("tekuci");
            PDField field8 = pDAcroForm.getField("poziv");
            PDField field9 = pDAcroForm.getField("sifra2");
            PDField field10 = pDAcroForm.getField("valuta2");
            PDField field11 = pDAcroForm.getField("iznos2");
            PDField field12 = pDAcroForm.getField("tekuci2");
            PDField field13 = pDAcroForm.getField("poziv2");
            PDField field14 = pDAcroForm.getField("platilac2");

            field1.setValue(ac.getOccupant().getFirstNameOccupant() + " "
                    + ac.getOccupant().getLastNameOccupant() + ", "
                    + ac.getResidentialCommunity().getName() + " "
                    + ac.getResidentialCommunity().getNumber() + ", "
                    + ac.getResidentialCommunity().getCity());
            field2.setValue("Uplata po računu broj " + ac.getCalculationNumber());
            field3.setValue("Stambena zajednica " + ac.getResidentialCommunity() + ", "
                    + ac.getResidentialCommunity().getCity());
            field4.setValue("189");
            field5.setValue("RSD");
            field6.setValue(String.valueOf(ac.getSum()));
            field7.setValue(ac.getResidentialCommunity().getBankAccounts().get(0).getBankAccountNumber());
            field8.setValue(ac.getCalculationNumber());
            field9.setValue("189");
            field10.setValue("RSD");
            field11.setValue(String.valueOf(ac.getSum()));
            field12.setValue(ac.getResidentialCommunity().getBankAccounts().get(0).getBankAccountNumber());
            field13.setValue(ac.getCalculationNumber());
            field14.setValue(ac.getOccupant().getFirstNameOccupant() + " "
                    + ac.getOccupant().getLastNameOccupant() + ", "
                    + ac.getResidentialCommunity().getName() + " "
                    + ac.getResidentialCommunity().getNumber() + ", "
                    + ac.getResidentialCommunity().getCity());

            pDDocument.save(ac.getCalculationNumber() + ".pdf");
            pDDocument.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
