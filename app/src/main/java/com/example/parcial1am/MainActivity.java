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
        TextView eggsQuantity = findViewById(R.id.eggsQuantity);
        TextView bananasQuantity = findViewById(R.id.bananasQuantity);
        TextView gingerQuantity = findViewById(R.id.gingerQuantity);

        TextView redPepperPrice = findViewById(R.id.redPepperPrice);
        TextView eggsPrice = findViewById(R.id.eggsPrice);

        double redPepperUnitPrice = 749.99;
        double eggsUnitPrice = 850.99;
        double bananasUnitPrice = 690.00;
        double gingerUnitPrice = 300.99;


        // Botón de aumentar cantidad en pimiento
        Button redPepperPlusButton = findViewById(R.id.redPepperPlusButton);
        redPepperPlusButton.setOnClickListener(v -> {
            String currentQuantityText = redPepperQuantity.getText().toString();
            int currentQuantity = Integer.parseInt(currentQuantityText);
            int newQuantity = currentQuantity + 1;

            redPepperQuantity.setText(String.valueOf(newQuantity));

            double newPrice = redPepperUnitPrice * newQuantity;
            redPepperPrice.setText(String.format("$%.2f", newPrice));
        });

        // Botón de disminuir cantidad en pimiento
        Button redPepperMinusButton = findViewById(R.id.redPepperMinusButton);
        redPepperMinusButton.setOnClickListener(v -> {
            String currentQuantityText = redPepperQuantity.getText().toString();
            int currentQuantity = Integer.parseInt(currentQuantityText);

            if (currentQuantity > 1) {
                int newQuantity = currentQuantity - 1;

                redPepperQuantity.setText(String.valueOf(newQuantity));

                double newPrice = redPepperUnitPrice * newQuantity;
                redPepperPrice.setText(String.format("$%.2f", newPrice));
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

        // Botón de aumentar cantidad en huevos
        Button eggsPlusButton = findViewById(R.id.eggsPlusButton);
        eggsPlusButton.setOnClickListener(v -> {
            String currentQuantityText = eggsQuantity.getText().toString();
            int currentQuantity = Integer.parseInt(currentQuantityText);
            int newQuantity = currentQuantity + 1;

            eggsQuantity.setText(String.valueOf(newQuantity));

            double newPrice = eggsUnitPrice * newQuantity;
            eggsPrice.setText(String.format("$%.2f", newPrice));
        });

        // Botón de disminuir cantidad en huevos
        Button eggsMinusButton = findViewById(R.id.eggsMinusButton);
        eggsMinusButton.setOnClickListener(v -> {
            String currentQuantityText = eggsQuantity.getText().toString();
            int currentQuantity = Integer.parseInt(currentQuantityText);

            if (currentQuantity > 1) {
                int newQuantity = currentQuantity - 1;

                eggsQuantity.setText(String.valueOf(newQuantity));

                double newPrice = eggsUnitPrice * newQuantity;
                eggsPrice.setText(String.format("$%.2f", newPrice));
            }
        });

        // Botón de eliminar huevos del carrito
        Button eggsRemoveButton = findViewById(R.id.eggsRemoveButton);
        View eggsItem = findViewById(R.id.eggsItem);
        View eggsDivider = findViewById(R.id.eggsDivider);

        eggsRemoveButton.setOnClickListener(v -> {
            eggsItem.setVisibility(View.GONE);
            eggsDivider.setVisibility(View.GONE);
        });

        // Botón de ir al pago y contenedor del carrito
        Button checkoutButton = findViewById(R.id.checkoutButton);
        LinearLayout cartItemsContainer = findViewById(R.id.cartItemsContainer);

        TextView checkoutSummary = new TextView(this);
        checkoutSummary.setTextColor(getColor(R.color.text_primary));
        checkoutSummary.setTextSize(18);
        checkoutSummary.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        checkoutButton.setOnClickListener(v -> {
            int redPepperCurrentQuantity = Integer.parseInt(redPepperQuantity.getText().toString());
            int eggsCurrentQuantity = Integer.parseInt(eggsQuantity.getText().toString());
            int bananasCurrentQuantity = Integer.parseInt(bananasQuantity.getText().toString());
            int gingerCurrentQuantity = Integer.parseInt(gingerQuantity.getText().toString());

            double redPepperTotal = redPepperUnitPrice * redPepperCurrentQuantity;
            double eggsTotal = eggsUnitPrice * eggsCurrentQuantity;
            double bananasTotal = bananasUnitPrice * bananasCurrentQuantity;
            double gingerTotal = gingerUnitPrice * gingerCurrentQuantity;

            if (redPepperItem.getVisibility() == View.GONE) {
                redPepperTotal = 0;
            }

            if (eggsItem.getVisibility() == View.GONE) {
                eggsTotal = 0;
            }

            double cartTotal = redPepperTotal + eggsTotal + bananasTotal + gingerTotal;

            checkoutSummary.setText("Resumen del pedido\nTotal estimado: $" + String.format("%.2f", cartTotal));

            if (checkoutSummary.getParent() == null) {
                cartItemsContainer.addView(checkoutSummary);
            }
        });
    }
}