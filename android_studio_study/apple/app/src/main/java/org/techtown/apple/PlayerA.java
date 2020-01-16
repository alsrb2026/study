package org.techtown.apple;

public class PlayerA {
    static int ahp = 10;
    int atk = 3;
    int def = 1;
    int evs=0; //회피율
    int cri=0; //치명타율

    public PlayerA(int hp, int atk, int def, int evs, int cri){
        this.ahp = hp;
        this.atk = atk;
        this.def = def;
        this.evs = evs;
        this.cri = cri;
    }

    public void attack(int atk) {
        PlayerB.bhp = PlayerB.bhp-atk;

    }




}
