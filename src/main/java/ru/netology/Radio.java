package ru.netology;

public class Radio {
    private int currentVolume;
    private int currentStationNumber;
    private int maxStationNumber;

    public Radio() {
        this.maxStationNumber = 9;
    }

    public Radio(int amountOfStations) {
        this.maxStationNumber = amountOfStations - 1;
    }

    // выбор номера станции
    public void setCurrentStationNumber(int newCurrentStationNumber) {   // Установка номера через прямое указание
        if (newCurrentStationNumber < 0) {
            return;
        }
        if (newCurrentStationNumber > maxStationNumber) {              // номер станции от 0 до (max-1)
            return;
        }
        this.currentStationNumber = newCurrentStationNumber;
    }

    public int getCurrentStationNumber() {
        return currentStationNumber;
    }

    public void next() {
        int target = currentStationNumber + 1;    // установка следующего номера станции с условием max->0
        if (currentStationNumber == maxStationNumber) {
            setCurrentStationNumber(0);
        }
        setCurrentStationNumber(target);
    }

    public void prev() {
        int target = currentStationNumber - 1;    // установка предыдущего номера станции c условием 0-> max
        if (currentStationNumber == 0) {
            setCurrentStationNumber(maxStationNumber);
        }
        setCurrentStationNumber(target);
    }

    // звук


    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < 0) {
            return;
        }
        if (currentVolume > 100) {              // уровень громкости от 0 до 100
            return;
        }
        this.currentVolume = currentVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

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
