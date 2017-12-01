<?php
    include("../common/document_head.php")
?>

<body>
   	<?php
    include("../common/header.php")
?>
    <main>
        <aside class="sidebar">
            <nav>
                <ul>
                    <li class="nav-item sidebar-item"><a href="./pages/software-catalogue.php">Software Catalogue</a></li>
                    <li class="nav-item sidebar-item"><a href="./pages/dijidevs.php">Diji Devs</a></li>
                </ul>
            </nav>
        </aside>
        <article class="article-w-sidebar">
            <div id="text">
                <h1 class="page-title">Products and Services</h1>
                <p>
                    We cover a wide range of services for our clients from consulting and advising to purchase and implementation of solutions. Below is a detailed list of everything we can do for you:
                </p>

                <ul class="column">
                    <li>
                        <!--start business and it infra. list-->
                        <h4>Business IT Infrastructure</h4>
                        <ul>
                            <!--office administration sublist-->
                            <li>Office and Administration
                                <ul>
                                    <li>Office Collaboration Software</li>
                                    <li>Human Resource Management Software</li>
                                    <li>Security and maintenance</li>
                                    <li>Cloud services</li>
                                    <li>Asset Procurement and Tracking</li>
                                    <li>End-user support</li>
                                </ul>
                            </li>

                            <!--retailers and marketers sublist-->
                            <li>Retailers and Marketers
                                <ul>
                                    <li>Point-of-Sales (POS) Systems</li>
                                    <li>Inventory Management</li>
                                    <li>Content Management Systems</li>
                                    <li>Accounting</li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <!--end business and it infra list-->
                    <li>
                        <!-- repair service list-->
                        <h4>Repair Center</h4>
                        <ul>
                            <li>Screen Repair/Replacement</li>
                            <li>Hardware Part replacement</li>
                            <li>Bugs/Error Troubleshooting</li>
                        </ul>
                    </li>
                    <!--end of repair service list-->
                </ul>
                <ul class="column">
                    <!--web development services list-->
                    <li>
                        <h4>Website and Web App Development</h4>
                        <ul>
                            <li>Web Design</li>
                            <li>Web Programming</li>
                            <li>Search Engine Optimization</li>
                            <li>Google Adwords Marketing</li>
                        </ul>
                    </li>
                    <!--end of web development-->
                    <li>
                        <!--start mobile applications list-->
                        <h4>Mobile Applications Development</h4>
                        <ul>
                            <li>Cross-platform applications</li>
                            <li>iOS Native applications</li>
                            <li>Android native applications</li>
                        </ul>
                    </li>
                    <!--end of mobile applications-->
                    <li>
                        <!--start networking list-->
                        <h4>Networking</h4>
                        <ul>
                            <li>Database systems and management</li>
                            <li>Enterprise Email Servers</li>
                            <li>Cloud Storage and Security</li>
                            <li>Collaboration and Conference</li>
                            <li>Data backup and Security</li>
                        </ul>
                    </li>
                    <!--end networking list-->
                </ul>
                <!--end product and services-->
            </div>
        </article>
    </main>
    <!--end product and services-->
    <?php
			include("../common/footer.php")
			?>
</body>

</html>