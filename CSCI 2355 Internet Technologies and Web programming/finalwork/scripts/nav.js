//navbar submenues dropdown
var subMenus = document.getElementsByClassName("sub-menu");

/**
 *
 */
function showSubMenu(itemID) {
  sm = document.getElementById(itemID);
  sm.style.display = "inline-flex";
}


for (var i = 0; i < subMenus.length; i++) {
  subMenus[i].addEventListener("mouseout", hide(subMenus[i].id));
}

//current time
function time() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var t = getElementById("time");
      t.innerHTML = this.responseText;
    }
  }
  xhttp.open('GET', './scripts/time.php', true);
  xhttp.send();
}

time();
setInterval(time, 60000);
