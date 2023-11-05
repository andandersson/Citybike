package citybike.backend.exception;

import citybike.backend.exceptions.InvalidStationNameException;
import org.junit.Test;

/**
 * Testclass for the class InvalidStationNameException.
 */
public class InvalidStationNameExceptionTest {

    /**
     * Testing that the text of invalid station name is created if the url is invalid
     */
    @Test
    public void testExceptionMessage() {
        String errorMessage = "Invalid station name";
        InvalidStationNameException exception = new InvalidStationNameException(errorMessage);
        assert exception.getMessage().equals(errorMessage);
    }

    /**
     * Testing that an exception is thrown if incorrect url.
     */
    @Test(expected = InvalidStationNameException.class)
    public void testThrowingException() {
        String errorMessage = "Invalid station name";
        throw new InvalidStationNameException(errorMessage);
    }
}
