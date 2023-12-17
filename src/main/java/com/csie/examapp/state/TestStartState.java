package com.csie.examapp.state;

public class TestStartState implements TestState {
    @Override
    public String start(TestContext context) {
        context.setState(new TestInProgressState());
        return("Starting the test.");
    }

    @Override
    public String submitAnswer(TestContext context) {
        return("Cannot submit answers. The test has not started yet.");
    }

    @Override
    public String end(TestContext context) {
        return("Cannot end the test. The test has not started yet.");
    }
}
