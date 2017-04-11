package test.optus.service;

public interface StringHandlingService {

    public static final String midTruncate = " ... (truncated) ... ";
    String truncateString(String str, int length);
}
