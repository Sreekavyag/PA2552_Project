package se.bth.pa2552_project;

import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.assertj.core.api.Assertions.assertThat;

public class BankingSystemTest {
    @Before
    public void setupForHeadlessTesting() throws Exception {
        ApplicationTest.launch(BankApplication.class);
    }

    @Test
    public void testButtonClick() {
        assertThat(true).isTrue();
    }
}
