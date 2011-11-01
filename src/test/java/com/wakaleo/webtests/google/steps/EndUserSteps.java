package com.wakaleo.webtests.google.steps;

import com.wakaleo.webtests.google.pages.SearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

public class EndUserSteps extends ScenarioSteps {

	public EndUserSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void enters(String keyword) {
        onSearchPage().enter_keywords(keyword);
	}

    @Step
    public void starts_search() {
        onSearchPage().starts_search();
    }

    private SearchPage onSearchPage() {
        return getPages().currentPageAt(SearchPage.class);
    }

    private SearchPage searchPage() {
        return getPages().currentPageAt(SearchPage.class);
    }

    @Step
	public void should_see_article_with_title_containing(String title) {
        assertThat(searchPage().getResultTitles(), hasItem(containsString(title)));
	}

    @Step
    public void is_the_google_home_page() {
        onSearchPage().open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

    @Step
    public void searches_using_several_terms(String... terms) {
        enters_terms(terms);
        starts_search();
        should_see_all_terms(terms);
    }

    @Step
    public void enters_terms(String... terms) {
        String termList = join(terms, " ");
        onSearchPage().enter_keywords(termList);
    }

    @Step
    public void should_see_all_terms(String... terms) {
        onSearchPage().shouldContainAllText(terms);
    }

    public void should_see_article_with_title_starting_with(String text) {
        assertThat(onSearchPage().getTitle(), startsWith(text));
    }
}
