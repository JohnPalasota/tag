package org.improving.tag.database;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ListOfStringConverter implements AttributeConverter<ListOfStrings, String> {
    @Override
    public String convertToDatabaseColumn(ListOfStrings listOfStrings) {
        String built = null;
        if(listOfStrings != null) {
            for (int i = 0; i < listOfStrings.size() - 1; i++) {
                built += listOfStrings.get(i) + ", ";
            }
            built.replace(", $", ""); //Finds the last use of ", " and replaces it with nothing.
        }
        return built;
    }

    @Override
    public ListOfStrings convertToEntityAttribute(String s) {

        ListOfStrings name = new ListOfStrings();
        if (s != null) {
            String[] newArray = s.split(", ");
            for (var member : newArray) {
                name.add(member);
            }
            return name;
        }
        return name;
    }
}
