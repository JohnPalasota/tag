import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.Player;
import org.improving.tag.commands.Command;
import org.improving.tag.commands.MoveCommand;
import org.improving.tag.commands.SetNameCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class SetNameCommandTests {
    SetNameCommand target;
    TestInputOutput io;
    Game game = mock(Game.class);

    @BeforeEach //Before you run each test, run this upcoming method.
    public void arrange() {
        // Arrange
        io = new TestInputOutput();
        target = new SetNameCommand(io);
    }

    @Test
    public void execute_should_display_all_words_but_Setname_John() {
        Player player = new Player();
        player.setName("hi");
        player.setHitPoints(50);
        player = spy(player);
        when(game.getPlayer()).thenReturn(new Player());
        //Act
        target.execute("@set name=John", game);

        //Assert
        verify(player).setName(anyString());
        verify(game, times(2)).getPlayer();
        assertEquals("Your name is now John.", io.lastText);
        //
    }

    @Test
    public void execute_should_display_all_words_but_move_with_spaces() {
        //Act
        target.execute("     @set name=John    ", game);

        //Assert

        assertEquals("Your name is now John.", io.lastText);
        //
    }
    @Test
    public void isValid_should_be_true_when_input_is_move(){
        //Act
        var result = target.isValid( "@set name=John", game);

        //Assert
        assertTrue(result);

    }


    @Test
    public void isValid_should_be_true_when_input_is_move_with_spaces(){
        //Act
        var result = target.isValid( "    @set name=John ", game);

        //Assert
        assertTrue(result);

    }

    @Test
    public void isValid_should_be_true_when_input_is_move_with_caps(){
        //Act
        var result = target.isValid( "@SeT NaMe=John", game);

        //Assert
        assertTrue(result);

    }
    @Test
    public void isValid_should_be_false_when_input_is_foobar(){
        //Act
        var result = target.isValid( "foobar", game);

        //Assert
        assertFalse(result);
    }
    @Test
    public void isValid_should_be_false_when_input_is_null(){
        //Act
        var result = target.isValid( null, game);

        //Assert
        assertFalse(result);
    }
    @Test
    public void isValid_should_be_false_when_input_is_only_one_word() {
        //Act
        var result = target.isValid("@set name=", game);

        //Assert
        assertFalse(result);
    }

}


