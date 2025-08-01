package com.example.samplenew.exception;
import java.time.LocalDateTime;
public class ErrorResponse {

    private LocalDateTime timestamps;
    private String error;
    // private String message;
    private String path;

    public ErrorResponse(LocalDateTime timestamps,String error, String message, String path) {
        this.timestamps = timestamps;
        this.error = error;
        // this.message = message;
        this.path = path;
    }

}
