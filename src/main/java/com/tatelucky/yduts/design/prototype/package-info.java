/**
 * 原型模式
 * 最简单的解释就是克隆，通常作为cv开发工程师的我们，相当熟悉这个套路。
 * 万物皆对象，Object同样也提供了clone的方法（当然必须先 implements  Cloneable）
 * 但是这里也引申初另一个问题：深克隆和浅克隆
 * <p>
 * 浅克隆  值类型，复制一份给克隆对象  引用类型，将引用对象的地址复制一份给克隆对象
 * <p>
 * 深克隆 完全全新的，切记implements Serializable,Cloneable
 * <p>
 * 创建型模式
 *
 * @author tangsheng
 * @since 2019-11-28
 */
package com.tatelucky.yduts.design.prototype;
