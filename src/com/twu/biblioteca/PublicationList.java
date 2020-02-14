package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class PublicationList<T> {
    private List<T> pubs;

    public PublicationList() {
        pubs = new ArrayList<>();
    }

    public PublicationList(List<T> pubs) {
        this.pubs = pubs;
    }

    public void addPub(T newPub) {
        pubs.add(newPub);
    }

    public T remove(int orderNum) throws IndexOutOfBoundsException {
        try {
            return pubs.remove(orderNum-1);
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }

    }

    public List<T> getPubs() {
        return pubs;
    }

    public int size() {
        return pubs.size();
    }

    public void outputList(Printer printer) {
        for (int i=0; i<pubs.size(); i++) {
            int order = i+1;
            printer.print(order + "." + pubs.get(i).toString());
        }
    }
}
