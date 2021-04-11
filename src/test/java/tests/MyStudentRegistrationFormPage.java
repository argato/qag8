package tests;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.ElementsCollection;
import java.io.File;
import java.util.Map;

public class MyStudentRegistrationFormPage {

  public void openPage() {
    open("https://demoqa.com/automation-practice-form");
  }

  public void setFirstName(String firstName) {
    $("#firstName").setValue(firstName);
  }

  public void setLastName(String lastName) {
    $("#lastName").setValue(lastName);
  }

  public void setUserEmail(String userEmail) {
    $("#userEmail").setValue(userEmail);
  }

  public void setGenter(String genter) {
    $("#genterWrapper [for=gender-radio-3]").shouldHave(
        text(genter)).click();
  }

  public void setUserNumber(String userNumber) {
    $("#userNumber").setValue(userNumber);
  }

  public void setSubject(String subject) {
    $("#subjectsInput").val(subject);
    $(".subjects-auto-complete__menu-list").$(byText(subject)).click();
  }

  public void setBirthDate(String year, String month, String day) {
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").$(byText(month)).click();
    $(".react-datepicker__year-select").$(byText(year)).click();
    $(".react-datepicker__month").$(byText(day)).click();
  }

  public void setHobby(String hobby) {
    $("#hobbiesWrapper [for=hobbies-checkbox-3]").shouldHave(
        text(hobby)).click();
  }

  public void setFile(File file) {
    $("#uploadPicture").uploadFile(file);
  }

  public void setCurrentAddress(String currentAddress) {
    $("#currentAddress").setValue(currentAddress);
  }

  public void setState(String state) {
    $("#stateCity-wrapper #state").click();
    $("#stateCity-wrapper #state .css-26l3qy-menu").$(byText(state)).click();
  }

  public void setCity(String city) {
    $("#stateCity-wrapper #city").click();
    $("#stateCity-wrapper #city .css-26l3qy-menu").$(byText(city)).click();
  }

  public void submitForm() {
    $("#submit").click();
  }

  public void checkData(Map<String, String> enteredData) {
    ElementsCollection rows = $$(".modal-content tbody tr");
    rows.forEach(row -> {
      ElementsCollection tds = row.$$("td");
      tds.get(1).shouldHave(exactText(enteredData.get(tds.get(0).text())));
    });
  }

}
