package com.csie.examapp.state;

import com.csie.examapp.utils.Constants;

public class TestEndedState implements TestState {
    @Override
    public String start(TestContext context) {
        return(Constants.START_TEST_END);
    }

    @Override
    public String submitAnswer(TestContext context) {
        return(Constants.SUBMIT_TEST_ENDED);
    }

    @Override
    public String end(TestContext context) {
        return(Constants.END_TEST_END);
    }
}