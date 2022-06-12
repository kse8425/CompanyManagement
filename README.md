# Company Management

거래처와 제품, 주문을 관리하고, 주문 데이터를 기반으로 매출을 차트로 보여주는 웹사이트입니다.   
근무하던 회사에서 사용하고 있는 엑셀 문서를 기준으로 만들었습니다.  
사용하기에는 부족한 면이 많지만 학습한 내용을 적용한 개인 프로젝트 입니다.

## 사용한 기술

- Spring을 이용한 MVC 패턴
- RESTful 설계 및 구현(Get,Post,Put,Delete)
- Ajax로 수정,삭제 기능

## 개발 환경

- 언어 : Java, HTML, CSS, JavaScript
- 프레임워크 : Spring
- DB : MariaDB
- 서버 : AWS EC2, RDS
- IDE : IntelliJ, VS code

## 페이지

- DashBoard
- Companies
- Products
- Orders

## 기능

- DashBoard
    - 일년간 월별 매출을 그래프로 표현합니다.
    - 월간, 주간 성장률과 매출 출력합니다.
    - 월중 최고 매출 제품과 회사를 출력합니다.


- Companies,Products,Orders
    - 거래처(Companies),제품(Products),주문(Orders) 페이지마다 등록,조회,수정,삭제 기능이 있습니다.

## 개선점
- Unit test case 추가와 리펙토링을 하고 싶습니다.
- 주문(Order) 등록시 기존에 등록되어 있는 고객사와 제품을 추천하는 검색어 추천 기능을 구현하고 싶습니다.
