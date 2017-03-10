package com.example.babis.herome.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.babis.herome.Fragments.MainFragment;
import com.example.babis.herome.Fragments.PickPowerFragment;
import com.example.babis.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener,
        PickPowerFragment.OnFragmentInteractionListener{

    public static String howYouGotIt = "";
    public static int imageHowYouGotIt=0;
    public static String primaryPower = "";
    public static int imagePrimaryPower=0;
    public static String name = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager =  getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.container);

        if(fragment==null){
            fragment = new MainFragment();
            manager.beginTransaction()
                    .add(R.id.container,fragment)
                    .commit();
        }


    }


    public void loadPowerScreen(){
       PickPowerFragment pickPowerFragment = new PickPowerFragment();
       getSupportFragmentManager()
               .beginTransaction()
               .replace(R.id.container,pickPowerFragment)
               .addToBackStack(null)
               .commit();

    }

   public void loadBackstoryScreen() {
       Intent intent = new Intent(this,BackStory.class);
       startActivity(intent);
  }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
