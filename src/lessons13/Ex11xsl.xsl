<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" />

	<xsl:template match="/pointList">
		<table border="2">
			<xsl:apply-templates />
		</table>
	</xsl:template>

	<xsl:template match="/pointList/point">
		<tr>
			<xsl:apply-templates />
		</tr>
	</xsl:template>

	<xsl:template match="/pointList/point/x">
		<td>
			<xsl:value-of select="text()" />
			<xsl:value-of select="atr/pointList/point/@unit" />
		</td>
	</xsl:template>

	<xsl:template match="/pointList/point/y">
		<td>
			<xsl:value-of select="text()" />
			<xsl:for-each select="/pointList/point">
				<xsl:value-of select="@unit" />
			</xsl:for-each>
		</td>
	</xsl:template>
</xsl:stylesheet>