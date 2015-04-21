package com.example.stephenhite.dndnextgen;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.stephenhite.dndnextgen.CreatorLogic.CreatorCntl;
import com.example.stephenhite.dndnextgen.Fragments.CharacterCreateFragment;
import com.example.stephenhite.dndnextgen.Fragments.GameClassFragment;
import com.example.stephenhite.dndnextgen.Fragments.MenuFragment;
import com.example.stephenhite.dndnextgen.Fragments.RaceFragment;
import com.example.stephenhite.dndnextgen.Fragments.ViewCharacterFragment;

import java.util.ArrayList;


public class ImportCharacter extends ActionBarActivity {
    ArrayList<NavItem> mNavigationItems = new ArrayList<NavItem>();
    ArrayList<NavItem> mCreationItems = new ArrayList<NavItem>();

    DrawerListAdapter mLeftAdapter;
    DrawerListAdapter mRightAdapter;

    ListView mLeftDrawer;
    ListView mRightDrawer;

    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;

    CharacterCreateFragment characterCreateFragment;
    RaceFragment raceFragment;
    MenuFragment menuFragment;
    ViewCharacterFragment viewCharacterFragment;
    GameClassFragment classFragment;

    Intent mainIntent;
    Intent createIntent;
    Intent viewIntent;
    Intent importIntent;

    CreatorCntl creatorCntl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMenus(savedInstanceState);
    }

    private void selectItemFromLeftDrawer(int position) {
        switch (position) {
            case 0:
                startActivity(mainIntent);
                finish();
                break;
            case 1:
                startActivity(createIntent);
                finish();
                break;
            case 2:
                startActivity(viewIntent);
                finish();
            case 3:
                Toast.makeText(getBaseContext(), "You're Already There!", Toast.LENGTH_SHORT).show();
                break;
        }

        mRightDrawer.setItemChecked(position, true);
        setTitle(mNavigationItems.get(position).mTitle);
        mDrawerLayout.closeDrawer(mLeftDrawer);
    }

    private void selectItemFromRightDrawer(int position) {
        FragmentManager fragmentManager = getFragmentManager();

        switch (position) {
            case 0:
                fragmentManager.beginTransaction().replace(R.id.container, characterCreateFragment, "title_section_2")
                        .commit();
                setTitle(mNavigationItems.get(position).mTitle);
                break;
            case 1:
                fragmentManager.beginTransaction().replace(R.id.container, raceFragment, "title_section_1")
                        .commit();
                setTitle(mNavigationItems.get(position).mTitle);
                break;
            case 2:
                fragmentManager.beginTransaction().replace(R.id.container, classFragment, "title_section_2")
                        .commit();
                setTitle(mNavigationItems.get(position).mTitle);
            case 3:

                fragmentManager.beginTransaction().replace(R.id.container, classFragment, "title_section_2")
                        .commit();
                setTitle(mNavigationItems.get(position).mTitle);
//                Toast.makeText(getBaseContext(), "AbilityScore", Toast.LENGTH_SHORT).show();
            case 4:
                creatorCntl.saveCharacter(this.getBaseContext());
                Toast.makeText(getBaseContext(), "saved", Toast.LENGTH_SHORT).show();
        }

        mRightDrawer.setItemChecked(position, true);

        mDrawerLayout.closeDrawer(mRightDrawer);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (mDrawerLayout.isDrawerOpen(mRightDrawer)) {
            mDrawerLayout.closeDrawer(mRightDrawer);
            return super.onCreateOptionsMenu(menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void initMenus(Bundle savedInstanceState) {
        setContentView(R.layout.activity_import_character);
        setTitle(R.string.menu_init);
        FragmentManager fm = getFragmentManager();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        characterCreateFragment = CharacterCreateFragment.newInstance("match_parent", "match_parent");
        raceFragment = RaceFragment.newInstance("match_parent", "match_parent");
        viewCharacterFragment = ViewCharacterFragment.newInstance("match_parent", "match_parent");

        mainIntent = new Intent(mDrawerLayout.getContext(), MainActivity.class);
        createIntent = new Intent(mDrawerLayout.getContext(), CharCreateActivity.class);
        viewIntent = new Intent(mDrawerLayout.getContext(), ViewCharacter.class);
        importIntent = new Intent(mDrawerLayout.getContext(), ImportCharacter.class);

        mLeftDrawer = (ListView) findViewById(R.id.navigation_drawer_left);
        mRightDrawer = (ListView) findViewById(R.id.navigation_drawer_right);

        mLeftDrawer.setTag(0);
        mRightDrawer.setTag(1);

        mNavigationItems.add(new NavItem("Main Menu", "You're Probably Already There"));
        mNavigationItems.add(new NavItem("Create A Character", "Begin Your Journey"));
        mNavigationItems.add(new NavItem("View A Character", "See What You've Done"));
        mNavigationItems.add(new NavItem("Import A Character", "I've Prepared This Ahead Of Time"));

        mCreationItems.add(new NavItem("Character Info", "License and Registration"));
        mCreationItems.add(new NavItem("Race", "Humans, Elves and Gnomes, oh my!"));
        mCreationItems.add(new NavItem("Class", "Who Is Your Daddy, What does he do?"));
        mCreationItems.add(new NavItem("Ability Score", "Do you Even Lift?"));

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);

        mLeftAdapter = new DrawerListAdapter(this, mNavigationItems);
        mRightAdapter = new DrawerListAdapter(this, mCreationItems);

        mLeftDrawer.setAdapter(mLeftAdapter);
        mRightDrawer.setAdapter(mRightAdapter);

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, mRightDrawer);
        mLeftDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromLeftDrawer(position);
            }
        });
        mRightDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromRightDrawer(position);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        creatorCntl = MainActivity.creatorCntl;
    }
}
