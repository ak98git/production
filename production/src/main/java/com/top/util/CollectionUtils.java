package com.top.util;

import java.util.List;
import java.util.Map;

/**
 * @author super.vae
 * @description: 集合工具类
 * @date 2018/11/9
 */
public class CollectionUtils {

    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(List<?> list) {
        return !isEmpty(list);
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return!isEmpty(map);
    }

}
