package osg.id.movieproject.model;

import android.arch.persistence.room.TypeConverter;

import java.util.ArrayList;
import java.util.List;

public class GenreConverter {

    @TypeConverter
    public List<Integer> getListFromString(String genreIds) {
        List<Integer> list = new ArrayList<>();
        for (String s : genreIds.split(",")) {
            if (!s.isEmpty()) {
                list.add(Integer.parseInt(s));
            }
        }
        return list;
    }

    @TypeConverter
    public String setStringFromList(List<Integer> list) {
        StringBuilder genreIds = new StringBuilder();
        for (int i : list) {
            genreIds.append(",").append(i);
        }
        return genreIds.toString();
    }
}
