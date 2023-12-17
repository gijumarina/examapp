package com.csie.examapp.state;

import com.csie.examapp.utils.Constants;

public class TestInProgressState implements TestState {
    @Override
    public String start(TestContext context) {
        return(Constants.START_TEST_IN_PROGRESS);
    }

    @Override
    public String submitAnswer(TestContext context) {
        return(Constants.SUBMIT_TEST_STARTED);
    }

    @Override
    public String end(TestContext context) {
        context.setState(new TestEndedState());
        return(Constants.END_TEST);
    }
}
