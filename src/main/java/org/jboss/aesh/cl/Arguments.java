/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.aesh.cl;

import org.jboss.aesh.cl.completer.NullOptionCompleter;
import org.jboss.aesh.cl.completer.OptionCompleter;
import org.jboss.aesh.cl.converter.CLConverter;
import org.jboss.aesh.cl.converter.StringCLConverter;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The possible arguments of a command line command
 * Must be defined with a field that implements Collection
 *
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface Arguments {

    /**
     * A description of the param.
     * This text will be printed out as part of a usage info.
     */
     String description() default "";

    /**
     * Option type, default is String.class
     */
    Class<?> type() default String.class;

    /**
     * Specify the value separator between arguments.
     * Default is ' ' (space).
     */
    char valueSeparator() default ' ';

    /**
     * Define a converter if the field is a type thats not java.lang and other
     * common types, eg: File,++
     * See ClConverterManager for whats added by default
     */
    Class<? extends CLConverter> converter() default StringCLConverter.class;

    /**
     * Define a completer for this option.
     */
    Class<? extends OptionCompleter> completer() default NullOptionCompleter.class;
}
