package io.mosip.authentication.common.service.impl.match;

import java.util.Map;

import io.mosip.authentication.core.exception.IdAuthenticationBusinessException;
import io.mosip.authentication.core.spi.indauth.match.MasterDataFetcher;
import io.mosip.authentication.core.spi.indauth.match.MatchFunction;
import io.mosip.authentication.core.spi.indauth.match.MatchingStrategyType;
import io.mosip.authentication.core.spi.indauth.match.TextMatchingStrategy;
import io.mosip.authentication.core.util.DemoMatcherUtil;
import io.mosip.authentication.core.util.DemoNormalizer;

/**
 * 
 * @author Dinesh Karuppiah.T
 * @author Nagarjuna
 */

public enum NameMatchingStrategy implements TextMatchingStrategy {

	EXACT(MatchingStrategyType.EXACT, (Object reqInfo, Object entityInfo, Map<String, Object> props) -> {
		return TextMatchingStrategy.normalizeAndMatch(reqInfo, 
				entityInfo, 
				props,
				NameMatchingStrategy::normalizeText,
				getDemoMatcherUtilObject(props)::doExactMatch);

	}), PARTIAL(MatchingStrategyType.PARTIAL, (Object reqInfo, Object entityInfo, Map<String, Object> props) -> {
		return TextMatchingStrategy.normalizeAndMatch(reqInfo, 
				entityInfo, 
				props,
				NameMatchingStrategy::normalizeText,
				getDemoMatcherUtilObject(props)::doPartialMatch);
	}), PHONETICS(MatchingStrategyType.PHONETICS, (Object reqInfo, Object entityInfo, Map<String, Object> props) -> {
		return TextMatchingStrategy.normalizeAndMatch(reqInfo, 
				entityInfo,
				props,
				NameMatchingStrategy::normalizeText,
				(refInfoName, entityInfoName) -> {
					String language = (String) props.get("language");
					return getDemoMatcherUtilObject(props).doPhoneticsMatch(refInfoName, entityInfoName, language);
				});
	});

	private final MatchFunction matchFunction;

	private final MatchingStrategyType matchStrategyType;

	/**
	 * Constructor for Name Matching Strategy
	 * 
	 * @param matchStrategyType
	 * @param matchFunction
	 */
	NameMatchingStrategy(MatchingStrategyType matchStrategyType, MatchFunction matchFunction) {
		this.matchFunction = matchFunction;
		this.matchStrategyType = matchStrategyType;
	}

	@Override
	public MatchingStrategyType getType() {
		return matchStrategyType;
	}

	@Override
	public MatchFunction getMatchFunction() {
		return matchFunction;
	}
	
	public static String normalizeText(DemoNormalizer demoNormalizer, String inputText, String langCode,
			Map<String, Object> properties) throws IdAuthenticationBusinessException {
		return demoNormalizer.normalizeName(inputText, langCode, (MasterDataFetcher) properties.get("titlesFetcher"));
	}

	/**
	 * Gets the demoMatcherUtil object
	 * @param props
	 * @return
	 */
	public static DemoMatcherUtil getDemoMatcherUtilObject(Map<String, Object> props) {
		return (DemoMatcherUtil)props.get("demoMatcherUtil");
	}
}
