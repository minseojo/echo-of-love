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
                .csrf(AbstractHttpConfigurer::disable) // CSRF 비활성화 (테스트 환경에서만)
                .logout(logout -> logout
                                .logoutUrl("/sign-out") // 로그아웃 URL 변경
                                .logoutSuccessUrl("/") // 로그아웃 후 리디렉션될 페이지
                                .invalidateHttpSession(true) // 세션 무효화
                                .deleteCookies("JSESSIONID") // 쿠키 삭제
        );
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/", "/about", "/contact").permitAll() // 공개 URL
//                        .requestMatchers("/dashboard/**", "/user/**").authenticated() // 인증 필요한 URL
//                );

        return http.build();
    }
}
