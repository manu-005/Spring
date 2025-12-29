<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false" %>
 <html>
<body>
<h2>Medicine Details</h2>
<pre>
<form action="addMedicine" method="post">
Medicine Name :  <input type="text" name="name">
price : <input type="number" name="price">
combination medicine : <input type="text" name="combination">
M G : <input type="text" name="mg">
Expire Date : <input type="text" name="expireDate">

<input type="submit" value="ADD">



</pre>
</form>
<form action="delete" method="post">
${success}${error}
Medicine Name :  <input type="text" name="name">
<a href="delete">
<button > Delete</button></a>
</form>
</pre>
</body>
</html>
