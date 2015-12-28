<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tiles:insertDefinition name="layout.main" >
    <tiles:putAttribute name="body" type="string">
        <div>Index Content</div>
        <a href="/logout.html">Logout</a>
    </tiles:putAttribute>
</tiles:insertDefinition>
