package org.techtown.seekbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CardItem {
    private String title;
    private String contens;


    public CardItem(String title, String contens) {
        this.title = title;
        this.contens = contens;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContens() {
        return contens;
    }

    public void setContens(String contens) {
        this.contens = contens;
    }


}
