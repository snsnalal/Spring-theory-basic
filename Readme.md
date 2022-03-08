# Spring-theory-basic
스프링 원리 기본편(김영한님)
<br>
* <h2>좋은 객체 지향 프로그래밍이란?</h2>
 * 객체 지향 특징
   * 추상화, 캡슐화, 상속, 다형성
   * 객체 지향 프로그래밍이란 "객체"들의 모임으로 파악하고자 하는 것이다. 각각의 객체는 메시지를 주고 받고, 데이터를 처리할 수 있다.(협력), 유연하고 변경에 용이하다.

 * 유연하고, 변경이 용이?
    * 레고 블럭 조립하듯이, 컴퓨터 부품을 갈아 끼우듯이 컴포넌트를 쉽고 유연하게 변경하면서 개발할 수 있다.
 
 * 다형성
 
```
    역할 : 인터페이스
    구현 : 인터페이스를 구현한 객체
```

<img src = "/img/스프링.png" width = "400px" height = "200px"> <img src = "/img/스프링2.png" width = "400px" height = "200px">
* 다형성 예시1

  * 운전자는 자동차 역할이라는 인터페이스를 알고 있기 때문에 차가 바뀌어도 역할을 활용할 수 있다.
  * 운전자(클라이언트)를 위해 구현을 분리시켰다. 자동차를 바꿔도 운전자에게 영향을 주지않는다.
  * 클라이언트에 영향을 주지 않고 새로운 기능을 제공할 수 있다.(역할과 구현을 구분했기 때문에 가능)
  
* 다형성 예시2 

  * 로미오와 줄리엣 역할(인터페이스)은 각각 다른 배우(구현)가 할 수 있다.
  * 배우는 대체가 가능하다.

* 역할과 구현을 분리

  * 역할과 구현으로 구분하면 세상이 단순해지고, 유연해지며 변경도 편리해진다.
  * 장점
    * 클라이언트는 대상의 역할(인터페이스)만 알면 된다.
    * 클라이언트는 구현 대상의 내부 구조를 몰라도 된다.
    * 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다.
    * 클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않는다.

* 자바에서의 다형성
  
  * 역할과 구현을 명확히 분리
  * 객체 설계시 역할을 먼저 부여하고, 그 역할을 수행하는 구현 객체 만들기
  * 오버라이딩
     <br><img src = "/img/스프링3.png" width = "300px" height = "150px">
     * 오버라이딩 된 메서드가 실행된다.
     * 다형성으로 인터페이스를 구현한 객체를 실행 시점에 유연하게 변경할 수 있다.

* <h2>객체 지향 설계의 5가지 원칙(SOLID)</h2>
  
  * SRP : 단일 책임 원칙(single responsible principle)
    * 한 클래스는 하나의 책임만 가져야 한다.
    * 중요한 기준은 변경이다. 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것

  * OCP : 개방-폐쇄 원칙(Open/closed principle)
    * 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
    * 다형성을 활용, 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능을 구현(앞의 자동차와 로미오와 줄리엣을 생각)
    * OCP 개방-폐쇄 원칙의 문제점
    <br><br><img src = "/img/스프링4.png" width = "500px" height = "200px">
      * MemberServie 클라이언트가 구현 클래스를 직접 선택
      * 구현 객체를 변경하려면 클라이언트 코드를 변경해야한다.(변경에 닫혀있지 않다)
      * 해결 : 객체를 생성하고, 연관관계를 맺어주는 별도의 조립, 설정자가 필요하다(스프링 컨테이너의 역할)

  * LSP 리스코프 치환 원칙(Liskov substitution principle)
    * 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
    * 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 한다는 것이다.
    * 인터페이스를 구현한 구현체를 믿고 사용하려면 이 원칙이 필요하다.

  * IPS 인터페이스 분리 원칙(Interface segregation principle)
    * 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다
    * 자동차라는 인터페이스 -> 운전, 정비 인터페이스로 분리
    * 인터페이스를 적당한 규모로 쪼개야한다는 의미.
    * 인터페이스가 명확해지고, 대체 가능성이 높아진다.

  * DIP 의존관계 역전 원칙(Dependency inversion principle)
    * 추상화에 의존해야지, 구체화에 의존하면 안된다.
    * 클라이언트 코드가 인터페이스만 바라봐야한다.
    * 인터페이스(역할)에 의존해게 해야한다.(의존이란? 내가 저 코드를 알고 있다)
    
  * 다형성 만으로는 OCP, DIP를 지킬 수 없다. 다른 무언가가 더 필요하다.
  
* <h2>객체 지향 설계와 스프링</h2>

  * 스프링 이야기에 왜 객체 지향 이야기가 나오는가?
    * 스프링 : (DI : 의존관계, 의존성 주입),  DI 컨테이너를 제공 = 다형성 + OCP, DIP를 가능하게 지원한다.
    * 클라이언트 코드의 변경 없이 기능 확장

  * 정리
    * 모든 설계에 역할과 구현을 분리하자.
    * 기능을 확장할 가능성이 없다면, 구체 클래시를 직접 사용하고, 향후 꼭 필요할 떄 리팩터링해서 인터페이스를 도입하는 것도 방법이다.
---
<h2> 1. 프로젝트 생성</h2>

  * Java 11
  * IDE : InteliJ
  * Project : Gradle
  * Spring Boot : 2.5.10
  * Language : Java

<h2> 2. 비지니스 요구사항과 설계 </h2>

* 회원
  * 회원 가입하고 조회할 수 있다.
  * 회원은 일반과 VIP 두 가지 등급이 있다.
  * 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. __(미확정)__

* 주문과 할인 정책
  * 회원은 상품을 주문할 수 있다.
  * 회원 등급에 따라 할인 정책을 적용할 수 있다.
  * 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라. __(나중에 변경 될 수있다.)__
  * 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을 미루고 싶다. 최악의 경우 할인을 적용하지 않을 수 도 있다. __(미확정)__

<h2> 3. 회원 도메인 설계 </h2>

* 회원 도메인 요구사항
  * 회원을 가입하고 조회할 수 있다.
  * 회원은 일반과 VIP 두 가지 등급이 있다.
  * 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. __(미확정)__

<img src = "/img/스프링5.png">
  * 도메인에 대한 큰 그림
  * 클라이언트는 회원 서비스 호출(가입, 조회 기능)
  * 회원 저장소(인터페이스)는 별도로 만듬
  * 구현은 메모리 회원저장소, DB회원 저장소, 외부 시스템 연동 회원 저장소 3개
  
<img src = "/img/스프링6.png">
  * MemberService 인터페이스 MemberSErviceImpl 구현체
  * MemberRepository 인터페이스 MemoryMemberRepository, DbMemberRepository 구현체
  
<img src = "/img/스프링7.png">
  * 실제 서버에서 객체 간의 메모리 참조 관계를 나타냄
  * 회원 서비스 : MemberServiceImpl

<h2> 4. 회원 도메인 개발 </h2>

* 참고 : HashMap은 동시성 이슈가 발생할 수 있다. 이런 경우 ConcurrentHashMap을 사용(실무에서 자주 사용)
* 위 설계의 문제점
  * 의존 관계가 인터페이스 뿐만 아니라 구현체까지 모두 의존하는 문제가 있다
  * MemberServiceImpl 구현체가 MemberRepository 인터페이스와 MemoryMemberRepository 구현체를 모두 의존하고 있다. -> DIP 위반
  
<h2> 5. 주문과 할인 도메인 설계 </h2>

* 주문과 할인 정책
  * 회원은 상품을 주문할 수 있다.
  * 회원 등급에 따라 할인 정책을 적용할 수 있다.
  * 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라. (나중에 변경 될 수 있다.)
  * 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을 미루고 싶다. 최악의 경우 할인을 적용하지 않을 수 도 있다. (미확정)

<img src = "/img/스프링8.png" width = "350" height = "170">
<img src = "/img/스프링9.png" width = "420" height = "300"> 

* 구현 객체가 점선 화살표로 인터페이스를 바라보고 있다.

<img src = "/img/스프링10.png" width = "420" height = "300">

* 구현체가 인터페이스에만 의존한다.

<img src = "/img/스프링11.png" width = "350" height = "170">

* 저장소의 구현체가 바뀌어도, 주문 서비스 구현체를 변경할 필요가 없다.

<img src = "/img/스프링12.png" width = "350" height = "170">

<h2> 6. 주문과 할인 도메인 개발 </h2>

* [할인 정책 인터페이스](/src/main/java/hello/core/discount/DiscountPolicy.java)
* [정액 할인 정책 구현체](/src/main/java/hello/core/discount/FixDiscountPolicy.java)
* [주문 엔티티](/src/main/java/hello/core/order/Order.java)
* [주문 서비스 인터페이스](/src/main/java/hello/core/order/OrderService.java)
* [주문 서비스 구현체](/src/main/java/hello/core/order/OrderServiceImpl.java)

---
<h2> 1. 새로운 할인 정책 개발 </h2>

* 새로운 할인 정책 추가(RateDiscountPolicy)

<img width="403" alt="스프링13" src="https://user-images.githubusercontent.com/62021242/156767762-f4cf5d77-218d-4ba1-bcfd-bc8c5b121b22.png">

  * [할인 정책 구현체](/src/main/java/hello/core/discount/RateDiscountPolicy.java)
  
* 새로운 할인 정책 적용과 문제점

``` JAVA
public class OrderServiceImpl implements OrderService {
// private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
 private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
}
```

  * OrderServiceImpl이 DiscountPolicy와 FixDiscountPolicy, RateDiscountPolicy 까지 의존하고 있다. -> DIP 위반
  * 지금 코드는 기능을 확장하려면 코드를 변경 해야한다 -> 클라이언트 코드에 영향을 준다 -> OCP 위반
  <img width="405" alt="스프링14" src="https://user-images.githubusercontent.com/62021242/156768847-4259cfca-a424-4ba1-96dd-1e0f8b85518e.png">
  
* 해결 방법

 * 인터페이스에만 의존하도록 설계를 변경하자

``` JAVA
public class OrderServiceImpl implements OrderService {
 //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
 private DiscountPolicy discountPolicy;
}
```
* 하지만 구현체가 없기 때문에 실행이 안된다(Null pointer Exceoption 발생)
* 해결하려면 OrderServiceImpl에 DiscountPolicy의 구현 객체를 대신 생성하고 주입해주어야 한다.

<h2> 2. 관심사의 분리 </h2>

* 이전 코드는 마치 로미오 역할(인터페이스)을 하는 레오나르도 디카프리오(구현체, 배우)가 줄리엣 역할(인터페이스)을 하는 여자 주인공(구현체, 배우)을 직접 초빙하는 것과 같다. 디카프리오는 공연도 해야하고 동시에 여자 주인공도 공연에 직접 초빙해야 하는 다양한 책임을 가지고 있다.

<h2> 3. AppConfig 등장 </h2>

* [AppConfig](/src/main/java/hello/core/AppConfig.java)는 애플리케이션의 전체 동작 방식을 구성(하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스
  * AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
  * AppConfig는 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입해준다.
  * 의존관계에 대한 고민은 외부에 맡기고 실행에만 집중하면 된다. [MemberServiceImpl](/src/main/java/hello/core/member/MemberServiceImpl.java)
    <img width="405" alt="스프링15" src="https://user-images.githubusercontent.com/62021242/156887601-9a3a5ed4-f50f-45f6-a6e4-6da3c3651152.png">
  * 관심사가 분리되어 객체를 생성하고 연결하는 역할과 실행하는 역할이 명확히 분리되었다. DIP 완성
  * AppConfig는 memoryMemberRepository 객체를 생성하고 그 참조값을 memberServiceImpl을 생성하면서 생성자로 전달한다.
 
<h2> 4. 좋은 객체 지향 설계의 5자기 원칙의 적용 </h2>

* SRP 단일 책임 원칙 - 한 클래스는 하나의 책임만 가져야 한다.
  * 구현 객체를 생성하고 연결하는 책임은 AppConfig가 담당
  * 클라이언트 객체는 실행하는 책임만 담당

* DIP 의존관계 역전 원칙 - 추상화에 의존해야지 구체화에 의존하면 안된다.
  * 클라이언트 코드(OrderServiceImple)는 DIP를 지키며 DiscountPolicy 추상화 인터페이스에 의존하는 것 같지만, FixDiscountPolicy 구체화 구현 클래스에도 함께 의존했다.
  * 클라이언트 코드가 DiscountPolicy 추상화 인터페이스에만 의존하도록 코드를 변경하고 AppConfig가 FixDiscountPolicy 객체 인스턴스를 클라이언트 코드 대신 생성해서 클라이언트 코드에 의존관계를 주입하면서 DIP원칙을 해결했다.

* OCP - 소프트웨어 요소는 확장에는 열려있으나 변경에는 닫혀 있어야 한다.
  * 애플리케이션을 사용 영역과 구성 영역으로 나눔
  * AppConfig가 의존관계를 FixDiscountPolicy RateDiscountPolicy 로 변경해서 클라이언트 코드에 주입하므로 클라이언트 코드는 변경하지 않아도 됨
  * 소프트웨어 요소를 새롭게 확장해도 사용 영역의 변경은 닫혀 있다.

---

<h2> 1. IoC, DI, 그리고  </h2>

* 제어의 역전
  * 기존 프로그램 : 클라이언트 구현 객체가 스스로 필요한 서버 구현 객체를 생성하고, 연결하고, 실행했다. 구현 객체가 프로그램의 제어 흐름을 스스로 조종
  * AppConfig : 구현 객체는 자신의 로직을 실행하는 역할만 담당. 외부에서  프로그램 동장 방식을 제어한다.
    * 프로그램에 대한 제어 흐름에 대한 권한은 모두 AppConfig가 가지고 있다. 어떤 인터페이스에 어떤 구현체를 선택할지도 정해준다.

```
프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 제어의 역전(IoC)라고 한다.
```

* 의존과계 주입 DI
  * 의존관계는 정적인 클래스 의존 관계와, 실행 시점에 결정되는 동적인 객체(인스턴스) 의존 관계 둘을 분리해서 생각해야 한다.
    * 정적인 클래스 의존관계
      * 클래스가 사용하는 import 코드만 보고 의존관계를 쉽게 판단할 수 있다.
        <img width="406" alt="스프링16" src="https://user-images.githubusercontent.com/62021242/156892578-1d07b174-e4fc-48fe-a10b-af2420701711.png">
      * OrderServiceImpl은 MemberRepository와 DiscountPolicy 에 의존한다는 것을 알 수 있다. 그런데 이러한 클래스 의존관계 만으로는 실제 어떤 객체가 OrderServiceImpl 에 주입 될지 알 수 없다
    * 동적인 객체 인스턴스 의존 관계
      * 애플리케이션 실행 시점에 실제 생성된 객체 인스턴스의 참조가 연결된 의존 관계다.
        <img width="404" alt="스프링17" src="https://user-images.githubusercontent.com/62021242/156892763-272c0527-c3f2-4726-843e-3fe730df70aa.png">
      * 애플리케이션 실행 시점에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결 되는 것을 __의존관계 주입__ 이라 한다.
      * AppConfig가 그 역할을 한다.(Appconfig = DI 컨테이너)
    * 의존관계 주입을 사용하면 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있다.

<h2> 2. 스프링으로 전환하기  </h2>

* @Configuration : AppConfig에 설정을 구성한다는 뜻
* @Bean : 스프링 빈 등록한다.

``` JAVA
public class MemberApp {
 public static void main(String[] args) {
// AppConfig appConfig = new AppConfig();
// MemberService memberService = appConfig.memberService();
 ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
 MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
 Member member = new Member(1L, "memberA", Grade.VIP);
 memberService.join(member);
 Member findMember = memberService.findMember(1L);
 System.out.println("new member = " + member.getName());
 System.out.println("find Member = " + findMember.getName());
 }
 ```
 
 * ApplicationContext를 스프링 컨테이너라 한다. 스프링 컨테이너는 @Configuration이 붙은 AppConfig를 설정 정보로 사용한다. @Bean이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨데이터에 등록한다.
 * 스프링 빈은 @Bean이 붙은 메서드의 명을 스프링 빈의 이름으로 사용한다.
 * 스프링 빈은 applicationContext.getBean() 메서드를 사용해서 찾을 수 있다

---

<h2> 1. 스프링 컨테이너 생성  </h2>

``` JAVA
ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
```

* ApplicationContext를 스프링 컨테이너라 한다.
* ApplicationContext는 인터페이스이다.
* new AnnotationConfigApplicationContext(AppConfig.class); 클래스는 ApplicationContext인터페이스의 구현체이다.

* 스프링 컨테이너의 생성 과정
  1. 스프링 컨테이너를 생성 할 때에는 구성 정보(Appconfig.java)를 정해줘야한다.
       <img width="453" alt="스프링18" src="https://user-images.githubusercontent.com/62021242/156893583-e9c55498-1b62-4568-af38-c3d11c3343e4.png">
  2. 스프링 컨테이너는 파라미터로 넘어온 설정 클래스 정보를 사용해서 스프링 빈을 등록한다.
       <img width="453" alt="스프링19" src="https://user-images.githubusercontent.com/62021242/156893635-36a67231-3d78-4638-a73a-f7c93bf7c1cb.png">
     * 빈 이름은 항상 다른 이름을 부여해하 한다.(@Bean(name = "memberService2")) 직접 부여 방법
  3. 스프링 빈 의존관계 설정 준비
     * AppConfig 기반으로 스프링 컨테이너를 생성한다.
      <img width="452" alt="스프링20" src="https://user-images.githubusercontent.com/62021242/156893717-b5573d77-4dc3-407f-8447-3b0c9a48e785.png">
  4. 스프링 빈 의존관계 설정
     * 스프링 컨테이너가 설정 정보를 참고해서 의존관계를 주입한다.
      <img width="452" alt="스프링21" src="https://user-images.githubusercontent.com/62021242/156893760-b66d7322-dd25-4394-a3a3-d02666b9cd3f.png">

<h2> 2. 스프링 빈 조회  </h2>

``` JAVA
 @Test
 @DisplayName("애플리케이션 빈 출력하기")
 void findApplicationBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    for (String beanDefinitionName : beanDefinitionNames) {
        BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
         //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
        //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
        if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name=" + beanDefinitionName + " object=" + bean);
        }
     }
 }
 ```
 
 * ac.getBeanDefinitionNames() : 스프링에 등록된 모든 빈 이름을 조회한다.
 * ac.getBean() : 빈 이름으로 빈 객체(인스턴스)를 조회한다.
 * 동일한 타입이 둘 이상
   * 빈 이름을 지정해야한다.
   * ac.getBeansOfType() 을 사용하면 해당 타입의 모든 빈을 조회할 수 있다.

``` JAVA
 @Test
 @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
 void findBeanByName() {
    MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
    assertThat(memberRepository).isInstanceOf(MemberRepository.class);
 }
 ```
 
 ```JAVA
 @Test
 @DisplayName("특정 타입을 모두 조회하기")
 void findAllBeanByType() {
    Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
    for (String key : beansOfType.keySet()) {
      System.out.println("key = " + key + " value = " + beansOfType.get(key));
    }
    System.out.println("beansOfType = " + beansOfType);
    assertThat(beansOfType.size()).isEqualTo(2);
 }
 ```
  * 상속 관계
    * 부모 타입으로 조회하면, 자식 타입도 함께 조회한다.
    * 그래서 모든 자바 객체의 최고 부모인 Object 타입으로 조회하면, 모든 스피링 빈을 조회한다.
    
 ```JAVA
 @Test
 @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 중복 오류가 발생한다")
 void findBeanByParentTypeDuplicate() {
    //DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
    assertThrows(NoUniqueBeanDefinitionException.class, () -> c.getBean(DiscountPolicy.class));
 }
 
 @Test
 @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다")
 void findBeanByParentTypeBeanName() {
    DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", iscountPolicy.class);
    assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
 }
 
 @Test
 @DisplayName("특정 하위 타입으로 조회")
 void findBeanBySubType() {
    RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
    assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
 }
 
 @Test
 @DisplayName("부모 타입으로 모두 조회하기")
 void findAllBeanByParentType() {
    Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
    assertThat(beansOfType.size()).isEqualTo(2);
    for (String key : beansOfType.keySet()) {
      System.out.println("key = " + key + " value=" + beansOfType.get(key));
    }
 }
 
 @Test
 @DisplayName("부모 타입으로 모두 조회하기 - Object")
 void findAllBeanByObjectType() {
    Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
    for (String key : beansOfType.keySet()) {
        System.out.println("key = " + key + " value=" +
        beansOfType.get(key));
    }
 }
 ```
  * 실무에서 print로 출력물을 만들면 안된다.
  * 테스트 통과/실패 여부만 판단하도록 작성하는게 좋다.

 <h2> 3. BeanFactory와 ApplicationContext  </h2>
 
 <img width="401" alt="스프링22" src="https://user-images.githubusercontent.com/62021242/157295030-d20ce4bb-9e80-4fba-ab2c-e8c045f649ce.png">
 
 * BeanFactory
  * 스프링 컨테이너의 최상위 인터페이스
  * 빈을 관리하고 조회하는 역할을 담당
  * getBean()을 제공한다.

* ApplicationContext
  * BeanFactory 기능을 모두 상속받아서 제공한다.
 
* 둘의 차이
  * ApplicationContext는 여러 인터페이스를 상속받아서 국제화 기능, 환경변수, 등의 기능을 제공한다.
  
  <img width="402" alt="스프링23" src="https://user-images.githubusercontent.com/62021242/157295493-c3fda398-be13-4968-b36b-2473e5389e68.png">


---

<h2> 1. 다양한 설정 형식 지원 </h2>

<img width="402" alt="스프링24" src="https://user-images.githubusercontent.com/62021242/157295742-91344ae8-9e9d-47c0-9e8d-5cf3e73c4950.png">

* 지금까지는 AppConfig 팩토리 빈에서 @Bean을 통해 스프링 빈을 스프링 컨테이너에 등록하는 방식을 사용했다.

``` JAVA
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class)
```

* xml 설정 방식
  * GenericXmlApplicationContext를 사용하면서 xml 설정 파일을 넘기면 된다.
  
``` JAVA
  @Test
 void xmlAppContext() {
    ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
 
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    assertThat(memberService).isInstanceOf(MemberService.class);
 }
```

  * [appConfig.xml](/src/main/resources/appConfig.xml)
  * 잘 사용하지 않으므로 알아만 두자

<h2> 2. 스프링 빈 설정 메타 정보 - BeanDefinition </h2>

<img width="405" alt="스프링25" src="https://user-images.githubusercontent.com/62021242/157296906-b3f504be-6b93-45e5-9d32-9f6835fd1499.png">

* BeanDefinition이라는 추상화를 중심으로 다양한 설정 형식을 지원
* 쉽게 얘기해서 역할과 구현을 개념적으로 나눈 것이다.
  * XML을 읽어서 BeanDefinition을 만들면 된다.
  * 자바 코드를 읽어서 BeanDefinition을 만들면 된다.
  * 스프링 컨테이너는 자바 코드인지, XML인지 몰라도 된다. 오직 BeanDefinition만 알면 된다.
* BeanDefinition 을 빈 설정 메타정보라 한다.
  * @Bean , bean 당 각각 하나씩 메타 정보가 생성된다.
* 스프링 컨테이너는 이 메타정보를 기반으로 스프링 빈을 생성한다

<img width="403" alt="스프링26" src="https://user-images.githubusercontent.com/62021242/157297604-8e746495-214b-476e-83a9-7bcb5ee095e3.png">

---

<h2> 1. 웹 애플리케이션과 싱글톤 컨테이너 </h2>

* 싱글톤 패턴
  * 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴이다.
  * 객체 인스턴스가 2개 이상 생성하지 못하도록 막아야 한다.
    * private 생성자를 사용해서 외부에서 임의로 new 키워드 사용하지 못하도록 막아야 한다.
   
``` JAVA
//1. static 영역에 객체를 딱 1개만 생성해둔다.
 private static final SingletonService instance = new SingletonService();
 //2. public으로 열어서 객체 인스터스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
 public static SingletonService getInstance() {
    return instance;
 }
 //3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
 private SingletonService() {
 }
 public void logic() {
    System.out.println("싱글톤 객체 로직 호출");
 }
 ```
 
* 1. static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.
* 2. 이 객체 인스턴스가 필요하면 오직 getInstance() 메서드를 통해서만 조회할 수 있다. 이 메서드를 호출하면 항상 같은 인스턴스를 반환한다.
* 3. 딱 1개의 객체 인스턴스만 존재해야 하므로, 생성자를 private으로 막아서 혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다.

``` JAVA
@Test
@DisplayName("싱글톤 패턴을 적용한 객체 사용")
public void singletonServiceTest() {
 //private으로 생성자를 막아두었다. 컴파일 오류가 발생한다.
 //new SingletonService();
 //1. 조회: 호출할 때 마다 같은 객체를 반환
 SingletonService singletonService1 = SingletonService.getInstance();
 
 //2. 조회: 호출할 때 마다 같은 객체를 반환
 SingletonService singletonService2 = SingletonService.getInstance();
 
 //참조값이 같은 것을 확인
 System.out.println("singletonService1 = " + singletonService1);
 System.out.println("singletonService2 = " + singletonService2);
 
 // singletonService1 == singletonService2
 assertThat(singletonService1).isSameAs(singletonService2);
 singletonService1.logic();
}
```

* private으로 new 차단
* 호출할 때마다 같은 객체 인스턴스 반환 확인 가능
* 싱글턴 패턴의 문제점
  * 싱글톤 패턴을 구현하는 코드 자체가 많이 들어간다.
  * 의존관계상 클라이언트가 구체 클래스에 의존한다. DIP를 위반한다.
  * 클라이언트가 구체 클래스에 의존해서 OCP 원칙을 위반할 가능성이 높다.
  * 테스트하기 어렵다.
  * 내부 속성을 변경하거나 초기화 하기 어렵다.
  * private 생성자로 자식 클래스를 만들기 어렵다.
  * 결론적으로 유연성이 떨어진다.
  * 안티패턴으로 불리기도 한다.

<h2> 2. 싱글톤 컨테이너 </h2>

* 스프링 컨테이너는 싱글톤 패턴의 문제점을 해결하면서, 싱글턴 패턴을 적용하지 않아도, 객체 인스턴스를 싱글톤으로 관리한다.
* 스프링 컨테이너는 싱글톤 컨테이너의 역할을 한다. 싱글톤 객체를 생성하고 관리하는 기능을 싱글톤 레지스트리라 한다.
* 스프링 컨테이너를 사용하는 테스트 코드

``` JAVA
@Test
@DisplayName("스프링 컨테이너와 싱글톤")
void springContainer() {
 ApplicationContext ac = new
AnnotationConfigApplicationContext(AppConfig.class);
 //1. 조회: 호출할 때 마다 같은 객체를 반환
 MemberService memberService1 = ac.getBean("memberService",
MemberService.class);
 //2. 조회: 호출할 때 마다 같은 객체를 반환
 MemberService memberService2 = ac.getBean("memberService",
MemberService.class);
 //참조값이 같은 것을 확인
 System.out.println("memberService1 = " + memberService1);
 System.out.println("memberService2 = " + memberService2);
 //memberService1 == memberService2
 assertThat(memberService1).isSameAs(memberService2);
}
```

* 싱글톤 컨테이너 적용 후

<img width="304" alt="스프링28" src="https://user-images.githubusercontent.com/62021242/157299688-7ffad51a-7279-43ac-af09-5aeae156b430.png">

* 이미 만들어진 객체를 공유해서 효율적으로 재사용할 수 있다.
* 싱글톤 방식의 주의점
  * 싱글톤 패턴이든, 스프링 같은 싱글톤 컨테이너를 사용하든, 객체 인스턴스를 하나만 생성해서 공유하는 싱글톤 방식은 여러 클라이언트가 하나의 같은 객체 인스턴스를 공유하기 때문에 싱글톤 객체는 상태를 유지(stateful)하게 설계하면 안된다. 
  * 무상태(stateless)로 설계해야 한다!
    * 특정 클라이언트에 의존적인 필드가 있으면 안된다.
    * 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다!
    * 가급적 읽기만 가능해야 한다.
    * 필드 대신에 자바에서 공유되지 않는, 지역변수, 파라미터, ThreadLocal 등을 사용해야 한다.
* 스프링 빈의 필드에 공유 값을 설정하면 정말 큰 장애가 발생할 수 있다!!!

* 상태를 유지할 경우 발생하는 문제점 예시

```JAVA

 private int price; //상태를 유지하는 필드
 
 public void order(String name, int price) {
    System.out.println("name = " + name + " price = " + price);
    this.price = price; //여기가 문제!
 }
 public int getPrice() {
     return price;
 }
```

```JAVA

@Test
 void statefulServiceSingleton() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
    StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);
    
    //ThreadA: A사용자 10000원 주문
    statefulService1.order("userA", 10000);
    //ThreadB: B사용자 20000원 주문
    statefulService2.order("userB", 20000);
 
    //ThreadA: 사용자A 주문 금액 조회
    int price = statefulService1.getPrice();
    //ThreadA: 사용자A는 10000원을 기대했지만, 기대와 다르게 20000원 출력
    System.out.println("price = " + price);
    Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
 }
 
 static class TestConfig {
    @Bean
    public StatefulService statefulService() {
      return new StatefulService();
    }
}
 ```
 
 * A사용자가 10000원 B사용자가 20000원 어치 주문할때 A의 주문금액이 20000원으로 나온다
 * StateSevice는 싱글톤 빈이니까 stateService1과 stateService2는 같은 객체이다.
 * 하나의 price 변수에 ThreadA와 ThreadB가 접근해서 값을 변경한 것이다.
 * 무상태로 바꾸기 위해서 공유되지 않는 지역변수, 파라미터, ThreadLocal등을 쓰자.
 * 금액을 return 값으로 넘기자.

``` JAVA
//private int price; //상태 유지 필드

    public int order(String name, int price)
    {
        System.out.println("name = " + name + " price = " + price);
        //this.price = price; //여기가 문제

        return price;
    }

    /*
    public int getPrice()
    {
        //return price;
    }
    */
```

<h2> 3. Configuration과 싱글톤 </h2>

``` JAVA
@Configuration
public class AppConfig {
 @Bean
 public MemberService memberService() {
 return new MemberServiceImpl(memberRepository());
 }
 @Bean
 public OrderService orderService() {
 return new OrderServiceImpl(
 memberRepository(),
 discountPolicy());
 }
 @Bean
 public MemberRepository memberRepository() {
 return new MemoryMemberRepository();
 }
 ...
}
```

* memberService 빈을 만드는 코드를 보면 memberRepository()를 호출한다.
  * 이 메서드를 호출하면 new MemoryMemberRepository()를 호출한다.
* orderService 빈을 만드는 코드로 동일하게 memberRepository()를 호출한다.
  * 이 메서드를 호출하면 new MemoryMemberRepository()를 호출한다.
* MemoryMemberRepository가 2개 생성되면서 글톤이 깨지는 것 처럼 보인다. 하지만 확인해보면 MemoryMemberRepository 인스턴스는 모두 같은 인스턴스가 공유되어 사용된다.

``` JAVA
@Test
 void configurationTest() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    
    MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
    OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
    MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
    
    //모두 같은 인스턴스를 참고하고 있다.
    System.out.println("memberService -> memberRepository = " + memberService.getMemberRepository());
    System.out.println("orderService -> memberRepository = " + orderService.getMemberRepository());
    System.out.println("memberRepository = " + memberRepository);
    
    //모두 같은 인스턴스를 참고하고 있다.
    assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
    assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
 }
```

* [appConfig](/src/main/java/hello/core/AppConfig.java)에서 보게되면 memberRepository()는 3번 호출되는 것 같지만 확인해보면 모두 1번만 호출된다.

<h2> 4. @Configuration과 바이트코드 </h2>

* 스프링 컨테이너는 싱글톤 레지스트리다. 따라서 스프링 빈이 싱글톤이 되도록 보장해주어야 한다. 그런데 스프링이 자바 코드까지 어떻게 하기는 어렵다. 저 자바 코드를 보면 분명 3번 호출되어야 하는 것이 맞다. 그래서 스프링은 클래스의 바이트코드를 조작하는 라이브러리를 사용한다.

``` JAVA
@Test
void configurationDeep() {
 ApplicationContext ac = new
AnnotationConfigApplicationContext(AppConfig.class);
 //AppConfig도 스프링 빈으로 등록된다.
 AppConfig bean = ac.getBean(AppConfig.class);
 
 System.out.println("bean = " + bean.getClass());
 //출력: bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$bd479d70
}
```

* 순수한 클래스라면 class hello.core.AppConfig가 출력되어야 하겟지만, @Configuration을 적용한 AppConfig는 CGLIB라는 바이트 코드 조작 라이브러리를 사용해서 AppConfig 클래스를 상속받은 임의의 다른 클래스를 만들고, 그 다른 클래스를 스프링 빈으로 등록한다.

<img width="402" alt="스프링29" src="https://user-images.githubusercontent.com/62021242/157302838-4b4b0db0-b2f0-44c8-978f-f44ca470ac3f.png">

* 그 임의의 다른 클래스가 바로 싱글톤이 보장되도록 해준다.
* @Bean이 붙은 메서드 마다 이미 스프링 빈이 존재하면 존재하는 빈을 반환하고, 스프링 빈이 없으면 생성해서 스프링 빈으로 등록하고 반환하는 코드가 동적으로 만들어진다.
* @Bean만 사용시 싱글톤을 보장하지 않는다.

---

<h2> 1. 컴포넌트 스캔과 의존관계 자동 주입 </h2>

* 스프링에서는 스프링 설정 정보 없이도 자동으로 스프링 빈을 등록하는 컴포넌트 스캔이라느 기능을 재공한다.
* 의존관계도 자동으로 주입하는 @Autowired라는 기능도 제공한다.

``` JAVA
@Configuration
@ComponentScan(
 excludeFilters = @Filter(type = FilterType.ANNOTATION, classes =
Configuration.class))
public class AutoAppConfig {
 
}
```

* 컴포넌트 스캔을 사용하려면 @ComponentScan을 설정 정보에 붙여주면 된다.
* 컴포넌트 스캔을 사용하면 @Configuration이 붙은 설정 정보도 자동으로 등록되기 때문에 AppConfig, TestConfig 등 앞서 만들어두었던 설정 정보도 함께 등록되고, 실행되어 버린다. 그래서 excludeFilters 를 이용해서 설정정보는 컴포넌트 스캔 대상에서 제외했다. 보통 설정 정보를 컴포넌트 스캔 대상에서 제외하지는 않지만, 기존 예제 코드를 최대한 남기고 유지하기 위해서 이 방법을 선택했다.
* Component가 붙은 클래스를 스캔해서 스프링 빈으로 등록한다.

``` JAVA
@Component
public class MemoryMemberRepository implements MemberRepository {}

@Component
public class RateDiscountPolicy implements DiscountPolicy {}

@Component
public class MemberServiceImpl implements MemberService {
 private final MemberRepository memberRepository;
 @Autowired
 public MemberServiceImpl(MemberRepository memberRepository) {
 this.memberRepository = memberRepository;
 }
}
```

* @Autowired를 붙여서 자동으로 의존관계를 주입한다.

* 컴포넌트 스캔과 자동 의존관계 주입의 동작 방법

    <img width="404" alt="스프링30" src="https://user-images.githubusercontent.com/62021242/157309255-c77437e6-9a8a-4b70-9b11-9e82a35dbe70.png">
    
    * @ComponentScan은 @Component가 붙은 모든 클래시를 스프링 빈으로 등록한다.
    * 스프링 빈의 기본 이름은 클래스명을 사용하되 맨 앞글자만 소문자를 사용한다.
      * MemberServiceImpl -> memberServiceImpl
      * @Component("memberService2") 직접 지정 방식

     <img width="404" alt="스프링31" src="https://user-images.githubusercontent.com/62021242/157309652-178cc0a7-8e85-4bab-a465-9d96def26a24.png">
     
    * 생성자에 @Autowired를 지정하면, 스프링 컨테이너가 자동으로 해당 스프링 빈을 찾아서 주입한다.
    * 기본 조회 전략은 타입이 같은 빈을 찾아서 주입한다.
      * getBean(MemberRepository.class)와 동일하다고 이해

    
<h2> 2. 탐색 위치와 기본 스캔 대상 </h2>

* 탐색 시작 위치를 지정할 수 있다.

``` JAVA
@ComponentScan(
 basePackages = "hello.core",
}
```

* basePackages로 패키지의 시작 위치를 지정한다. {"", ""} 여러 시작 위치를 지정할 수도 있다.
* basePackageClasses는 지정한 클래스의 패키지를 탐색 시작 위치로 지정한다.
* 지정하지 않으면 @ComponentScan이 붙은 클래스의 패키지가 시작 위치
* 권장하는 방법 : 시작 위치를 지정하지 않고 최상단에 두는 것.

* 컴포넌트 스캔 기본 대상
  * @Component : 컴포넌트 스캔에 사용
  * @Controller : 스프링 MVC 컨트롤러에서 사용, MVC 컨트롤러로 인식
  * @Service : 스프링 비지니스 로직에서 사용, 개발자들이 핵심 비즈니스 로직이 여기에 있겟구나 라고 인식에 도움을 준다
  * @Repository : 스프링 데이터 접근 계층에서 사용, 스프링 데이터 접근 계층으로 인식하고, 데이터 계층의 예외를 스프링 예외로 변환해준다.
  * @Configuration : 스프링 설정 정보에서 사용, 스프링 설정 정보로 인식하고, 스프링 빈이 싱글톤을 유지하도록 추가 처리를 한다.

<h2> 3. 필터 </h2>

* includeFilters : 컴포넌트 스캔 대상을 추가로 지정한다.
* excludeFilters : 컴포넌스 스캔에서 제외할 대상을 지정한다.


* 컴포넌트 스캔 대상에 추가할 애노테이션

``` JAVA
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
```
* 컴포넌트 스캔 대상에 제외할 애노테이션

```JAVA
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
```

* 컴포넌트 스캔 대상에 추가할 클래스

``` JAVA
@MyIncludeComponent
public class BeanA {
}
```

* 컴포넌트 스캔 대상에서 제외할 클래스

``` JAVA
@MyExcludeComponent
public class BeanB {
}
```

* 전체 테스트 코드

``` JAVA
@Test
 void filterScan() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
    BeanA beanA = ac.getBean("beanA", BeanA.class);
    assertThat(beanA).isNotNull();
    Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("beanB", BeanB.class));
 }
 @Configuration
 @ComponentScan(
 includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
 excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class))
 static class ComponentFilterAppConfig {
 }
 ```
 
 
