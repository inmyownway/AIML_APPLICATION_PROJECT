### 홍익대학교 컴퓨터공학과 2022 AIML APPLICATION PROJECT
22.03 ~ 22.11
***


# 홍대생의 카도
사용자가 홍대 주변에서 ‘카공’을 위한 카페를 선택하고자 할 때 도움을 주는 서비스입니다. ‘카공’ 적합성을 판단하는 기준이 될 수 있는 대표적인 키워드들을 선정하고, 크롤링으로 수집한 인터넷 상의 리뷰 데이터를 BERT 기반 자연어 처리 모델을 이용하여 해당 키워드들을 기준으로 가공한 결과물을 웹 서비스 형태로 사용자에게 제공합니다.


***


## Team Members 
|박정민|김다인|이채정|
|:--------------------:|:--------------------:|:--------------------:|
|<img src = "https://avatars.githubusercontent.com/u/90558247?v=4" width = "100" height = "100">|<img src = "https://avatars.githubusercontent.com/u/107914598?s=400&v=4" width = "100" height = "100">|<img src = "https://avatars.githubusercontent.com/u/107914598?s=400&v=4" width = "100" height = "100">
|[@inmyownway](https://github.com/inmyownway)|[@dynene](https://github.com/dynene)|[@ChocoPic](https://github.com/ChocoPic)|



***


## Build and Execution manual
### 실행 방법
1. IntelliJ 또는 기타 IDE로 Build.gradle 파일을 실행 후 DemoApplication 을 실행합니다.

<img src="https://user-images.githubusercontent.com/90558247/207782476-8d594c3e-bd27-42c3-9682-4f2cb59c3aef.png"  width = "300" height = "200">

<img src="https://user-images.githubusercontent.com/90558247/207782731-fbb972c4-00d5-4c01-a7e1-3e4f1825bcc6.png"  width = "400" height = "100">

2. http://localhost:8080/ 에 접속하여 확인 가능합니다.

3. 데이터베이스는 AWS RDS 원격 DB을 사용하여 기본으로 연결되어 있습니다. 

***

### 서비스 설명
1. 메인 화면
메인 화면에서는 홍대 주변의 카페들의 위치와 사용자의 현 위치를 지도에 표시하여 보여줍니다. 각 카페의 마커를 클릭하면, 해당 카페의 정보와 총 리뷰의 개수, 각 키워드 관련 리뷰 개수를 볼 수 있습니다. 사용자는 총 리뷰 개수와 카공 키워드 관련 리뷰 개수를 비교하여 원하는 카페를 선택하는 데에 도움을 받을 수 있습니다.
<img src="https://user-images.githubusercontent.com/90558247/207772894-374f17cf-1e65-41f0-adac-86fb3dd5ede1.png"  width = "300" height = "600">

2. 상세 정보 화면
해당 카페에 대해 더 자세히 알고 싶은 경우, 우측 하단의 더보기 버튼을 누르면 키워드별 대표 문장과 카페에 대한 자세한 정보를 확인할 수 있습니다. 
<img src="https://user-images.githubusercontent.com/90558247/207787426-4841875c-8d6f-45d0-ba19-92dcbf67bea4.png" width = "300" height = "600">

3. 검색 화면
사용자는 검색어 입력 또는 선호하는 키워드 선택을 통해 자신이 원하는 카페의 정보를 선택적으로 얻을 수 있습니다.
<img src="https://user-images.githubusercontent.com/90558247/207773545-3eb17a6e-1121-45eb-b366-c67bb93f7a2c.png" width = "300" height = "600">

4. 검색 결과 화면
검색어를 통해 카페를 이름으로 검색할 수 있고, 원하는 카공 키워드를 선택하여, 해당 키워드가 리뷰에서 일정 비율 이상 언급된 카페들을 모아 볼 수 있습니다.
<img src="https://user-images.githubusercontent.com/90558247/207773662-4c2ec462-d6ad-4b20-a59d-529d44eee370.png" width = "300" height = "600">

