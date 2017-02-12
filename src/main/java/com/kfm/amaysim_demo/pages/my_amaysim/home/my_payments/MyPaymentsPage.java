package com.kfm.amaysim_demo.pages.my_amaysim.home.my_payments;

import org.openqa.selenium.WebDriver;

import com.kfm.amaysim_demo.pages.my_amaysim.home.MyAmaysimHomePage;

public class MyPaymentsPage extends MyAmaysimHomePage {

    public MyPaymentsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageId() {
        return "/my-account/my-amaysim/payment_methods";
    }
}
