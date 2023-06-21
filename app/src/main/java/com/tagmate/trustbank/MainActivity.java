package com.tagmate.trustbank;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tagmate.TagmateAnalytics;

public class MainActivity extends AppCompatActivity {

    Button btnLoan;
    TextView tvReadMore;

    TagmateAnalytics tagmateAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoan = findViewById(R.id.btnLoan);
        tvReadMore = findViewById(R.id.tvReadMore);

        tagmateAnalytics = TagmateAnalytics.getInstance(MainActivity.this);

   /*     actionBar = getSupportActionBar();
        actionBar.setTitle("Trust Bank");
        actionBar.setIcon(R.drawable.ic_trust_bank);*/

        // methods to display the icon in the ActionBar
    /*    actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);*/

        btnLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //event name with params
                Bundle bundle = new Bundle();
                bundle.putString("screen_name","Home Screen");
                bundle.putString("previous_screen_name","null");
                bundle.putString("product_name","Trust Bank");
                bundle.putString("product_category","Loan");

                tagmateAnalytics.logEvent("money_loan_on_card", bundle);

                startActivity(new Intent(MainActivity.this, SecondActivity.class));

            }
        });

        tvReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //event name with extra params
                Bundle bundle = new Bundle();
                bundle.putString("screen_name","Home Screen");
                bundle.putString("previous_screen_name","null");
                bundle.putString("product_name","Trust Bank");
                bundle.putString("product_category","Read More");
                bundle.putString("product_subcategory","Terms & conditions");

                tagmateAnalytics.logEvent("money_loan_on_card_read_more", bundle);

                startActivity(new Intent(MainActivity.this, ReadMoreActivity.class));
            }
        });
    }

}