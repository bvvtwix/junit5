package org.example;

public class MockService implements  SiteService{
    @Override
    public String say() {
        return "This is a mock";
    }
}
