package com.tatelucky.yduts.util.aggregation;

import com.tatelucky.yduts.util.MapUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author tangsheng
 * @since 2019-04-30
 */
public class PropHelper {
    /**
     * 考虑很多bean里面其实他们有着共同的属性名
     */
    private Map<Object, List<Integer>> posMap = new HashMap<Object, List<Integer>>();

    /**
     * 有此编码值的记住行位置,设想一个列表有很多行，针对某个属性列，有此编码值的会有若干行，此次增记住一行
     *
     * @param code
     * @param rowPos
     */
    public void addCodeRowPos(Object code, int rowPos) {
        MapUtil.putValueItem(posMap, code, rowPos);
    }

    /**
     * 获取该属性值有哪些行与之对应
     *
     * @param code
     * @return
     */
    public List<Integer> getCodeRowPoss(Object code) {
        return posMap.get(code);
    }

    /**
     * 获取有哪些属性值
     *
     * @return
     */
    public Iterator<Object> codeIter() {
        return posMap.keySet().iterator();
    }

}
