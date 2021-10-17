package com.sparksfoundation.thesparksfoundationbank.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sparksfoundation.thesparksfoundationbank.R;

public class HomeScreen extends AppCompatActivity {

    Animation anim;
    ImageView bankLogo;
    TextView tvBankTitle;
    Button btnUsers, btnTransactionsHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        anim = AnimationUtils.loadAnimation(this, R.anim.animation);
        bankLogo = findViewById(R.id.imageView2);
        btnUsers = findViewById(R.id.all_users);
        btnTransactionsHistory = findViewById(R.id.all_transactions);
        tvBankTitle = findViewById(R.id.bank_title);

        bankLogo.setAnimation(anim);
        tvBankTitle.setAnimation(anim);
        btnUsers.setAnimation(anim);
        btnTransactionsHistory.setAnimation(anim);
    }

   public void showAllUsers(View view) {
        Intent intent = new Intent(this, UsersList.class);
        startActivity(intent);
    }

    public void showAllTransactions(View view) {
        Intent intent = new Intent(this, TransactionHistory.class);
        startActivity(intent);
    }
}