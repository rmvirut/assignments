ch04/nature3_readme.txt

The nature3 subdirectory of this chapter contains
a version of our Nature's Source website that has
a revised user interface: the footer now contains
only the copyright notice, and the two menu items
that were previously located in the right-hand end
of the footer have been moved up to the right-hand
end of the main menu, which now contains seven links
instead of five. This rearrangement makes it a little
easier to illustrate the idea of "responsive web
design", which we introduce here for the first time,
using only CSS to transform the layout of our site's
pages when the viewport size is reduced to "tablet
size" from the size of a "normal" desktop PC monitor.
This is just an introduction to responsive design, and
a further reduction in size of the viewport (browser
window) will cause our page layout to "come off the
rails", since that part of responsive design (for 
smartphones, for example) is not dealt with in this
example.

================ RESPONSIVE DESIGN ================
In this version of our website we use only CSS to
accomplish a simple "responsive design" which you
can see by reducing the size of the viewport from
the typical desktop size to something more typical
of a tablet size. In this case, what happens is 
that the rotating image disappears completely and
the single line of menu items at the top changes to
a double line to accommodate the reduction in
display area. To accomplish this we make use of two
different CSS files--desktop.css and tablet.css.
Each HTML file is linked to both CSS files, and
the styles in tablet.css override or add to those
in desktop.css when the viewport size shrinks to
tablet dimensions. In general, "responsive design"
means that a web page is designed in such a way that
it behaves differently and responds appropriately to
the size of the display on which it is being viewed.
Note that if you load the page into the browser on a
tablet device such as an iPad, you should see the
alternate version of the page display immediately,
without having to adjust the browser window size.
Note as well, however, that this does not continue
to work as you might hope if you continue to reduce
the display area to smartphone size. But ... the
principles are the same, and taking this extra step
makes a nice exercise.
================ RESPONSIVE DESIGN ================

Every page on this version of the website should
validate as HTML 5 and CSS 3.

Full list of nature3 subdirectory contents:
-- index.html (our home page)
-- images (subdirectory) files:
   -- naturelogo.gif (the Nature's Source logo)
   -- outdoor4.jpg (a business-related image for our home page)
-- common (subdirectory) files:
   -- document_head.html (DOCTYPE, opening html tag, and head element)
   -- footer_content.html (copyright notice, but no two-element menu)
   -- logo.html (logo image)
   -- mainmenu.html (main menu, now with seven menu items)
-- css (subdirectory) files:
   -- desktop.css (our CSS style sheet for the third version of
      our website in this chapter, desktop view)
   -- tablet.css (our CSS style sheet for the third version of
      our website in this chapter, tablet view)
-- pages (subdirectory) files linked to from the home page:
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
