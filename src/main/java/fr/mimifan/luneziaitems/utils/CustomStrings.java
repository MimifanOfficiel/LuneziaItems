package fr.mimifan.luneziaitems.utils;

import fr.mimifan.luneziaitems.Main;

public class CustomStrings {

    public static String replaceString(String path){
        return Main.getInstance().getConfig().getString(path)
                .replace("&","§");

    }

}
