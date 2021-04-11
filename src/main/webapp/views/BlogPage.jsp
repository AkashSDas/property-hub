<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Blogs</title>
        </head>

        <body>
            <jsp:include page="Navbar.jsp" />

            <main>
                <h2>PropertyHub Blog</h2>

                <section>
                    <c:forEach items="${blogs}" var="blog">
                        <form action="blog-info" method="GET">
                            <button type="submit">
                                <h2>${blog.getTitle()}</h2>
                                <img src="${blog.getCoverImageUrl()}" alt="${blog.getTitle()}">
                            </button>
                            <input name="blogId" type="hidden" value="${blog.getId()}" />
                        </form>
                    </c:forEach>
                </section>
            </main>
        </body>

        </html>
