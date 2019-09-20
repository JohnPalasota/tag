import org.improving.tag.InputOutput;
import org.improving.tag.commands.DanceCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DanceCommandTests {

    DanceCommand target;
    TestInputOutput io;

    @BeforeEach //Before you run each test, run this upcoming method.
    public void arrange(){
        // Arrange
        io = new TestInputOutput();
        target = new DanceCommand(io);
    }
    @Test public void execute_should_return_phrase(){
        //Act
        target.execute(null);

        //Assert
        assertEquals("You dance around in a circle.", io.lastText);
    }

    @Test
    public void isValid_should_be_true_when_input_is_dance(){
        //Act
        var result = target.isValid( "dance");

        //Assert
        assertTrue(result);

    }

    @Test
    public void isValid_should_be_false_when_input_is_foobar(){
        //Act
        var result = target.isValid( "foobar");

        //Assert
        assertFalse(result);
    }
    @Test
    public void isValid_should_be_false_when_input_is_null(){
        //Act
        var result = target.isValid( null);

        //Assert
        assertFalse(result);
    }
    @Test
    public void isValid_should_be_true_when_input_is_dance_with_spaces(){
        //Act
        var result = target.isValid( "    dance ");

        //Assert
        assertTrue(result);

    }

    @Test
    public void isValid_should_be_true_when_input_is_dance_with_caps(){
        //Act
        var result = target.isValid( "dANCe");

        //Assert
        assertTrue(result);

    }

}

