ch03/nature3_readme.txt

The nature3 subdirectory contains the third version of
our Nature's Source website. From the point of view of
a visitor to the website, there should be no visible
difference at all between this version and the one seen
in nature2. However, behind the scenes there is something
quite different going on.

This time around, we are making use of the web server's
SSI (Sever Side Includes) facility, which allows us to
place markup that is common to all (or many) of our pages
in a single location and have this common markup retrieved
from that location and inserted into each of our web pages
that needs it on the server before the page is sent to the
browser for display.

This process also involves the use of the HTML base tag,
to provide a common base URL, enabling the use of relative
paths for our pages (relative to the URL in the base tag).

Note that we are still using tables for layout, so that
aspect of our website has not changed since nature2.

================== VERY IMPORTANT NOTE =====================
It is important to realize that this nature3 version of our
website will only display properly if it is "served" by an
actual web server that is also SSI aware. In particular, if
you place have these files on a "normal" PC, and double click
on the index.html file in the nature3 subdirectory, the site
will not display properly.
================== VERY IMPORTANT NOTE =====================

Every page on this version of the website should also 
validate as HTML 5.

Full list of nature3 subdirectory contents:
-- index.html (our home page)
-- images (subdirectory) files:
   -- naturelogo.gif (the Nature's Source logo)
   -- outdoor4.jpg (a business-related image for our home page)
-- common (subdirectory) files containing common markup segments
   and ordered not alphabetically but in the order in which they
   are used on the page:
   -- document_head.html (each page has this content at the top)
   -- logo_row.html (each page contains the company logo)
   -- mainmenu_row.html (each page contains the main menu)
   -- footer_row.html (each page contains the footer)
-- pages (subdirectory) files linked to from the home page (compare the
   content these files with those from nature2 having the same names):
   -- about.html
   -- bmi.html
   -- catalog.html
   -- contact.html
   -- employment.html
   -- estore.html
   -- expert.html
   -- featured.html
   -- feedback.html
   -- links.html
   -- locations.html
   -- news.html
   -- products.html
   -- services.html
   -- sitemap.html
   -- suppliers.html
   -- tools.html
   -- vision.html
   -- yourhealth.html
