/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chimera.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.function.Supplier;

/**
 *
 * @author cas
 */
public final class Iif {
    private Iif() {
    }

    public static <T> T hasText(CharSequence c, Supplier<T> whenTrue, Supplier<T> whenFalse) {
        return isTrue(StringUtils.isNotBlank(c), whenTrue, whenFalse);
    }

    public static <T> T nonEmpty(Collection c, Supplier<T> whenTrue, Supplier<T> whenFalse) {
        return isTrue(null != c && !c.isEmpty(), whenTrue, whenFalse);
    }

    public static <T> T nonNull(Object o, Supplier<T> whenTrue, Supplier<T> whenFalse) {
        return isTrue(null != o, whenTrue, whenFalse);
    }

    public static <T> T isTrue(boolean condition, Supplier<T> whenTrue, Supplier<T> whenFalse) {
        return condition ? whenTrue.get() : whenFalse.get();
    }
}
