package com.appdev.a503_02.a1011widget;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView 찾아오기
        TextView textView = (TextView)findViewById(R.id.textView);

        //스크롤 가능하도록 설정
        textView.setMovementMethod(new ScrollingMovementMethod());


        String data = "블랙핑크\n img \n 제니입니다.";


        //img 부분에 이미지 삽입하기
        SpannableStringBuilder builder1 = new SpannableStringBuilder(data);

        //삽입할 시작 위치 찾기
        int start = data.indexOf("img");

        //삽입할 종료 위치 찾기
        int end = start + "img".length();

        //출력할 이미지 찾기
        Drawable dr = ResourcesCompat.getDrawable(getResources(), R.drawable.jenny1, null);

        //이미지 추출하기, 본연의 사진 사이즈
        dr.setBounds(0,0,dr.getIntrinsicWidth(),dr.getIntrinsicHeight());
        //dr.setBounds(0,0,400,400);

        //이미지 출력하기 위한 Span 만들기
        ImageSpan imageSpan1 = new ImageSpan(dr);

        //SpannableBuilder에 적용
        builder1.setSpan(imageSpan1, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        //제니입니다 부분의 서식 변경
        start=data.indexOf("제니입니다.");
        end=start+"제니입니다.".length();

        StyleSpan styleSpan1=new StyleSpan(Typeface.BOLD_ITALIC);
        RelativeSizeSpan sizeSpan1 = new RelativeSizeSpan(3.0f);

        builder1.setSpan(styleSpan1, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder1.setSpan(sizeSpan1,start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);




        //텍스트 뷰에 적용
        textView.setText(builder1);


    }
}
