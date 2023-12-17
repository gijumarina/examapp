package com.csie.examapp.state;

public class TestInProgressState implements TestState {
    @Override
    public String start(TestContext context) {
        return("Test is already in progress.");
    }

    @Override
    public String submitAnswer(TestContext context) {
        return("Submitting answer during the test.");
    }

    @Override
    public String end(TestContext context) {
        context.setState(new TestEndedState());
        return("Test ended");
    }
}
