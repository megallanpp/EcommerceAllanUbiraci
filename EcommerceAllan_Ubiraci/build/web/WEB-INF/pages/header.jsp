<div class="logo">
    <a href="${pageContext.request.contextPath}">
        <img src="${pageContext.request.contextPath}/resources/img_logo_azul.png" alt="logo" width="200px" height="90px"/>
    </a>
</div>
<div class="topPanel">
    <div class="search">
        <jsp:include page="/WEB-INF/pages/topPanelSearch.jsp"/>
    </div>
    <div class="departmentTitle">
        <jsp:include page="/WEB-INF/pages/topPanelDepartment.jsp"/>
    </div>
</div>    