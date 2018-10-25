/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chimera.util;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 *
 * @author cas
 */
public final class Check {

    public static final String REQUIRE_TEXT = "require non blank text !";
    public static final String REQUIRE_NON_EMPTY = "require non empty collection !";
    public static final String REQUIRE_NON_NULL = "required non null argument !";
    public static final String REQUIRE_TRUE = "require true argument !";

    private Check() {
    }

    /**
     * @param text
     */
    public static void hasText(@Nullable CharSequence text) {
        hasText(text, REQUIRE_TEXT);
    }

    /**
     * @param text
     * @param errorMessage
     */
    public static void hasText(@Nullable CharSequence text, @Nonnull String errorMessage) {
        hasText(text, new IllegalArgumentException(errorMessage));
    }

    /**
     * @param text
     * @param runtimeException
     */
    public static void hasText(@Nullable CharSequence text, @Nonnull RuntimeException runtimeException) {
        isTrue(StringUtils.isNotBlank(text), runtimeException);
    }

    /**
     * @param collection
     */
    public static void nonEmpty(@Nullable Collection collection) {
        nonEmpty(collection, REQUIRE_NON_EMPTY);
    }

    /**
     * @param collection
     * @param errorMessage
     */
    public static void nonEmpty(@Nullable Collection collection, @Nonnull String errorMessage) {
        nonEmpty(collection, new IllegalArgumentException(errorMessage));
    }

    /**
     * @param collection
     * @param runtimeException
     */
    public static void nonEmpty(@Nullable Collection collection, @Nonnull RuntimeException runtimeException) {
        isTrue(null != collection && !collection.isEmpty(), runtimeException);
    }

    /**
     * @param o
     */
    public static void nonNull(@Nullable Object o) {
        nonNull(o, REQUIRE_NON_NULL);
    }

    /**
     * @param o
     * @param errorMessage
     */
    public static void nonNull(@Nullable Object o, @Nonnull String errorMessage) {
        nonNull(o, new NullPointerException(errorMessage));
    }

    /**
     * @param o
     * @param runtimeException
     */
    public static void nonNull(@Nullable Object o, @Nonnull RuntimeException runtimeException) {
        isTrue(null != o, runtimeException);
    }

    /**
     * @param condition
     */
    public static void isTrue(boolean condition) {
        isTrue(condition, REQUIRE_TRUE);
    }

    /**
     * @param condition
     * @param errorMessage
     */
    public static void isTrue(boolean condition, @Nonnull String errorMessage) {
        isTrue(condition, new IllegalArgumentException(errorMessage));
    }

    /**
     * @param condition
     * @param runtimeException
     */
    public static void isTrue(boolean condition, RuntimeException runtimeException) {
        if (!condition) {
            throw runtimeException;
        }
    }
}
