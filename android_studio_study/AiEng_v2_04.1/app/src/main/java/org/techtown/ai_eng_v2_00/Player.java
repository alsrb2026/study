package org.techtown.ai_eng_v2_00;

import java.util.ArrayList;

public class Player {
    static public ArrayList<Integer> CardImage = new ArrayList<Integer>();
    static public ArrayList<Integer> Hp = new ArrayList<Integer>();
    static public ArrayList<Integer> Power = new ArrayList<Integer>();
    private int MP;
    private int Mileage;
    static public int Episode = 1;

    //값 다시표시하는 함수 만들어놓고 값 변경할 때 마다 다시표시하는 함수도 같이 불러라
    public Player(int MP, int Mileage) {
        this.MP = MP;
        this.Mileage = Mileage;
    }

    public void plusMP(int n) {
        this.MP = this.MP + n;
    }

    public void plusMileage(int n) {
        this.Mileage = this.Mileage + n;
    }

    public void minusMP(int n) {
        this.MP = this.MP - n;
    }

    public void minusMileage(int n) {
        this.MP = this.MP - n;
    }

    public int getMileage() {
        return Mileage;
    }

    public int getMP() {
        return MP;
    }

    public void setMP() {
        this.MP = MP;
    }

    public void setMileage() {
        this.Mileage = Mileage;
    }
}



