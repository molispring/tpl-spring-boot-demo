package com.yonyou.exception;

/**
 * Created by Administrator on 2017/11/3.
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message, Exception e) {
		super(message, e);
	}
    

    public BusinessException(String message) {
		super(message);
	}

	private static final long serialVersionUID = -8702644122994245542L;
//
//    public BusinessException(ErrorType errorType, Object ... args) {
//        super(String.format(errorType.getErrMsg(), args));
//        this.errorType = errorType;
//    }
//
//    public BusinessException(ErrorType errorType, Exception e, Object ... args) {
//        super(String.format(errorType.getErrMsg(), args), e);
//        this.errorType = errorType;
//    }
//    public ErrorType getErrorType() {
//        return errorType;
//    }
}

