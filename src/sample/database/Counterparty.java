package sample.database;

public class Counterparty {
    private String name_counter;
    private String legal_form;
    private String edrpou;
    private String director;
    private String cooperation;
    private String responsible_person;
    private String legal_address;
    private String mailing_address;
    private String date_of_foundation;
    private String phone;
    private String phone_fax;
    private String email;
    private String person_1;
    private String person_1_position;
    private String person_1_mobile_phone;
    private String person_1_email;
    private String person_2;
    private String person_2_position;
    private String person_2_mobile_phone;
    private String person_2_email;
    private String person_3;
    private String person_3_position;
    private String person_3_mobile_phone;
    private String person_3_email;
    private String bank_details;
    private String ipn;
    private String certificate_pdv;

//    Конструктор клсса Counterparty
    public Counterparty(String name_counter, String legal_form, String edrpou,
                        String director, String cooperation, String responsible_person,
                        String legal_address, String mailing_address, String date_of_foundation,
                        String phone, String phone_fax, String email, String person_1,
                        String person_1_position, String person_1_mobile_phone, String person_1_email,
                        String person_2, String person_2_position, String person_2_mobile_phone,
                        String person_2_email, String person_3, String person_3_position,
                        String person_3_mobile_phone, String person_3_email, String bank_details,
                        String ipn, String certificate_pdv) {

        this.name_counter = name_counter;
        this.legal_form = legal_form;
        this.edrpou = edrpou;
        this.director = director;
        this.cooperation = cooperation;
        this.responsible_person = responsible_person;
        this.legal_address = legal_address;
        this.mailing_address = mailing_address;
        this.date_of_foundation = date_of_foundation;
        this.phone = phone;
        this.phone_fax = phone_fax;
        this.email = email;
        this.person_1 = person_1;
        this.person_1_position = person_1_position;
        this.person_1_mobile_phone = person_1_mobile_phone;
        this.person_1_email = person_1_email;
        this.person_2 = person_2;
        this.person_2_position = person_2_position;
        this.person_2_mobile_phone = person_2_mobile_phone;
        this.person_2_email = person_2_email;
        this.person_3 = person_3;
        this.person_3_position = person_3_position;
        this.person_3_mobile_phone = person_3_mobile_phone;
        this.person_3_email = person_3_email;
        this.bank_details = bank_details;
        this.ipn = ipn;
        this.certificate_pdv = certificate_pdv;
    }

    public String getName_counter() {
        return name_counter;
    }

    public void setName_counter(String name_counter) {
        this.name_counter = name_counter;
    }

    public String getLegal_form() {
        return legal_form;
    }

    public void setLegal_form(String legal_form) {
        this.legal_form = legal_form;
    }

    public String getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(String edrpou) {
        this.edrpou = edrpou;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCooperation() {
        return cooperation;
    }

    public void setCooperation(String cooperation) {
        this.cooperation = cooperation;
    }

    public String getResponsible_person() {
        return responsible_person;
    }

    public void setResponsible_person(String responsible_person) {
        this.responsible_person = responsible_person;
    }

    public String getLegal_address() {
        return legal_address;
    }

    public void setLegal_address(String legal_address) {
        this.legal_address = legal_address;
    }

    public String getMailing_address() {
        return mailing_address;
    }

    public void setMailing_address(String mailing_address) {
        this.mailing_address = mailing_address;
    }

    public String getDate_of_foundation() {
        return date_of_foundation;
    }

    public void setDate_of_foundation(String date_of_foundation) {
        this.date_of_foundation = date_of_foundation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone_fax() {
        return phone_fax;
    }

    public void setPhone_fax(String phone_fax) {
        this.phone_fax = phone_fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerson_1() {
        return person_1;
    }

    public void setPerson_1(String person_1) {
        this.person_1 = person_1;
    }

    public String getPerson_1_position() {
        return person_1_position;
    }

    public void setPerson_1_position(String person_1_position) {
        this.person_1_position = person_1_position;
    }

    public String getPerson_1_mobile_phone() {
        return person_1_mobile_phone;
    }

    public void setPerson_1_mobile_phone(String person_1_mobile_phone) {
        this.person_1_mobile_phone = person_1_mobile_phone;
    }

    public String getPerson_1_email() {
        return person_1_email;
    }

    public void setPerson_1_email(String person_1_email) {
        this.person_1_email = person_1_email;
    }

    public String getPerson_2() {
        return person_2;
    }

    public void setPerson_2(String person_2) {
        this.person_2 = person_2;
    }

    public String getPerson_2_position() {
        return person_2_position;
    }

    public void setPerson_2_position(String person_2_position) {
        this.person_2_position = person_2_position;
    }

    public String getPerson_2_mobile_phone() {
        return person_2_mobile_phone;
    }

    public void setPerson_2_mobile_phone(String person_2_mobile_phone) {
        this.person_2_mobile_phone = person_2_mobile_phone;
    }

    public String getPerson_2_email() {
        return person_2_email;
    }

    public void setPerson_2_email(String person_2_email) {
        this.person_2_email = person_2_email;
    }

    public String getPerson_3() {
        return person_3;
    }

    public void setPerson_3(String person_3) {
        this.person_3 = person_3;
    }

    public String getPerson_3_position() {
        return person_3_position;
    }

    public void setPerson_3_position(String person_3_position) {
        this.person_3_position = person_3_position;
    }

    public String getPerson_3_mobile_phone() {
        return person_3_mobile_phone;
    }

    public void setPerson_3_mobile_phone(String person_3_mobile_phone) {
        this.person_3_mobile_phone = person_3_mobile_phone;
    }

    public String getPerson_3_email() {
        return person_3_email;
    }

    public void setPerson_3_email(String person_3_email) {
        this.person_3_email = person_3_email;
    }

    public String getBank_details() {
        return bank_details;
    }

    public void setBank_details(String bank_details) {
        this.bank_details = bank_details;
    }

    public String getIpn() {
        return ipn;
    }

    public void setIpn(String ipn) {
        this.ipn = ipn;
    }

    public String getCertificate_pdv() {
        return certificate_pdv;
    }

    public void setCertificate_pdv(String certificate_pdv) {
        this.certificate_pdv = certificate_pdv;
    }
}

