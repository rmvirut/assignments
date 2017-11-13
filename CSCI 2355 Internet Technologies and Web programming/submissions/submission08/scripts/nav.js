var subMenus = document.getElementsByClassName("sub-menu");

function showSubMenu(itemID) {
    sm = document.getElementById(itemID);
    sm.style.display = "inline-flex";
}

function hide(itemID) {
    sm = document.getElementById(itemID);
    sm.style.display = "none";
}

for (var i = 0; i < subMenus.length; i++) {
    subMenus[i].addEventListener("mouseout", hide(subMenus[i].id));
}