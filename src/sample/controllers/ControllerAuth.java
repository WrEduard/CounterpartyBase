package sample.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.animation.Shake;
import sample.database.DatabaseHandler;
import sample.operation.*;

public class ControllerAuth extends DatabaseHandler {

    // Установка логина и пароля для авторизации
    private String mLogin = "";
    private String mPassword = "";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField auth_password_field;

    @FXML
    private TextField auth_login_field;

    @FXML
    private Label auth_label;

    @FXML
    private Button auth_entry_button;

    @FXML
    void initialize() {

        // Обработчик кнопки "Вхід"
        auth_entry_button.setOnAction(event -> {

            // Получение введеных даных с полей "Логін" и "Пароль"
            String in_login = auth_login_field.getText().trim();
            String in_password = auth_password_field.getText();

            // Если введеные логин и пароль совпадают с предустановленными,
            // то выполняется переход к следующему окну
            if (in_login.equals(mLogin) && in_password.equals(mPassword)) {
                auth_entry_button.getScene().getWindow().hide();
                NewWindow newWindow = new NewWindow();
                newWindow.openNewScene("/sample/view/searhAdd.fxml");

                // Если логин совпадает, а пароль не совпадает с предустановленым
            } else if (in_login.equals(mLogin) && !in_password.equals(mPassword)) {
                Shake password_filed = new Shake(auth_password_field);
                password_filed.playAnim();

                // Если пароль совпадает, а логин не совпадает с предустановленым
            } else if (!in_login.equals(mLogin) && in_password.equals(mPassword)) {
                Shake login_filed = new Shake(auth_login_field);
                login_filed.playAnim();

                // Если логин и пароль не совпадают с предустановлеными
            } else {
                Shake password_filed = new Shake(auth_password_field);
                password_filed.playAnim();
                Shake login_filed = new Shake(auth_login_field);
                login_filed.playAnim();
            }
        });
    }
}


