# ✈️ Expedia Clone Coding

- __Table of Contents__
  - [팀 ](#)

## 🚀 프로젝트 사용기술

- Kotlin, Java
- Spring Boot, Spring Security, Spring webflux, Spring Cloud
- Spring Data JPA
- PostgreSQL, MySQL
- Kafka, gRPC

## 🚀 소개

- 익스피디아 클론 코딩
- 백엔드 설계에 집중하기 위해 프론트 UI 는 카카오 오븐을 이용한 프로토 타이핑으로 대체함

## 🚀 전체 프로젝트의 구조

- __Gradle Multi module__
  - 루트 모듈은 expedia-server 와 platform-server 로 나뉘어져있으며 각 모듈 아래 서브 모듈들이 존재하는 형태

> 아키텍처 이미지를 넣어주세요.

## 🚀 팀 컨벤션

- __Style Guide__
  - Kotlin - [Coding conventions Kotlin](https://kotlinlang.org/docs/coding-conventions.html)
  - Java - [Google Java Coding Style Guide](https://google.github.io/styleguide/javaguide.html)
- __Test: 기본 틀은 아래와 같으며 본인이 편한 방향에 따라서 작업 가능__
  1. 시나리오를 기반으로 실패하는 인수테스트를 작성(fail-acceptance)
  2. 문서화 테스트를 작성(documentation)
  3. 실패하는 테스트 케이스 작성(fail-unittest)
  4. 테스트 케이스를 통과시키기 위한 도메인 로직 작성 (production)
  5. 테스트 케이스 성공 시키고(success-unittest)
  6. 인수테스트를 성공 시키기(success-acceptance)
- __Package: Layered Architectures__
  - 패키지간 의존성 방향을 한 곳으로 흐르게끔 설계

## Rule

- __Language__
  - Kotlin or Java
- __Style Guide__
  - Kotlin - [Coding conventions Kotlin](https://kotlinlang.org/docs/coding-conventions.html)
  - Java - [Google Java Coding Style Guide](https://google.github.io/styleguide/javaguide.html)
- __ORM__
  - Spring Data JPA
- __Clean Code 를 지향__
- __모든 기능에 대해 Test Case 를 작성__ 
  - Coverage 80% 이상 목표
  - Test 작성 방법론은 `TDD + ATDD` 사용
  - 문서화 테스트 필수
  - Test 메서드 명은 한글로 작성
  - 인수 테스트 작성 필수 
- __DDD 를 지향__
- __패키지 구성__
  - 3 layer architecture 지향
  - interfaces, application, domain, infrastructure
  - 패키지간 의존성 방향을 한 곳으로 흐르게끔 설계

  
### Package

> DDD 지향

- __interfaces__
  - 사용자에게 정보를 보여주고 사용자의 명령을 해석하는 일을 책임진다.
  - DTO, Mapper, Controller
- __application__
  - 수행할 작업을 정의하고 표현력 있는 도메인 객체가 문제를 해결하게 한다. 이 계층에서 책임지는 작업은 업무상 중요하거나 다른 시스템의 응용 계층과 상호 작용하는 데 필요한 것들이다. 이 계층은 얇게 유지되고, 오직 작업을 조정하고 아래에 위치한 계층에 포함된 도메인 객체의 협력자에게 작업을 위임한다.
  - xxxFacade
- __domain__
  - 업무 개념과 업무 상황에 대한 정보, 업무 규칙을 표현하는 일을 책임진다.
  - Service, Command, Query, Entity
- __infrastructure__
  - 상위 계층을 지원하는 일반화된 기술적 기능을 제공한다.
  - RedisConnector, Low level 구현체  

## VCS

- __Git 전략은 Forking Workflow 방식을 채용한다.__
  - Github Open Source Contribute 방식(Forking Workflow)을 채용한다.
  - 개인 저장소로 Fork 후 진행
  - 모든 작업을 진행하기 전에(브랜치 생성하기 전)에 이슈를 먼저 생성해야 한다.
- __Remote 저장소의 Merge 는 “반드시 `코드 리뷰`가 진행되어야 한다.”__
  - 코드 리뷰 없이 Merge 는 없다.
- __이슈 관리는 Github 기능을 활용한다.__
  - 모든 작업을 진행하기 전에(브랜치 생성하기 전)에 이슈를 먼저 생성해야 한다.
  - __Label__
    - codereview: code review
    - hotfix: bug fix
    - docs: documentations
    - enhance: new feature or request
    - discussion: Discussion
- __Branch__
  - `feature/이슈번호`
  - 모든 작업한 feature 브랜치는 Merge 후에도 삭제하지 않는다.
- __Commit Message Template__
  - init
  - feature
  - hotfix
  - refactor
  - docs
  - chore
  - ```
    feature: 숙박 후기 기능
    line break
    내용 작성
    ```

## Step

> 각 단계를 거칠 수록 비지니스 로직의 깊이가 깊어진다.

- __V1: Rest Call__
  - 사용자 위주의 구현
  - 비지니스 로직의 깊이 최대한 얇게
- __V2: Event Driven__
  - 내부 서비스간의 호출은 gRPC 사용
  - Kafka 활용 
- __V3: async__
  - 동기 코드를 비동기 코드로 전환
  - Spring Webflux + Coroutines 사용
- __V4: Spring cloud__
  - Spring Cloud 적용 하기
  
### Version 1 - Architctures

#### Login 

![login](https://user-images.githubusercontent.com/47518272/193559220-d2ecb1dd-c410-4eb4-a355-46349deccc45.png)

- Redis 에 RefreshToken 

#### 주문 생성 요청

![simple-v1-create-order-not-payment](https://user-images.githubusercontent.com/47518272/193560539-d3236537-7b1c-403f-9e8a-98b34a57320b.png)

- 결제 서비스 미적용
