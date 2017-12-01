ch03/readme.txt

Study Order for Files in This Directory
These are the files from Chapter 3.
---------------------------------------

1. first.html (does not validate as HTML 5)
A first and very simple HTML example. Introduces
the four main elements of any HTML page (html,
head, title and body), as well as the h1
(header) and p (paragraph) elements.

2. second.html (does not validate as HTML 5)
Introduces the HTML comment, the br (line break)
tag, and the unordered list (ul and li tags).
Also shows one (fairly typical) way of formatting
HTML markup.

Note that empty elements no longer need to be
"self-closing" (like they had to be in XHTML)
with the forward slash (and its optional
preceding blank space) preceding the closing
angle bracket. Thus the <br /> of XHTML becomes
<br> in HTML 5. Leaving an empty element in its
self-closing form is still OK, and some authors
even recommend retaining the practice, for
backward compatibility with XHTML.

3. third.html (validates as HTML 5)
Introduces the following three items:
- <!DOCTYPE html>
- <html lang="en">
- <meta charset="utf-8">
These are three major changes that are much simplified
when compared to their previous XHTML counterparts.
The DOCTYPE declaration is the most radical departure.
You can now even memorize it, it's so simple. It is 
even optional, but it should be there to prevent
older browsers from switching into "quirks mode".
The html opening tag has a lang attribute. It too is
optional, but is recommended since globalization makes
it increasingly important to ensure that browsers know
what language they are dealing with. The meta tag now
needs only a charset attribute, and the meta element is
also no longer self-closing, just like the br element
in second.html (above).

4. The nature1 subdirectory (read nature1_readme.txt)
5. The nature2 subdirectory (read nature2_readme.txt)
6. The nature3 subdirectory (read nature3_readme.txt)
For each of the above subdirectories, be sure to read the
corresponding readme file before examining its contents.
All pages in each of these directories should validate
as HTML 5.
