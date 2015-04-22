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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stephenhite.dndnextgen.CreatorLogic.CreatorCntl;
import com.example.stephenhite.dndnextgen.Fragments.CharacterCreateFragment;
import com.example.stephenhite.dndnextgen.Fragments.GameClassFragment;
import com.example.stephenhite.dndnextgen.Fragments.MenuFragment;
import com.example.stephenhite.dndnextgen.Fragments.RaceFragment;
import com.example.stephenhite.dndnextgen.Fragments.ViewCharacterFragment;

import java.io.File;
import java.util.ArrayList;


public class ViewCharacter extends ActionBarActivity {
    MainActivity mainActivity = new MainActivity();
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
                Toast.makeText(getBaseContext(), "You're Already There!", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                startActivity(importIntent);
                finish();
        }

        mRightDrawer.setItemChecked(position, true);
        setTitle(mNavigationItems.get(position).mTitle);
        mDrawerLayout.closeDrawer(mLeftDrawer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initMenus(Bundle savedInstanceState) {
        setContentView(R.layout.activity_view_character);
        setTitle(R.string.menu_init);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mainIntent = new Intent(mDrawerLayout.getContext(), MainActivity.class);
        createIntent = new Intent(mDrawerLayout.getContext(), CharCreateActivity.class);
        viewIntent = new Intent(mDrawerLayout.getContext(), ViewCharacter.class);
        importIntent = new Intent(mDrawerLayout.getContext(), ImportCharacter.class);

        characterCreateFragment = CharacterCreateFragment.newInstance("match_parent", "match_parent");
        classFragment = GameClassFragment.newInstance("match_parent", "match_parent");
        raceFragment = RaceFragment.newInstance("match_parent", "match_parent");
        menuFragment = MenuFragment.newInstance("match_parent", "match_parent");

        FragmentManager fm = getFragmentManager();
        {
            fm.beginTransaction().replace(R.id.container, ViewCharacterFragment.newInstance("match_parent", "match_parent"), "title_section_1").commit();
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

        this.creatorCntl = MainActivity.creatorCntl;
    }

    public void ViewCreateCharacter(View view) {
        TextView nameBox = (TextView) findViewById(R.id.character_name_box);
        TextView ageBox = (TextView) findViewById(R.id.character_age_box);
        TextView heightBox = (TextView) findViewById(R.id.character_height_box);
        TextView weightBox = (TextView) findViewById(R.id.character_weight_box);
        TextView raceBox = (TextView) findViewById(R.id.character_race_box);
        TextView classBox = (TextView) findViewById(R.id.character_class_box);
        TextView alignmentBox = (TextView) findViewById(R.id.character_alignment_box);
        ListView characterLoader = (ListView) findViewById(R.id.character_loader);
        creatorCntl.listFilesMatching(new File(this.getBaseContext().getFilesDir().getPath()), ".*");
        characterLoader.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, creatorCntl.fileNames));



        creatorCntl.loadCharacter(this.getBaseContext());

        nameBox.setText(creatorCntl.userCharacter.getName());
        ageBox.setText(Integer.valueOf(creatorCntl.userCharacter.getAge()).toString());
        heightBox.setText(Integer.valueOf(creatorCntl.userCharacter.getHeight()).toString());
        weightBox.setText(Integer.valueOf(creatorCntl.userCharacter.getWeight()).toString());
        raceBox.setText(creatorCntl.userCharacter.getRace());
        classBox.setText(creatorCntl.userCharacter.getClass1());
        alignmentBox.setText(creatorCntl.userCharacter.getAlignment());


    }
}
