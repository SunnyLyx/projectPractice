package edu.fosu.common.oss;

import java.util.Collection;
import java.util.Map;

/**
 * <p>判断是否是空的 工具类</p>
 */
public class EmptyUtils {

    /**
     * 判断对象是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isEmpty(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }

    /**
     * 判断对象是否不为空
     *
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }


    /**
     * 判断对象是否全都为空,全部为空返回true,不全为空返回false
     *
     * @param args
     * @return
     */
    public static boolean validPropertyEmpty(Object... args) {
        for (int i = 0; i < args.length; i++) {
            if (!EmptyUtils.isEmpty(args[i])) {
                return false;
            }
        }
        return true;
    }
}
