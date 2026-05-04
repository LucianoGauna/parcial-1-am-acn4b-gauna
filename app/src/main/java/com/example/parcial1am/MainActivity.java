package com.example.parcial1am;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        TextView redPepperQuantity = findViewById(R.id.redPepperQuantity);

        // Botón de aumentar cantidad en pimiento
        Button redPepperPlusButton = findViewById(R.id.redPepperPlusButton);
        redPepperPlusButton.setOnClickListener(v -> {
            String currentQuantityText = redPepperQuantity.getText().toString();
            int currentQuantity = Integer.parseInt(currentQuantityText);
            int newQuantity = currentQuantity + 1;

            redPepperQuantity.setText(String.valueOf(newQuantity));
        });

        // Botón de disminuir cantidad en pimiento
        Button redPepperMinusButton = findViewById(R.id.redPepperMinusButton);
        redPepperMinusButton.setOnClickListener(v -> {
            String currentQuantityText = redPepperQuantity.getText().toString();
            int currentQuantity = Integer.parseInt(currentQuantityText);

            if (currentQuantity > 1) {
                int newQuantity = currentQuantity - 1;
                redPepperQuantity.setText(String.valueOf(newQuantity));
            }
        });

        // Botón de eliminar pimiento del carrito
        Button redPepperRemoveButton = findViewById(R.id.redPepperRemoveButton);
        View redPepperItem = findViewById(R.id.redPepperItem);
        View redPepperDivider = findViewById(R.id.redPepperDivider);

        redPepperRemoveButton.setOnClickListener(v -> {
            redPepperItem.setVisibility(View.GONE);
            redPepperDivider.setVisibility(View.GONE);
        });

        // Botón de ir al pago y contenedor del carrito
        Button checkoutButton = findViewById(R.id.checkoutButton);
        LinearLayout cartItemsContainer = findViewById(R.id.cartItemsContainer);

        TextView checkoutSummary = new TextView(this);
        checkoutSummary.setTextColor(getColor(R.color.text_primary));
        checkoutSummary.setTextSize(18);
        checkoutSummary.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        checkoutButton.setOnClickListener(v -> {
            checkoutSummary.setText("Resumen del pedido\nProductos listos para avanzar al pago");

            if (checkoutSummary.getParent() == null) {
                cartItemsContainer.addView(checkoutSummary);
            }
        });
    }
}