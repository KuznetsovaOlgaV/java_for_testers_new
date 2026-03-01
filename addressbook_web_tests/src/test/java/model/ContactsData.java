package model;

public record ContactsData(String firstname, String lastname, String address, String mobile, String email) {
    public ContactsData() {
        this("", "", "", "", "");

    }

    public ContactsData withFirstName(String firstname) {
        return new ContactsData(firstname, this.lastname, this.address, this.mobile, this.email);
    }

    public ContactsData withLastName(String lastname) {
        return new ContactsData(this.firstname, lastname, this.address, this.mobile, this.email);
    }

    public ContactsData withAddress(String address) {
        return new ContactsData(this.firstname, this.lastname, address, this.mobile, this.email);
    }

    public ContactsData withMobile(String mobile) {
        return new ContactsData(this.firstname, this.lastname, this.address, mobile, this.email);
    }

    public ContactsData withEMail(String email) {
        return new ContactsData(this.firstname, this.lastname, this.address, this.mobile, email);
    }
}