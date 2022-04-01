package com.wastelogics.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GradeElement {

    private SelenideElement gradeElement;
    private List<EntityElement> entities = new ArrayList<>();

    public GradeElement(SelenideElement gradeElement) {
        this.gradeElement = gradeElement;
    }

    public void insertElement(SelenideElement element) {
        if (element.getAttribute("class").contains("gl-3")) {
            entities.add(new EntityElement(element));
        }
    }

    public SelenideElement getName() {
        return gradeElement.$$("td").get(1);
    }

    public SelenideElement getWeight() {
        return gradeElement.$$("td").get(2);
    }
}
