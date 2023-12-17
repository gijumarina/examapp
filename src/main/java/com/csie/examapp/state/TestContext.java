package com.csie.examapp.state;

public class TestContext {
    private TestState state;

    public TestContext() {
        this.state = new TestStartState();
    }

    public void setState(TestState state) {
        this.state = state;
    }

    public String startTest() {
        return state.start(this);
    }

    public String submitAnswer() {
        return state.submitAnswer(this);
    }

    public String endTest() {
        return state.end(this);
    }
}
