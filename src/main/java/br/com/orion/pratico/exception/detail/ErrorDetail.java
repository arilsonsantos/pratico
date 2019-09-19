package br.com.orion.pratico.exception.detail;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetail {

    protected int statusCode;

    protected String message;

    @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    protected LocalDateTime timestamp;
    
    public static final class Builder {
        private static final ErrorDetail errorDetail = new ErrorDetail();

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder statusCode(int code) {
            errorDetail.setStatusCode(code);
            return this;
        }

        public Builder message(String message) {
            errorDetail.setMessage(message);
            return this;
        }

        public Builder timestamp(LocalDateTime localDateTime) {
            errorDetail.setTimestamp(localDateTime);
            return this;
        }

        public ErrorDetail build() {
            return errorDetail;
        }


    }
}