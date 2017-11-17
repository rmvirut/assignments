<?php
include("../common/document_head.html")
?>

<body>
<?php
include("../common/header.html")
?>
<main>
    <aside class="sidebar">
        <nav>
            <ul>
                <li class="nav-item sidebar-item"><a href="./pages/contact-us.php">Contact Us</a></li>
                <li class="nav-item sidebar-item"><a href="./pages/locations.php">Locations</a></li>
            </ul>
        </nav>
    </aside>
    <article class="article-w-sidebar">
        <div id="text">
            <h1 class="page-title">Customer Care</h1>
            <div class="form-container">
                <form id="feedback-form" onsubmit="validateForm()">
                    <h3>Product/service Feeback</h3>
                    <div class="form-field">
                        <label>Salutation: </label>
                        <select name="salute" id="salute">
                            <option>&nbsp;</option>
                            <option value="Mrs">Mrs.</option>
                            <option value="Ms">Ms.</option>
                            <option value="Mr">Mr.</option>
                        </select>
                    </div>
                    <div class="form-field">
                        <label for="fname">First Name:</label>
                        <input name="user" id="fname" type="text" placeholder="First name..." pattern="^[a-zA-Z-\s]+"
                               oninvalid="this.setCustomValidity('Please enter a valid name')" required/>
                    </div>
                    <div class="form-field">
                        <label for="lname">Last Name:</label>
                        <input name="user" id="lname" type="text" placeholder="Last name..." pattern="^[a-zA-Z-\s]+"
                               oninvalid="this.setCustomValidity('Please enter a valid name')" required/>
                    </div>
                    <div class="form-field">
                        <label for="userphone">Phone:</label>
                        <input type="tel" name="u-tel" id="userphone" placeholder="###-###-####"/>
                    </div>
                    <div class="form-field">
                        <label for="useremail">Email:</label>
                        <input name="email" type="email" id="useremail" placeholder="Email address..." required/>
                    </div>
                    <div class="form-field">
                        <label>Subject:</label>
                        <input id="subject" placeholder="Feedback subject">
                    </div>
                    <h5>Message</h5>
                    <textarea name="message" id="msg" rows="15" cols="50"></textarea>
                    <br>
                    <div>
                        <label for="reply" style="width: auto;">Please click here if you wish to receive a reply</label>
                        <input type="checkbox" name="reply" id="reply"/>
                    </div>
                    <div class="form-field">
                        <input type="submit" name="Submit Form" class="submit btn"/>
                        <input type="reset" name="Reset Fields" class="reset btn"/>
                    </div>
                </form>
            </div>
        </div>
    </article>
</main>
<?php
include("../common/footer.html")
?>
<script src="./scripts/feedbackForm.js"></script>
</body>

</html>
