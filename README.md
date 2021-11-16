# Company Management

고객사와 제품, 주문을 관리하고, 주문 데이터를 기반으로 매출을 차트로 보여주는 웹사이트입니다.  
실제 사용하고 있는 엑셀 문서에서 발생하는 어마어마한 중복을 효율적으로 관리하기 위해서 웹에서 구현해봤습니다.  
사용하기에는 부족한 면이 많지만 학습한 내용을 적용해 보고자 만든 토이 프로젝트 입니다. 

## 목적

- Spring으로 MVC 패턴 구현
- RESTful 설계 및 구현(Get,Post,Delete)
- Ajax로 JSON 요청, 응답 구현

## 페이지

- DashBoard
- Companies
- Products
- Orders

## 기능

- DashBoard
    - 일년간 월별 매출을 그래프로 표현합니다.
    - 월간, 주간 성장률과 매출 게시합니다.

- Companies,Products,Orders
    - 고객사(Companies),제품(Products),주문(Orders) 페이지마다 등록,조회,삭제 기능이 있습니다.

## 개발 환경

- 언어 : Java, HTML, CSS, JavaScript
- 프레임워크 : Spring
- DB : MariaDB
- 서버 : AWS EC2, RDS
- IDE : IntelliJ, VS code

## 개선점
- HTTP method PUT를 사용해 수정 기능을 추가 싶습니다.
- Unit test case 추가와 리펙토링을 하고 싶습니다.
- 주문(Order) 등록시 기존에 등록되어 있는 고객사와 제품을 추천하는 검색어 추천 기능을 구현하고 싶습니다.
