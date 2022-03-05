# Spring_Theory_Basic
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
