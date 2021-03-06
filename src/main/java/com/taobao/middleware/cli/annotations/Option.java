/*
 *  Copyright (c) 2011-2013 The original author or authors
 *  ------------------------------------------------------
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *       The Eclipse Public License is available at
 *       http://www.eclipse.org/legal/epl-v10.html
 *
 *       The Apache License v2.0 is available at
 *       http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */
package com.taobao.middleware.cli.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotates a setter to be called with the value of a command line option. Setter have been preferred to field to
 * allow validation.
 * <p/>
 * The cardinality of the option is detected from the single method parameter type: arrays, list and set can receive
 * several values.
 *
 * @author Clement Escoffier <clement@apache.org>
 * @see Argument
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Option {

    String NO_NAME = "\0";

    /**
     * The name of the option (without the {@code --} prefix).
     * Defaults to a name based on the setter name
     */
    String longName() default NO_NAME;

    /**
     * The short option name (without the {@code -} prefix).
     * If not given the option has no short name.
     */
    String shortName() default NO_NAME;

    /**
     * The name of this argument (used in doc)
     */
    String argName() default "value";

    /**
     * Whether or not the option is required.
     */
    boolean required() default false;

    /**
     * Whether or not the option accept a value.
     * If the setter accepts an array, a list, a set, or a collection as parameter, it automatically detect it accepts
     * multiple values.
     */
    boolean acceptValue() default true;

    /**
     * Whether or not the option accept multiple values. If the setter accepts an array, a list, a set, or a collection
     * as parameter, it automatically detect it accepts multiple values.
     */
    boolean acceptMultipleValues() default false;

    /**
     * Whether or not the option can be used as a flag (meaning no value)
     */
    boolean flag() default false;

    /**
     * Whether or not this option is a "Help" option. Help options are generally flag.
     */
    boolean help() default false;

    /**
     * The set of choices accepted as values by this option. No need to call this methods for enums.
     */
    String[] choices() default {};
}
