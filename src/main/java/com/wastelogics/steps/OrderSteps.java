package com.wastelogics.steps;

import com.wastelogics.elements.EntityElement;
import com.wastelogics.elements.GradeElement;
import com.wastelogics.elements.OrderElement;
import io.qameta.allure.Step;

import java.util.Collection;

import static com.codeborne.selenide.Condition.text;

public class OrderSteps {
    private OrderElement orderElement;

    public OrderSteps(OrderElement orderElement) {
        this.orderElement = orderElement;
    }

    @Step("Check company name is `{name}`")
    public OrderSteps checkCompanyName(String name) {
        orderElement.getInvoiceElement().getCompany().shouldHave(text(name));
        return this;
    }

    @Step("Check invoice address is `{address}`")
    public OrderSteps checkInvoiceAddress(String address) {
        orderElement.getInvoiceElement().getInvoiceAddress().shouldHave(text(address));
        return this;
    }

    @Step("Check order contains grade `{gradeName}` with weight `{weight}`")
    public OrderSteps checkContainsGrade(String gradeName, String weight) {
        GradeElement gradeElement = orderElement.getGrades().stream()
                .filter(grade -> grade.getName().has(text(gradeName)))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("There is no grade with name " + gradeName));
        gradeElement.getWeight().shouldHave(text(weight));
        return this;
    }

    @Step("Check order contains entity `{entityName}` with price `{price}`")
    public OrderSteps checkContainsEntity(String entityName, String price) {
        EntityElement entityElement = orderElement.getGrades().stream()
                .map(GradeElement::getEntities)
                .flatMap(Collection::stream)
                .filter(entity -> entity.getName().has(text(entityName)))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("There is no entity with name " + entityName));
        entityElement.getPrice().shouldHave(text(price));
        return this;
    }
}
