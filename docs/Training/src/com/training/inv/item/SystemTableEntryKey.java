package com.training.inv.item;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Validation constraint ensuring that value is present in the system table.
 * If applied on the class level, {@link #property()} must be specified.
 * <br/><br/>
 * If applied inside entity type class, default validation group shouldn't be used.
 * You can apply BPEValidationGroups.SystemTableVerification.
 *
 * @author damian.koniecki@syncron.com
 *
 */
@Target({METHOD, TYPE})
@Retention(RUNTIME)
public @interface SystemTableEntryKey {

}
