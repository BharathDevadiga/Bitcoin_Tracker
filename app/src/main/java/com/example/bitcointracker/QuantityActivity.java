package com.example.bitcointracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class QuantityActivity extends AppCompatActivity {

    public final String BPI_ENDPOINT = "https://api.coindesk.com/v1/bpi/currentprice.json";
    public Object bpiObject;
    private OkHttpClient okHttpClient = new OkHttpClient();
    private TextView txt;
    int totalQ=0;
    double usd1= 45783.3225;
    double Rps = 3425316.32;
    double totalAmount;
    TextView plus,minus,quan,rupee,dollar,tm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantity);
        txt = (TextView) findViewById(R.id.text);
        plus = findViewById(R.id.add);
        minus = findViewById(R.id.delete);
        quan = findViewById(R.id.quantity);
        rupee = findViewById(R.id.indian);
        dollar = findViewById(R.id.america);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(totalQ <10)
                    totalQ++;
                quan.setText(String.valueOf(totalQ));
                totalAmount = totalQ*usd1;
                dollar.setText(String.valueOf("$"+totalAmount));
                totalAmount=0;
                totalAmount = totalQ*Rps;
                rupee.setText(String.valueOf("₹"+totalAmount));
            }
        });


        minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(totalQ >=1)
                        totalQ--;
                    quan.setText(String.valueOf(totalQ));
                    totalAmount = totalQ*usd1;
                    dollar.setText(String.valueOf("$"+totalAmount));
                    totalAmount=0;
                    totalAmount = totalQ*Rps;
                    rupee.setText(String.valueOf("₹"+totalAmount));

                }
            });
        }
}