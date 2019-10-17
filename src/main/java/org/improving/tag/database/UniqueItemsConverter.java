package org.improving.tag.database;

import org.improving.tag.items.UniqueItems;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.stream.Stream;

@Converter(autoApply =  true)
public class UniqueItemsConverter implements AttributeConverter<UniqueItems, String> {
    @Override
    public String convertToDatabaseColumn(UniqueItems uniqueItems) {
        if (uniqueItems != null) {
            return uniqueItems.getName();
        }
        else return "";
    }

    @Override
    public UniqueItems convertToEntityAttribute(String s) {
        if(s != null) {
            return Stream.of(UniqueItems.values()).filter(a -> a.getName().equalsIgnoreCase(s)).findFirst().orElse(UniqueItems.NOTHING);
        }
        else return UniqueItems.NOTHING;
    }
}
