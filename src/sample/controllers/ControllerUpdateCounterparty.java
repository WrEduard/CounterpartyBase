package sample.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.database.Counterparty;
import sample.database.DatabaseHandler;
import sample.operation.DialogWindow;

public class ControllerUpdateCounterparty extends ControllerViewCounterparty {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label updateCounterparty;

    @FXML
    private TextField name_counter;

    @FXML
    private TextField legal_form;

    @FXML
    private TextField edrpou;

    @FXML
    private TextField director;

    @FXML
    private TextField cooperation;

    @FXML
    private TextField responsible_person;

    @FXML
    private TextField date_of_foundation;

    @FXML
    private TextField phone;

    @FXML
    private TextField phone_fax;

    @FXML
    private TextField email;

    @FXML
    private TextField ipn;

    @FXML
    private TextField certificate_pdv;

    @FXML
    private TextArea legal_address;

    @FXML
    private TextArea mailing_address;

    @FXML
    private TextArea bank_details;

    @FXML
    private TextField person_1;

    @FXML
    private TextField person_1_position;

    @FXML
    private TextField person_1_mobile_phone;

    @FXML
    private TextField person_1_email;

    @FXML
    private TextField person_2;

    @FXML
    private TextField person_2_position;

    @FXML
    private TextField person_2_mobile_phone;

    @FXML
    private TextField person_2_email;

    @FXML
    private TextField person_3;

    @FXML
    private TextField person_3_position;

    @FXML
    private TextField person_3_mobile_phone;

    @FXML
    private TextField person_3_email;

    @FXML
    private Button buttonUpdateCounterparty;

    @FXML
    private Button back_Button;

    @FXML
    void initialize() {
        name_counter.setText(counterparty1.getName_counter());
        legal_form.setText(counterparty1.getLegal_form());
        edrpou.setText(counterparty1.getEdrpou());
        director.setText(counterparty1.getDirector());
        cooperation.setText(counterparty1.getCooperation());
        responsible_person.setText(counterparty1.getResponsible_person());
        legal_address.setText(counterparty1.getLegal_address());
        mailing_address.setText(counterparty1.getMailing_address());
        date_of_foundation.setText(counterparty1.getDate_of_foundation());
        phone.setText(counterparty1.getPhone());
        phone_fax.setText(counterparty1.getPhone_fax());
        email.setText(counterparty1.getEmail());
        person_1.setText(counterparty1.getPerson_1());
        person_1_position.setText(counterparty1.getPerson_1_position());
        person_1_mobile_phone.setText(counterparty1.getPerson_1_mobile_phone());
        person_1_email.setText(counterparty1.getPerson_1_email());
        person_2.setText(counterparty1.getPerson_2());
        person_2_position.setText(counterparty1.getPerson_2_position());
        person_2_mobile_phone.setText(counterparty1.getPerson_2_mobile_phone());
        person_2_email.setText(counterparty1.getPerson_2_email());
        person_3.setText(counterparty1.getPerson_3());
        person_3_position.setText(counterparty1.getPerson_3_position());
        person_3_mobile_phone.setText(counterparty1.getPerson_3_mobile_phone());
        person_3_email.setText(counterparty1.getPerson_3_email());
        bank_details.setText(counterparty1.getBank_details());
        ipn.setText(counterparty1.getIpn());
        certificate_pdv.setText(counterparty1.getCertificate_pdv());


        buttonUpdateCounterparty.setOnAction(event -> {
//        Проверка заполнения обязательных полей

            String name_counter = this.name_counter.getText();
            String legal_form = this.legal_form.getText();
            String edrpou = this.edrpou.getText();
            String director = this.director.getText();
            String cooperation = this.cooperation.getText();
            String responsible_person = this.responsible_person.getText();
            String legal_address = this.legal_address.getText();
            String mailing_address = this.mailing_address.getText();
            String date_of_foundation = this.date_of_foundation.getText();
            String phone = this.phone.getText();
            String phone_fax = this.phone_fax.getText();
            String email = this.email.getText();
            String person_1 = this.person_1.getText();
            String person_1_position = this.person_1_position.getText();
            String person_1_mobile_phone = this.person_1_mobile_phone.getText();
            String person_1_email = this.person_1_email.getText();
            String person_2 = this.person_2.getText();
            String person_2_position = this.person_2_position.getText();
            String person_2_mobile_phone = this.person_2_mobile_phone.getText();
            String person_2_email = this.person_2_email.getText();
            String person_3 = this.person_3.getText();
            String person_3_position = this.person_3_position.getText();
            String person_3_mobile_phone = this.person_3_mobile_phone.getText();
            String person_3_email = this.person_3_email.getText();
            String bank_details = this.bank_details.getText();
            String ipn = this.ipn.getText();
            String certificate_pdv = this.certificate_pdv.getText();

            if (name_counter.equals("") || legal_form.equals("") || edrpou.equals("") ||
                    director.equals("") || cooperation.equals("") || responsible_person.equals("") ||
                    legal_address.equals("") || date_of_foundation.equals("")) {
                DialogWindow.infoBox("Перевірте правильність заповнення усіх даних",
                        "Помилка", "Не заповнені обов'язкові поля");
//      Если все поля заполненны, то
            } else {
                DatabaseHandler dbHandler = new DatabaseHandler();
                try {
                    dbHandler.getDbConnection();

                    Counterparty counterparty = new Counterparty(name_counter, legal_form, edrpou, director,
                            cooperation, responsible_person, legal_address, mailing_address,
                            date_of_foundation, phone, phone_fax, email,
                            person_1, person_1_position, person_1_mobile_phone, person_1_email,
                            person_2, person_2_position, person_2_mobile_phone, person_2_email,
                            person_3, person_3_position, person_3_mobile_phone, person_3_email,
                            bank_details, ipn, certificate_pdv);

                    dbHandler.updateCounterparty(counterparty);

                } catch (SQLException e) {
                } catch (ClassNotFoundException e) {
                    System.out.println(e);
                }
            }
        });
    back_Button.setOnAction(event -> {
        back_Button.getScene().getWindow().hide();
    });
    }
}


