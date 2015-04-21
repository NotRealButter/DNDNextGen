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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stephenhite.dndnextgen.CreatorLogic.CreatorCntl;
import com.example.stephenhite.dndnextgen.CreatorLogic.UserCharacter;
import com.example.stephenhite.dndnextgen.Fragments.CharacterCreateFragment;
import com.example.stephenhite.dndnextgen.Fragments.RaceFragment;

import java.util.ArrayList;


public class CharCreateActivity extends ActionBarActivity {
    ArrayList<NavItem> mNavigationItems = new ArrayList<>();
    ArrayList<NavItem> mCreationItems = new ArrayList<>();

    DrawerListAdapter mLeftAdapter;
    DrawerListAdapter mRightAdapter;

    ListView mLeftDrawer;
    ListView mRightDrawer;

    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;

    Button createCharacter;

    CreatorCntl creatorCntl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMenus(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_char_create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void selectItemFromRightDrawer(int position) {
        FragmentManager fragmentManager = getFragmentManager();

        switch (position) {
            case 0:
                fragmentManager.beginTransaction().replace(R.id.container, CharacterCreateFragment.newInstance("match_parent", "match_parent"), "title_section_2")
                        .commit();
                setTitle(mNavigationItems.get(position).mTitle);
                break;
            case 1:
                fragmentManager.beginTransaction().replace(R.id.container, RaceFragment.newInstance("match_parent", "match_parent"), "title_section_1")
                        .commit();
                setTitle(mNavigationItems.get(position).mTitle);
                break;
            case 2:
                fragmentManager.beginTransaction().replace(R.id.container, CharacterCreateFragment.newInstance("match_parent", "match_parent"), "title_section_2")
                        .commit();
                setTitle(mNavigationItems.get(position).mTitle);
            case 3:

                fragmentManager.beginTransaction().replace(R.id.container, CharacterCreateFragment.newInstance("match_parent", "match_parent"), "title_section_2")
                        .commit();
                setTitle(mNavigationItems.get(position).mTitle);
                Toast.makeText(getBaseContext(), "AbilityScore", Toast.LENGTH_SHORT).show();
            case 4:
                creatorCntl.saveCharacter(this.getBaseContext());
                Toast.makeText(getBaseContext(), "saved", Toast.LENGTH_SHORT).show();
        }

        mRightDrawer.setItemChecked(position, true);

        mDrawerLayout.closeDrawer(mRightDrawer);
    }

    private void selectItemFromLeftDrawer(int position) {
        switch (position) {
            case 0:
                Intent mainIntent = new Intent(mDrawerLayout.getContext(), MainActivity.class);
                startActivity(mainIntent);
                finish();
                break;
            case 1:
                Toast.makeText(getBaseContext(), "You're Already There!", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Intent viewIntent = new Intent(mDrawerLayout.getContext(), ViewCharacter.class);
                startActivity(viewIntent);
                finish();
//            case 3:
//                Intent importIntent = new Intent(mDrawerLayout.getContext(),ImportCharacter.class);
//                startActivity(importIntent);
//                finish();
        }

        mRightDrawer.setItemChecked(position, true);
        setTitle(mNavigationItems.get(position).mTitle);
        mDrawerLayout.closeDrawer(mLeftDrawer);
    }

    public void initMenus(Bundle savedInstanceState) {
        setContentView(R.layout.activity_char_create);
        setTitle(R.string.menu_init);
        FragmentManager fm = getFragmentManager();

        if (savedInstanceState == null) {
            fm.beginTransaction().replace(R.id.container, CharacterCreateFragment.newInstance("match_parent", "match_parent"), "title_section_1").commit();
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

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

        UserCharacter character = new UserCharacter();
        creatorCntl = new CreatorCntl();
    }

    public void HandleCreateCharacter(View view) {
        TextView nameBox = (TextView) findViewById(R.id.character_name_field);
        TextView ageBox = (TextView) findViewById(R.id.character_age_field);

        creatorCntl.userCharacter.setName(nameBox.getText().toString());
        creatorCntl.userCharacter.setAge(Integer.parseInt(ageBox.getText().toString()));

        creatorCntl.saveCharacter(this.getBaseContext());
    }

}
