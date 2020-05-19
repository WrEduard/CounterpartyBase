package sample.database;

import sample.operation.DialogWindow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

// Метод соединения с базой данных
public class DatabaseHandler extends Configs {

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {

        Connection dbConnection;

        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    //  Метод добавления нового контрагента в базу данных
    public void addCounterparty(Counterparty counterparty) {

//        Строка запроса в базу данных MSQL
        String insert = "INSERT INTO " + Const.COUNTERS_TABLE + "(" + Const.NAME_COUNTER + "," + Const.LEGAL_FORM + ","
                + Const.EDRPOU + "," + Const.DIRECTOR + "," + Const.COOPERATION + "," + Const.RESPONSIBLE_PERSON + "," +
                Const.LEGAL_ADDRESS + "," + Const.MAILING_ADDRESS + "," + Const.DATE_OF_FOUNDATION + "," +
                Const.PHONE + "," + Const.PHONE_FAX + "," + Const.EMAIL + "," + Const.PERSON_1 + "," +
                Const.PERSON_1_POSITION + "," + Const.PERSON_1_MOBILE_PHONE + "," + Const.PERSON_1_EMAIL + "," +
                Const.PERSON_2 + "," + Const.PERSON_2_POSITION + "," + Const.PERSON_2_MOBILE_PHONE + "," +
                Const.PERSON_2_EMAIL + "," + Const.PERSON_3 + "," + Const.PERSON_3_POSITION + "," +
                Const.PERSON_3_MOBILE_PHONE + "," + Const.PERSON_3_EMAIL + "," + Const.BANK_DETAILS + "," +
                Const.IPN + "," + Const.CERTIFICATE_PDV + ")" + "VALUES(?,?,?,?,?,?,?,?,?,?," +
                "?,?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, counterparty.getName_counter());
            prSt.setString(2, counterparty.getLegal_form());
            prSt.setString(3, counterparty.getEdrpou());
            prSt.setString(4, counterparty.getDirector());
            prSt.setString(5, counterparty.getCooperation());
            prSt.setString(6, counterparty.getResponsible_person());
            prSt.setString(7, counterparty.getLegal_address());
            prSt.setString(8, counterparty.getMailing_address());
            prSt.setString(9, counterparty.getDate_of_foundation());
            prSt.setString(10, counterparty.getPhone());
            prSt.setString(11, counterparty.getPhone_fax());
            prSt.setString(12, counterparty.getEmail());
            prSt.setString(13, counterparty.getPerson_1());
            prSt.setString(14, counterparty.getPerson_1_position());
            prSt.setString(15, counterparty.getPerson_1_mobile_phone());
            prSt.setString(16, counterparty.getPerson_1_email());
            prSt.setString(17, counterparty.getPerson_2());
            prSt.setString(18, counterparty.getPerson_2_position());
            prSt.setString(19, counterparty.getPerson_2_mobile_phone());
            prSt.setString(20, counterparty.getPerson_2_email());
            prSt.setString(21, counterparty.getPerson_3());
            prSt.setString(22, counterparty.getPerson_3_position());
            prSt.setString(23, counterparty.getPerson_3_mobile_phone());
            prSt.setString(24, counterparty.getPerson_3_email());
            prSt.setString(25, counterparty.getBank_details());
            prSt.setString(26, counterparty.getIpn());
            prSt.setString(27, counterparty.getCertificate_pdv());

            prSt.executeUpdate();
            DialogWindow.infoBox("Контрагента додано", "", "");

        } catch (SQLException e) {
            e.printStackTrace();
            DialogWindow.infoBox("Контрагента не додано", "Помилка", "Помилка");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            DialogWindow.infoBox("Контрагента не додано", "Помилка", "Помилка");
        }
    }

    public void updateCounterparty(Counterparty counterparty) {
        //        Строка запроса в базу данных MSQL
        String uptate = "UPDATE " +
                Const.COUNTERS_TABLE +
                " SET " +
                Const.NAME_COUNTER + " = ?, " +
                Const.LEGAL_FORM + " = ?, " +
                Const.DIRECTOR + " = ?, " +
                Const.COOPERATION + " = ?, " +
                Const.RESPONSIBLE_PERSON + " = ?, " +
                Const.LEGAL_ADDRESS + " = ?, " +
                Const.MAILING_ADDRESS + " = ?, " +
                Const.DATE_OF_FOUNDATION  + " = ?, " +
                Const.PHONE + " = ?, " +
                Const.PHONE_FAX + " = ?, " +
                Const.EMAIL + " = ?, " +
                Const.PERSON_1 + " = ?, " +
                Const.PERSON_1_POSITION + " = ?, " +
                Const.PERSON_1_MOBILE_PHONE + " = ?, " +
                Const.PERSON_1_EMAIL + " = ?, " +
                Const.PERSON_2 + " = ?," +
                Const.PERSON_2_POSITION + " = ?," +
                Const.PERSON_2_MOBILE_PHONE + " = ?," +
                Const.PERSON_2_EMAIL + " = ?," +
                Const.PERSON_3 + " = ?," +
                Const.PERSON_3_POSITION + " = ?," +
                Const.PERSON_3_MOBILE_PHONE + " = ?," +
                Const.PERSON_3_EMAIL + " = ?," +
                Const.BANK_DETAILS + " = ?," +
                Const.IPN + " = ?, " +
                Const.CERTIFICATE_PDV + " = ?" +
                " WHERE " +
                Const.EDRPOU + " = ?;";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(uptate);
            prSt.setString(1, counterparty.getName_counter());
            prSt.setString(2, counterparty.getLegal_form());
            prSt.setString(3, counterparty.getDirector());
            prSt.setString(4, counterparty.getCooperation());
            prSt.setString(5, counterparty.getResponsible_person());
            prSt.setString(6, counterparty.getLegal_address());
            prSt.setString(7, counterparty.getMailing_address());
            prSt.setString(8, counterparty.getDate_of_foundation());
            prSt.setString(9, counterparty.getPhone());
            prSt.setString(10, counterparty.getPhone_fax());
            prSt.setString(11, counterparty.getEmail());
            prSt.setString(12, counterparty.getPerson_1());
            prSt.setString(13, counterparty.getPerson_1_position());
            prSt.setString(14, counterparty.getPerson_1_mobile_phone());
            prSt.setString(15, counterparty.getPerson_1_email());
            prSt.setString(16, counterparty.getPerson_2());
            prSt.setString(17, counterparty.getPerson_2_position());
            prSt.setString(18, counterparty.getPerson_2_mobile_phone());
            prSt.setString(19, counterparty.getPerson_2_email());
            prSt.setString(20, counterparty.getPerson_3());
            prSt.setString(21, counterparty.getPerson_3_position());
            prSt.setString(22, counterparty.getPerson_3_mobile_phone());
            prSt.setString(23, counterparty.getPerson_3_email());
            prSt.setString(24, counterparty.getBank_details());
            prSt.setString(25, counterparty.getIpn());
            prSt.setString(26, counterparty.getCertificate_pdv());
            prSt.setString(27, counterparty.getEdrpou());

            prSt.executeUpdate();

            DialogWindow.infoBox("Контрагента змінено", "", "");

        } catch (SQLException e) {
            e.printStackTrace();
            DialogWindow.infoBox("Контрагента не змінено", "Помилка", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            DialogWindow.infoBox("Контрагента не змінено", "Помилка", "");
        }
    }

    public void deleteCounterparty(String edrpou){
        String deleteCounterparty = "DELETE FROM " + Const.COUNTERS_TABLE + " WHERE " + Const.EDRPOU + " =?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(deleteCounterparty);
            prSt.setString(1, edrpou);
            prSt.executeUpdate();
            DialogWindow.infoBox("Контрагента видалено", "", "");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//Проверка есть ли контрагент с введенным ЕГРПОУ в базе данных
//Возвращается контрагент или пустое значение

    public ResultSet searhAndReturnCounterparty(String nameOrEdrpou) throws SQLException {

        ResultSet resSet = null;

        try {
//            Строка запроса в базу данных MSQL
//            char str1 = (char)34;
//            String str2 = String.format(str1+"%%" + nameOrEdrpou + "%%" + str1);
            String select = "SELECT * FROM " + Const.COUNTERS_TABLE + " WHERE EDRPOU = ? or name_counter = ?";

            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, nameOrEdrpou);
            prSt.setString(2, nameOrEdrpou);

            resSet = prSt.executeQuery();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            DialogWindow.infoBox("",
                    "Помилка", "Не вдалося отримати дані з бази даних");

        } catch (SQLException e) {
            DialogWindow.infoBox("Перевірте чи запущена служба MSQL",
                    "Помилка з'єднання", "Не вдалося з'єднатися з базою даних");
            e.printStackTrace();
        }
        return resSet;
    }
}
