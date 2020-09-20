package com.justcodeit.smartclickablespan;

import android.text.style.ClickableSpan;
import androidx.annotation.NonNull;

public class ClickableOption{
    private String text;
    private ClickableSpan clickableSpan;
    private int color = -1;

    public ClickableOption(){
        // Empty
    }

    @NonNull
    public ClickableOption setText(@NonNull String text){
        this.text = text;
        return this;
    }

    @NonNull
    public ClickableOption setOnClick(@NonNull ClickableSpan clickableSpan){
        this.clickableSpan = clickableSpan;
        return this;
    }

    @NonNull
    public ClickableOption setColor(int color){
        this.color = color;
        return this;
    }

    public String getText(){
        return text;
    }

    public ClickableSpan getOnClick(){
        return clickableSpan;
    }

    public int getColor(){
        return color;
    }
}
