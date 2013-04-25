package net.thucydides.showcase.jbehave;

import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.steps.ReaderSteps;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.io.IOException;

import static net.thucydides.core.steps.StepData.withTestDataFrom;

public class DefinitionSteps {

    @Steps
    ReaderSteps reader;

    @Steps
    DataDefinitionSteps dataDefinitionSteps;

    @Given("the user does not know the meaning of the word '$word'")
    @Alias("the user does not know the meaning of the word '<word>'")
    public void givenTheUserDoesNotKnowAWord () {
        reader.consults_the_online_dictionary();
    }

    @When("the user looks up the definition of the word '$word'")
    @Alias("the user looks up the definition of the word '<word>'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        reader.looks_up_the_definition_of(word);
    }

    @Then("they should obtain a definition containing the words '$definition'")
    @Alias("they should obtain a definition containing the words '<definition>'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        reader.should_see_a_definition_containing(definition);
    }


    @Given("the user wants to know the meaning of some words")
    public void userWantsToLookUpSomeWords() {

    }

    @Then("he should be able to look them up")
    public void theUserLooksThemUp() throws IOException {
        withTestDataFrom("data/definitions.csv").run(dataDefinitionSteps).the_definition_should_be_correct();
    }
//
//    @AfterScenario
//    public void done() {
//        System.out.println("after scenario");
//    }
}


