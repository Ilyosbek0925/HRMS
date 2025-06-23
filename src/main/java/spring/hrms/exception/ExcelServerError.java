package spring.hrms.exception;

import java.io.IOException;

public class ExcelServerError extends IOException {
    public ExcelServerError(String message) {
        super(message);
    }
}
