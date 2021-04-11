package tests;

import static io.qameta.allure.Allure.step;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyStudentRegistrationFormTest extends TestBase {

  MyStudentRegistrationFormPage studentRegistrationFormPage = new MyStudentRegistrationFormPage();

  @Test
  @Owner("anovikova")
  @DisplayName("Тест без ошибки")
  void successfulFillTest() {
    MyUserDefaultData testDate = new MyUserDefaultData();
    step("Open students registration form", () -> {
      studentRegistrationFormPage.openPage();
    });
    step("Fill students registration form", () -> {
      studentRegistrationFormPage.setFirstName(testDate.getFirstName());
      studentRegistrationFormPage.setLastName(testDate.getLastName());
      studentRegistrationFormPage.setUserEmail(testDate.getUserEmail());
      studentRegistrationFormPage.setUserNumber(testDate.getUserNumber());
      studentRegistrationFormPage.setGenter(testDate.getGender());
    });
    step("Set subjects", () -> {
      studentRegistrationFormPage.setSubject(testDate.getSubject());
    });
    step("Set date", () -> {
      studentRegistrationFormPage.setBirthDate(testDate.getYearOfBirth(),
                                               testDate.getMonthOfBirth(),
                                               testDate.getDateOfBirth());
    });
    step("Set hobbies", () -> {
      studentRegistrationFormPage.setHobby(testDate.getHobby());
    });
    step("Set address", () -> {
      studentRegistrationFormPage.setCurrentAddress(testDate.getCurrentAddress());
      studentRegistrationFormPage.setState(testDate.getState());
      studentRegistrationFormPage.setCity(testDate.getCity());
    });
    step("Upload image", () -> {
      studentRegistrationFormPage.setFile(testDate.getFile());
    });

    step("Submit form", () -> {
      studentRegistrationFormPage.submitForm();
    });
    step("Verify successful form submit", () -> {
      studentRegistrationFormPage.checkData(testDate.getEnteredDate());
    });
  }

  @Test
  @Owner("anovikova")
  @DisplayName("Тест с ошибкой")
  void unsuccessfulFillTest() {
    MyUserDefaultData testDate = new MyUserDefaultData();
    step("Open students registration form", () -> {
      studentRegistrationFormPage.openPage();
    });
    step("Fill students registration form", () -> {
      studentRegistrationFormPage.setFirstName(testDate.getFirstName());
      studentRegistrationFormPage.setLastName(testDate.getLastName());
      studentRegistrationFormPage.setUserEmail(testDate.getUserEmail());
      studentRegistrationFormPage.setUserNumber(testDate.getUserNumber());
      studentRegistrationFormPage.setGenter(testDate.getGender());
    });
    step("Set subjects", () -> {
      studentRegistrationFormPage.setSubject(testDate.getSubject());
    });
    step("Set date", () -> {
      studentRegistrationFormPage.setBirthDate(testDate.getYearOfBirth(),
                                               testDate.getMonthOfBirth(),
                                               testDate.getDateOfBirth());
    });
    step("Set hobbies", () -> {
      studentRegistrationFormPage.setHobby(testDate.getHobby());
    });
    step("Set address", () -> {
      studentRegistrationFormPage.setCurrentAddress(testDate.getCurrentAddress());
      studentRegistrationFormPage.setState(testDate.getState());
      studentRegistrationFormPage.setCity(testDate.getCity());
    });
    step("Upload image", () -> {
      studentRegistrationFormPage.setFile(testDate.getFile());
    });

    step("Submit form", () -> {
      studentRegistrationFormPage.submitForm();
    });
    step("Verify successful form submit", () -> {
      studentRegistrationFormPage.checkData(testDate.getBadEnteredDate());
    });
  }
}
