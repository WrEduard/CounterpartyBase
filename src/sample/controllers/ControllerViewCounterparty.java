package sample.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import sample.database.Counterparty;
import sample.database.DatabaseHandler;
import sample.operation.DialogWindow;
import sample.operation.NewWindow;
import sample.operation.Printed;

public class ControllerViewCounterparty extends ControllerSearhAdd {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelCounterparty;

    @FXML
    private TextFlow text_counterparty;

    @FXML
    private Button buttonPrint;

    @FXML
    private Button buttonUpdate;

    @FXML
    private Button buttonDelete;

    public static Counterparty counterparty1;

    @FXML
    void initialize() {

//        Обработчик кнопки "Друк" - печатается поле textAreaViewCounterparty
        buttonPrint.setOnAction(event -> {
            Printed printed = new Printed();
            printed.print(text_counterparty);
        });

//        Обработчик кнопки "Змінити дані про контрагента"
        buttonUpdate.setOnAction(event -> {
            NewWindow newWindow = new NewWindow();
            newWindow.openNewScene("/sample/view/updateCounterparty.fxml");
        });

        buttonDelete.setOnAction(event -> {
            String edrpou = counterparty1.getEdrpou();
            DatabaseHandler dbHandler = new DatabaseHandler();
            try {
                dbHandler.getDbConnection();
                dbHandler.deleteCounterparty(edrpou);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            buttonDelete.getScene().getWindow().hide();
        });

        counterparty1 = new Counterparty(counterparty.getName_counter(), counterparty.getLegal_form(),
                counterparty.getEdrpou(), counterparty.getDirector(), counterparty.getCooperation(),
                counterparty.getResponsible_person(), counterparty.getLegal_address(), counterparty.getMailing_address(),
                counterparty.getDate_of_foundation(), counterparty.getPhone(), counterparty.getPhone_fax(),
                counterparty.getEmail(), counterparty.getPerson_1(), counterparty.getPerson_1_position(),
                counterparty.getPerson_1_mobile_phone(), counterparty.getPerson_1_email(),
                counterparty.getPerson_2(), counterparty.getPerson_2_position(), counterparty.getPerson_2_mobile_phone(),
                counterparty.getPerson_2_email(), counterparty.getPerson_3(), counterparty.getPerson_3_position(),
                counterparty.getPerson_3_mobile_phone(), counterparty.getPerson_3_email(), counterparty.getBank_details(),
                counterparty.getIpn(), counterparty.getCertificate_pdv());

        Text text_name_counter = new Text("Найменування контрагента: ");
        text_name_counter.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text name_counter = new Text(counterparty1.getName_counter() + "\n");

        Text text_legal_form = new Text("Організаційно-правова форма: ");
        text_legal_form.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text legal_form = new Text(counterparty1.getLegal_form() + "\n");

        Text text_edrpou = new Text("Код ЄДРПОУ: ");
        text_edrpou.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text edrpou = new Text(counterparty1.getEdrpou() + "\n");

        Text text_director = new Text("Керівник: ");
        text_director.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text director = new Text(counterparty1.getDirector() + "\n");

        Text text_cooperation = new Text("Предмет співпраці: ");
        text_cooperation.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text cooperation = new Text(counterparty1.getCooperation() + "\n");

        Text text_responsible_person = new Text("Відповідальна особа: ");
        text_responsible_person.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text responsible_person = new Text(counterparty1.getResponsible_person() + "\n");

        Text text_legal_address = new Text("Юридична адреса: ");
        text_legal_address.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text legal_address = new Text(counterparty1.getLegal_address() + "\n");

        Text text_mailing_address = new Text("Поштова адреса: ");
        text_mailing_address.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text mailing_address = new Text(counterparty1.getMailing_address() + "\n");

        Text text_date_of_foundation = new Text("Дата заснування: ");
        text_date_of_foundation.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text date_of_foundation = new Text(counterparty1.getDate_of_foundation() + "\n");

        Text text_phone = new Text("Телефон: ");
        text_phone.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text phone = new Text(counterparty1.getPhone() + "\n");

        Text text_phone_fax = new Text("Телефон/факс: ");
        text_phone_fax.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text phone_fax = new Text(counterparty1.getPhone_fax() + "\n");

        Text text_email = new Text("Електронна адреса: ");
        text_email.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text email = new Text(counterparty1.getEmail() + "\n");

        Text text_person_1 = new Text("Посадова особа 1: ");
        text_person_1.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text person_1 = new Text(counterparty1.getPerson_1() + "\n");

        Text text_person_1_position = new Text("Посада посадової особи 1: ");
        text_person_1_position.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text person_1_position = new Text(counterparty1.getPerson_1_position() + "\n");

        Text text_person_1_mobile_phone = new Text("Телефон посадової особи 1: ");
        text_person_1_mobile_phone.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text person_1_mobile_phone = new Text(counterparty1.getPerson_1_mobile_phone() + "\n");

        Text text_person_1_email = new Text("Електронна адреса посадової особи 1: ");
        text_person_1_email.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text person_1_email = new Text(counterparty1.getPerson_1_email() + "\n");

        Text text_person_2 = new Text("Посадова особа 2: ");
        text_person_2.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text person_2 = new Text(counterparty1.getPerson_2() + "\n");

        Text text_person_2_position = new Text("Посада посадової особи 2: ");
        text_person_2_position.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text person_2_position = new Text(counterparty1.getPerson_2_position() + "\n");

        Text text_person_2_mobile_phone = new Text("Телефон посадової особи 2: ");
        text_person_2_mobile_phone.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text person_2_mobile_phone = new Text(counterparty1.getPerson_2_mobile_phone() + "\n");

        Text text_person_2_email = new Text("Електронна адреса посадової особи 2: ");
        text_person_2_email.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text person_2_email = new Text(counterparty1.getPerson_2_email() + "\n");

        Text text_person_3 = new Text("Посадова особа 3: ");
        text_person_3.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text person_3 = new Text(counterparty1.getPerson_3() + "\n");

        Text text_person_3_position = new Text("Посада посадової особи 3: ");
        text_person_3_position.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text person_3_position = new Text(counterparty1.getPerson_3_position() + "\n");

        Text text_person_3_mobile_phone = new Text("Телефон посадової особи 3: ");
        text_person_3_mobile_phone.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text person_3_mobile_phone = new Text(counterparty1.getPerson_3_mobile_phone() + "\n");

        Text text_person_3_email = new Text("Електронна адреса посадової особи 3: ");
        text_person_3_email.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text person_3_email = new Text(counterparty1.getPerson_3_email() + "\n");

        Text text_bank_details = new Text("Банківські реквізити: ");
        text_bank_details.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text bank_details = new Text(counterparty1.getBank_details() + "\n");

        Text text_ipn = new Text("ІПН : ");
        text_ipn.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text ipn = new Text(counterparty1.getIpn() + "\n");

        Text text_certificate_pdv = new Text("Свідоцтво ПДВ № : ");
        text_certificate_pdv.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
        Text certificate_pdv = new Text(counterparty1.getCertificate_pdv() + "\n");

        text_counterparty.getChildren().add(text_name_counter);
        text_counterparty.getChildren().add(name_counter);
        text_counterparty.getChildren().add(text_legal_form);
        text_counterparty.getChildren().add(legal_form);
        text_counterparty.getChildren().add(text_edrpou);
        text_counterparty.getChildren().add(edrpou);
        text_counterparty.getChildren().add(text_director);
        text_counterparty.getChildren().add(director);
        text_counterparty.getChildren().add(text_cooperation);
        text_counterparty.getChildren().add(cooperation);
        text_counterparty.getChildren().add(text_responsible_person);
        text_counterparty.getChildren().add(responsible_person);
        text_counterparty.getChildren().add(text_legal_address);
        text_counterparty.getChildren().add(legal_address);
        text_counterparty.getChildren().add(text_mailing_address);
        text_counterparty.getChildren().add(mailing_address);
        text_counterparty.getChildren().add(text_date_of_foundation);
        text_counterparty.getChildren().add(date_of_foundation);
        text_counterparty.getChildren().add(text_phone);
        text_counterparty.getChildren().add(phone);
        text_counterparty.getChildren().add(text_phone_fax);
        text_counterparty.getChildren().add(phone_fax);
        text_counterparty.getChildren().add(text_email);
        text_counterparty.getChildren().add(email);
        text_counterparty.getChildren().add(text_person_1);
        text_counterparty.getChildren().add(person_1);
        text_counterparty.getChildren().add(text_person_1_position);
        text_counterparty.getChildren().add(person_1_position);
        text_counterparty.getChildren().add(text_person_1_mobile_phone);
        text_counterparty.getChildren().add(person_1_mobile_phone);
        text_counterparty.getChildren().add(text_person_1_email);
        text_counterparty.getChildren().add(person_1_email);
        text_counterparty.getChildren().add(text_person_2);
        text_counterparty.getChildren().add(person_2);
        text_counterparty.getChildren().add(text_person_2_position);
        text_counterparty.getChildren().add(person_2_position);
        text_counterparty.getChildren().add(text_person_2_mobile_phone);
        text_counterparty.getChildren().add(person_2_mobile_phone);
        text_counterparty.getChildren().add(text_person_2_email);
        text_counterparty.getChildren().add(person_2_email);
        text_counterparty.getChildren().add(text_person_3);
        text_counterparty.getChildren().add(person_3);
        text_counterparty.getChildren().add(text_person_3_position);
        text_counterparty.getChildren().add(person_3_position);
        text_counterparty.getChildren().add(text_person_3_mobile_phone);
        text_counterparty.getChildren().add(person_3_mobile_phone);
        text_counterparty.getChildren().add(text_person_3_email);
        text_counterparty.getChildren().add(person_3_email);
        text_counterparty.getChildren().add(text_bank_details);
        text_counterparty.getChildren().add(bank_details);
        text_counterparty.getChildren().add(text_ipn);
        text_counterparty.getChildren().add(ipn);
        text_counterparty.getChildren().add(text_certificate_pdv);
        text_counterparty.getChildren().add(certificate_pdv);
    }
}

