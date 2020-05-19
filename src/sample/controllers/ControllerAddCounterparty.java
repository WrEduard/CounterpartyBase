package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.database.Counterparty;
import sample.database.DatabaseHandler;
import sample.operation.DialogWindow;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerAddCounterparty {

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
    private Button buttonAddCounterparty;

    @FXML
    private Button back_Button;

    @FXML
    void initialize() {

//        Обработчик кнопки "Додати контрагента"
        buttonAddCounterparty.setOnAction(event -> {
//            Запуск метода getAddCounterparty()
            getAddCounterparty();
        });

//        Обработчик кнопки "Назад"
        back_Button.setOnAction(event -> {
//            Скрыть окно
            back_Button.getScene().getWindow().hide();
        });
    }

    //    Метод добавления контрагента в базу данных
    private void getAddCounterparty() {

//        Присвоение переменным данных из полей для ввода данных
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

//        Проверка заполнения обязательных полей
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
//                  идет поиск совпадений в базе данных по найменованию и коду ЕГРПОУ
//                  Если есть совпадение, то обьект извлекается из базы данных в переменную rs
                ResultSet rs = dbHandler.searhAndReturnCounterparty(edrpou);

//                     Установка курсора на первую строку извлеченного обьекта
                rs.next();

//                     Присваиванее полученных данних переменным класса
                String EDRPOU = rs.getString("EDRPOU");

//                     Перевод полученных строк в нижний регистр
//                     и их сравнение с введенными данными в поле для ввода наименования или кода ЕГРПОУ
                if (EDRPOU.toLowerCase().equals(edrpou.toLowerCase())) {

//                      Если они совпадают, то открывается информативное окно,
//                      про то что такой контрагент уже есть в базе данных
                    DialogWindow.infoBox("Контрагент уже існує в базі даних",
                            "Контрагент з кодом ЄДРПОУ " + edrpou + " уже є в базі даних",
                            "Перевірте введений код ЄДРПОУ");
                }

//              Если контрагента нет базе данных, то он добавляется в базу
            } catch (SQLException e) {
                Counterparty counterparty = new Counterparty(name_counter, legal_form, edrpou, director,
                        cooperation, responsible_person, legal_address, mailing_address, date_of_foundation, phone,
                        phone_fax, email, person_1, person_1_position, person_1_mobile_phone, person_1_email,
                        person_2, person_2_position, person_2_mobile_phone, person_2_email,
                        person_3, person_3_position, person_3_mobile_phone, person_3_email, bank_details, ipn, certificate_pdv);

//            Вызывается метод добавления нового контрагента в базу данных
                dbHandler.addCounterparty(counterparty);

            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
        }
    }
}

