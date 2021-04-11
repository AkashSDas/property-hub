<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Sign Up</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/design/style.css" type="text/css">
    </head>

    <body>
        <jsp:include page="Navbar.jsp" />

        <main>
            <h2>Sign Up</h2>

            <div><strong>${message}</strong></div>

            <form action="sign-up" method="POST">
                <label for="email">Email Address</label>
                <input type="email" name="email" required />

                <label for="password">Password</label>
                <input type="password" name="password" required />

                <button type="submit">Submit</button>
            </form>
        </main>

        <jsp:include page="Footer.jsp" />
    </body>

    </html>
