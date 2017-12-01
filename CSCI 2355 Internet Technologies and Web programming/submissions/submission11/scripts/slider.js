var imgSrcArr = [
  "./images/managed_it_services.jpg",
  "./images/madevelop.png",
  "./images/c-software.png",
  "./images/871.png",
  "./images/managed-services-image.jpg",
  "./images/working-on-tablet.png"
];

var i = 0;
slider = document.getElementById("slider");

setInterval(function () {
  slider.src = imgSrcArr[i];
  if (i < imgSrcArr.length - 1) {
    i++;
  } else {
    i = 0;
  }
}, 3000);