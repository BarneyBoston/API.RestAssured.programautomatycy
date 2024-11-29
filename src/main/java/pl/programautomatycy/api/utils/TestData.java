package pl.programautomatycy.api.utils;

public class TestData {

    public static Integer getExpectedResponseCode(String scenario) {
        switch (scenario) {
            case "correctRequest":
                return 200;
            case "incorrectRequest":
                return 401;
            default:
                throw new IllegalArgumentException("Unknown scenario: " + scenario);
        }
    }
}
