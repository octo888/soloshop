package com.core.constants;

import java.util.ArrayList;
import java.util.List;

public class GenreConstants {

    public static final String KIDS = "Детская литература";
    public static final String CLASSIC = "Классика";

    public List<String> getGenresAsList() {
        List<String> list = new ArrayList<>();
        list.add(KIDS);
        list.add(CLASSIC);
        return list;
    }
}
