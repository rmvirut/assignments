<!-- supplements.xsl -->
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns="http://www.w3.org/1999/xhtml">
<xsl:output method="html"/>
  <xsl:template match="supplements">
  <html>
    <head>
      <title>Vitamin Supplements</title>
    </head>
    <body style="width:600px;font-family:Arial;font-size:12pt;background-color:#EEEEEE">
      <h2>Vitamin Supplements</h2>
      <xsl:for-each select="vitamin">
        <div style="background-color:teal;color:white;padding:4px">
          <span style="font-weight:bold"><xsl:value-of select="name"/></span>
          - <xsl:value-of select="price"/>
        </div>
        <div style="margin-left:20px;margin-bottom:1em;font-size:10pt;font-weight:bold">
          Helps support: <xsl:value-of select="helps_support"/><br />
          <span style="font-style:italic">
            Daily requirement: <xsl:value-of select="daily_requirement"/>
          </span>
        </div>
      </xsl:for-each>
    </body>
  </html>
  </xsl:template>
</xsl:stylesheet>
