package org.techtown.ai_eng_v2_00;

import android.graphics.drawable.Drawable;

import androidx.cardview.widget.CardView;

public class Person {
    String grade;
    String name;
    String number;
    Drawable cardimage;

    public Person(String name, String number, String grade, Drawable cardimage) {
        this.name = name;
        this.number = number;
        this.grade = grade;
        this.cardimage = cardimage;
    }

    public String getName() { //HP
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    } //공격력?

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGrade() {
        return grade;
    } //등급

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Drawable getCardimage() {
        return cardimage;
    }

    public void setCardimage(Drawable cardimage) {
        this.cardimage = cardimage;
    }
}
