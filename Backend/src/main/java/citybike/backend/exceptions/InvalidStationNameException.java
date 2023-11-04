package citybike.backend.exceptions;

/**
 * This class is throwing an exception in case someone is typing an incorrect url.
 */
public class InvalidStationNameException extends RuntimeException {
    public InvalidStationNameException(String message) {
        super(message);
    }
}


