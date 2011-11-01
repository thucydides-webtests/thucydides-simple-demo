package com.wakaleo.webtests.google

import com.wakaleo.webtests.google.requirements.Application.Backend.ProcessSales
import com.wakaleo.webtests.google.steps.BackendSteps

using "thucydides"

thucydides.uses_steps_from BackendSteps
thucydides.tests_story ProcessSales

thucydides.tests_issue "#WIKI-1"

scenario "Processing a sales transation", {
    when "the backend processes a sale", {
        backend.accepts_a_sale_transaction()
    }
    then "the mainframe should be updated", {
       backend.should_the_update_mainframe()
    }
}
