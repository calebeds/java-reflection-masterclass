package dynamicproxing.measuringdynamicproxing.external.impl;

import dynamicproxing.measuringdynamicproxing.external.HttpClient;

public class HttpClientImpl implements HttpClient {
    @Override
    public void initialize() {
        System.out.println("Initialing HTTP client");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String sendRequest(String request) {
        System.out.printf("Sending request %s %n", request);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Received response");
        return "someResponse Data";
    }
}
