package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( //컴포넌트 빈 자동 등록
        basePackages = "hello.core", //탐색 시작 위치 // 지정 하지 않으면 componentscan이 붙은 클래스의 패키지가 시작 위치
        basePackageClasses = AutoAppConfig.class, //지정한 클래스의 패키지를 탐색 위치로 지정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)//제외 지정
)
public class AutoAppConfig {

}
