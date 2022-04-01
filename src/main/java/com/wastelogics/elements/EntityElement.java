package com.wastelogics.elements;

import com.codeborne.selenide.SelenideElement;

public class EntityElement {

    private SelenideElement entityElement;

    public EntityElement(SelenideElement entityElement) {
        this.entityElement = entityElement;
    }

    public SelenideElement getName() {
        return entityElement.$$("td").get(1);
    }

    public SelenideElement getPrice() {
        return entityElement.$$("td").get(7);
    }
}
