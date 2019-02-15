
package ua.training;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void isUkrainianSurnameTest() {
        Assert.assertTrue(Main.isUkrainianSurname("Квітка"));
        Assert.assertTrue(Main.isUkrainianSurname("Основ'яненко"));
        Assert.assertTrue(Main.isUkrainianSurname("Квітка-Квітка"));
        Assert.assertTrue(Main.isUkrainianSurname("Основ'яненко-Квітка"));
        Assert.assertTrue(Main.isUkrainianSurname("Квітка-Основ'яненко"));
        Assert.assertTrue(Main.isUkrainianSurname("Основ'яненко-Основ'яненко"));

        Assert.assertFalse(Main.isUkrainianSurname("Салтыков-Щедрин"));
    }
}