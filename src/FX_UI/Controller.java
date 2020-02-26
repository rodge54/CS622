package FX_UI;

import ESOLSMS.*;
import ESOLSMS.GenericClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
    //Initialize search button disable when text box has no input
    public void initialize() {
        searchButton.setDisable(true);
    }

    @FXML
    public void onButtonClick(ActionEvent e) {
        //Performs functions when search button is pressed

        int studIndicator = 1;
        SqlSearch sqlSearch = new SqlSearch();

        if(e.getSource().equals(searchButton) && comboBox.getValue().equals(gradeLevel)){
            System.out.println("GradeLevel");
            //Search for student by grade level
            GenericClass.printPersonv2(sqlSearch.queryByGradeLevel(nameField.getText(), studIndicator));
        }

        else if(e.getSource().equals(searchButton) && comboBox.getValue().equals(englishLevel)){
            //Search for student by english level
            GenericClass.printPersonv2(sqlSearch.queryByEnglishLevel(nameField.getText(), studIndicator));
        }

        else if(e.getSource().equals(searchButton) && comboBox.getValue().equals(lastName)){
            //Search for student by grade level
            GenericClass.printPersonv2(sqlSearch.queryByLastName(nameField.getText(), studIndicator));
        }

        //Disables the submit button so the user cannot press it
        // until changes are made in the text box
        searchButton.setDisable(true);
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
