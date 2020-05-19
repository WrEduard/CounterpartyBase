package sample.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.database.Counterparty;
import sample.database.DatabaseHandler;
import sample.operation.*;

public class ControllerSearhAdd {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField searh_field;

    @FXML
    private TextField add_field;

    @FXML
    private Button searh_button;

    @FXML
    private Button add_button;

    @FXML
    private Button button_allCounterparty;

    public static Counterparty counterparty;

    @FXML
    void initialize() {

//         Обработчик кнопки "Знайти"
        searh_button.setOnAction(event -> {

//             Полученние введеных даних с поля для ввода наименования или кода ЕГРПОУ
            String nameOrEdrpou = searh_field.getText();

//             Обьявление переменной, в которую будет извлекатся обьект из базы данных
            ResultSet rs;

//             Выделение памяти для обьекта класса DatabaseHandler
            DatabaseHandler connect = new DatabaseHandler();

//             Проверка ввода данных в поле для ввода наименования или кода ЕГРПОУ
//             Если поле для ввода наименования или кода ЕГРПОУ пустое, то
//             открывается информативное окно об этом
            if (nameOrEdrpou.equals("")) {
                DialogWindow.infoBox("Ви не ввели код ЄДРПОУ/назву",
                        "", "Перевірте введений код ЄДРПОУ/назву");

//                 Если поле для ввода наименования или кода ЕГРПОУ не пустое, то:
            } else {
//                 выполняется соединение с базой данных
                connectDatabase(connect);
                try {
//                     идет поиск совпадений в базе данных по найменованию и коду ЕГРПОУ
//                     Если есть совпадение, то обьект извлекается из базы данных в переменную rs
                    rs = connect.searhAndReturnCounterparty(nameOrEdrpou);

//                     Установка курсора на первую строку извлеченного обьекта
                    rs.next();

//                     Присваиванее полученных данних переменным
                    String name_counter = rs.getString("name_counter");
                    String legal_form = rs.getString("legal_form");
                    String EDRPOU = rs.getString("EDRPOU");
                    String director = rs.getString("director");
                    String cooperation = rs.getString("cooperation");
                    String responsible_person = rs.getString("responsible_person");
                    String legal_address = rs.getString("legal_address");
                    String mailing_address = rs.getString("mailing_address");
                    String date_of_foundation = rs.getString("date_of_foundation");
                    String phone = rs.getString("phone");
                    String phone_fax = rs.getString("phone_fax");
                    String email = rs.getString("email");
                    String person_1 = rs.getString("person_1");
                    String person_1_position = rs.getString("person_1_position");
                    String person_1_mobile_phone = rs.getString("person_1_mobile_phone");
                    String person_1_email = rs.getString("person_1_email");
                    String person_2 = rs.getString("person_2");
                    String person_2_position = rs.getString("person_2_position");
                    String person_2_mobile_phone = rs.getString("person_2_mobile_phone");
                    String person_2_email = rs.getString("person_2_email");
                    String person_3 = rs.getString("person_3");
                    String person_3_position = rs.getString("person_3_position");
                    String person_3_mobile_phone = rs.getString("person_3_mobile_phone");
                    String person_3_email = rs.getString("person_3_email");
                    String bank_details = rs.getString("bank_details");
                    String IPN = rs.getString("IPN");
                    String certificate_pdv = rs.getString("certificate_PDV");

//                     Перевод полученных строк в нижний регистр
//                     и их сравнение с введенными данными в поле для ввода наименования или кода ЕГРПОУ
                    if (EDRPOU.toLowerCase().equals(nameOrEdrpou.toLowerCase()) ||
                            name_counter.toLowerCase().equals(nameOrEdrpou.toLowerCase())) {

//                         Если они совпадают, то создается обьект класса Counterparty
//                         с присвоением ему данных, полученых из базы данных, после чего
                        counterparty = new Counterparty(name_counter, legal_form, EDRPOU, director,
                                cooperation, responsible_person, legal_address, mailing_address, date_of_foundation,
                                phone, phone_fax, email, person_1, person_1_position, person_1_mobile_phone,
                                person_1_email, person_2, person_2_position, person_2_mobile_phone, person_2_email,
                                person_3, person_3_position, person_3_mobile_phone, person_3_email,
                                bank_details, IPN, certificate_pdv);

//                         выполняется переход к окну отображения контрагента
                        NewWindow newWindow = new NewWindow();
                        newWindow.openNewScene("/sample/view/viewCounterparty.fxml");

                    }
//                     Если совпадений введеных данных с базой данных нет, то
//                     открывается информативное окно об этом
                } catch (SQLException e) {
                    DialogWindow.infoBox("Контрагента із кодом ЄДРПОУ/назвою " + nameOrEdrpou + " не знайдено",
                            "", "Контрагента із кодом ЄДРПОУ/назвою " + nameOrEdrpou + " не знайдено");
                }
            }
        });

        add_button.setOnAction(event -> {
//             Полученние введеных даних с поля для ввода наименования или кода ЕГРПОУ
            String nameOrEdrpou = add_field.getText();

//             Обьявление переменной, в которую будет извлекатся обьект из базы данных
            ResultSet rs;

//             Выделение памяти для обьекта класса DatabaseHandler
            DatabaseHandler connect = new DatabaseHandler();

//             Проверка ввода данных в поле для ввода наименования или кода ЕГРПОУ
//             Если поле для ввода наименования или кода ЕГРПОУ пустое, то
//             открывается информативное окно об этом
            if (nameOrEdrpou.equals("")) {
                DialogWindow.infoBox("Ви не ввели код ЄДРПОУ/назву",
                        "", "Перевірте введений код ЄДРПОУ/назву");

//                 Если поле для ввода наименования или кода ЕГРПОУ не пустое, то:
            } else {
//                 выполняется соединение с базой данных
                connectDatabase(connect);
                try {
//                  идет поиск совпадений в базе данных по найменованию и коду ЕГРПОУ
//                  Если есть совпадение, то обьект извлекается из базы данных в переменную rs
                    rs = connect.searhAndReturnCounterparty(nameOrEdrpou);

//                     Установка курсора на первую строку извлеченного обьекта
                    rs.next();

//                     Присваиванее полученных данних переменным класса
                    String name_counter = rs.getString("name_counter");
                    String EDRPOU = rs.getString("EDRPOU");

//                     Перевод полученных строк в нижний регистр
//                     и их сравнение с введенными данными в поле для ввода наименования или кода ЕГРПОУ
                    if (EDRPOU.toLowerCase().equals(nameOrEdrpou.toLowerCase()) ||
                            name_counter.toLowerCase().equals(nameOrEdrpou.toLowerCase())) {

//                      Если они совпадают, то открывается информативное окно,
//                      про то что такой контрагент уже есть в базе данных
                        DialogWindow.infoBox("Контрагент уже існує в базі даних",
                                "Контрагент з кодом ЄДРПОУ " + nameOrEdrpou + " уже є в базі даних",
                                "Перевірте введений код ЄДРПОУ");
                    }

//                  Если совпадений введеных данных с базой данных нет, то
//                  открывется окно для добавления нового контрагента
                } catch (SQLException e) {
                    NewWindow newWindow = new NewWindow();
                    newWindow.openNewScene("/sample/view/addCounterparty.fxml");
                }
            }
        });
    }

    //    Метод соединения с базой данных
    public void connectDatabase(DatabaseHandler connect) {
        try {
            connect.getDbConnection();
        } catch (ClassNotFoundException e) {
            System.out.println("109");
            DialogWindow.infoBox("Перевірте чи запущена служба MSQL",
                    "Помилка з'єднання", "Не вдалося з'єднатися з базою даних");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("113");
            DialogWindow.infoBox("Перевірте чи запущена служба MSQL",
                    "Помилка з'єднання", "Не вдалося з'єднатися з базою даних");
            e.printStackTrace();
        }
    }
}
