package br.com.orion.pratico.exception.detail;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class ValidationErrorDetail extends ErrorDetail {

    @Getter
    @Setter
    private Map<String, String> errors = new HashMap<>();
    
    public static final class Builder {
        private static final ValidationErrorDetail validationErrorDetail = new ValidationErrorDetail();

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder statusCode(int statusCode) {
            validationErrorDetail.setStatusCode(statusCode);
            return this;
        }
        
        public Builder message(String message) {
            validationErrorDetail.setMessage(message);
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp){
            validationErrorDetail.setTimestamp(timestamp);
            return this;
        }

        public Builder errors(Map<String, String> errors) {
            validationErrorDetail.setErrors(errors);
            return this;
        }

        public ValidationErrorDetail build() {
            return validationErrorDetail;
        }
    }
}