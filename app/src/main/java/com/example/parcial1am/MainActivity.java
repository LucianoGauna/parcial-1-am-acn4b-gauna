package com.example.parcial1am;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LinearLayout cartItemsContainer = findViewById(R.id.cartItemsContainer);

        TextView productText = new TextView(this);
        productText.setText(getString(R.string.product_red_pepper) + " - " + getString(R.string.unit_red_pepper) + " - $4.99");
        productText.setTextSize(20);
        productText.setTextColor(getColor(R.color.text_primary));
        productText.setTypeface(null, Typeface.BOLD);
        productText.setPadding(0, 0, 0, 24);

        cartItemsContainer.addView(productText);
    }
}