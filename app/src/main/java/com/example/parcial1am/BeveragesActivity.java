package com.example.parcial1am;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BeveragesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_beverages);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.beveragesRoot), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View backButton = findViewById(R.id.backButton);
        View filterButton = findViewById(R.id.filterButton);

        View dietCokeCard = findViewById(R.id.dietCokeCard);
        View spriteCard = findViewById(R.id.spriteCard);
        View appleGrapeJuiceCard = findViewById(R.id.appleGrapeJuiceCard);
        View orangeJuiceCard = findViewById(R.id.orangeJuiceCard);
        View cocaColaCard = findViewById(R.id.cocaColaCard);
        View pepsiCard = findViewById(R.id.pepsiCard);

        View addDietCokeButton = findViewById(R.id.addDietCokeButton);
        View addSpriteButton = findViewById(R.id.addSpriteButton);
        View addAppleGrapeJuiceButton = findViewById(R.id.addAppleGrapeJuiceButton);
        View addOrangeJuiceButton = findViewById(R.id.addOrangeJuiceButton);
        View addCocaColaButton = findViewById(R.id.addCocaColaButton);
        View addPepsiButton = findViewById(R.id.addPepsiButton);

        backButton.setOnClickListener(v -> finish());

        filterButton.setOnClickListener(v ->
                Toast.makeText(this, "Filtros próximamente", Toast.LENGTH_SHORT).show()
        );

        dietCokeCard.setOnClickListener(v -> showProductDetailSoon());
        spriteCard.setOnClickListener(v -> showProductDetailSoon());
        appleGrapeJuiceCard.setOnClickListener(v -> showProductDetailSoon());
        orangeJuiceCard.setOnClickListener(v -> showProductDetailSoon());
        cocaColaCard.setOnClickListener(v -> showProductDetailSoon());
        pepsiCard.setOnClickListener(v -> showProductDetailSoon());

        addDietCokeButton.setOnClickListener(v -> showProductAdded());
        addSpriteButton.setOnClickListener(v -> showProductAdded());
        addAppleGrapeJuiceButton.setOnClickListener(v -> showProductAdded());
        addOrangeJuiceButton.setOnClickListener(v -> showProductAdded());
        addCocaColaButton.setOnClickListener(v -> showProductAdded());
        addPepsiButton.setOnClickListener(v -> showProductAdded());
    }

    private void showProductAdded() {
        Toast.makeText(this, R.string.product_added, Toast.LENGTH_SHORT).show();
    }

    private void showProductDetailSoon() {
        Toast.makeText(this, "Detalle de producto próximamente", Toast.LENGTH_SHORT).show();
    }
}