# Expedia Clone Coding

> 익스피디아 그룹(영어: Expedia Group)는 주로 호텔 · 항공권 등 여행에 관한 온라인 예약 처리, 웹사이트 및 응용 프로그램을 개발하여 서비스하고 있는 기업으로 같은 이름의 온라인 여행사 (Online Travel Agency, OTA) 사이트를 운영하고 있다.

## Table of Contents

- [MVP](https://github.com/cIonecoder/expedia/wiki/MVP)
- [Rule](https://github.com/cIonecoder/expedia/issues/1)
- [MSA](https://github.com/cIonecoder/expedia/issues/1)
- Flow

## Micro Service Archtictures

- __authentication-service__
  - Kotlin, Spring Data JPA
- __authorization-service__
  - Kotlin, Spring Data JPA
- __b2b-service__
  - Kotlin, Java, Spring Data JPA
- __b2c-service__
  - Kotlin, Java, Spring Data JPA
- __payment-service__ 
  - Kotlin, Java, Spring Data JPA
- __booking-service__
  - Kotlin, Spring Data JPA
  
## Plan

- STEP-1
  - 인증(JWT, Redis)
  - 숙박(상품, 주문)
