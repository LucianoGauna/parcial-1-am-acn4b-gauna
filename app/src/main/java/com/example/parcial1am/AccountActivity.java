package com.example.parcial1am;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.accountRoot), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firebaseAuth = FirebaseAuth.getInstance();

        TextView userEmailText = findViewById(R.id.userEmailText);
        TextView logoutButton = findViewById(R.id.logoutButton);

        View navShop = findViewById(R.id.navShop);
        View navExplore = findViewById(R.id.navExplore);
        View navCart = findViewById(R.id.navCart);
        View navFavorites = findViewById(R.id.navFavorites);

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        if (currentUser != null && currentUser.getEmail() != null) {
            userEmailText.setText(currentUser.getEmail());
        } else {
            userEmailText.setText(R.string.account_no_user);
        }

        logoutButton.setOnClickListener(v -> {
            firebaseAuth.signOut();
            Toast.makeText(this, R.string.logout_success, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        navExplore.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, ExploreActivity.class);
            startActivity(intent);
        });

        navCart.setOnClickListener(v -> {
            Intent intent = new Intent(AccountActivity.this, MainActivity.class);
            startActivity(intent);
        });

        navShop.setOnClickListener(v ->
                Toast.makeText(this, "Tienda próximamente", Toast.LENGTH_SHORT).show()
        );

        navFavorites.setOnClickListener(v ->
                Toast.makeText(this, "Favoritos próximamente", Toast.LENGTH_SHORT).show()
        );
    }
}