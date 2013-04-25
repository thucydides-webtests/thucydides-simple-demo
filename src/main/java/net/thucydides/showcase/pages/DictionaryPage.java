package net.thucydides.showcase.pages;

import com.google.common.collect.Lists;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary:Main_Page")
public class DictionaryPage extends PageObject {

    @FindBy(name="search")
    private WebElementFacade searchTerms;

    @FindBy(name="go")
    private WebElementFacade lookupButton;

    @FindBy(id="WOTD-rss-title")
    private WebElementFacade wordOfTheDay;

    @FindBy(css=".mp-index a")
    private List<WebElement> indexEntries;

    @FindBy(id="WOTD-rss-title")
    private WebElement wordOfTheDay2;

    public DictionaryPage(WebDriver driver) {
        super(driver);
    }

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public Iterable<String> getDefinitions() {
        List<WebElementFacade> definitions = findAll(By.cssSelector("ol li"));
        List<String> terms = Lists.newArrayList();
        for(WebElementFacade definition : definitions) {
            terms.add(definition.getText());
        }
        return terms;
    }

    public String getWordOfTheDay() {
        assertThat(wordOfTheDay2).isNotNull();
        return wordOfTheDay.getText();
    }

    public void refreshWordOfTheDay() {
        find(By.id("mf-wotd")).then().findBy(By.linkText("refresh")).click();
    }

    public List<String> getIndexEntries() {
        assertThat(indexEntries).isNotNull();
        List<String> results = Lists.newArrayList();
//        for(WebElement indexEntry : indexEntries) {
//            results.add(indexEntry.getText());
//        }
        return results;
    }
}


