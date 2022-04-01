package com.wastelogics.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.getLast;

@Getter
public class OrderElement {

    private SelenideElement orderElement;
    private InvoiceElement invoiceElement;
    private List<GradeElement> grades = new ArrayList<>();

    public OrderElement(InvoiceElement invoiceElement, SelenideElement orderElement) {
        this.invoiceElement = invoiceElement;
        this.orderElement = orderElement;
    }

    public void insertElement(SelenideElement element) {
        if (element.getAttribute("class").contains("gl-2")) {
            grades.add(new GradeElement(element));
        } else {
            getLast(grades).insertElement(element);
        }
    }

    public String getOrderId() {
        return orderElement.$$("td").get(2).getText();
    }
}
