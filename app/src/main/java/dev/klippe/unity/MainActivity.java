package dev.klippe.unity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import dev.klippe.unity.fragment.AddAdFragment;
import dev.klippe.unity.fragment.AddEventFragment;
import dev.klippe.unity.fragment.EventFragment;
import dev.klippe.unity.fragment.FeatbackFragment;
import dev.klippe.unity.fragment.QrScanFragment;
import dev.klippe.unity.fragment.SearchFragment;
import dev.klippe.unity.fragment.SwapScoreFragment;
import dev.klippe.unity.fragment.TimetableFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);
        getSupportActionBar().setTitle("");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ft = getSupportFragmentManager().beginTransaction();
        EventFragment eventFragment = EventFragment.getInstance(this);
        ft.replace(R.id.main_frame, eventFragment);
        ft.commit();
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

           @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        ft = getSupportFragmentManager().beginTransaction();

        if (id == R.id.btn_nav_mainpage) {
            EventFragment eventFragment = EventFragment.getInstance(this);
            ft.replace(R.id.main_frame, eventFragment);

        } else if (id == R.id.btn_nav_myshedule) {
            TimetableFragment timetableFragment = TimetableFragment.getInstance(this);
            ft.replace(R.id.main_frame, timetableFragment);
            Toast.makeText(this, "Готово", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.btn_nav_ads) {
            Toast.makeText(this, "Не готово", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.btn_nav_city_catalog) {
            Toast.makeText(this, "Не готово", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.btn_nav_ibusnessman) {
            Toast.makeText(this, "Не готово", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.btn_nav_search) {

            SearchFragment searchFragment  = SearchFragment.getInstance(this);
            ft.replace(R.id.main_frame, searchFragment);


        } else if (id == R.id.btn_nav_add_event) {
            AddEventFragment addEventFragment = AddEventFragment.getInstance(this);
            ft.replace(R.id.main_frame, addEventFragment);
            Toast.makeText(this, "Готово", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.btn_nav_add_ad) {
            AddAdFragment addAdFragment = AddAdFragment.getInstance(this);
            ft.replace(R.id.main_frame, addAdFragment);
            Toast.makeText(this, "Готово", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.btn_nav_swap_score) {
            SwapScoreFragment swapScoreFragment = SwapScoreFragment.getInstance(this);
            ft.replace(R.id.main_frame, swapScoreFragment);
            Toast.makeText(this, "Готово", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.btn_nav_qr_code) {
            QrScanFragment qrScanFragment = QrScanFragment.getInstance(this);
            ft.replace(R.id.main_frame, qrScanFragment);
            Toast.makeText(this, "Готово", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.btn_nav_feedback) {

            FeatbackFragment featbackFragment  = FeatbackFragment.getInstance(this);
            ft.replace(R.id.main_frame, featbackFragment);

        } else if (id == R.id.btn_nav_setting) {
            Toast.makeText(this, "Не готово", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.btn_nav_about) {
            Toast.makeText(this, "Не готово", Toast.LENGTH_SHORT).show();
        }
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
