<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<div id="top-bar" class="container">
	<div class="row">
		<div class="span4">
			<form method="POST" class="search_form">
				<input type="text" class="input-block-level search-query" Placeholder="eg. T-sirt">
			</form>
		</div>
		<div class="span8">
			<div class="account pull-right">
				<ul class="user-menu">				
					<li><a href="#">My Account</a></li>
					<li><a href="cart.html">Your Cart</a></li>
					<li><a href="checkout.html">Checkout</a></li>					
					<li><a href="${pageContext.request.contextPath}/login">Login</a></li>		
				</ul>
			</div>
		</div>
	</div>
</div>