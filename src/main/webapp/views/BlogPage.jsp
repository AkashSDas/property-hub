<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Blogs</title>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/design/style.css"
      type="text/css"
    />
  </head>

  <body>
    <jsp:include page="Navbar.jsp" />

    <main>
        <section class="blog">
            <h2>PropertyHub Blog</h2>

            <div class="hr"></div>

            <div class="blog-list">
                <c:forEach items="${blogs}" var="blog">
                    <form action="blog-info" method="GET">
                        <div class="wrapper">
                            <img src="${blog.getCoverImageUrl()}" alt="${blog.getTitle()}">

                            <div class="blog-info">
                                <h2>${blog.getTitle()}</h2>
                                <p class="info">${blog.getDescription()}</p>
                                <div>Written by ${blog.getAuthorName()}</div>
                                <div class="reading-info">${blog.getWordCount()} words,
                                    ${blog.getMinutesToRead()} mins read</div>

                                <button type="submit">Read</button>
                            </div>
                        </div>
                        <input name="blogId" type="hidden" value="${blog.getId()}" />
                    </form>
                </c:forEach>
        </section>
    </main>

    <jsp:include page="Footer.jsp" />
  </body>
</html>
