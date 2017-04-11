package test.optus.service.impl;

import org.springframework.stereotype.Component;

import test.optus.StringUtils;
import test.optus.service.StringHandlingService;

@Component
public class StringHandlingServiceImpl implements StringHandlingService {

	public String truncateString(String str, int length) {
		String returnStr = str;
        if (!StringUtils.isStringLargerThan(str, length)
                || !StringUtils.isStringLargerThan(str, midTruncate.length() + 2) || (length <= midTruncate.length() + 2)) {
            return returnStr;
        } else {
            int leftStrStart = (length - midTruncate.length()) % 2;
            int rightStr = (length - midTruncate.length()) / 2;

            return new StringBuffer().append(str.substring(0, leftStrStart + rightStr)).append(midTruncate)
                    .append(str.substring((str.length() - rightStr), str.length())).toString();
        }
	}

}
