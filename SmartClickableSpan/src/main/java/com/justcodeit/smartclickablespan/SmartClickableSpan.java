package com.justcodeit.smartclickablespan;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class SmartClickableSpan {
    private SpannableStringBuilder stringBuilder;
    private TextView mTextView;

    public static class Builder{
        private final Context context;
        private SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        private boolean isAutoSpacing = false;
        private int highlightColor = Color.TRANSPARENT;

        public Builder(Context context){
            this.context = context;
        }

        @NonNull
        public Builder regularText(String text){
            this.stringBuilder.append(text).append(isAutoSpacing ? " " : "");
            return this;
        }

        @NonNull
        public Builder autoSpacing(){
            isAutoSpacing = true;
            return this;
        }

        @NonNull
        public Builder setHighlightColor(int highlightColor){
            this.highlightColor = context.getResources().getColor(highlightColor);
            return this;
        }

        @NonNull
        public Builder clickableText(ClickableOption options){
            // Setting text
            String text = options.getText();
            this.stringBuilder.append(text);

            // Clickable span
            ClickableSpan clickableSpan = options.getOnClick();
            int lengthLeft = this.stringBuilder.toString().indexOf(text);
            int lengthRight = this.stringBuilder.toString().indexOf(text) + text.length();
            this.stringBuilder.setSpan(clickableSpan, lengthLeft, lengthRight, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            // Color
            int color = options.getColor();
            this.stringBuilder.setSpan(new ForegroundColorSpan(color != -1 ? context.getResources().getColor(color) : Color.BLUE), lengthLeft, lengthRight, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            return this;
        }

        @NonNull
        public SmartClickableSpan into(TextView textView){
            return new SmartClickableSpan(this, textView);
        }
    }

    public SmartClickableSpan(Builder builder, TextView textView){
        this.stringBuilder = builder.stringBuilder;
        this.mTextView = textView;

        mTextView.setHighlightColor(builder.highlightColor);
        mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        mTextView.setText(this.stringBuilder, TextView.BufferType.SPANNABLE);
        mTextView.setSelected(true);
    }

    public String getAppendedText(){
        return stringBuilder.toString();
    }
}