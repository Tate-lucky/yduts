package com.tatelucky.yduts.design.factorymethod;

/**
 * @author tangsheng
 * @since 2019-11-28
 */
public class JpgReader implements Reader {
    @Override
    public void readPic() {
        System.out.println("read jpg pic");
    }
}
