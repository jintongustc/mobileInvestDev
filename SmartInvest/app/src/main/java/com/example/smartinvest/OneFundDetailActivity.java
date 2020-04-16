package com.example.smartinvest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class OneFundDetailActivity extends AppCompatActivity {


    public static final String EXTRA_FUNDSYMBOL = "fundSymbol";
    public static final String EXTRA_FUNDNAME = "fundName";
    public static final String EXTRA_DBMANAGER = "dbManager";

    private Button btnAddTrans;

    String fundSymbol, fundName;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_fund_detail);

        Intent intent_main = getIntent();
        fundSymbol = intent_main.getStringExtra(EXTRA_FUNDSYMBOL);
        fundName = intent_main.getStringExtra(EXTRA_FUNDNAME);


        setTitle(fundName);


        /** Add Transcation Button **/
        btnAddTrans = (Button) findViewById(R.id.onefund_btn_addtran);
        btnAddTrans.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Transaction trans = new Transaction(fundSymbol, fundName, new Date(), new Float(137.25), 2, new Float(220));

                // Insert new transaction recornd into table transaction
                long rowId = dbManager.insert(trans);
            }
        });
    }
}
