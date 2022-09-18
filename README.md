# Expedia Clone Coding

## Table of Contents

- [MVP](https://github.com/cIonecoder/expedia/wiki/MVP)
- [Rule](https://github.com/cIonecoder/expedia/issues/1)
- [MSA](https://github.com/cIonecoder/expedia/issues/1)

## 개발

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

## 프로젝트 구조

> Gradle Multi module 로 구성

- __platform-server__
  - authentication-server
  - authorization-server
  - payment-server
  - message-server
- __expedia-server__
  - booking-server
  
### 패키지 구조

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

## Tests

```
-> 시나리오를 기반으로 실패하는 인수테스트를 작성(fail-acceptance)
-> 문서화 테스트를 작성(documentation)
-> 실패하는 테스트 케이스 작성(fail-unittest)
-> 테스트 케이스를 통과시키기 위한 도메인 로직 작성 (production)
-> 테스트 케이스 성공 시키고(success-unittest)
-> 인수테스트를 성공 시키기(success-acceptance)
```



