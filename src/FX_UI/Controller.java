package FX_UI;

import ESOLSMS.*;
import ESOLSMS.GenericClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Controller {
    /*Provides functionality for JavaFX UI*/

    @FXML
    //Text field for user search input
    private TextField nameField;

    @FXML
    //Search button for student/teacher search
    private Button searchButton;

    @FXML
    //Gives user options for what type of search to perform
    private ComboBox comboBox;

    @FXML
    //Option 1 for search Combo Box
    public String gradeLevel;

    @FXML
    //Option 2 for search Combo Box
    public String englishLevel;

    @FXML
    //Option 3 for search Combo Box
    public String lastName;

    @FXML
    //Search Results List
    private TableView searchResultsTable;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label searchResultsEmpty;

    @FXML
    //Initialize search button disable when text box has no input
    public void initialize() {
        searchButton.setDisable(true);
        progressBar.setVisible(false);
        searchResultsTable.setVisible(false);
        searchResultsEmpty.setVisible(false);
    }

    @FXML
    public void onButtonClick(ActionEvent e) {
        //Performs functions when search button is pressed

        searchResultsTable.setVisible(true);
        searchResultsTable.getItems().clear();
        searchButton.setDisable(true);

        Thread threadOne = new Thread(new Runnable() {
            //This thread is used to accomplish the search function.

            @Override
            public void run() {

                //Disables the submit button so the user cannot press it
                // until changes are made in the text box
                nameField.setDisable(true);
                progressBar.setVisible(true);
                comboBox.setDisable(true);
                searchResultsEmpty.setVisible(false);
                int studIndicator = 1;
                SqlSearch sqlSearch = new SqlSearch();
                ArrayList<ESOLStudent> studArr = new ArrayList<>();

                if (e.getSource().equals(searchButton) && comboBox.getValue().equals(gradeLevel)) {
                    //Search for student by grade level

                    studArr = (ArrayList<ESOLStudent>) sqlSearch.queryByGradeLevel(nameField.getText(), studIndicator);

                    if (studArr.isEmpty()){
                        //If no results are found hide table and show results empty message
                        setEmptyResultsVisibility();
                    } else printResults(studArr);

                } else if (e.getSource().equals(searchButton) && comboBox.getValue().equals(englishLevel)) {
                    //Search for student by english level

                    studArr = (ArrayList<ESOLStudent>) sqlSearch.queryByEnglishLevel(nameField.getText(), studIndicator);

                    if (studArr.isEmpty()){
                        //If no results are found hide table and show results empty message
                        setEmptyResultsVisibility();
                    } else printResults(studArr);

                } else if (e.getSource().equals(searchButton) && comboBox.getValue().equals(lastName)) {
                    //Search for student by last name

                    studArr = (ArrayList<ESOLStudent>) sqlSearch.queryByLastName(nameField.getText(), studIndicator);

                    if (studArr.isEmpty()){
                        //If no results are found hide table and show results empty message
                        setEmptyResultsVisibility();
                    } else printResults(studArr);
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable(){
            //This thread hides progress
            // bar and enables combo box once search completes

            @Override
            public void run() {
                try {
                    threadOne.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                progressBar.setVisible(false);
                comboBox.setDisable(false);
            }
        });

        Thread threadThree = new Thread(new Runnable(){
            //This thread hides empty results message and
            // enables name field after short delay to
            // prevent user from attempting another search immediately

            @Override
            public void run() {
                try {
                    threadTwo.join();
                    TimeUnit.SECONDS.sleep(3);
                    searchResultsEmpty.setVisible(false);
                    nameField.setDisable(false);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }

    private void setEmptyResultsVisibility(){
        //Set results table visibility to false and results empty to visible

        searchResultsTable.setVisible(false);
        searchResultsEmpty.setVisible(true);
    }

    private void printResults(ArrayList<ESOLStudent> studArr){
        for (ESOLStudent student : studArr) {
            //Print Students results to JavaFX table

            try {
                //********************ILLUSTRATIVE ONLY REMOVE WHEN FINISHED**************************
                TimeUnit.SECONDS.sleep(2);
                //************************************************************************************
                searchResultsTable.getItems().add(new ESOLStudentModel(
                        student.getFirstName(),
                        student.getLastName(),
                        student.calculateAge(),
                        student.getGradeLevel(),
                        student.getEnglishLevel(),
                        student.getFirstLanguage()));
            } catch (ParseException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    @FXML
    public void handleKeyReleased(){
        //Disables button when text box doesn't contain text and
        //ensures box in not empty
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        searchButton.setDisable(disableButtons);
    }
}
