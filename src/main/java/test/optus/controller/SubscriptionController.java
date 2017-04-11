package test.optus.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.optus.service.StringHandlingService;

@Controller
public class SubscriptionController {
	public static final Logger log = LoggerFactory.getLogger(SubscriptionController.class);

    @Autowired
    private StringHandlingService stringHandlingService;

    @RequestMapping(value = "/subscribe", method = RequestMethod.GET)
    @ResponseBody
    public String subscribe(HttpServletRequest request) {
        String orderDetails = getOrderDetails(request);
        log(orderDetails);
        String truncatedOrderDetails = truncate(orderDetails, 250);
        log(truncatedOrderDetails);
        
        return truncatedOrderDetails;
    }

    private String getOrderDetails(HttpServletRequest request) {
		// TODO Auto-generated method stub
    	System.out.println("url:" + request.getRequestURL().toString());
		return request.getRequestURL().toString();
	}

	private String truncate(String str, int length) {
        return stringHandlingService.truncateString(str, length);
    }

	private void log(String details) {
		log.debug(details);
	}
}
