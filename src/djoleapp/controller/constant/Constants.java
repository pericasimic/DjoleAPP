package djoleapp.controller.constant;

import java.util.regex.Pattern;

public class Constants {

    public static final String STYLE_PATH = "gui/style.css";
    public static final int SCENE_WIDTH = 1280;
    public static final int SCENE_HEIGHT = 720;
    public static final int SCENE_WIDTH_TEMP = 800;
    public static final int SCENE_HEIGHT_TEMP = 600;
    public static final String PRIMARY_STAGE_TITLE = "Aplikacija - BuildMan";
    public static final String ALERT_WARNING_DIALOG = "Upozorenje";
    public static final String ALERT_ERROR_DIALOG = "Greška";
    public static final String ALERT_INFORMATION_DIALOG = "Informacija";
    public static final String BUTTON_SHOW = "Prikaži";
    public static final String BUTTON_ADD = "Dodaj";
    public static final String BUTTON_REMOVE = "Obriši";
    public static final String BUTTON_EDIT = "Izmeni";
    public static final String SUCCESS_SAVE = "Uspešno je sačuvano";
    public static final String SUCCESS_DELETE = "Uspešno je obrisano";
    public static final String ADD_BANK_ACCOUNT_SUCCESS = "Bankovni račun je dodat";
    public static final String ALERT_EMPTY_INPUT_TEXT = "Polja moraju biti popunjena";
    public static final String ALERT_NOT_SELECT = "Morate izabrati stavku";
    public static final String BANK_ACCOUNT = "Tekući račun";
    public static final String OCCUPANTS = "Stanari";
    public static final String CLOSE_APP_DIALOG_TEXT = "Da li želiš da zatvoriš aplikaciju?";
    public static final String BUTTON_CONFIRM = "Potvrdi";


    /*
    SerStorage
     */
    public static final String ERROR_STORAGE_LOAD_ADMIN = "package djoleapp.business.storage.loadAdmin";
    public static final String ERROR_STORAGE_WRITE_ADMIN = "package djoleapp.business.storage.writeAdmin";
    public static final String ERROR_STORAGE_LOAD_BUILDING = "package djoleapp.business.storage.loadResidentialCommunity";
    public static final String ERROR_STORAGE_WRITE_BUILDING = "package djoleapp.business.storage.writeResidentialCommunity";
    public static final String ERROR_STORAGE_LOAD_BANK_ACCOUNT = "package djoleapp.business.storage.loadBankAccounts";
    public static final String ERROR_STORAGE_WRITE_BANK_ACCOUNT = "package djoleapp.business.storage.writeBankAccounts";
    public static final String ERROR_STORAGE_LOAD_OCCUPANT = "package djoleapp.business.storage.loadOccupant";
    public static final String ERROR_STORAGE_WRITE_OCCUPANT = "package djoleapp.business.storage.writeOccupant";
    public static final String ERROR_STORAGE_LOAD_SEPARATE_SECTIONS = "package djoleapp.business.storage.loadSeparateSections";
    public static final String ERROR_STORAGE_WRITE_SEPARATE_SECTIONS = "package djoleapp.business.storage.writeSeparateSections";
    public static final String ADMIN_DAT = "admin.dat";
    public static final String BUILDINGS_DAT = "buildings.dat";
    public static final String OCCUPANTS_DAT = "occupants.dat";

    /*FacadeSER*/
    public static final String COUNT_ID_OCCUPANT = "C:\\Users\\perica.simic\\Documents\\NetBeansProjects\\DjoleAPP\\id.txt";
    public static final String ADMIN_EXISTS = "Kreiran je novi administrator";
    public static final String ADMIN_LOGIN_FAILD = "Pogrešno korisničko ime ili lozinka";
    public static final String ADMIN = "admin";
    public static final String BAD_FORMAT_FOR_EMAIL = "Neispravan format za mejl adresu";
    public static final String BAD_FORMAT_FOR_TAX_NUMBER = "Neispravan PIB";
    public static final String BAD_FORMAT_FOR_ID_NUMBER = "Neispravan matični broj";
    public static final String VALID_EMAIL_ADDRESS_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static final String VALID_NUMBER = "[0-9]+";
    public static final String ALERT_ACCOUNT_EXIST = "Račun vec postoji";
    public static final String HAVE_TO_NAME_INDEPENDENT = "Morate uneti naziv samostalnog dela";
    public static final String HAVE_TO_NAME_COMMON = "Morate uneti naziv zajedničkog dela";
    public static final String BAD_FORMAT_PER_MONTH = "Neispravan format za Mesečno održavanje";
    public static final String ALERT_EMPTY_INPUT_TEXT_OCCUPANT = "Sva polja moraju biti popunjena osim polja *Napomena";
    public static final String ALERT_BUILDING_EXIST = "Zgrada vec postoji u bazi";

    /*
     Login pane & AddAdminPane & AddAdminEvent
     */
    public static final String TITLE_LOGIN = "Prijava na aplikaciju";
    public static final String USERNAME_LBL = "Korisničko ime:";
    public static final String PASSWORD_LBL = "Lozinka:";
    public static final String BUTTON_LOGIN = "Prijava";
    public static final String BUTTON_LOGOUT = "Odjava";
    public static final String ADD_ADMIN = "Novi administrator je dodat";
    public static final String ADMIN_DENY = "Uneto korisničko ime nije dozvoljeno";
    public static final String ALERT_PASSWORD_NOT_SAME = "Lozinke se ne poklapaju";
    public static final String TITLE_ADD_ADMIN = "Dodavanje administratora";

    /*
    Main Pane
     */
    public static final String FILE = "Fajl";
    public static final String BUILDINGS = "Stambene zajednice";
    public static final String MENU_ITEM_BUILDING_LIST = "Lista zgrada...";
    public static final String ABOUT = "O programu";
    public static final String SAVE = "Snimi";
    public static final String EXIT = "Izlaz";
    public static final String PRINT = "Štampaj";
    public static final String FINANCE = "Finansije";
    public static final String MENU_ITEM_BUILDING_DETAILS = "Detalji o zgradi...";
    public static final String MENU_ITEM_OCCUPANT_DETAILS = "Detalji o stanarima...";
    public static final String SECTION_DETAILS = "Detalji o sekciji...";
    public static final String SECTION_DETAILS_TITLE = "Detalji o sekciji";

    /*
    List Building Pane
     */
    public static final String NAME_OF_BUILDING = "Naziv zgrade";
    public static final String NUMBER = "Broj";
    public static final String ID_NUM = "MB";
    public static final String TAX_NUM_BUILDING = "PIB";
    public static final String MAIL = "Mejl adresa";
    public static final String CITY = "Mesto";

    /*
    TopHBox Building Pane
     */
    public static final String SELECT_ITEM = "Izaberi stavku:";

    /*
    FacadeSER & ChangeCalculationEvent
     */
    public static final String BAD_FORMAT_AREA = "Neispravan format za površinu";

    /*
    DetailsSeparatePane
     */
    public static final String INVESTEMENT_MAINTENANCE = "Investiciono održavanje";

    /*
    CalculationPane
     */
    public static final String LIST_ITEM = "Lista stavki za održavanje";

    public static final String TITLE_ADD_OCCUPANT = "Dodavanje stanara";
    public static final String TITLE_ADD_SECTION = "Dodavanje sekcije za ";
    public static final String TITLE_ADD_IND_SECTION = "Dodavanje samostalnog dela za ";
    public static final String TITLE_EDIT_IND_SECTION = "Izmena samostalnog dela: ";
    public static final String TITLE_ADD_COMMON_SECTION = "Dodavanje zajedničkog dela za ";
    public static final String INFO_OCCUPANT = "Informacije o korisniku: ";
    public static final String ADD_NEW_SECTION = "Nova sekcija je dodata";
    public static final String MODIFIED_SECTION = "Sekcija je uspešno izmenjena";
    public static final String ADD_ADMIN_LABEL_PASSWORD_CONFIRM = "Potvrdi lozinku:";
    public static final String FONT_COMIC_SANS = "Comic Sans";
    public static final String FONT_ARIAL = "Arial";
    public static final String FX_BORDER_COLOR_BLACK = "-fx-border-color: black";
    public static final String BUILDINGS_LIST_TITLE = "Lista stambenih zajednica";
    public static final String OCCUPANT_LIST_TITLE = "Lista stanara";

    public static final String OCCUPANT_COLON = "Stanar:";
    public static final String ACCOUNTS = "Računi";
    public static final String STATEMENTS = "Izvodi";
    public static final String EXPORT_TO_PDF = "Izvezi u PDF";

    public static final String EMPTY_STRING = "";
    public static final String DEBIT = "Zaduženje";
    public static final String DEBIT_FOR = "Zaduženje za";
    public static final String FROM_PREVIOUS_PERIOD = "iz prethodnog perioda";
    public static final String SECTION_EDIT_TITLE = "Izmena sekcije";
    public static final String MENU_ITEM_OCCUPANT_LIST = "Lista stanara...";

    public static final String BUTTON_BACK = "Nazad";
    public static final String BUTTON_SEARCH = "Pretraga";
    public static final String BUTTON_CANCEL = "Otkaži";
    public static final String EDIT_OCCUPANT = "Promena podataka korisnika: ";
    public static final String ID = "ID";

    public static final String NOTE = "Napomena";

    public static final String BANK = "Naziv banke";
    public static final String RENTER = "Zakupac";
    public static final String BUILDING = "Stambena zajednica";
    public static final String ADD_BUILDING = "Stambena zajednica je dodata";

    public static final String NOT_ADD_BUILDING = "Stambena zajednica nije dodata";
    public static final String SELECT_BUILDINGS = "Izaberi zgradu:";

    public static final String SELECT_LIST = "Izaberi listu:";
    public static final String FIRST_NAME = "Ime";
    public static final String NAME_OF_SECTION = "Naziv sekcije";
    public static final String PRICE_PER_MONTH = "Mesecno odrzavanje (din/m2)";
    public static final String LAST_NAME = "Prezime";
    public static final String PHONE_NUMBER = "Broj telefona";

    public static final String FLAT_AREA = "Povrsina(m2)";
    public static final String OWNER = "Vlasnik";
    public static final String OWNER_IF_EXIST = "Izabrati vlasnika (ako postoji)";
    public static final String KIND_SECTION = "Vrsta posebnog dela";
    public static final String HASH_KEY = "#";
    public static final String BUTTON_ADD_ACCOUNT = "Dodaj racun";
    public static final String BUTTON_ADD_OCCUPANT = "Dodaj stanara";
    public static final String SEPARATE_SECTIONS = "Posebni delovi";
    public static final String INDEPENDENT_SECTIONS = "Samostalni delovi";
    public static final String COMMON_SECTIONS = "Zajednički delovi";
    public static final String SHOW_ALL_OCCUPANTS = "Prikazi sve stanare u listi";
    public static final String PAYMENT_ITEM_STRING_I = "Investiciono odrzavanje za ";
    public static final String PAYMENT_ITEM_STRING_II = "din./m2)";
    public static final double PARKING_BOX_PRICE = 4.69;
    public static final double PARKING_SPACE_PRICE = 5.69;
    public static final double GARAGE_PRICE = 10;
    public static final double FLAT_PRICE = 7.82;
    public static final double BUSINESS_PRICE = 6.82;
    public static final String FLAT = "Stan";
    public static final String GARAGE = "Garaza";
    public static final String GARAGE_SPACE = "Garazno mesto";
    public static final String GARAGE_BOX = "Garazni boks";
    public static final String BUSINESS_SPACE = "Poslovni prostor";
    public static final String NUMBER_SECTION_EXIST = "Broj sekcije već postoji";
    public static final String OCCUPANT_IDNUM_EXIST = "Stanar sa unetim matičnim brojem već postoji";
    public static final String JANUARY = "Januar";
    public static final String FEBRUARY = "Februar";
    public static final String MARCH = "Mart";
    public static final String APRIL = "April";
    public static final String MAY = "Maj";
    public static final String JUNE = "Jun";
    public static final String JULY = "Jul";
    public static final String AUGUST = "Avgust";
    public static final String SEPTEMBER = "Septembar";
    public static final String OCTOBER = "Oktobar";
    public static final String NOVEMBER = "Novembar";
    public static final String DECEMBER = "Decembar";
    public static final String MONTH = "Mesec";
    public static final String NUMBER_CALCULATION = "Broj računa";
    public static final String SUM_CALCULATION = "Iznos za uplatu";
    public static final String SUM_ALL = "Ukupno za uplatu";
    public static final String STATUS = "Status";
    public static final String ACCOUNT_CALCULATION_FOR = "Račun-Obračun za ";
    public static final String DATE_DELIVERY = "Datum dostave:";
    public static final String DATE_DEADLINE = "Rok za plaćanje:";
    public static final String EDIT_OCCUPANT_SUCCESS = "Uspešno izmenjen korisnik";
    public static final String ADD_OCCUPANT_SUCCESS = "Uspešno dodat stanar";

}
