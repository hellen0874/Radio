package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class RadioTest {
    @Test
// проверка установки номера станции через прямое указание
    public void ShouldSetInRange() {            // установка номера станции внутри допустимого диапазона (объект создается без параметров)
        Radio radio = new Radio();
        radio.setCurrentStationNumber(5);
        int actual = radio.getCurrentStationNumber();
        int expected = 5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldSetInRangeParmetrized() {            // установка номера станции внутри допустимого диапазона (объект создается с параметрами)
        Radio radio = new Radio(30);
        radio.setCurrentStationNumber(15);
        int actual = radio.getCurrentStationNumber();
        int expected = 15;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldNotSetUnder0() {            // установка номера станции меньше нуля - возврат к начальному значению
        Radio radio = new Radio();
        radio.setCurrentStationNumber(-1);
        int actual = radio.getCurrentStationNumber();
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void ShouldNotSetUpperMax() {            // установка номера станции больше max - возврат к начальному значению
        Radio radio = new Radio(30);
        radio.setCurrentStationNumber(31);
        int actual = radio.getCurrentStationNumber();
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    // проверка переключения на +\-1 (номер станции)
    public void ShouldAddOne() {            // переключение на +1 с середины диапазона
        Radio radio = new Radio();
        radio.setCurrentStationNumber(5);
        radio.next();
        int actual = radio.getCurrentStationNumber();
        int expected = 6;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldAddOneFrom9() {            // переключение на +1 с конца диапазона (граничные значения)
        Radio radio = new Radio();
        radio.setCurrentStationNumber(9);
        radio.next();
        int actual = radio.getCurrentStationNumber();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldAddOneFrom8() {            // переключение на +1 с (конца диапазона - 1) (граничные значения)
        Radio radio = new Radio();
        radio.setCurrentStationNumber(8);
        radio.next();
        int actual = radio.getCurrentStationNumber();
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldAddOneFromMax() {            // переключение на +1 с конца диапазона, объект с параметром (граничные значения)
        Radio radio = new Radio(31);
        radio.setCurrentStationNumber(30);
        radio.next();

        int actual = radio.getCurrentStationNumber();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldAddOneFromPreMax() {            // переключение на +1 с (конца диапазона - 1), объект с параметром (граничные значения)
        Radio radio = new Radio(31);
        radio.setCurrentStationNumber(29);
        radio.next();
        int actual = radio.getCurrentStationNumber();
        int expected = 30;
        Assertions.assertEquals(expected, actual);
    }

    // переключение на +1 с (конца диапазона + 1) (граничные значения) - не проверяем, это уже проверено, больше 9 номер станции не проставится
    @Test
    public void ShouldAddOneFrom0() {            // переключение на +1 с начала диапазона (граничные значения) - может, и не нужно, но на всякий случай
        Radio radio = new Radio();
        radio.setCurrentStationNumber(0);
        radio.next();
        int actual = radio.getCurrentStationNumber();
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldAddOneFrom1() {            // переключение на +1 с (начала диапазона + 1) (граничные значения) - может, и не нужно, но на всякий случай
        Radio radio = new Radio();
        radio.setCurrentStationNumber(1);
        radio.next();
        int actual = radio.getCurrentStationNumber();
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }
    // переключение на +1 с (начала диапазона - 1) (граничные значения) - не проверяем, это уже проверено, меньше 0 номер станции не проставится

    // проверка переключения на предыдущую станцию
    @Test
    public void ShouldRemoveOne() {            // переключение на -1 с середины диапазона
        Radio radio = new Radio();
        radio.setCurrentStationNumber(5);
        radio.prev();
        int actual = radio.getCurrentStationNumber();
        int expected = 4;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveOneFrom9() {            // переключение на -1 с конца диапазона (граничные значения) - может, и не надо, но на всякий случай
        Radio radio = new Radio();
        radio.setCurrentStationNumber(9);
        radio.prev();
        int actual = radio.getCurrentStationNumber();
        int expected = 8;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveOneFrom8() {            // переключение на -1 с (конца диапазона - 1) (граничные значения) - может, и не надо, но на всякий случай
        Radio radio = new Radio();
        radio.setCurrentStationNumber(8);
        radio.prev();
        int actual = radio.getCurrentStationNumber();
        int expected = 7;
        Assertions.assertEquals(expected, actual);
    }

    // переключение на -1 с (конца диапазона + 1) (граничные значения) - не проверяем, это уже проверено, больше 9 номер станции не проставится
    @Test
    public void ShouldRemoveOneFrom0() {            // переключение на -1 с начала диапазона (граничные значения)
        Radio radio = new Radio();
        radio.setCurrentStationNumber(0);
        radio.prev();
        int actual = radio.getCurrentStationNumber();
        int expected = 9;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveOneFrom1() {            // переключение на -1 с (начала диапазона + 1) (граничные значения) - может, и не нужно, но на всякий случай
        Radio radio = new Radio();
        radio.setCurrentStationNumber(1);
        radio.prev();
        int actual = radio.getCurrentStationNumber();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }
    // переключение на -1 с (начала диапазона - 1) (граничные значения) - не проверяем, это уже проверено, меньше 0 номер станции не проставится

    // проверка изменения громкости звука
    @Test
    public void ShouldNotSetVolumeUnder0() {            // не дает установить громкость меньше 0
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);
        int actual = radio.getCurrentVolume();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldNotSetVolumeUpper100() {            // не дает установить громкость выше 100
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        int actual = radio.getCurrentVolume();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldAddOneToVolume() {            // переключение на +1 с середины диапазона
        Radio radio = new Radio();
        radio.setCurrentVolume(5);
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 6;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldNotAddOneToVolumeFrom100() {            // переключение на +1 с конца диапазона (граничные значения)
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 100;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldAddOneToVolumeFrom99() {            // переключение на +1 с (конца диапазона - 1) (граничные значения)
        Radio radio = new Radio();
        radio.setCurrentVolume(99);
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 100;
        Assertions.assertEquals(expected, actual);
    }

    // переключение на +1 с (конца диапазона + 1) не проверяем, установить уровень 101 не даст
    @Test
    public void ShouldRemoveOneFromVolume5() {            // переключение на -1 с середины диапазона
        Radio radio = new Radio();
        radio.setCurrentVolume(5);
        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 4;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldNotRemoveOneFromVolume0() {            // переключение на -1 с начала диапазона
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldNotRemoveOneFromVolume1() {            // переключение на -1 с (начала диапазона + 1)
        Radio radio = new Radio();
        radio.setCurrentVolume(1);
        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }
    // переключение на -1 с (начала диапазона - 1) не проверяем, установить уровень ниже 0 не даст

}
