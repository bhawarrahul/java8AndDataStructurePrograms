package com.adobe.program.example;

import java.util.stream.IntStream;

/**
 * Auther - Rahul A. Bhawar
 */
public class SentenceReverse {
    public static void main(String[] args) {
        reverseSentenceWordByWord("My Name is Rahul Bhawar");
    }
    public static void reverseSentenceWordByWord(final String sentence){
        final  String[] strArray = sentence.split(" ");
        IntStream.range( 0, strArray.length ).forEach(index->{
            System.out.print(strArray[strArray.length - index - 1 ] + " ");
        });
    }
}
