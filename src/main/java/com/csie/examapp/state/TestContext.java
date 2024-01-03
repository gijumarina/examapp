package com.csie.examapp.state;

import lombok.Getter;

public class TestContext {
    private TestState state;
    @Getter boolean testInProgress = false;

    public TestContext() {
        this.state = new TestStartState();
    }

    public void setState(TestState state) {
        this.state = state;
    }

    public String startTest() {
        this.testInProgress = true;
        return state.start(this);
    }

    public String submitAnswer() {
        return state.submitAnswer(this);
    }

    public String endTest() {
        this.testInProgress = false;
        return state.end(this);
    }
}
