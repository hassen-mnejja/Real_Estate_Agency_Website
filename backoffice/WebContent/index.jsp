<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>

<title>Login</title>
<link rel="stylesheet/scss" type="text/css" href="test.scss">
<link rel="icon" href="Images/icon4.ico" />
<style>
* {
	font-family: -apple-system, BlinkMacSystemFont, "San Francisco",
		Helvetica, Arial, sans-serif;
	font-weight: 300;
	margin: 0;
}

html, body {
	height: 100vh;
	width: 100vw;
	margin: 0 0;
	display: flex;
	align-items: flex-start;
	justify-content: flex-start;
	background: #f3f2f2;
}

h4 {
	font-size: 24px;
	font-weight: 600;
	color: #000;
	opacity: 0.85;
}

label {
	font-size: 12.5px;
	color: #000;
	opacity: 0.8;
	font-weight: 400;
}

form {
	padding: 40px 30px;
	background: #fefefe;
	display: flex;
	flex-direction: column;
	align-items: flex-start;
	padding-bottom: 20px;
}

form h4 {
	margin-bottom: 20px;
	color: rgba(0, 0, 0, .5);
}

form h4 span {
	color: rgba(0, 0, 0, 1);
	font-weight: 700;
}

form p {
	line-height: 155%;
	margin-bottom: 5px;
	font-size: 14px;
	color: #000;
	opacity: 0.65;
	font-weight: 400;
	max-width: 200px;
	margin-bottom: 40px;
}

a.discrete {
	color: rgba(0, 0, 0, .4);
	font-size: 14px;
	border-bottom: solid 1px rgba(0, 0, 0, .0);
	padding-bottom: 4px;
	margin-left: auto;
	font-weight: 300;
	transition: all 0.3s ease;
	margin-top: 40px;
}

a.discrete:hover {
	border-bottom: solid 1px rgba(0, 0, 0, .2);
}

button {
	-webkit-appearance: none;
	width: auto;
	min-width: 100px;
	border-radius: 24px;
	text-align: center;
	padding: 15px 40px;
	margin-top: 5px;
	background-color: #148de0;
	color: #fff;
	font-size: 14px;
	margin-left: auto;
	font-weight: 500;
	box-shadow: 0px 2px 6px -1px rgba(0, 0, 0, .13);
	border: none;
	transition: all 0.3s ease;
	outline: 0;
	cursor: pointer;
}

button:hover {
	transform: translateY(-3px);
	box-shadow: 0 2px 6px -1px rgba(182, 157, 230, .65);
}

button:hover:active {
	transform: scale(0.99);
}

input {
	font-size: 16px;
	padding: 20px 0px;
	height: 56px;
	border: none;
	border-bottom: solid 1px rgba(0, 0, 0, .1);
	background: #fff;
	min-width: 280px;
	box-sizing: border-box;
	transition: all 0.3s linear;
	color: #000;
	font-weight: 400;
	-webkit-appearance: none;
}

input:focus {
	border-bottom: solid 1px #b69de6;
	outline: 0;
	box-shadow: 0 2px 6px -8px rgba(182, 157, 230, .45);
}

.floating-label {
	position: relative;
	margin-bottom: 10px;
}

.floating-label label {
	position: absolute;
	top: calc(50% - 7px);
	left: 0;
	opacity: 0;
	transition: all 0.3s ease;
}

.floating-label

 

input


:not

 

(
:placeholder-shown

 

)
{
padding


:

 

28
px

 

0
px

 

12
px

 

0
px


;
}
.floating-label input:not (:placeholder-shown ) +label {
	transform: translateY(-10px);
	opacity: 0.7;
}

.session {
	display: flex;
	flex-direction: row;
	width: auto;
	height: auto;
	margin: auto auto;
	background: #fff;
	border-radius: 4px;
	box-shadow: 0px 2px 6px -1px rgba(0, 0, 0, .12);
}

.left {
	width: 220px;
	height: auto;
	min-height: 100%;
	position: relative;
	background-image: url("Images/login.jpg");
	background-size: cover;
	border-top-left-radius: 4px;
	border-bottom-left-radius: 4px;
}

.left svg {
	height: 40px;
	width: auto;
	margin: 20px;
}
</style>
</head>

<body>
	<div class="session">
		<div class="left"></div>
		<form action="login" class="log-in" method="post" autocomplete="off">
			<h4>
				Nous sommes <span>LUXE</span>
			</h4>
			<p>Bienvenue à nouveau ! Connectez-vous maintenant pour gérer votre agence :</p>

			<div class="floating-label">
				<input placeholder="Username" type="text" name="username" id="username" autocomplete="off"> <label for="email">Username:</label>
			</div>
			<div class="floating-label">
				<input placeholder="Password" type="password" name="password" id="password" autocomplete="off" class=""> <label for="password">Password:</label>
			</div>
			<button type="submit">Se connecter</button>
		</form>
	</div>
</body>

</html>