package com.tatelucky.yduts.design.factorymethod;

/**
 * @author tangsheng
 * @since 2019-11-28
 */
public class Test {
    public static void main(String[] args) {
        ReaderFactory readerFactory = new GifReaderFactory();
        Reader reader = readerFactory.createReader();
        reader.readPic();
        ;

        ReaderFactory readerFactory2 = new JpgReaderFactory();
        reader = readerFactory2.createReader();
        reader.readPic();
    }
}
