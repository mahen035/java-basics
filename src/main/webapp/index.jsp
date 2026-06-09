<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Bank Login - Secure Access</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

<header class="site-header">
    <div class="brand">
        <div class="logo">B</div>
        <div class="title">Bluewave Bank</div>
    </div>
    <div class="header-links muted">Secure Online Banking</div>
    
</header>

<div class="page-wrap">
    <nav class="sidebar" aria-label="Primary">
        <h3>Navigation</h3>
        <ul>
            <li><a href="<%=request.getContextPath()%>/about">About Us</a></li>
            <li><a href="<%=request.getContextPath()%>/contact">Contact</a></li>
            <li><a href="<%=request.getContextPath()%>/open-account">Open an Account</a></li>
            <li><a href="<%=request.getContextPath()%>/services">Services</a></li>
            <li><a href="<%=request.getContextPath()%>/loans">Loans</a></li>
            <li><a href="<%=request.getContextPath()%>/branches">Branches</a></li>
        </ul>
    </nav>

    <main class="content" role="main">
        <section class="login-card" aria-labelledby="login-heading">
            <h2 id="login-heading">Customer Login</h2>
            <p class="lead">Sign in to access your accounts, transfer funds, and more.</p>

            <form action="<%=request.getContextPath()%>/home" method="post" novalidate>
                <div class="form-group">
                    <label for="username">Username or Customer ID</label>
                    <input id="username" name="username" type="text" placeholder="e.g. john.doe" required>
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" name="password" type="password" placeholder="Enter your password" required>
                </div>

                <div class="form-actions">
                    <div class="links muted">
                        <label style="display:flex;align-items:center;gap:8px"><input type="checkbox" name="remember"> Remember me</label>
                    </div>
                    <div>
                        <a class="muted" href="<%=request.getContextPath()%>/forgot-password">Forgot?</a>
                    </div>
                </div>

                <div style="margin-top:18px;display:flex;gap:12px;align-items:center;justify-content:space-between">
                    <button type="submit" class="btn btn-primary">Sign In</button>
                    <a class="muted" href="<%=request.getContextPath()%>/open-account">Open an account</a>
                </div>
            </form>

            <p class="muted" style="margin-top:18px;font-size:13px">By signing in you agree to our <a href="<%=request.getContextPath()%>/terms">Terms</a> and <a href="<%=request.getContextPath()%>/privacy">Privacy Policy</a>.</p>
        </section>
    </main>

</div>

<footer class="site-footer">
    &copy; <%=java.time.Year.now()%> Bluewave Bank. All rights reserved. Need help? Visit <a href="<%=request.getContextPath()%>/contact">Contact Us</a>.
</footer>

</body>
</html>