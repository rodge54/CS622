package FX_UI;

import ESOLSMS.*;
import ESOLSMS.GenericClass;
import ESOLSMS.FileBinaryOutput;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
    public void initialize() throws FileNotFoundException {
        searchButton.setDisable(true);
        ESOLStudentTeacherSearch esolStudentTeacherSearch = new ESOLStudentTeacherSearch();
        esolStudentTeacherSearch.buildStudentArray();
    }

    @FXML
    public void onButtonClick(ActionEvent e) throws FileNotFoundException {
        //Performs functions when button is pressed
        ESOLStudentTeacherSearch esolStudentTeacherSearch = new ESOLStudentTeacherSearch();
        ArrayList<Student> studArr;
        studArr = FileBinaryOutput.inputFromBinaryFile();

        if(e.getSource().equals(searchButton) && comboBox.getValue().equals(gradeLevel)){
            //Search for student by grade level
            GenericClass.printPersonv2(esolStudentTeacherSearch.searchByGradeLevelWithStream(nameField.getText(), studArr));



        }
        else if(e.getSource().equals(searchButton) && comboBox.getValue().equals(englishLevel)){
            //Search for student by grade level
            GenericClass.printPersonv2(esolStudentTeacherSearch.searchByEnglishLevelWithStream(nameField.getText(), studArr));
        }
        else if(e.getSource().equals(searchButton) && comboBox.getValue().equals(lastName)){
            //Search for student by grade level
            GenericClass.printPersonv2(esolStudentTeacherSearch.searchByLastNameWithStream(nameField.getText(), studArr));
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
