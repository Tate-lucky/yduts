package com.tatelucky.yduts.design.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 作为CloneDemo的引用类型
 *
 * @author tangsheng
 * @since 2019-11-28
 */
@Data
@AllArgsConstructor
public class Attach implements Serializable {
    private String name;
}
