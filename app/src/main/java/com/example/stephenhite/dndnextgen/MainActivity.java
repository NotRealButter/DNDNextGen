package com.example.stephenhite.dndnextgen;

import android.app.FragmentManager;
import android.content.Intent;
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

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ArrayList<NavItem> mNavigationItems = new ArrayList<>();
    ArrayList<NavItem> mCreationItems = new ArrayList<>();

    DrawerListAdapter mLeftAdapter;
    DrawerListAdapter mRightAdapter;

    ListView mLeftDrawer;
    ListView mRightDrawer;

    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;

    CharacterCreateFragment characterCreateFragment;
    RaceFragment raceFragment;
    MenuFragment menuFragment;
    GameClassFragment classFragment;

    Intent mainIntent;
    Intent createIntent;
    Intent viewIntent;
    Intent importIntent;

    static CreatorCntl creatorCntl = new CreatorCntl();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMenus(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    private void selectItemFromLeftDrawer(int position) {
        switch (position) {
            case 0:
//                Intent mainIntent = new Intent(mDrawerLayout.getContext(),MainActivity.class);
//                startActivity(mainIntent);
//                break;
                Toast.makeText(getBaseContext(), "You're Already There!", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                startActivity(createIntent);
                finish();
                break;
            case 2:
                startActivity(viewIntent);
                finish();
            case 3:
                startActivity(importIntent);
                finish();
        }

        mRightDrawer.setItemChecked(position, true);
        setTitle(mNavigationItems.get(position).mTitle);
        mDrawerLayout.closeDrawer(mLeftDrawer);
    }

    public void initMenus(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mainIntent = new Intent(mDrawerLayout.getContext(), MainActivity.class);
        createIntent = new Intent(mDrawerLayout.getContext(), CharCreateActivity.class);
        viewIntent = new Intent(mDrawerLayout.getContext(), ViewCharacter.class);
        importIntent = new Intent(mDrawerLayout.getContext(), ImportCharacter.class);

        characterCreateFragment = CharacterCreateFragment.newInstance("match_parent", "match_parent");
        classFragment = GameClassFragment.newInstance("match_parent", "match_parent");
        raceFragment = RaceFragment.newInstance("match_parent", "match_parent");
        menuFragment = MenuFragment.newInstance("match_parent", "match_parent");


        setTitle(R.string.menu_init);
        FragmentManager fm = getFragmentManager();

        if (savedInstanceState == null) {
            fm.beginTransaction().replace(R.id.container, menuFragment, "title_section_1").commit();
        }

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
        mCreationItems.add(new NavItem("Create Character", "Don't hit this til you're done"));


        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);

        mLeftAdapter = new DrawerListAdapter(this, mNavigationItems);
        mRightAdapter = new DrawerListAdapter(this, mCreationItems);

        mLeftDrawer.setAdapter(mLeftAdapter);
        mRightDrawer.setAdapter(mRightAdapter);

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, mRightDrawer);
        mLeftDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromLeftDrawer(position);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        mDrawerToggle.syncState();

        creatorCntl = new CreatorCntl();
    }
}
