var cafeName = ["A", "B", "C"];
var cafeAddr = ["카페 A의 주소", "카페 B의 주소", "카페 C의 주소"];
var cafeKeyNum = [[11, 21, 31, 41, 51, 61], [12, 22, 32, 42, 52, 62], [13, 23, 33, 43, 53, 63]];
var cafeAKeySent = [
    ["A의 조용함 대표문장 1", "A의 조용함 대표문장 2", "A의 조용함 대표문장 3"],
    ["A의 공부하기좋은분위기 대표문장 1", "A의 공부하기좋은분위기 대표문장 2", "A의 공부하기좋은분위기 대표문장 3"],
    ["A의 콘센트이용 대표문장 1", "A의 콘센트이용 대표문장 2", "A의 콘센트이용 대표문장 3"]
];

//지도를 삽입할 HTML 요소 또는 HTML 요소의 id를 지정합니다.
var mapDiv = document.getElementById('map'); // 'map'으로 선언해도 동일

var map = new naver.maps.Map('map', {
    center: new naver.maps.LatLng(37.3595704, 127.105399),
    zoom: 10
});


/////////다중 마커 띄우기////////
var areaArr = new Array();
areaArr.push(
    {location: cafeName[0], lat: '37.4959854', lng: '127.0664091'},
    {location: cafeName[1], lat: '37.5492077', lng: '127.1464824'},
    {location: cafeName[2], lat: '37.6469954', lng: '127.0147158'},
);

let markers = new Array(); // 마커 정보를 담는 배열
let infoWindows = new Array(); // 정보창을 담는 배열

for (var i = 0; i < areaArr.length; i++) {
    // 지역을 담은 배열의 길이만큼 for문으로 마커와 정보창을 채워주자

    var marker = new naver.maps.Marker({
        map: map,
        title: areaArr[i].location, // 지역구 이름
        position: new naver.maps.LatLng(areaArr[i].lat, areaArr[i].lng) // 지역구의 위도 경도 넣기
    });

    var contentString = [
        '<div class="iw_inner">',
        '   <h3>' + cafeName[i] + '</h3>',
        '   <p>' + cafeAddr[i] + '<br />',
        '       조용함: ' + cafeKeyNum[i][0] + ' 공부하기좋은분위기: ' + cafeKeyNum[i][1] + ' 콘센트이용: ' + cafeKeyNum[i][2] + ' 책상편함: ' + cafeKeyNum[i][3] + ' 공간넓음: ' + cafeKeyNum[i][4] + ' 맛있음: ' + cafeKeyNum[i][5] + '<br />',
        '   </p>',
        '</div>'
    ].join('');

    /* 정보창 */
    var infoWindow = new naver.maps.InfoWindow({
        content: contentString
    }); // 클릭했을 때 띄워줄 정보 HTML 작성

    markers.push(marker); // 생성한 마커를 배열에 담는다.
    infoWindows.push(infoWindow); // 생성한 정보창을 배열에 담는다.
}

// $(function() {
//     initMap();
// });
//
// function initMap() {
//
// }

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