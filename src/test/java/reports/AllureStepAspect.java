package reports;

import io.qameta.allure.Allure;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
// Create an Aspect class to automatically log all step definition methods as Allure steps.
@Aspect
public class AllureStepAspect {

    // Pointcut to target all methods in step definition classes
    @Pointcut("execution(* stepdefinitions..*.*(..))")
    public void stepDefinitions() {}

    @Around("stepDefinitions()")
    public Object logStep(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String stepName = className + " - " + methodName; // Include class name
        return Allure.step(stepName, () -> joinPoint.proceed());
    }
}
