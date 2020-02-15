package com.twu.biblioteca;

public class Record {

    private Customer customer;
    private Publication loanedPub;

    public Record(Customer customer, Publication pub) {
        this.customer = customer;
        this.loanedPub = pub;
    }

    @Override
    public String toString() {
        String string = customer.getName();
        string += " | ";
        string += customer.getNumber();
        string += " -> ";
        string += loanedPub.toString();
        return string;
    }
}
