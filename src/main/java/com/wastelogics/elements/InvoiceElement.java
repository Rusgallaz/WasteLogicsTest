package com.wastelogics.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.getLast;

@Getter
public class InvoiceElement {

    private List<OrderElement> orders = new ArrayList<>();
    private SelenideElement invoiceElement;

    public InvoiceElement(SelenideElement invoiceElement) {
        this.invoiceElement = invoiceElement;
    }

    public void insertElement(SelenideElement element) {
        if (element.getAttribute("class").contains("gl-1")) {
            orders.add(new OrderElement(this, element));
        } else {
            getLast(orders).insertElement(element);
        }
    }

    public SelenideElement getCompany() {
        return invoiceElement.$$("td").get(4);
    }

    public SelenideElement getInvoiceAddress() {
        return invoiceElement.$$("td").get(5);
    }
}
