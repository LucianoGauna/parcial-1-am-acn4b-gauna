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
        TextView bananasPrice = findViewById(R.id.bananasPrice);
        TextView gingerPrice = findViewById(R.id.gingerPrice);

        double redPepperUnitPrice = 749.99;
        double eggsUnitPrice = 850.99;
        double bananasUnitPrice = 690.00;
        double gingerUnitPrice = 300.99;

        Button checkoutButton = findViewById(R.id.checkoutButton);
        LinearLayout cartItemsContainer = findViewById(R.id.cartItemsContainer);
        TextView emptyCartMessage = findViewById(R.id.emptyCartMessage);

        Button redPepperRemoveButton = findViewById(R.id.redPepperRemoveButton);
        View redPepperItem = findViewById(R.id.redPepperItem);
        View redPepperDivider = findViewById(R.id.redPepperDivider);

        Button eggsRemoveButton = findViewById(R.id.eggsRemoveButton);
        View eggsItem = findViewById(R.id.eggsItem);
        View eggsDivider = findViewById(R.id.eggsDivider);

        Button bananasRemoveButton = findViewById(R.id.bananasRemoveButton);
        View bananasItem = findViewById(R.id.bananasItem);
        View bananasDivider = findViewById(R.id.bananasDivider);

        Button gingerRemoveButton = findViewById(R.id.gingerRemoveButton);
        View gingerItem = findViewById(R.id.gingerItem);
        View gingerDivider = findViewById(R.id.gingerDivider);

        TextView checkoutSummary = new TextView(this);

        // Botón de aumentar cantidad en pimiento
        Button redPepperPlusButton = findViewById(R.id.redPepperPlusButton);
        redPepperPlusButton.setOnClickListener(v -> {
            String currentQuantityText = redPepperQuantity.getText().toString();
            int currentQuantity = Integer.parseInt(currentQuantityText);
            int newQuantity = currentQuantity + 1;

            redPepperQuantity.setText(String.valueOf(newQuantity));

            double newPrice = redPepperUnitPrice * newQuantity;
            redPepperPrice.setText(String.format("$%.2f", newPrice));

            hideCheckoutSummary(checkoutSummary);
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

                hideCheckoutSummary(checkoutSummary);
            }
        });

        // Botón de eliminar pimiento del carrito
        redPepperRemoveButton.setOnClickListener(v -> {
            redPepperItem.setVisibility(View.GONE);
            redPepperDivider.setVisibility(View.GONE);
            hideCheckoutSummary(checkoutSummary);
            updateCartState(emptyCartMessage, checkoutButton, redPepperItem, eggsItem, bananasItem, gingerItem);
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

            hideCheckoutSummary(checkoutSummary);
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

                hideCheckoutSummary(checkoutSummary);
            }
        });

        // Botón de eliminar huevos del carrito
        eggsRemoveButton.setOnClickListener(v -> {
            eggsItem.setVisibility(View.GONE);
            eggsDivider.setVisibility(View.GONE);
            hideCheckoutSummary(checkoutSummary);
            updateCartState(emptyCartMessage, checkoutButton, redPepperItem, eggsItem, bananasItem, gingerItem);
        });

        // Botón de aumentar cantidad en bananas
        Button bananasPlusButton = findViewById(R.id.bananasPlusButton);
        bananasPlusButton.setOnClickListener(v -> {
            String currentQuantityText = bananasQuantity.getText().toString();
            int currentQuantity = Integer.parseInt(currentQuantityText);
            int newQuantity = currentQuantity + 1;

            bananasQuantity.setText(String.valueOf(newQuantity));

            double newPrice = bananasUnitPrice * newQuantity;
            bananasPrice.setText(String.format("$%.2f", newPrice));

            hideCheckoutSummary(checkoutSummary);
        });

        // Botón de disminuir cantidad en bananas
        Button bananasMinusButton = findViewById(R.id.bananasMinusButton);
        bananasMinusButton.setOnClickListener(v -> {
            String currentQuantityText = bananasQuantity.getText().toString();
            int currentQuantity = Integer.parseInt(currentQuantityText);

            if (currentQuantity > 1) {
                int newQuantity = currentQuantity - 1;

                bananasQuantity.setText(String.valueOf(newQuantity));

                double newPrice = bananasUnitPrice * newQuantity;
                bananasPrice.setText(String.format("$%.2f", newPrice));

                hideCheckoutSummary(checkoutSummary);
            }
        });

        // Botón de eliminar bananas del carrito
        bananasRemoveButton.setOnClickListener(v -> {
            bananasItem.setVisibility(View.GONE);
            bananasDivider.setVisibility(View.GONE);
            hideCheckoutSummary(checkoutSummary);
            updateCartState(emptyCartMessage, checkoutButton, redPepperItem, eggsItem, bananasItem, gingerItem);
        });

        // Botón de aumentar cantidad en jengibre
        Button gingerPlusButton = findViewById(R.id.gingerPlusButton);
        gingerPlusButton.setOnClickListener(v -> {
            String currentQuantityText = gingerQuantity.getText().toString();
            int currentQuantity = Integer.parseInt(currentQuantityText);
            int newQuantity = currentQuantity + 1;

            gingerQuantity.setText(String.valueOf(newQuantity));

            double newPrice = gingerUnitPrice * newQuantity;
            gingerPrice.setText(String.format("$%.2f", newPrice));

            hideCheckoutSummary(checkoutSummary);
        });

        // Botón de disminuir cantidad en jengibre
        Button gingerMinusButton = findViewById(R.id.gingerMinusButton);
        gingerMinusButton.setOnClickListener(v -> {
            String currentQuantityText = gingerQuantity.getText().toString();
            int currentQuantity = Integer.parseInt(currentQuantityText);

            if (currentQuantity > 1) {
                int newQuantity = currentQuantity - 1;

                gingerQuantity.setText(String.valueOf(newQuantity));

                double newPrice = gingerUnitPrice * newQuantity;
                gingerPrice.setText(String.format("$%.2f", newPrice));

                hideCheckoutSummary(checkoutSummary);
            }
        });

        // Botón de eliminar jengibre del carrito
        gingerRemoveButton.setOnClickListener(v -> {
            gingerItem.setVisibility(View.GONE);
            gingerDivider.setVisibility(View.GONE);
            hideCheckoutSummary(checkoutSummary);
            updateCartState(emptyCartMessage, checkoutButton, redPepperItem, eggsItem, bananasItem, gingerItem);
        });

        // Botón de ir al pago y contenedor del carrito
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

            if (bananasItem.getVisibility() == View.GONE) {
                bananasTotal = 0;
            }

            if (gingerItem.getVisibility() == View.GONE) {
                gingerTotal = 0;
            }

            double cartTotal = redPepperTotal + eggsTotal + bananasTotal + gingerTotal;

            checkoutSummary.setText("Resumen del pedido\nTotal estimado: $" + String.format("%.2f", cartTotal));
            checkoutSummary.setVisibility(View.VISIBLE);

            if (checkoutSummary.getParent() == null) {
                cartItemsContainer.addView(checkoutSummary);
            }
        });
    }

    private void updateCartState(
            TextView emptyCartMessage,
            Button checkoutButton,
            View redPepperItem,
            View eggsItem,
            View bananasItem,
            View gingerItem
    ) {
        boolean isCartEmpty =
                redPepperItem.getVisibility() == View.GONE &&
                        eggsItem.getVisibility() == View.GONE &&
                        bananasItem.getVisibility() == View.GONE &&
                        gingerItem.getVisibility() == View.GONE;

        if (isCartEmpty) {
            emptyCartMessage.setVisibility(View.VISIBLE);
            checkoutButton.setEnabled(false);
            checkoutButton.setAlpha(0.5f);
        } else {
            emptyCartMessage.setVisibility(View.GONE);
            checkoutButton.setEnabled(true);
            checkoutButton.setAlpha(1f);
        }
    }

    private void hideCheckoutSummary(TextView checkoutSummary) {
        if (checkoutSummary.getParent() != null) {
            checkoutSummary.setVisibility(View.GONE);
        }
    }
}