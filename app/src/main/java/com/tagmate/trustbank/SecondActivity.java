package com.tagmate.trustbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tagmate.TagmateAnalytics;

public class SecondActivity extends AppCompatActivity {

    Button btnCreditCard, btnStatement;
    TextView tvLoanDesc;

    TagmateAnalytics tagmateAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tagmateAnalytics = TagmateAnalytics.getInstance(SecondActivity.this);

        btnCreditCard = findViewById(R.id.btnCreditCard);
        btnStatement = findViewById(R.id.btnStatement);
        tvLoanDesc = findViewById(R.id.tvLoanDesc);

        btnCreditCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //event name with params and user property
                Bundle bundle = new Bundle();
                bundle.putString("screen_name","Loan Screen");
                bundle.putString("previous_screen_name","Home Screen");
                bundle.putString("product_name","Trust Bank");
                bundle.putString("product_category","Credit Card");
                bundle.putString("user_id","1234567abcd");

                tagmateAnalytics.logEvent("money_credit_card", bundle);
            }
        });

        btnStatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //event name with params and missing user property
                Bundle bundle = new Bundle();
                bundle.putString("screen_name","Loan Screen");
                bundle.putString("previous_screen_name","Home Screen");
                bundle.putString("product_name","Trust Bank");
                bundle.putString("product_category","Statement");

                tagmateAnalytics.logEvent("money_statement", bundle);
            }
        });

        tvLoanDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //event name with missing param
                Bundle bundle = new Bundle();

                tagmateAnalytics.logEvent("money_statement", bundle);
            }
        });

    }
}