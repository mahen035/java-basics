<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <title>Login - Bluewave Bank</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <style>
        body{background:#f7fafc;font-family:Inter,system-ui,-apple-system,Segoe UI,Roboto,'Helvetica Neue',Arial;color:#0f172a}
        .wrap{max-width:420px;margin:48px auto;padding:22px}
        .card{background:#fff;border-radius:12px;box-shadow:0 6px 18px rgba(15,23,42,0.06);padding:22px}
        h1{font-size:20px;margin:0 0 8px}
        label{font-weight:600;margin-bottom:6px;display:block}
        input[type="text"],input[type="password"]{width:100%;padding:10px 12px;border:1px solid #e6eef8;border-radius:8px;font-size:14px;margin-bottom:8px}
        .btn{background:#2563eb;color:white;padding:10px 14px;border-radius:8px;border:0;font-weight:600;cursor:pointer}
        .hint{font-size:13px;color:#6b7280}
        .error{color:#dc2626;font-size:13px;margin-top:6px}
        .success{color:#16a34a;font-size:13px;margin-top:6px}
        .muted-link{color:#6b7280;text-decoration:none}
    </style>
</head>
<body>

<div class="wrap">
    <div class="card">
        <h1>Sign in to Bluewave Bank</h1>
        <p class="hint">Enter your username and password to continue.</p>

        <form id="loginForm" novalidate>
            <div>
                <label for="username">Username</label>
                <input id="username" name="username" type="text" placeholder="Your username" aria-required="true">
                <div id="usernameError" class="error" aria-live="polite" style="display:none"></div>
            </div>

            <div>
                <label for="password">Password</label>
                <input id="password" name="password" type="password" placeholder="Your password" aria-required="true">
                <div id="passwordError" class="error" aria-live="polite" style="display:none"></div>
            </div>

            <div style="display:flex;gap:10px;align-items:center;margin-top:12px">
                <button id="submitBtn" type="submit" class="btn">Sign in</button>
                <div id="formStatus" role="status" aria-live="polite"></div>
            </div>

            <p style="margin-top:12px;font-size:13px;color:#6b7280">Don't have an account? <a class="muted-link" href="<%=request.getContextPath()%>/register.jsp">Register</a></p>
        </form>
    </div>
</div>

<script>
    (function(){
        const form = document.getElementById('loginForm');
        const username = document.getElementById('username');
        const password = document.getElementById('password');
        const submitBtn = document.getElementById('submitBtn');
        const formStatus = document.getElementById('formStatus');

        const usernameError = document.getElementById('usernameError');
        const passwordError = document.getElementById('passwordError');

        function showError(el, msg){ el.style.display='block'; el.textContent = msg; }
        function clearError(el){ el.style.display='none'; el.textContent = ''; }

        function validateAll(){
            let ok = true;
            if(!username.value.trim()){
                showError(usernameError, 'Username is required.'); ok=false;
            } else if(username.value.trim().length < 3){
                showError(usernameError, 'Username must be at least 3 characters.'); ok=false;
            } else { clearError(usernameError); }

            if(!password.value){
                showError(passwordError, 'Password is required.'); ok=false;
            } else if(password.value.length < 8){
                showError(passwordError, 'Password must be at least 8 characters.'); ok=false;
            } else { clearError(passwordError); }

            return ok;
        }

        form.addEventListener('submit', function(e){
            e.preventDefault();
            formStatus.textContent = '';

            if(!validateAll()){
                return;
            }

            const payload = {
                username: username.value.trim(),
                password: password.value
            };

            submitBtn.disabled = true;
            submitBtn.textContent = 'Signing in...';

            fetch('http://localhost:8081/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(payload)
            }).then(async resp => {
                const text = await resp.text();
                let data = text;
                try{ data = JSON.parse(text); }catch(err){}

                if(resp.ok){
                    // Save user info or token to sessionStorage for dashboard
                    const userObj = (data && typeof data === 'object') ? data : { username: payload.username };
                    try{ sessionStorage.setItem('user', JSON.stringify(userObj)); }catch(e){}

                    // Redirect to dashboard
                    window.location.href = '<%=request.getContextPath()%>/dashboard.jsp';
                } else {
                    formStatus.className = 'error';
                    const msg = (data && data.error) ? data.error : (data && data.message) ? data.message : (text || 'Login failed.');
                    formStatus.textContent = msg;
                }
            }).catch(err => {
                formStatus.className = 'error';
                formStatus.textContent = 'Unable to reach the login service. Please try again later.';
            }).finally(()=>{
                submitBtn.disabled = false;
                submitBtn.textContent = 'Sign in';
            });
        });

        [username, password].forEach(input=>{
            input.addEventListener('blur', function(){ validateAll(); });
        });
    })();
</script>

</body>
</html>
