package com.wastelogics.elements;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.google.common.collect.Iterables.getLast;

@Getter
public class TableElement {

    private List<InvoiceElement> invoices = new ArrayList<>();

    public TableElement() {
        $$("tbody").forEach(element -> {
            if (element.getAttribute("class").contains("gl-0")) {
                invoices.add(new InvoiceElement(element));
            } else {
                getLast(invoices).insertElement(element);
            }
        });
    }
}
