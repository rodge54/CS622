package FX_UI;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ESOLStudentModel {
    private final SimpleStringProperty firstName = new SimpleStringProperty("");
    private final SimpleStringProperty lastName = new SimpleStringProperty("");
    private final SimpleIntegerProperty age = new SimpleIntegerProperty(0);
    private final SimpleStringProperty gradeLevel = new SimpleStringProperty("");
    private final SimpleStringProperty englishLevel = new SimpleStringProperty("");
    private final SimpleStringProperty firstLanguage = new SimpleStringProperty("");

    public ESOLStudentModel() {
        this("", "",0,"","","");
    }

    public ESOLStudentModel(String firstName, String lastName, int age, String gradeLevel, String englishLevel, String firstLanguage) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setGradeLevel(gradeLevel);
        setEnglishLevel(englishLevel);
        setFirstLanguage(firstLanguage);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getGradeLevel() {
        return gradeLevel.get();
    }

    public SimpleStringProperty gradeLevelProperty() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel.set(gradeLevel);
    }

    public String getEnglishLevel() {
        return englishLevel.get();
    }

    public SimpleStringProperty englishLevelProperty() {
        return englishLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel.set(englishLevel);
    }

    public String getFirstLanguage() {
        return firstLanguage.get();
    }

    public SimpleStringProperty firstLanguageProperty() {
        return firstLanguage;
    }

    public void setFirstLanguage(String firstLanguage) {
        this.firstLanguage.set(firstLanguage);
    }


}