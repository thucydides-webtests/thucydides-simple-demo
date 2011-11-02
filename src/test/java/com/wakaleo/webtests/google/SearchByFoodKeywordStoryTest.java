package com.wakaleo.webtests.google;

import com.wakaleo.webtests.google.requirements.Application;
import com.wakaleo.webtests.google.steps.EndUserSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
@Story(Application.Search.SearchByKeyword.class)
public class SearchByFoodKeywordStoryTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://www.google.co.nz")
    public Pages pages;

    @Steps
    public EndUserSteps endUser;

    @Test
    public void searching_by_keyword_apples_should_display_the_corresponding_article() {
        endUser.is_the_google_home_page();
		endUser.enters("pears");
        endUser.starts_search();
		endUser.should_see_article_with_title_containing("Pear");
    }

    @Test
    public void searching_by_keyword_pineapples_should_display_the_corresponding_article() {
        endUser.is_the_google_home_page();
		endUser.enters("pineapples");
        endUser.starts_search();
        endUser.should_see_article_with_title_containing("Pineapple");
    }

    @Pending @Test
    public void searching_by_a_chinese_word_should_contain_chinese_web_sites() {
    }
} 