package com.example.parcial1am;

import android.os.Bundle;
import android.widget.Button;
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

        // Botón de aumentar cantidad en pimiento
        Button redPepperPlusButton = findViewById(R.id.redPepperPlusButton);
        TextView redPepperQuantity = findViewById(R.id.redPepperQuantity);

        redPepperPlusButton.setOnClickListener(v -> {
            String currentQuantityText = redPepperQuantity.getText().toString();
            int currentQuantity = Integer.parseInt(currentQuantityText);
            int newQuantity = currentQuantity + 1;

            redPepperQuantity.setText(String.valueOf(newQuantity));
        });
    }
}