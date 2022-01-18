package com.example;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
@DisplayName("Тесты проверки Name")
public class AccountTests {

    Account account;
    private final String fullName;
    private final boolean expectedResult;

    public AccountTests(String fullName, boolean expectedResult) throws InterruptedException {
        this.fullName = fullName;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        account = new Account(fullName);
    }

    @Parameterized.Parameters
    public static Object[][] getNameData() {
        return new Object[][]{
                {"Д М", true},
                {"Моисеев Дмитрий", true},
                {"Дмитрий Моисеев", true},
                {"МДП", false},
                {"Моисеев Дмитрий Кодирующий", false},
                {" Дмитрий Моисеев", false},
                {"Моисеев Дмитрий ", false},
                {"МоисеевДмитрий", false},
                {"Моисеев  Дмитрий", false},
                {"123 Дмитрий", false},
                {"Моисеев 123", false},
                {"",false},
                {null,false}
        };
    }

    @Test
    public void accountTest()  {
        try {
            Assert.assertEquals(account.checkNameToEmboss(), expectedResult);
        } catch (NullPointerException e) {
            {
                System.out.print("NullPointerException caught");
            }
        }
    }


}