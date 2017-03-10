package com.example.babis.herome.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.babis.herome.R;

public class BackStory extends AppCompatActivity {

    TextView title, bio;
    Button primary, secondary, goBack;
    private static final String HULK = " During times of high stress or anger, an increase in adrenaline causes the Hulk's strength to increase dramatically. There has never been a limit shown as to the highest strength the Hulk can reach thus it is assumed it is limitless.";
    private static final String SUPERMAN = "Superman possesses the powers of flight, superhuman strength, x-ray vision, heat vision, cold breath, super-speed, enhanced hearing, and nigh-invulnerability.";
    private static final String SPIDERMAN = "1.1 Generally enhanced physiology.\n" +
            "1.2 Possible mystical connection.\n" +
            "1.3 Wall-crawling. ...\n" +
            "1.4 Superhuman strength, durability, healing factor, jumping, leaping and speed.\n" +
            "1.5 Superhuman agility, reflexes and equilibrium.\n";
    private static final String THOR = "Thor possesses physical powers superior to those of normal Asgardian gods. He has an extended lifespan augmented (although not immortal) by the Golden Apples of Idunn, immunity to conventional diseases, enhanced endurance.";

    private static final String CYCLOPS = "Cyclops  is  capable of generating concussive force red-colored beams from his eyes. He has fought for peace and equality between humans and mutants since joining the X-Men. ";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_story);


        title = (TextView) findViewById(R.id.title_text_view);
        bio = (TextView) findViewById(R.id.bio_text_view);


        primary = (Button) findViewById(R.id.primary_power_button);
        secondary = (Button) findViewById(R.id.secondary_power_button);

        title.setText(MainActivity.name);

        primary.setText(MainActivity.primaryPower);
        secondary.setText(MainActivity.howYouGotIt);

        primary.setCompoundDrawablesRelativeWithIntrinsicBounds(MainActivity.imagePrimaryPower, 0, 0, 0);
        secondary.setCompoundDrawablesRelativeWithIntrinsicBounds(MainActivity.imageHowYouGotIt, 0, 0, 0);


        switch (MainActivity.name) {
            case "Hulk":
                bio.setText(HULK);
                break;
            case "Spiderman":
                bio.setText(SPIDERMAN);
                break;
            case "Cyclops":
                bio.setText(CYCLOPS);
                break;
            case "Superman":
                bio.setText(SUPERMAN);
                break;
            case "Thor":
                bio.setText(THOR);
                break;
        }


        goBack = (Button) findViewById(R.id.reset);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BackStory.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}