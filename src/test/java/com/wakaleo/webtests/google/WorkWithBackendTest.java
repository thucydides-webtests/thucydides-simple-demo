package com.wakaleo.webtests.google;

import com.wakaleo.webtests.google.requirements.Application;
import com.wakaleo.webtests.google.steps.BackendSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ThucydidesRunner.class)
@Story(Application.Backend.ProcessSales.class)
public class WorkWithBackendTest {

    @Steps
    public BackendSteps backend;

    @Issue("#WIKI-1")
    @Test
    public void when_processing_a_sale_transation() {
        backend.accepts_a_sale_transaction();
        backend.should_the_update_mainframe();
    }
}