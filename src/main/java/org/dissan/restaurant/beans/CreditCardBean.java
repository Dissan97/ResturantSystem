package org.dissan.restaurant.beans;

import org.dissan.restaurant.exceptions.InvalidCreditCard;
import org.dissan.restaurant.models.CreditCard;
import org.jetbrains.annotations.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class CreditCardBean {

    private CreditCard creditCard;

    public CreditCardBean(@NotNull String num, @NotNull String date,@NotNull String cvv) throws InvalidCreditCard {

        controlData(num, date, cvv);

    }

    private void controlData(@NotNull String num,@NotNull String date,@NotNull String cvv) throws InvalidCreditCard {
        boolean notEmpty = !(num.isEmpty() || date.isEmpty() || cvv.isEmpty());
        int length = num.length();
        boolean lengthValidation = length == 15 || length == 16 ;
        boolean dateValidation;
        SimpleDateFormat format = new SimpleDateFormat("MM/yyyy");
        try {
            format.parse(date);
            dateValidation = true;
        } catch (ParseException e) {
            format = new SimpleDateFormat("MM:yyyy");
            try {
                format.parse(date);
                dateValidation = true;
            } catch (ParseException ex) {
                dateValidation = false;
            }
        }
        boolean cvvLength = cvv.length() == 3;

        if (!(notEmpty && lengthValidation && dateValidation && cvvLength)){
            throw new InvalidCreditCard("Bad credential");
        }


    }

    public static void main(String...args) throws InvalidCreditCard {
       new CreditCardBean("123456789023456", "03/2023", "223");

    }
}
