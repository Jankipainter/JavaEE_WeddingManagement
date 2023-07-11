function findAddress() {
    var address = document.querySelector("#address");
    var result = document.querySelector("#result");

    function showAddress() {
        result.innerHTML = "";
        if (addressArr.length > 0) {
            addressArr.forEach((element) => {
                result.innerHTML +=
                        "<div class='results'>" +
                        element.display_name +
                        "<br> Latitude :" +
                        element.lat +
                        "<br> Longitude :" +
                        element.lon +
                        "<hr>";
                "</div>";
            });
        } else {
            result.innerHTML = "<h2 style='color: red'>Not Found</h2>"
        }
    }


    function showLocation()
    {

        var mapProp = {
            center: new google.maps.LatLng(addressArr[0].lat, addressArr[0].lon),
            zoom: 5,
        };
        var map = new google.maps.Map(document.getElementById("map"), mapProp);
//    if(navigator.geolocation)
//    {
//        navigator.geolocation.getCurrentPosition(addressArr[0].lat,addressArr[0].lon);
//    }
    }


    var url =
            "https://nominatim.openstreetmap.org/search?format=json&limit=1&q=" + address.value;



    fetch(url)
            .then((response) => response.json())
            .then((data) => (addressArr = data))
            .then((show) => showAddress())
            .catch((err) => console.log(err));
}



