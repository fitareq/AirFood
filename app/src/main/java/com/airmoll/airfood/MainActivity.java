package com.airmoll.airfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.airmoll.airfood.databinding.ActivityMainBinding;
import com.airmoll.airfood.fragments.HomeFragment;
import com.airmoll.airfood.fragments.MoreFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final HomeFragment homeFragment = new HomeFragment();
    private final MoreFragment moreFragment = new MoreFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        binding.bottomNav.setBackground(null);
        binding.bottomNav.getMenu().getItem(2).setEnabled(false);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,moreFragment).addToBackStack(null).commit();
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLoginPage();
            }
        });
    }

    private void goToLoginPage()
    {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu,menu);
        MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return false;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                return false;
            }
        };
        return super.onCreateOptionsMenu(menu);
    }


}

