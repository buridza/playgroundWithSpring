package by.itacademy.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Log {

    private Logger logger;

    @Pointcut("execution(* by.itacademy.interfaces..*(..))")
    void allInter() {
    }

    /*@Before("allInter()")
    public void addInLog() {
        PropertyConfigurator.configure("service/src/main/log4j.properties");
        logger = Logger.getLogger(Log.class);
        System.out.println(100);
        logger.fatal("smth wrong");
    }*/

    @Around("allInter()")
    public Object enableLogger(ProceedingJoinPoint joinPoint) throws Throwable {

        //logger.info("start: "+joinPoint.getStaticPart().getSignature().getName());
        Object proceed = joinPoint.proceed();
        //logger.info("end: "+joinPoint.getStaticPart().getSignature().getName());
        return proceed;
    }
}
