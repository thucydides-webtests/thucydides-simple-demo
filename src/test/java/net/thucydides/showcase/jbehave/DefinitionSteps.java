package net.thucydides.showcase.jbehave;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import net.thucydides.showcase.steps.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("the user does not know the meaning of the word '<word>'")
    @Alias("the user does not know the meaning of the word '$word'")
    public void givenTheUserDoesNotKnowAWord () {
        endUser.is_the_home_page();
    }

    @When("the user looks up the definition of the word '<word>'")
    @Alias("the user looks up the definition of the word '$word'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        endUser.looks_for(word);
    }

    @Then("they should obtain a definition containing the words '<definition>'")
    @Alias("they should obtain a definition containing the words '$definition'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        endUser.should_see_definition_containing_words(definition);
    }

}
