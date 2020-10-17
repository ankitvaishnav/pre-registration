package io.mosip.preregistration.core.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.mosip.kernel.core.templatemanager.spi.TemplateManager;
import io.mosip.kernel.core.templatemanager.spi.TemplateManagerBuilder;

/**
 * @author Sanober Noor
 *@since 1.0.0
 */
@Configuration
public class TemplateConfiguration {

	/*
	To resolve the issue component required a bean of type 'java.lang.String' that could not be found
	 */

	@Bean
	public TemplateManager templateManager(TemplateManagerBuilder templateManagerBuilder){
	   
	    return templateManagerBuilder.build();
	} 
}
