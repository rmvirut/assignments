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
            <h1 class="page-title">Web Request Form</h1>
            <p>To request a service from Diji Domain for you home or company, simply complete the form below and submit
                it. An agent will get in touch with you soon.</p>
            <div class="form-container">
                <form id="service-request-form">
                    <p>I'm a/an</p>
                    <div class="form-field">
                        <input type="radio" id="company" name="entity" onclick="showCompanyBlock()">
                        <label for="company">Company</label>
                        <input type="radio" id="individual" name="entity" onclick="showCompanyBlock()">
                        <label for="individual">Individual</label>
                    </div>
                    <fieldset id="comp-info">
                        <legend>Company Information</legend>
                        <div class="form-field">
                            <label for="com_name">Company Name:</label>
                            <input name="company name" type="text" id="com-name" placeholder="Name of your business"/>
                        </div>
                        <div class="form-field">
                            <label for="industry">Industry:</label>
                            <select name="industry" id="industry">
                                <option>&nbsp;</option>
                                <option value="acc">Accommodation &amp; Food Services</option>
                                <option value="agric">Agriculture</option>
                                <option value="real">Construction &amp; Real Estate</option>
                                <option value="consul">Consultation &amp; Professional Services</option>
                                <option value="cult">Culture &amp; Leisure</option>
                                <option value="edu">Education</option>
                                <option value="energy">Energy</option>
                                <option value="beau">Beauty and Health Care</option>
                                <option value="it">Information &amp; Communications Technology</option>
                                <option value="manu">Manufacturing</option>
                                <option value="natrsc">Natural Resources</option>
                                <option value="retail">Retail &amp; Wholesale</option>
                                <option value="sci">Science and Technology</option>
                                <option value="trans">Storage &amp; Transportation</option>
                                <option value="travel">Travel and Tourism</option>
                                <option value="other">Other</option>
                            </select>
                        </div>
                        <div class="form-field">
                            <label for="com-phone">Phone (xxx-xxx-xxxx):</label>
                            <input name="company_phone" type="tel" id="com-phone" pattern="^\d{3}-\d{3}-\d{4}$"
                                   placeholder="xxx-xxx-xxxx"/>
                        </div>
                        <div class="form-field">
                            <label for="com-email">Email:</label>
                            <input name="email" type="email" id="com-email" placeholder="Email address"/>
                        </div>
                        <div class="form-field">
                            <label for="company-address">Street Address:</label>
                            <input type="text" id="com-address" name="street-address" placeholder="Street address..."/>
                        </div>
                        <div class="form-field">
                            <label for="com-website">Website:</label>
                            <input type="text" id="com-website" name="com-website" placeholder="optional"/>
                        </div>
                    </fieldset>
                    <fieldset id="contact_info">
                        <legend>Contact Information</legend>
                        <div class="form-field">
                            <label for="salute">Salutation: </label>
                            <select name="salute" id="salute">
                                <option>&nbsp;</option>
                                <option>Mrs.</option>
                                <option>Ms.</option>
                                <option>Mr.</option>
                            </select>
                        </div>
                        <div class="form-field">
                            <label for="username">Name:</label>
                            <input name="user" id="username" type="text" placeholder="Name..." required/>
                        </div>
                        <div class="form-field">
                            <label for="role">Role/Title:</label>
                            <input name="role" id="role" type="text" placeholder="Role/Title (optional)..." required/>
                        </div>
                        <div class="form-field">
                            <label for="userphone">Phone (xxx-xxx-xxxx):</label>
                            <input type="tel" name="u-tel" id="userphone" pattern="^\d{3}-\d{3}-\d{4}$"
                                   placeholder="xxx-xxx-xxxx"/>
                        </div>
                        <div class="form-field">
                            <label for="useremail">Email:</label>
                            <input name="email" type="email" id="useremail" placeholder="Email address" required/>
                        </div>
                    </fieldset>
                    <fieldset id="service-info">
                        <legend>Web Development Packages</legend>
                        <div id="service-packs">
                            <ul id="packs">
                                <li>
                                    <input name="package" value="simple" type="radio" id="simple"/> Standard 5-page site
                                    - $250.00
                                </li>
                                <li>
                                    <input name="package" value="ecom" type="radio" id="ecom"/> E-Commerce Store -
                                    $350.00
                                </li>
                                <li>
                                    <input name="package" value="brand" type="radio" id="brand"/> Brand Landing Page -
                                    $250.00
                                </li>
                                <li>
                                    <input name="package" value="corp" type="radio" id="corp"/> Coorporate - $500.00
                                </li>
                            </ul>
                            <h4>Additional Features</h4>
                            <div id="add-services">
                                <div>
                                    <ul>
                                        <li>
                                            <input type="checkbox" value="50" name="feature"/><span
                                                    class="feature-name">Hosting &amp; deployment - $50.00
											</span></li>
                                        <li>
                                            <input type="checkbox" value="75" name="feature"/><span
                                                    class="feature-name">User Registration/Forum - $75.00
											</span></li>
                                        <li>
                                            <input type="checkbox" value="15" name="feature"/><span
                                                    class="feature-name">Custom email address(s) - $15.00
											</span></li>
                                        <li>
                                            <input type="checkbox" value="0" name="feature"/><span class="feature-name">Web Analytics Inegration - $0.00
											</span></li>
                                    </ul>
                                    <ul>
                                        <li>
                                            <input type="checkbox" value="25" name="feature"/><span
                                                    class="feature-name">SEO and Publishing - $25.00 per page
											</span></li>
                                        <li>
                                            <input type="checkbox" value="50" name="feature"/><span
                                                    class="feature-name">Payment Integration - $50.00
											</span></li>
                                        <li>
                                            <input type="checkbox" value="20" name="feature"/><span
                                                    class="feature-name">Blogging Enabled - $20.00
											</span></li>
                                        <li>
                                            <input type="checkbox" value="20" name="feature"/><span
                                                    class="feature-name">Get Diji Domain T-Shirt - $15.00
											</span></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="form-field">
                            <label for="msg">Other Requirements<sub>(<abbr
                                            title="Add any extra features you might want your website to have in the area">?</abbr>)</sub>:</label>
                            <textarea name="message" id="msg" rows="15" cols="50"></textarea>
                        </div>
                        <div class="form-field">
                            <input type="checkbox" style="width: auto" id="appoint"/>I'd like to make an in office
                            appointment
                        </div>
                    </fieldset>
                    <div>
                        <input type="submit" name="Submit Form" class="submit btn" onclick="sendRequest()"/>
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
<script src="./scripts/forms.js"></script>
</body>

</html>
