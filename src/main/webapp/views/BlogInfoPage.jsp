<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>${blog.getTitle()}</title>
    </head>

    <body>
        <jsp:include page="Navbar.jsp" />

        <main>
            <h2>${blog.getTitle()}</h2>

            <img src="${blog.getGifUrl()}" alt="${blog.getTitle()}">

            <p>${blog.getText()}</p>
        </main>

        <jsp:include page="Footer.jsp" />
    </body>

    </html>
