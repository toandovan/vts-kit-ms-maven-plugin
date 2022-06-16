package com.atviettelsolutions.plugin.help;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.yaml.snakeyaml.introspector.*;
import org.yaml.snakeyaml.representer.Representer;

public class CustomRepresenter extends Representer {

    public CustomRepresenter() {
        super();
        PropertyUtils propUtil = new PropertyUtils() {
            @Override
            protected Set<Property> createPropertySet(Class<? extends Object> type, BeanAccess bAccess) {
                return getPropertiesMap(type, bAccess).values().stream().sequential()
                        .filter(prop -> prop.isReadable() && (isAllowReadOnlyProperties() || prop.isWritable()))
                        .collect(Collectors.toCollection(LinkedHashSet::new));
            }
        };
        setPropertyUtils(propUtil);
    }
}