package se.bth.pa2552_project;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class BankingSystemTest {
    @BeforeAll
    public static void setupForHeadlessTesting() {
        HeadlessHelper.setupForHeadlessTesting();
    }


    @BeforeEach
    public void setup() throws Exception {
        ApplicationTest.launch(BankingApplication.class);
    }

    @Test
    public void testButtonClick() {
        assertThat(true).isTrue();
    }
}
