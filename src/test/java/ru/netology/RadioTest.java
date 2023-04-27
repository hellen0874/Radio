package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class RadioTest {
    @Test
// проверка установки номера станции через прямое указание
    public void ShouldSet5(){            // установка номера станции внутри допустимого диапазона
        Radio radio = new Radio();
        radio.setCurrentStationNumber(5);
        int actual = radio.getCurrentStationNumber();
        int expected = 5;
        Assertions.assertEquals(expected, actual);

    }

    public void ShouldNotSetUnder0(){            // установка номера станции меньше нуля - возврат к начальному значению
        Radio radio = new Radio();
        radio.setCurrentStationNumber(-3);
        int actual = radio.getCurrentStationNumber();
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }

    public void ShouldNotSetUpper9(){            // установка номера станции больше 9 - возврат к начальному значению
        Radio radio = new Radio();
        radio.setCurrentStationNumber(11);
        int actual = radio.getCurrentStationNumber();
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }
    // переключение на +\-1 (номер станции)
    public void ShouldAddOne() {            // переключение на +1 с середины диапазона
        Radio radio = new Radio();
        radio.setCurrentStationNumber(5);
        radio.nextStationNumber();
        int actual = radio.getCurrentStationNumber();
        int expected = 6;
        Assertions.assertEquals(expected, actual);
    }

    public void ShouldAddOneFrom9() {            // переключение на +1 с конца диапазона (граничные значения)
        Radio radio = new Radio();
        radio.setCurrentStationNumber(9);
        radio.nextStationNumber();
        int actual = radio.getCurrentStationNumber();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    public void ShouldAddOneFrom8() {            // переключение на +1 с (конца диапазона - 1) (граничные значения)
        Radio radio = new Radio();
        radio.setCurrentStationNumber(8);
        radio.nextStationNumber();
        int actual = radio.getCurrentStationNumber();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }
    // переключение на +1 с (конца диапазона + 1) (граничные значения) - не проверяем, это уже проверено, больше 9 номер станции не проставится

    public void ShouldAddOneFrom0() {            // переключение на +1 с начала диапазона (граничные значения) - может, и не нужно, но на всякий случай
        Radio radio = new Radio();
        radio.setCurrentStationNumber(0);
        radio.nextStationNumber();
        int actual = radio.getCurrentStationNumber();
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    public void ShouldAddOneFrom1() {            // переключение на +1 с (начала диапазона + 1) (граничные значения) - может, и не нужно, но на всякий случай
        Radio radio = new Radio();
        radio.setCurrentStationNumber(1);
        radio.nextStationNumber();
        int actual = radio.getCurrentStationNumber();
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }
    // переключение на +1 с (начала диапазона - 1) (граничные значения) - не проверяем, это уже проверено, меньше 0 номер станции не проставится
}
