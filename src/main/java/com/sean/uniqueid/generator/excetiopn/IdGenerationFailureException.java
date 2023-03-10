package com.sean.uniqueid.generator.excetiopn;

/**
 * id生成失败异常
 * @author zengyusheng
 * @date 2023/3/9 22:41
 */
public class IdGenerationFailureException extends RuntimeException {

    public IdGenerationFailureException() {
        super();
    }

    public IdGenerationFailureException(String message) {
        super(message);
    }

    public IdGenerationFailureException(Throwable cause) {
        super(cause);
    }

    public IdGenerationFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
