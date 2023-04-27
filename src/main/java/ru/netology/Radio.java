package ru.netology;

public class Radio {
    private int currentStationNumber;
    private int currentVolume;

    // выбор номера станции
    public void setCurrentStationNumber(int newCurrentStationNumber) {   // Установка номера через прямое указание
        if (newCurrentStationNumber < 0) {
            return;
        }
        if (newCurrentStationNumber > 9) {              // номер станции от 0 до 9
            return;
        }
        this.currentStationNumber = newCurrentStationNumber;
    }

    public int getCurrentStationNumber() {
        return currentStationNumber;
    }

    public void nextStationNumber() {
        int target = currentStationNumber + 1;    // установка следующего номера станции с условием 9->0
        if (currentStationNumber == 9) {
            setCurrentStationNumber(0);
        }
        setCurrentStationNumber(target);
    }

    public void prevStationNumber() {
        int target = currentStationNumber - 1;    // установка предыдущего номера станции c условием 0-> 9
        if (currentStationNumber == 0) {
            setCurrentStationNumber(9);
        }
        setCurrentStationNumber(target);
    }

    // звук


    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < 0) {
            return;
        }
        if (currentVolume > 100) {              // уровень грромкости от 0 до 100
            return;
        }
        this.currentVolume = currentVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    // Для увеличения и уменьшения громкости взяла образец из разборного вебинара, по образцу из ДЗ тесты падали
    // public void increaseVolume() {
    //     if (currentVolume < 100) {
    //          currentVolume = currentVolume + 1;
    //  }

    public void increaseVolume() {
        if (currentVolume != 100) {
            currentVolume = currentVolume + 1;  // увеличение уровня громкости на +1, после 100 ничего не делать
        } else {
            currentVolume = 100;
        }
    }

    public void decreaseVolume() {
        if (currentVolume != 0) {
            currentVolume = currentVolume - 1;  // уменьшение уровня громкости на -1, после 0 ничего не делать
        } else {
            currentVolume = 0;
        }
    }


}
