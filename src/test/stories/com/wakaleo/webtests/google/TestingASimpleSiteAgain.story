package com.wakaleo.webtests.google

import com.wakaleo.webtests.google.steps.EndUserSteps
import com.wakaleo.webtests.google.requirements.Application.Search.SearchByKeyword
import com.wakaleo.webtests.google.requirements.Application.Search.SearchByPlaceRelatedKeyword
import com.wakaleo.webtests.google.requirements.Application.Search.SearchByFoodRelatedKeyword

using "thucydides"

thucydides.uses_default_base_url "http://www.google.co.nz"
thucydides.uses_steps_from EndUserSteps
thucydides.tests_story SearchByFoodRelatedKeyword

scenario "Searching for fruit", {
    given "the user is on the home page", {
        end_user.is_the_google_home_page()
    }
    when "the end user searches for 'bananas'", {
        end_user.looks_for "bananas"
    }
    then "they should see the corresponding article", {
       end_user.should_see_article_with_title_containing "Banana - Wikipedia, the free encyclopedia"
    }
}
