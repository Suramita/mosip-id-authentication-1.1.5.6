package io.mosip.authentication.core.indauth.dto;

import java.util.Map;

import io.mosip.authentication.core.dto.ObjectWithMetadata;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * General-purpose of {@code AuthRequestDTO} class used to communicate with
 * core-kernel API. This class is picked request and send to core-kernel. Where
 * core-kernal API processed operation with {@code AuthRequestDTO} attributes.
 * 
 * @author Rakesh Roshan
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthRequestDTO extends BaseAuthRequestDTO implements ObjectWithMetadata {

	/** The value for request*/
	private RequestDTO request;

	/** The value for consentObtained*/
	private boolean consentObtained;
	
	/** The value for requestHMAC*/
	private String requestHMAC;
	
	/** The value for requestSessionKey*/
	private String requestSessionKey;
	
	private Map<String, Object> metadata;

}
