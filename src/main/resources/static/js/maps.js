function iniciarMap(){
    var coord = {lat:2.7806684666124224 ,lng: -75.26330832534603};
    var map = new google.maps.Map(document.getElementById('map'),{
      zoom: 18,
      center: coord
    });
    var marker = new google.maps.Marker({
      position: coord,
      map: map
    });
}