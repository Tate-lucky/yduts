package com.tatelucky.yduts.design.prototype;

import lombok.Builder;
import lombok.Data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author tangsheng
 * @since 2019-11-28
 */
@Data
@Builder
public class CloneDemo implements Serializable, Cloneable {
    private String name;

    private Attach attach;

    @Override
    protected CloneDemo clone() throws CloneNotSupportedException {
        return new CloneDemo(this.name, attach);
    }

    public CloneDemo deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (CloneDemo) ois.readObject();
    }

    public static void main(String[] args) {

        try {

            CloneDemo cloneDemo = new CloneDemo("testName", new Attach("attach"));

            //浅拷贝
            CloneDemo cloneDemo1 = cloneDemo.clone();
            System.out.println(cloneDemo1.toString());

            //值引用
            cloneDemo.setName("test2");
            //对象引用
            cloneDemo.getAttach().setName("change attach");
            //结果如下：值引用是没有被修改的，但是对象引用由于是指向了同一个内存地址，被修改了
            //CloneDemo(name=testName, attach=Attach(name=attach))
            //CloneDemo(name=testName, attach=Attach(name=change attach))
            System.out.println(cloneDemo1.toString());


            //深拷贝,记得一定要序列化对象
            CloneDemo cloneDemo2 = new CloneDemo("cloneDemo2", new Attach("attach"));
            CloneDemo cloneDemo3 = cloneDemo2.deepClone();
            System.out.println(cloneDemo3.toString());

            cloneDemo2.setName("cloneDemo2 change");
            cloneDemo2.getAttach().setName("change attach");
            System.out.println(cloneDemo3.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
