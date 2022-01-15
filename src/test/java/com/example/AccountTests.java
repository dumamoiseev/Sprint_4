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

    public AccountTests(String fullName, boolean expectedResult) {
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
                {"Моисеев 123", false}

        };
    }

    @Test
    public void accountTest(){
        Assert.assertEquals(account.checkNameToEmboss(), expectedResult);
    }


}