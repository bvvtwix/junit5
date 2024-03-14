package tests;

import extentions.SiteServiceInjector;
import tryExtention.SiteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.inject.Inject;

@ExtendWith(SiteServiceInjector.class)
public class SiteServiceTest extends BaseTest{

    @Inject
    SiteService service;

    @Test
    void sayTest() {
        Assertions.assertEquals("Welcome to heisenbugs", service.say());
    }

    @Disabled
    @Test
    void sayMockTest() {
        Assertions.assertEquals("This is a mock", service.say());
    }
}
