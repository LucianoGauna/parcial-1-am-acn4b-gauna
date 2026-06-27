package com.example.parcial1am;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class ExploreActivity extends AppCompatActivity {

    private LinearLayout fruitsCategoryCard;
    private LinearLayout oilCategoryCard;
    private LinearLayout meatCategoryCard;
    private LinearLayout bakeryCategoryCard;
    private LinearLayout dairyCategoryCard;
    private LinearLayout beveragesCategoryCard;
    private TextView noCategoriesMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_explore);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.exploreRoot), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText searchEditText = findViewById(R.id.searchEditText);

        fruitsCategoryCard = findViewById(R.id.fruitsCategoryCard);
        oilCategoryCard = findViewById(R.id.oilCategoryCard);
        meatCategoryCard = findViewById(R.id.meatCategoryCard);
        bakeryCategoryCard = findViewById(R.id.bakeryCategoryCard);
        dairyCategoryCard = findViewById(R.id.dairyCategoryCard);
        beveragesCategoryCard = findViewById(R.id.beveragesCategoryCard);
        noCategoriesMessage = findViewById(R.id.noCategoriesMessage);

        View navCart = findViewById(R.id.navCart);
        View navShop = findViewById(R.id.navShop);
        View navFavorites = findViewById(R.id.navFavorites);
        View navAccount = findViewById(R.id.navAccount);

        fruitsCategoryCard.setOnClickListener(v -> showComingSoon());
        oilCategoryCard.setOnClickListener(v -> showComingSoon());
        meatCategoryCard.setOnClickListener(v -> showComingSoon());
        bakeryCategoryCard.setOnClickListener(v -> showComingSoon());
        dairyCategoryCard.setOnClickListener(v -> showComingSoon());

        beveragesCategoryCard.setOnClickListener(v -> {
            Intent intent = new Intent(ExploreActivity.this, BeveragesActivity.class);
            startActivity(intent);
        });

        navCart.setOnClickListener(v -> {
            Intent intent = new Intent(ExploreActivity.this, MainActivity.class);
            startActivity(intent);
        });

        navShop.setOnClickListener(v ->
                Toast.makeText(this, "Tienda próximamente", Toast.LENGTH_SHORT).show()
        );

        navFavorites.setOnClickListener(v ->
                Toast.makeText(this, "Favoritos próximamente", Toast.LENGTH_SHORT).show()
        );

        navAccount.setOnClickListener(v ->
                Toast.makeText(this, "Cuenta próximamente", Toast.LENGTH_SHORT).show()
        );

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
                // No se necesita lógica antes del cambio.
            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                filterCategories(text.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // No se necesita lógica después del cambio.
            }
        });
    }

    private void filterCategories(String query) {
        String normalizedQuery = query.toLowerCase(Locale.ROOT).trim();

        int visibleCategories = 0;

        visibleCategories += updateCategoryVisibility(
                fruitsCategoryCard,
                getString(R.string.category_fruits),
                normalizedQuery
        );

        visibleCategories += updateCategoryVisibility(
                oilCategoryCard,
                getString(R.string.category_oil),
                normalizedQuery
        );

        visibleCategories += updateCategoryVisibility(
                meatCategoryCard,
                getString(R.string.category_meat),
                normalizedQuery
        );

        visibleCategories += updateCategoryVisibility(
                bakeryCategoryCard,
                getString(R.string.category_bakery),
                normalizedQuery
        );

        visibleCategories += updateCategoryVisibility(
                dairyCategoryCard,
                getString(R.string.category_dairy),
                normalizedQuery
        );

        visibleCategories += updateCategoryVisibility(
                beveragesCategoryCard,
                getString(R.string.category_beverages),
                normalizedQuery
        );

        if (visibleCategories == 0) {
            noCategoriesMessage.setVisibility(View.VISIBLE);
        } else {
            noCategoriesMessage.setVisibility(View.GONE);
        }
    }

    private int updateCategoryVisibility(View categoryCard, String categoryName, String query) {
        boolean shouldShow = query.isEmpty()
                || categoryName.toLowerCase(Locale.ROOT).contains(query);

        categoryCard.setVisibility(shouldShow ? View.VISIBLE : View.GONE);

        return shouldShow ? 1 : 0;
    }

    private void showComingSoon() {
        Toast.makeText(this, R.string.category_coming_soon, Toast.LENGTH_SHORT).show();
    }
}