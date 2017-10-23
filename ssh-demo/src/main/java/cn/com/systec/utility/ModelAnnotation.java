package cn.com.systec.utility;

import java.lang.annotation.*;

/**
 * Created by wwf on 17-1-26.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ModelAnnotation {
    String description() default "";
}
