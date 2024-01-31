package com.mobile.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.mobile.userinterface.MyCartView.LBL_PRODUCT_NAME;

public class VerifyProduct implements Question<String> {

    public static VerifyProduct withName(){
        return new VerifyProduct();
    }

    @Override
    public String answeredBy(Actor actor) {
        return LBL_PRODUCT_NAME.resolveFor(actor).getText();
    }
}