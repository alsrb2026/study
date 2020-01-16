package org.techtown.ai_eng_v2_00;

import java.util.ArrayList;

public class Player {
    static public ArrayList<Integer> CardImage = new ArrayList<Integer>();
    static public ArrayList<Integer> Hp = new ArrayList<Integer>();
    static public ArrayList<Integer> Power = new ArrayList<Integer>();
    private int MP;
    private int GOLD;

    //값 다시표시하는 함수 만들어놓고 값 변경할 때 마다 다시표시하는 함수도 같이 불러라
    public Player(int MP, int GOLD) {
        this.MP = MP;
        this.GOLD = GOLD;
    }

    public void plusMP(int n) {
        this.MP = this.MP + n;
    }

    public void plusGOLD(int n) {
        this.GOLD = this.GOLD + n;
    }

    public void minusMP(int n) {
        this.MP = this.MP - n;
    }

    public void minusGOLD(int n) {
        this.MP = this.MP - n;
    }

    public int getGOLD() {
        return GOLD;
    }

    public int getMP() {
        return MP;
    }

    public void setMP() {
        this.MP = MP;
    }

    public void setGOLD() {
        this.GOLD = GOLD;
    }
}



