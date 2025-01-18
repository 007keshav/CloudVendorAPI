package com.tc.restfulAPI.exception;

public class CloudVendorCreationException extends RuntimeException {

        public CloudVendorCreationException(String message) {
            super(message);
        }

        public CloudVendorCreationException(String message, Throwable cause) {
            super(message, cause);
        }


}
