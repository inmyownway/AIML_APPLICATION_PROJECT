<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta charset="utf-8" pageEncoding="UTF-8"%/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Bare - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>

    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#">Link</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Page content-->
        <div class="container">
            <div class="text-center mt-5">
                <h1>홍대 카공하기좋은 카페 추천 웹</h1>
                <p class="lead">카페 클릭시 정보를 볼수있습니다.</p>
            </div>
        </div>
        </head>
        <head>
            <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=g5hxxpri54"></script>
            <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
            <meta charset="EUC-KR">
            <title>Insert title here</title>
        </head>

        <body>

        <div id="map" style="width:100%;height:75vh; margin: 0 auto; float : left"></div>

        </body>
        <script type="text/javascript">
            $(function() {

                initMap();

            });

            function initMap() {



                ///@@
                // var map = new naver.maps.Map('map', {
                //     center: new naver.maps.LatLng(37.552758094502494, 126.98732600494576),
                //     zoom: 15
                // });

                // var marker = new naver.maps.Marker({
                //     map: map,
                //     title: "남산서울타워",
                //     position: new naver.maps.LatLng(37.552758094502494, 126.98732600494576),
                //     icon: {
                //         content: '<img src="resources/img/chu1.png" alt="" style="margin: 0px; padding: 0px; border: 0px solid transparent; display: block; max-width: none; max-height: none; -webkit-user-select: none; position: absolute; width: 22px; height: 35px; left: 0px; top: 0px;">',                    size: new naver.maps.Size(32, 32),
                //         size: new naver.maps.Size(32, 32),
                //         anchor: new naver.maps.Point(16, 32)
                //     }
                // });
            }
        </script>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
    <script type="text/javascript">
        $(function() {

            initMap();

        });


        function initMap() {
            var areaArr = new Array();  // 지역을 담는 배열 ( 지역명/위도경도 )
            areaArr.push(
                /*지역구 이름*/			/*위도*/					/*경도*/
                {location : '스타벅스 홍대역8번출구점' , lat : '37.55602055992243' , lng : '126.922939675669061'},
                {location : '스타벅스 홍대공항철도역점' , lat : '37.55748838221418' , lng : '126.92519320428961'},
                {location : '엔젤리너스 L7홍대점' , lat : '37.55567500441952' , lng : '126.92153667791773 '},
                {location : '홍대 투썸플레이스' , lat : '37.558061977615345' , lng : '126.92395616899384'},
                {location : '커피빈 홍대역8번출구점' , lat: '37.556776463845345',lng: '126.92498737097256 '}

            );
            let markers = new Array(); // 마커 정보를 담는 배열
            let infoWindows = new Array(); // 정보창을 담는 배열

            var map = new naver.maps.Map('map', {
                center: new naver.maps.LatLng( 37.556020559922431,126.92293967566906),
                zoom: 18
            });

            // var marker = new naver.maps.Marker({
            //     map: map,
            //     title: "홍대 투썸플레이스",
            //     position: new naver.maps.LatLng(37.558061977615345, 126.92395616899384),
            //     icon: {
            //         content: '<img src="resources/img/chu1.png" alt="" style="margin: 0px; padding: 0px; border: 0px solid transparent; display: block; max-width: none; max-height: none; -webkit-user-select: none; position: absolute; width: 40px; height: 55px; left: 0px; top: 0px;">',                    size: new naver.maps.Size(32, 32),
            //         anchor: new naver.maps.Point(0, 0)
            //
            //     }
            // });

            /* 정보창 */
            cafe_list =[["엔젤리너스 L7홍대점","50","60","30"],["홍대 투썸플레이스","30","40","50"],["스타벅스 홍대공항철도역점","100","99","40"],["스타벅스 홍대역8번출구점","30","40","19"],["커피빈 홍대역8번출구점","50","60","70"]];

            for (var i = 0; i < areaArr.length; i++) {
                // 지역을 담은 배열의 길이만큼 for문으로 마커와 정보창을 채워주자 !

                var marker = new naver.maps.Marker({
                    map: map,
                    icon:{
                    content: '<img src="resources/img/chu1.png" alt="" style="margin: 0px; padding: 0px; border: 0px solid transparent; display: block; max-width: none; max-height: none; -webkit-user-select: none; position: absolute; width: 40px; height: 55px; left: 0px; top: 0px;">',
                        size: new naver.maps.Size(32, 32)
                },
                    title: areaArr[i].location, // 지역구 이름
                    position: new naver.maps.LatLng(areaArr[i].lat , areaArr[i].lng) // 지역구의 위도 경도 넣기
                });

                /* 정보창 */

                    for(var j=0;j<4;j++)
                    {
                        if (areaArr[i].location == cafe_list[j][0])
                        {
                            var temp1=cafe_list[j][1]
                            var temp2=cafe_list[j][2]
                            var temp3=cafe_list[j][3]
                        }
                    }


                var infoWindow = new naver.maps.InfoWindow({
                    anchorSize: new naver.maps.Size(-300, -400),
                content: '<div style="width:800px;text-align:center;padding:10px;"><b>' + areaArr[i].location + '</b>  <br> 조용함 : ' + temp1  +'<br> 콘센트이용 : ' +temp2 +'<br> 공부하기좋은 분위기 : ' +temp3+'  </div>'
                });


                // 클릭했을 때 띄워줄 정보 HTML 작성

                markers.push(marker); // 생성한 마커를 배열에 담는다.
                infoWindows.push(infoWindow); // 생성한 정보창을 배열에 담는다.
            }




            function getClickHandler(seq) {

                return function(e) {  // 마커를 클릭하는 부분
                    var marker = markers[seq], // 클릭한 마커의 시퀀스로 찾는다.
                        infoWindow = infoWindows[seq]; // 클릭한 마커의 시퀀스로 찾는다

                    if (infoWindow.getMap()) {
                        infoWindow.close();
                    } else {
                        infoWindow.open(map, marker); // 표출
                    }
                }
            }

            for (var i=0, ii=markers.length; i<ii; i++) {
                console.log(markers[i] , getClickHandler(i));
                naver.maps.Event.addListener(markers[i], 'click', getClickHandler(i)); // 클릭한 마커 핸들러
            }
        }

    </script>




</html>
