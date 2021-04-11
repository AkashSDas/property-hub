<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Loans</title>
        </head>

        <body>
            <jsp:include page="Navbar.jsp" />

            <main>
                <h2>Bank Loans</h2>

                <section>
                    <c:forEach items="${loans}" var="loan">
                        <h3>${loan.getBankName()}</h3>
                        <img src="${loan.getBankLogoImageUrl()}" alt="${loan.getBankName()}">
                    </c:forEach>
                </section>
            </main>

        </body>

        </html>
