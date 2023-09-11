@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    open fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            headers {
                httpStrictTransportSecurity { //TP
                    includeSubDomains = false
                    preload = true
                    maxAgeInSeconds = 31536000
                }
            }
        }
        return http.build()
    }
}