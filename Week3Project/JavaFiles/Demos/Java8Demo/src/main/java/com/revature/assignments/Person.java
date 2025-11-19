package com.revature.assignments;

public class Person {
    private String name;
    private String phone;
    private Address address;

    public Person(){
    }

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
        // this.address = null;
    }

    public Person(String name, String phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Person(String name, String phone, String street, String city, int zip) {
        this.name = name;
        this.phone = phone;
        this.address = new Address(street, city, zip);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAddress(String street, String city, int zip) {
        this.address.setStreet(street);
        this.address.setCity(city);
        this.address.setZipCode(zip);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }
}
