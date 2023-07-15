package fr.mimifan.luneziaitems.utils;

import fr.mimifan.luneziaitems.Main;

import java.util.ArrayList;
import java.util.List;

public class CustomStrings {

    public static String replaceString(String path){
        return Main.getInstance().getConfig().getString(path)
                .replace("&","§");

    }

    public static List<String> replaceStringList(String path){
        List<String> l = new ArrayList<>();
        for(String line : Main.getInstance().getConfig().getStringList(path)){
            l.add(line.replace("&", "§"));
        }
        return l;
    }

}
