package cn.shi.leasplat.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = { ElementType.PARAMETER , ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * 	��¼ϵͳ��־
 * @author shiqiang
 *
 */
public @interface Auditable {

     /** ģ������ **/  
     public String moduleName() default "";  
      
     /** �������� **/  
     public String operationName() default "";
}
