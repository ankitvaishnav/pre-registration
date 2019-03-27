package io.mosip.kernel.otpmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.mosip.kernel.core.http.RequestWrapper;
import io.mosip.kernel.core.http.ResponseFilter;
import io.mosip.kernel.core.otpmanager.spi.OtpGenerator;
import io.mosip.kernel.otpmanager.dto.GenerationDTOValidationLevels;
import io.mosip.kernel.otpmanager.dto.OtpGeneratorRequestDto;
import io.mosip.kernel.otpmanager.dto.OtpGeneratorResponseDto;

/**
 * This class provides controller methods for OTP generation.
 * 
 * @author Sagar Mahapatra
 * @author Ritesh Sinha
 * @since 1.0.0
 *
 */
@RestController
@CrossOrigin
public class OtpGeneratorController {
	/**
	 * Autowired reference of {@link OtpGenerator}.
	 */
	@Autowired
	OtpGenerator<OtpGeneratorRequestDto, OtpGeneratorResponseDto> otpGeneratorService;

	/**
	 * This method handles the OTP generation.
	 * 
	 * @param otpDto
	 *            The request DTO for OTP generation.
	 * @return The generated OTP as DTO response.
	 */
	@ResponseFilter
	@PostMapping(value = "/otp/generate")
	public ResponseEntity<OtpGeneratorResponseDto> generateOtp(@Validated({
			GenerationDTOValidationLevels.ValidationLevel.class }) @RequestBody RequestWrapper<OtpGeneratorRequestDto> otpDto) {
		return new ResponseEntity<>(otpGeneratorService.getOtp(otpDto.getRequest()), HttpStatus.OK);
	}
}
