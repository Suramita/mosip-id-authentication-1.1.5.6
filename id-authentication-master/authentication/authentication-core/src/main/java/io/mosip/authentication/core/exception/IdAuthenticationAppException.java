package io.mosip.authentication.core.exception;

import io.mosip.authentication.core.constant.IdAuthenticationErrorConstants;
import io.mosip.kernel.core.exception.BaseUncheckedException;

/**
 * The base exception for ID Authentication application which is always associated with an error code.
 * This exception is thrown at application level, usually wrapped with root cause.
 *
 * @author Manoj SP
 */
public class IdAuthenticationAppException extends IdAuthenticationBaseException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7770924160513076138L;
	
	/**
	 * Instantiates a new id authentication app exception.
	 */
	public IdAuthenticationAppException() {
		super();
	}
	
	/**
	 * Constructs exception for the given error code and error message.
	 *
	 * @param errorCode the error code
	 * @param errorMessage the error message
	 * @see BaseUncheckedException#BaseUncheckedException(String, String)
	 */
	public IdAuthenticationAppException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
	
	/**
	 * Constructs exception for the given  error code, error message and {@code Throwable}.
	 *
	 * @param errorCode the error code
	 * @param errorMessage the error message
	 * @param cause the cause
	 * @see BaseUncheckedException#BaseUncheckedException(String, String, Throwable)
	 */
	public IdAuthenticationAppException(String errorCode, String errorMessage, Throwable cause) {
		super(errorCode, errorMessage, cause);
	}


	/**
	 * Constructs exception for the given {@code IdAuthenticationErrorConstants}.
	 *
	 * @param exceptionConstant the exception constant
	 * @see BaseUncheckedException#BaseUncheckedException(String, String)
	 */
	public IdAuthenticationAppException(IdAuthenticationErrorConstants exceptionConstant) {
		super(exceptionConstant);
	}

	/**
	 * Constructs exception for the given {@code IdAuthenticationErrorConstants} and {@code Throwable}.
	 *
	 * @param exceptionConstant the exception constant
	 * @param rootCause the root cause
	 * @see BaseUncheckedException#BaseUncheckedException(String, String, Throwable)
	 */
	public IdAuthenticationAppException(IdAuthenticationErrorConstants exceptionConstant, Throwable rootCause) {
		super(exceptionConstant, rootCause);
	}


}
