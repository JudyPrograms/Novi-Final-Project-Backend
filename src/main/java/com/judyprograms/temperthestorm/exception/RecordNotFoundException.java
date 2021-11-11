package com.judyprograms.temperthestorm.exception;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException() {
        super("Record not found.");
    }
    public RecordNotFoundException(String message) {
        super(message);
    }
}

//    #### VOORBEELD UIT DE LES:
//public class RecordNotFoundException extends RuntimeException {
//    public class RecordNotFoundException extends RuntimeException {
//    public static final long serialVersionUID = 1L;
//}
//    #### EINDE

