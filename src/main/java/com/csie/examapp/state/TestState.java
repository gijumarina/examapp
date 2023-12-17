package com.csie.examapp.state;

public interface TestState {
    String start(TestContext context);

    String submitAnswer(TestContext context);

    String end(TestContext context);
}
