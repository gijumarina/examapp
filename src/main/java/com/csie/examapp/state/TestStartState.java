package com.csie.examapp.state;

import com.csie.examapp.utils.Constants;

public class TestStartState implements TestState {
    @Override
    public String start(TestContext context) {
        context.setState(new TestInProgressState());
        return(Constants.START_TEST);
    }

    @Override
    public String submitAnswer(TestContext context) {
        return(Constants.SUBMIT_TEST_NOT_STARTED);
    }

    @Override
    public String end(TestContext context) {
        return(Constants.END_TEST_NOT_STARTED);
    }
}
