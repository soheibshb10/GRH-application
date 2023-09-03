package com.eng.GRH.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;
import java.util.logging.Logger;



@Aspect
@Component
public class AspectClass {
    Logger logger=Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.eng.GRH.controller.EmployeeController.deleteEmployee(..))")
    public void deleteEmployee(){}

    @Pointcut("execution(* com.eng.GRH.controller.EmployeeController.createEmployee(..))")
    public void addEmplyee(){}


    @Pointcut("execution(* com.eng.GRH.controller.EmployeeController.updateEmployee(..))")
    public void updateEmployee(){}





    @Before("deleteEmployee()")
    public void beforeDeleteEmployee(JoinPoint joinPoint){
        logger.info("@Before execution===>Employee will deleted");
        System.out.println("method==>"+joinPoint.getSignature());
    }

    @After("deleteEmployee()")
    public void afterDeleteEmployee(JoinPoint joinPoint){
        logger.info("@After execution==>Employee is deleted");
        System.out.println( "method==>"+joinPoint.getSignature());
    }



    @Before("addEmplyee()")
    public void beforAddEmployee(JoinPoint joinPoint){
        logger.info("@Before execution ===>Employee will added");
        System.out.println("method==>"+joinPoint.getSignature());
    }


    @After("addEmplyee()")
    public void afterAddEmployee(JoinPoint joinPoint){
        logger.info("@After execution===>Employee is added");
        System.out.println("method==>"+joinPoint.getSignature());

    }


    @After("updateEmployee()")
    public void afterUpdateEmployee(JoinPoint joinPoint){
        logger.info("@After execution===>Employee is updated");
        System.out.println("method==>"+joinPoint.getSignature());
    }






}
