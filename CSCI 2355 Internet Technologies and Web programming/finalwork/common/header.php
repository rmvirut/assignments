<!-- header.php -->

<header>
  <div id="head-container">
    <a href="./my_business.php"> <img class="page-banner"
                                      src="./images/banner.png"
                                      alt="diji domain company banner"/></a>
    <div id="time">
      Monday, May 8th<br> Our time right now is 4:15pm
    </div>
  </div>
  <nav id="navbar" onmouseout="">
    <li class="nav-item"><a href="my_business.php">Home</a></li>
    <li class="nav-item" onmouseover="showSubMenu('sm1')"
        onmouseout="hide('sm1')">
      <a href="./pages/services.php">Services</a>
      <ul class="sub-menu" id="sm1">
        <li class="nav-item sidebar-item"><a
              href="./pages/software-catalogue.php">Software Catalogue</a></li>
        <li class="nav-item sidebar-item"><a href="./pages/dijidevs.php">Diji
            Devs</a></li>
      </ul>
    </li>

    <li class="nav-item" onmouseover="showSubMenu('sm5')"
        onmouseout="hide('sm5')">
      <a href="./pages/merch-store.php" style="cursor:pointer;">E-Store</a>
      <ul class="sub-menu" id="sm5">
        <li><a href="./pages/merch-store.php">Products Catalogue</a></li>
      </ul>
    </li>

    <li class="nav-item" onmouseover="showSubMenu('sm2')"
        onmouseout="hide('sm2')">
      <a href="./pages/your-business.php">Your Business</a>
      <ul class="sub-menu" id="sm2">
        <li><a href="./pages/get-quote.php">Get a quote</a></li>
      </ul>
    </li>
    <li class="nav-item" onmouseover="showSubMenu('sm3')"
        onmouseout="hide('sm3')"><a href="./pages/about-us.php">
        About Us</a>
      <ul class="sub-menu" id="sm3">
        <li class="nav-item sidebar-item"><a href="./pages/our-story.php">Our
            Story</a></li>
        <li class="nav-item sidebar-item"><a href="./pages/our-values.php">Our
            Mission &amp; Values</a></li>
        <li class="nav-item sidebar-item"><a href="./pages/faq.php">FAQ</a></li>
      </ul>
    </li>
    <li class="nav-item" onmouseover="showSubMenu('sm4')"
        onmouseout="hide('sm4')"><a href="./pages/contact-us.php">
        Contact
        Us</a>
      <ul class="sub-menu" id="sm4">
        <li class="nav-item sidebar-item"><a href="./pages/locations.php">Locations</a>
        </li>
        <li class="nav-item sidebar-item"><a href="./pages/customer-care.php">Provide
            Feedback</a></li>
      </ul>
    </li>
    <li class="nav-item"><a href="./pages/sitemap.php">Site Map</a></li>
  </nav>
</header>
