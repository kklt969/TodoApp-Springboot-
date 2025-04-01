<%@ include file="common/header.jspf" %>


<style>
	body {
		background: linear-gradient(135deg, #4b6cb7, #182848);
		color: #fff;
		font-family: 'Arial', sans-serif;
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100vh;
		margin: 0;
	}
	.container-box {
		background: rgba(255, 255, 255, 0.15);
		padding: 40px;
		border-radius: 15px;
		text-align: center;
		box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
		backdrop-filter: blur(10px);
		max-width: 400px;
	}
	h1 {
		font-size: 24px;
		margin-bottom: 15px;
	}
	h2 {
		font-size: 20px;
		margin-bottom: 10px;
	}
	p {
		font-size: 16px;
		margin-bottom: 20px;
	}
	.btn-custom {
		background-color: #ffcc00;
		color: #333;
		padding: 12px 20px;
		border-radius: 8px;
		text-decoration: none;
		font-weight: bold;
		display: inline-block;
		transition: all 0.3s ease-in-out;
	}
	.btn-custom:hover {
		background-color: #ff9900;
		color: #fff;
		transform: scale(1.05);
	}
</style>

<div class="container-box">
	<h1>🚀 Welcome to Your Todo App!</h1>
	<h2>Hi, ${name}! 👋</h2>
	<p>Start managing your tasks efficiently.</p>

	<a href="list-todo" class="btn btn-custom">📋 Manage Your Todos</a>
</div>

<%@ include file="common/footer.jspf" %>
