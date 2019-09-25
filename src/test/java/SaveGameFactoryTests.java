import org.improving.tag.FileSystemAdapter;
import org.improving.tag.Game;
import org.improving.tag.SaveGameFactory;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.Dictionary;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SaveGameFactoryTests {

    @Test
    public void save_should_preserve_location_name(){
        //Arrange
        TestInputOutput io = new TestInputOutput();
        Game g = new Game(null, io);
        FileSystemAdapter fsa = mock(FileSystemAdapter.class);
        SaveGameFactory target = new SaveGameFactory(fsa);
        Class<Dictionary<String, String>> dictClass =
                (Class<Dictionary<String, String>>)(Class)Dictionary.class;
        ArgumentCaptor<Dictionary<String, String>> contentsCaptor =
                ArgumentCaptor.forClass(dictClass);
        when(fsa.saveToFile(any())).thenReturn("this is dumb");


        //Act
        String path = target.save(g);

        //Assert
        verify(fsa).saveToFile(contentsCaptor.capture());
        var loc = contentsCaptor.getValue().get("location");
        assertEquals("The Deathly Hallows", loc);
        assertNotNull(path);
        assertNotEquals("", path);
    }
}
