package com.fouadev.customerservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class CorsConfig {
    //@Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

//    @Bean
//    public WebMvcConfigurer corsWebConfig() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:4200")
//                        .allowedMethods(HttpMethod.GET.name(),
//                                HttpMethod.POST.name(),
//                                HttpMethod.PUT.name(),
//                                HttpMethod.DELETE.name())
//                        .allowedHeaders(HttpHeaders.CONTENT_TYPE,
//                                HttpHeaders.AUTHORIZATION)
//                        .allowCredentials(true);
//            }
//        };
//    }
}