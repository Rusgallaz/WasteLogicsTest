package com.wastelogics.utils;

import java.net.URL;

public final class ResourceUtil {
    private static final String TEST_PAGE_NAME = "TestPage.mhtml";

    private ResourceUtil() {}

    public static URL getCompanyInvoicesPage() {
        URL testPage = ResourceUtil.class.getClassLoader().getResource(TEST_PAGE_NAME);
        if (testPage == null) {
            throw new IllegalStateException("Can't load " + TEST_PAGE_NAME);
        }
        return testPage;
    }
}
