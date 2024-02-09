package Proyect.ProyectoV2.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityWebConfig {
    
     @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
            //.requestMatchers("/blog/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
            //   .loginPage("/login")
                .permitAll()
                .successHandler(redireccionar())
                .and()
            .rememberMe();

        return http.build();
    }
    
    public AuthenticationSuccessHandler redireccionar (){
        return ((request, response, authentication) ->{
        response.sendRedirect("/index");//Direccion a donde llevar al usuario post formulario
        });
    }
    
     //Asignar usuario y contraseña
    @Bean
    public UserDetailsService usuario(){
        PasswordEncoder codificador = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            
            return new InMemoryUserDetailsManager(
                     User.withUsername("admin")
                    .password(codificador.encode("admin"))
                    .build()
            );
    }
   
    
}