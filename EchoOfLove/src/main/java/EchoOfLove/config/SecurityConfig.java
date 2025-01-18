package EchoOfLove.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 모든 요청에 대해 인증 없이 접근 허용
                )
                .csrf(AbstractHttpConfigurer::disable); // CSRF 비활성화 (테스트 환경에서만)
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/", "/about", "/contact").permitAll() // 공개 URL
//                        .requestMatchers("/dashboard/**", "/user/**").authenticated() // 인증 필요한 URL
//                );

        return http.build();
    }
}
