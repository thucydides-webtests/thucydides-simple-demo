package net.thucydides.showcase.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.showcase.pages.DictionaryPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class ReaderSteps extends ScenarioSteps {

    DictionaryPage dictionaryPage;

    public ReaderSteps(Pages pages) {
        super(pages);
        dictionaryPage = getPages().get(DictionaryPage.class);
    }

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_a_definition_containing(String terms) {
        Iterable<String> displayedDefinitions = dictionaryPage.getDefinitions();
        assertThat(displayedDefinitions, hasItem(containsString(terms)));
    }

    @Step
    public void consults_the_online_dictionary() {
        dictionaryPage.open();
    }

    @Step
    public void looks_up_the_definition_of(String term) {
        enters(term);
        starts_search();
    }
}
