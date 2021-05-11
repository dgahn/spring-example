## Spring Example

[인프런 강의](https://www.inflearn.com/course/spring-boot-restful-web-services#) 를 보고 배운 내용을 작성한다.


### DispatcherServletAutoConfiguration

스프링에서 **DispatcherServlet**이 사용자의 요청을 처리해주는 게이트웨이의 역할을 한다. 이를 자동으로 설정해주는 
객체가 **DispatcherServletAutoConfiguration**다.

### HttpMessageConvertersAutoConfiguration

사용자에게 전달해야하는 내용을 담은 객체가 **HttpMessageConverters**고 이를 자동 설정해주는 객체다.

### dispatch

dispatch의 사전적 의미는 특정한 목적을 위해서 보낸다라는 의미다. 사용자의 요청과 사용자를 위한 응답은 모두
**DispatcherServlet**을 통해서 처리한다.

### @RestController

view를 갖지 않는 REST Data를 반환한다. 