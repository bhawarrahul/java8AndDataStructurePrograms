package com.adobe.program.youtubevideo;

import com.github.axet.vget.VGet;

import java.io.File;
import java.net.URL;

public class JavaYoutubeDownloader {
    public static void main(String[] args) {
        try {
            // ex: http://www.youtube.com/watch?v=Nj6PFaDmp6c
//            String url = "https://www.youtube.com/watch?v=vZQMoY_2_AA&list=PLO0KWyajXMh4u-DhB7bXoRQ21rfkF_cSU&index=12";
            String url = "https://www.youtube.com/watch?v=eGBXkzijCzQ";
            // ex: "/Users/axet/Downloads"
            String path = "C:\\Users\\rahul.bhawar\\Downloads";
            VGet v = new VGet(new URL(url), new File(path));
            v.download();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
