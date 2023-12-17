package com.csie.examapp.state;

public class TestEndedState implements TestState {
    @Override
    public String start(TestContext context) {
        return("Cannot start the test. The test has already ended.");
    }

    @Override
    public String submitAnswer(TestContext context) {
        return("Cannot submit answers. The test has ended.");
    }

    @Override
    public String end(TestContext context) {
        return("Test has already ended.");
    }
}