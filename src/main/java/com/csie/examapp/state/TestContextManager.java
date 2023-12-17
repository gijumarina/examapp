package com.csie.examapp.state;

import org.springframework.stereotype.Component;

import com.csie.examapp.state.TestContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TestContextManager {

    private final Map<Integer, TestContext> testContexts;

    public TestContextManager() {
        this.testContexts = new ConcurrentHashMap<>();
    }

    public TestContext createTestContext(int testId) {
        TestContext testContext = new TestContext();
        testContexts.put(testId, testContext);
        return testContext;
    }

    public TestContext getTestContext(int testId) {
        return testContexts.get(testId);
    }

    public void removeTestContext(int testId) {
        testContexts.remove(testId);
    }
}
