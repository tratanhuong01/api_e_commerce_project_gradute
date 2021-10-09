package com.api.api_e_commerce_project_gradute.jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .cors().and().csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/", "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js").permitAll()


        .antMatchers(HttpMethod.POST, "/checkLoginJWT","/getProductBySlug","/getSlug",
            "/reviewProducts/**","/reviewProductsAll","/reviewProductsAll/**","/reviewProducts",
            "/messages","/messages/**","/groupChats/**","/groupChats","/groupChatsAll/**","/groupChatsAll",
            "/comments","/comments/**","/commentsAll/**","/commentsAll","/getNewsBySlug","/getUserFromJWT",
            "/adminCheckLoginJWT","/users/email","/users/phone","/users","/sendCodeEmail").permitAll()


        .antMatchers(HttpMethod.DELETE,"/addresses").permitAll()


        .antMatchers(HttpMethod.PUT,"/setDefaultAddress","/updateViewNews","/infoProducts/**",
            "/users","/users/**").permitAll()


        .antMatchers(HttpMethod.GET, "/colorsAll","/brandsAll","/getProductIndex","/carts/**",
            "/getCategoryByGroupProducts/","/carts","/slides","/slides/**","/getAllProductFull","/getProductByCategory/**",
            "/products/**","/getProductBySlugCategory","getProductBySlugCategoryAndSlugGroup",
            "/getCategoryByGroupProducts","/getProductBySlugCategory","/productsAll/**","/reviewProductByStar/**",
            "/reviewProductByStarAll","/reviewProductByStarAll/**","/newsPagination","/newsPaginationAll",
            "/reviewProducts/**","/reviewProductsAll","/reviewProductsAll/**","/reviewProducts",
            "/attributeProducts/**","/attributeProducts","/brands/**","/brandsAll","/brands","/colors","/colors/**",
            "/colorsAll/**","/colorsAll","/rams/**","/rams","/ramsAll","/ramsAll/**","/memories/**","/memories",
            "/memoriesAll","/memoriesAll/**","/messages","/messages/**","/messagesAll/","/messagesAll/**",
            "/discountCodes/**","/discountCodes","/addresses","/addresses/**","/addressesAll/**","/addressesAll",
            "/getDefaultAddress","/getBestNews","/getBestLoveNews","/commentsAll/**","/commentsAll","/comments",
            "/comments/**","/getListNewsMostView","/getNewsPage","/news/**","/newsAll",
            "/categoryProducts","/categoryProductsAll","/categoryProductsAll/**","/categoryProducts/**",
            "/groupProductsAll","/groupProductsAll/**","/groupProducts","/groupProducts/**",
            "/groupProductsByCategory","/groupProductsBySlugCategory","/lineProductsAll" ,
            "/lineProductsAll/**","/lineProducts","/lineProducts/**","/getLineProductsByGroup",
            "/groupProductsBySlugCategory/**","/productsFilter","/groupFilterProductsAll","/groupFilterProductsAll/**",
            "/groupFilterProducts","/groupFilterProducts/**","/functionProductsAll","/functionProductsAll/**",
            "/functionProducts","/functionProducts/**","/getFilterByGroupProduct/**","/functionProductsBySlug/**",
            "/getTeleSupport","/infoProducts","/infoProductsAll/**","/infoProductsAll","/infoProducts/**",
            "/getSlidesActive","/getBannerIndexShow","/configWebsites/**","/categoryNews","/imageOthers",
            "/imageOthers/**","/users","/users/**").permitAll()


        .anyRequest().authenticated()
        .and()
        .addFilterBefore(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
        // disable page caching
        .headers().cacheControl();
  }
}