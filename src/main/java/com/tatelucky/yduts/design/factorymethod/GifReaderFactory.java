package com.tatelucky.yduts.design.factorymethod;

/**
 * @author tangsheng
 * @since 2019-11-28
 */
public class GifReaderFactory implements ReaderFactory {
    @Override
    public Reader createReader() {
        return new GifReader();
    }
}
