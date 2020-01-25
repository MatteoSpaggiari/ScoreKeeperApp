package it.matteospaggiari.scorekeeperapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Spinner spinnerTeamA;
    Spinner spinnerTeamB;
    TextView teamA;
    TextView teamB;
    TextView scoreTeamA;
    TextView scoreTeamB;
    TextView playersTeamA;
    TextView playersTeamB;
    TextView cornerTeamA;
    TextView cornerTeamB;
    TextView offsideTeamA;
    TextView offsideTeamB;
    int valueScoreTeamA;
    int valueScoreTeamB;
    int numberPlayersTeamA;
    int numberPlayersTeamB;
    int numberCornerTeamA;
    int numberCornerTeamB;
    int numberOffsideTeamA;
    int numberOffsideTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamA = findViewById(R.id.team_a);
        teamB = findViewById(R.id.team_b);
        scoreTeamA = findViewById(R.id.team_a_score);
        scoreTeamB = findViewById(R.id.team_b_score);
        playersTeamA = findViewById(R.id.team_a_num_players);
        playersTeamB = findViewById(R.id.team_b_num_players);
        cornerTeamA = findViewById(R.id.team_a_corner);
        cornerTeamB = findViewById(R.id.team_b_corner);
        offsideTeamA = findViewById(R.id.team_a_offside);
        offsideTeamB = findViewById(R.id.team_b_offside);

        // TextView Statistic Invisible, disable buttons and reset variable statistic
        invisibleStatisticTeams();
        disableButton();
        resetStatistics();

        // Spinner: List Team A
        spinnerTeamA = findViewById(R.id.team_list_a);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterTeamA = ArrayAdapter.createFromResource(this, R.array.list_teams, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterTeamA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerTeamA.setAdapter(adapterTeamA);
        // Call private method
        selectTeamA();

        // Spinner: List Team B
        spinnerTeamB = findViewById(R.id.team_list_b);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterTeamB = ArrayAdapter.createFromResource(this, R.array.list_teams, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterTeamB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerTeamB.setAdapter(adapterTeamB);
        // Call private method
        selectTeamB();
    }

    private void selectTeamA() {
        /*
        * Spinner Team A
        * */
        spinnerTeamA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getSelectedItem().toString().equals("Select Team")) {
                    teamA.setText("Team A");
                } else {
                    /*
                    * Set the selected team in the TextView, make the statistics visible and enable the buttons
                    * */
                    teamA.setText(parent.getSelectedItem().toString());
                    parent.setVisibility(View.GONE);
                    visibleStatisticTeamA();
                    enableButtonTeamA();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void selectTeamB() {
        /*
        * Spinner Team B
        * */
        spinnerTeamB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getSelectedItem().toString().equals("Select Team")) {
                    teamB.setText("Team B");
                } else {
                    /*
                    * Set the selected team in the TextView, make the statistics visible and enable the buttons
                    * */
                    teamB.setText(parent.getSelectedItem().toString());
                    parent.setVisibility(View.GONE);
                    visibleStatisticTeamB();
                    enableButtonTeamB();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void addScoreTeamA(View v) {
        /*
        * Add a goal to team A
        * */
        valueScoreTeamA += 1;
        scoreTeamA.setText(String.valueOf(valueScoreTeamA));
    }

    public void addScoreTeamB(View v) {
        /*
        * Add a goal to team B
        * */
        valueScoreTeamB += 1;
        scoreTeamB.setText(String.valueOf(valueScoreTeamB));
    }

    public void addCornerTeamA(View v) {
        /*
        * Increase team A offside by one
        * */
        numberCornerTeamA += 1;
        cornerTeamA.setText("Corner: " + numberCornerTeamA);
    }

    public void addCornerTeamB(View v) {
        /*
        * Increase team B corner by one
        * */
        numberCornerTeamB += 1;
        cornerTeamB.setText("Corner: " + numberCornerTeamB);
    }

    public void addOffsideTeamA(View v) {
        /*
        * Increase team A offside by one
        * */
        numberOffsideTeamA += 1;
        offsideTeamA.setText("Offside: " + numberOffsideTeamA);
    }

    public void addOffsideTeamB(View v) {
        /*
        * Increase team B offside by one
        * */
        numberOffsideTeamB += 1;
        offsideTeamB.setText("Offside: " + numberOffsideTeamB);
    }

    public void addRedCardTeamA(View v) {
        /*
        * A player's team A decreases due to the red card
        * */
        numberPlayersTeamA -= 1;
        if(numberPlayersTeamA >= 0) {
            playersTeamA.setText("Players: " + numberPlayersTeamA);
        }
    }

    public void addRedCardTeamB(View v) {
        /*
        * A player's team B decreases due to the red card
        * */
        numberPlayersTeamB -= 1;
        if(numberPlayersTeamB >= 0) {
            playersTeamB.setText("Players: " + numberPlayersTeamB);
        }
    }

    public void resetApp(View v) {
        /*
        * Reset all variables, views and buttons
        * */
        spinnerTeamA.setVisibility(View.VISIBLE);
        spinnerTeamA.setSelection(0);
        spinnerTeamB.setVisibility(View.VISIBLE);
        spinnerTeamB.setSelection(0);
        teamA.setText("Team A");
        teamB.setText("Team B");
        invisibleStatisticTeams();
        scoreTeamA.setText("0");
        scoreTeamB.setText("0");
        cornerTeamA.setText("Corner: 0");
        cornerTeamB.setText("Corner: 0");
        offsideTeamA.setText("Offside: 0");
        offsideTeamB.setText("Offside: 0");
        playersTeamA.setText("Players: 11");
        playersTeamB.setText("Players: 11");
        disableButton();
        resetStatistics();
    }

    private void visibleStatisticTeamA() {
        /*
        * Once chosen the squdra makes the statistics of the Team A
        * */
        playersTeamA.setVisibility(View.VISIBLE);
        cornerTeamA.setVisibility(View.VISIBLE);
        offsideTeamA.setVisibility(View.VISIBLE);
    }

    private void visibleStatisticTeamB() {
        /*
         * Once chosen the squdra makes the statistics of the Team B
         * */
        playersTeamB.setVisibility(View.VISIBLE);
        cornerTeamB.setVisibility(View.VISIBLE);
        offsideTeamB.setVisibility(View.VISIBLE);
    }

    private void invisibleStatisticTeams() {
        /*
        * Hides team statistics
        * */
        playersTeamA.setVisibility(View.GONE);
        playersTeamB.setVisibility(View.GONE);
        cornerTeamA.setVisibility(View.GONE);
        cornerTeamB.setVisibility(View.GONE);
        offsideTeamA.setVisibility(View.GONE);
        offsideTeamB.setVisibility(View.GONE);
    }

    private void resetStatistics() {
        /*
        * Reset all variables
        * */
        valueScoreTeamA = 0;
        valueScoreTeamB = 0;
        numberPlayersTeamA = 11;
        numberPlayersTeamB = 11;
        numberCornerTeamA = 0;
        numberCornerTeamB = 0;
        numberOffsideTeamA = 0;
        numberOffsideTeamB = 0;
    }

    private void disableButton() {
        /*
        * Disable the buttons
        * */
        findViewById(R.id.team_a_goal).setEnabled(false);
        findViewById(R.id.team_a_corner_button).setEnabled(false);
        findViewById(R.id.team_a_offside_button).setEnabled(false);
        findViewById(R.id.team_a_red_card_button).setEnabled(false);
        findViewById(R.id.team_b_goal).setEnabled(false);
        findViewById(R.id.team_b_corner_button).setEnabled(false);
        findViewById(R.id.team_b_offside_button).setEnabled(false);
        findViewById(R.id.team_b_red_card_button).setEnabled(false);
    }

    private void enableButtonTeamA() {
        /*
        * Enable team A buttons
        * */
        findViewById(R.id.team_a_goal).setEnabled(true);
        findViewById(R.id.team_a_corner_button).setEnabled(true);
        findViewById(R.id.team_a_offside_button).setEnabled(true);
        findViewById(R.id.team_a_red_card_button).setEnabled(true);
    }

    private void enableButtonTeamB() {
        /*
        * Enable team B buttons
        * */
        findViewById(R.id.team_b_goal).setEnabled(true);
        findViewById(R.id.team_b_corner_button).setEnabled(true);
        findViewById(R.id.team_b_offside_button).setEnabled(true);
        findViewById(R.id.team_b_red_card_button).setEnabled(true);
    }

}
