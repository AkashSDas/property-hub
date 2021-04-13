<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Sign Up</title>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/design/style.css"
      type="text/css"
    />
  </head>

  <body>
    <jsp:include page="Navbar.jsp" />

    <main>
      <section class="sign-up">
        <h2>Sign Up</h2>

        <div class="hr"></div>

        <div class="img-wrapper">
          <img
            src="https://media.giphy.com/media/3o7529XXY2bwPvawnK/giphy.gif"
            alt="welcome"
          />
        </div>

        <!-- Show registeration success/fail message once the form the submitted -->
        <c:if test="${message != null}">
          <div class="message">${message}</div>
        </c:if>

        <!-- registeration form -->
        <form class="form" action="sign-up" method="POST">
          <div class="form-group">
            <label for="email">Email Address</label>
            <input
              type="email"
              name="email"
              placeholder="Enter your email address..."
              required
            />
          </div>

          <div class="form-group">
            <label for="password">Password</label>
            <input
              type="password"
              name="password"
              placeholder="Enter your password..."
              required
            />
          </div>

          <button type="submit">Submit</button>
        </form>
      </section>
    </main>

    <jsp:include page="Footer.jsp" />
  </body>
</html>
