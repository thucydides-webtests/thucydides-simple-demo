package com.wakaleo.webtests.google

import com.wakaleo.webtests.google.requirements.Application.Backend.ProcessSubscriptions
import com.wakaleo.webtests.google.steps.BackendSteps

using "thucydides"

thucydides.uses_steps_from BackendSteps
thucydides.tests_story ProcessSubscriptions

scenario "Processing a substription transation", {
    when "the backend processes a subscription"
    then "the mainframe should be updated"
}

scenario "Cancelling a substription", {
    when "the backend cancels a subscription"
    then "the mainframe should be updated"
}

scenario "Renewing a substription", {
    when "the backend renewing a subscription"
    then "the mainframe should be updated"
}
