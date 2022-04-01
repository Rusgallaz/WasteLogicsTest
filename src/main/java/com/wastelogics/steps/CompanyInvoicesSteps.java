package com.wastelogics.steps;

import com.codeborne.selenide.Condition;
import com.wastelogics.elements.InvoiceElement;
import com.wastelogics.elements.OrderElement;
import com.wastelogics.elements.TableElement;
import io.qameta.allure.Step;

import java.util.Collection;

import static com.codeborne.selenide.Condition.or;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.wastelogics.utils.ResourceUtil.getCompanyInvoicesPage;

public class CompanyInvoicesSteps {

    private TableElement table;

    @Step("Open company invoices page")
    public CompanyInvoicesSteps openPage() {
        open(getCompanyInvoicesPage());
        table = new TableElement();
        return this;
    }

    @Step("Move to order with id `{orderId}`")
    public OrderSteps toOrderSteps(String orderId) {
        OrderElement orderElement = table.getInvoices().stream()
                .map(InvoiceElement::getOrders)
                .flatMap(Collection::stream)
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("There is no order with id " + orderId));
        return new OrderSteps(orderElement);
    }
}
