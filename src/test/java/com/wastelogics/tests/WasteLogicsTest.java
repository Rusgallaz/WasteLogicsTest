package com.wastelogics.tests;

import com.google.inject.Inject;
import com.wastelogics.annotations.SelenideTest;
import com.wastelogics.steps.CompanyInvoicesSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SelenideTest
public class WasteLogicsTest {

    @Inject private CompanyInvoicesSteps companyInvoicesSteps;

    @Test
    @DisplayName("Check invoice for an order")
    void checkInvoiceData() {
        companyInvoicesSteps
                .openPage()
                .toOrderSteps("146566")
                .checkCompanyName("TEST CUSTOMER")
                .checkInvoiceAddress("TEST ADDRESS, TEST TOWN, 111111");
    }

    @Test
    @DisplayName("Check grade for an order")
    void checkGradeData() {
        companyInvoicesSteps
                .openPage()
                .toOrderSteps("146566")
                .checkContainsGrade("Mixed Municipal Waste", "0.460 T");
    }

    @Test
    @DisplayName("Check entities for an order")
    void checkEntitiesData() {
        companyInvoicesSteps
                .openPage()
                .toOrderSteps("146566")
                .checkContainsEntity("Flat charge", "£100.00")
                .checkContainsEntity("per tonne", "£4.60")
                .checkContainsEntity("Item", "£110.10");
    }
}
