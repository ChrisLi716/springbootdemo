package com.springboot.chris.demo.controller;

import com.springboot.chris.demo.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorld {
	
	@Value("${chris.msg}")
	private String msg;
	
	@Value("${random.int}")
	private int num;
	
	@RequestMapping(value = "/sayhello", method = RequestMethod.GET)
	public String helloworld() {
		int i = 6 / 0;
		return msg + num;
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String getBizException() {
		throw new BusinessException("100", "user password is wrong!");
	}
	
	/*
	@Override
	@TokenSecured
	@RequestMapping(value = "/user/{userId}/audit-draft/previous-order/{orderId}", method = RequestMethod.POST)
	@ApiOperation(value = "Create Draft From Previous Order API", response = AuditBookingBean.class)
	public ResponseEntity<ApiCallResult> createDraftFromPreviousOrder(
		@ApiParam(value = "userId", required = true) @PathVariable("userId") String userId,
		@ApiParam(value = "orderId", required = true) @PathVariable("orderId") String orderId,
		@ApiParam(value = "serviceType", required = true) @RequestParam("serviceType") String serviceType) {
		log.info("invoke: " + "/user/" + userId + "/audit-draft/previous-psi-order/" + orderId + "?serviceType="
			+ serviceType);
		ApiCallResult result = auditorService.createDraftFromPreviousOrder(userId, orderId, serviceType);
		if (null == result.getMessage()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			log.error("fail from psi-service!" + result.getMessage());
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
}
