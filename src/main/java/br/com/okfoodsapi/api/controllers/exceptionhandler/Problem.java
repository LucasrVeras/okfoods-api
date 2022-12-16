package br.com.okfoodsapi.api.controllers.exceptionhandler;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Problem {
	
	private LocalDateTime dataTime;
	private String message;
	
}
