package net.thucydides.showcase.jbehave;

import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.steps.ReaderSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.Scenario;

import static org.fest.assertions.Assertions.assertThat;


public class WordOfTheDaySteps {

    @Steps
    ReaderSteps reader;

    @Given("the user is curious")
    public void theUserIsCurious() {}

    @When("the user is on the wiktionary home page")
    public void userIsOnTheHomePage() {
        reader.consults_the_online_dictionary();
    }

    @Then("they should see a word of the day definition")
    public void shouldSeeWordOfTheDay() {
        reader.should_see_word_of_the_day();
    }


}
