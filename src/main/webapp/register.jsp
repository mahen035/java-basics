<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <title>Register - Bluewave Bank</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <style>
        /* Light, professional theme overrides for the register page */
        :root{--bg:#f7fafc;--card:#ffffff;--muted:#6b7280;--accent:#2563eb;--danger:#dc2626;--success:#16a34a}
        body{background:var(--bg);font-family:Inter,system-ui,-apple-system,Segoe UI,Roboto,'Helvetica Neue',Arial;color:#0f172a}
        .register-wrap{max-width:920px;margin:36px auto;padding:28px;display:grid;grid-template-columns:1fr 420px;gap:28px}
        .intro-card{background:transparent;padding:18px}
        .brand-large{display:flex;align-items:center;gap:14px}
        .logo{background:linear-gradient(135deg,#60a5fa,#2563eb);color:white;border-radius:10px;width:72px;height:72px;display:flex;align-items:center;justify-content:center;font-weight:700;font-size:28px}
        .card{background:var(--card);border-radius:12px;box-shadow:0 6px 18px rgba(15,23,42,0.06);padding:22px}
        h1{margin:0 0 6px 0;font-size:22px}
        p.lead{margin:6px 0 18px;color:var(--muted)}
        form .form-group{display:flex;flex-direction:column;margin-bottom:12px}
        label{font-weight:600;margin-bottom:6px}
        .required{color:var(--danger);margin-left:6px;font-weight:700}
        input[type="text"],input[type="email"],input[type="password"]{padding:10px 12px;border:1px solid #e6eef8;border-radius:8px;font-size:14px}
        .hint{font-size:13px;color:var(--muted);margin-top:6px}
        .error{color:var(--danger);font-size:13px;margin-top:6px}
        .success{color:var(--success);font-size:14px;margin-top:6px}
        .btn{background:var(--accent);color:white;padding:10px 14px;border-radius:8px;border:0;font-weight:600;cursor:pointer}
        .btn[disabled]{opacity:0.6;cursor:not-allowed}
        .muted-link{color:var(--muted);text-decoration:none;font-size:14px}
        @media (max-width:900px){.register-wrap{grid-template-columns:1fr;padding:12px}}
    </style>
</head>
<body>

<div class="register-wrap">
    <div class="intro-card">
        <div class="brand-large">
            <div class="logo">B</div>
            <div>
                <h1>Join Bluewave Bank</h1>
                <p class="lead">Create an account to manage your finances securely. Registration is quick and free.</p>
            </div>
        </div>

        <div style="height:18px"></div>
        <div class="card">
            <h2 style="font-size:16px;margin-bottom:10px">Why create an account?</h2>
            <ul style="margin:0 0 0 18px;color:var(--muted)">
                <li>View balances and statements</li>
                <li>Transfer funds and pay bills</li>
                <li>Secure two-factor options</li>
            </ul>
        </div>
    </div>

    <div>
        <div class="card">
            <h2 style="margin-bottom:6px">Register</h2>
            <p class="hint">Fields marked <span style="color:var(--danger)">*</span> are required.</p>

            <form id="registerForm" novalidate>
                <div class="form-group">
                    <label for="username">Username <span class="required">*</span></label>
                    <input id="username" name="username" type="text" placeholder="Choose a username" aria-required="true">
                    <div id="usernameError" class="error" aria-live="polite" style="display:none"></div>
                </div>

                <div class="form-group">
                    <label for="email">Email <span class="required">*</span></label>
                    <input id="email" name="email" type="email" placeholder="you@example.com" aria-required="true">
                    <div id="emailError" class="error" aria-live="polite" style="display:none"></div>
                </div>

                <div class="form-group">
                    <label for="password">Password <span class="required">*</span></label>
                    <input id="password" name="password" type="password" placeholder="Minimum 8 characters, letters and numbers" aria-required="true">
                    <div class="hint">Use at least 8 characters, include letters and numbers.</div>
                    <div id="passwordError" class="error" aria-live="polite" style="display:none"></div>
                </div>

                <div class="form-group">
                    <label for="confirmPassword">Confirm Password <span class="required">*</span></label>
                    <input id="confirmPassword" name="confirmPassword" type="password" placeholder="Re-enter password" aria-required="true">
                    <div id="confirmError" class="error" aria-live="polite" style="display:none"></div>
                </div>

                <div style="display:flex;gap:10px;align-items:center;margin-top:12px">
                    <button id="submitBtn" type="submit" class="btn">Create account</button>
                    <div id="formStatus" role="status" aria-live="polite"></div>
                </div>

                <p style="margin-top:12px;font-size:13px;color:var(--muted)">Already have an account? <a class="muted-link" href="<%=request.getContextPath()%>/login.jsp">Sign in</a></p>
            </form>
        </div>
    </div>
</div>

<script>
    (function(){
        const form = document.getElementById('registerForm');
        const username = document.getElementById('username');
        const email = document.getElementById('email');
        const password = document.getElementById('password');
        const confirmPassword = document.getElementById('confirmPassword');
        const submitBtn = document.getElementById('submitBtn');
        const formStatus = document.getElementById('formStatus');

        const usernameError = document.getElementById('usernameError');
        const emailError = document.getElementById('emailError');
        const passwordError = document.getElementById('passwordError');
        const confirmError = document.getElementById('confirmError');

        function showError(el, msg){ el.style.display='block'; el.textContent = msg; }
        function clearError(el){ el.style.display='none'; el.textContent = ''; }

        function validateEmail(value){
            // Simple RFC-like email validation
            return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value);
        }

        function validatePasswordRule(value){
            // Minimum 8 characters, at least one letter and one number
            return /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/.test(value);
        }

        function validateAll(){
            let ok = true;
            // username
            if(!username.value.trim()){
                showError(usernameError, 'Username is required.'); ok=false;
            } else { clearError(usernameError); }

            // email
            if(!email.value.trim()){
                showError(emailError, 'Email is required.'); ok=false;
            } else if(!validateEmail(email.value.trim())){
                showError(emailError, 'Please enter a valid email address.'); ok=false;
            } else { clearError(emailError); }

            // password
            if(!password.value){
                showError(passwordError, 'Password is required.'); ok=false;
            } else if(!validatePasswordRule(password.value)){
                showError(passwordError, 'Password must be at least 8 characters and include letters and numbers.'); ok=false;
            } else { clearError(passwordError); }

            // confirm
            if(!confirmPassword.value){
                showError(confirmError, 'Please confirm your password.'); ok=false;
            } else if(password.value !== confirmPassword.value){
                showError(confirmError, 'Passwords do not match.'); ok=false;
            } else { clearError(confirmError); }

            return ok;
        }

        form.addEventListener('submit', function(e){
            e.preventDefault();
            formStatus.textContent = '';

            if(!validateAll()){
                formStatus.textContent = '';
                return;
            }

            // Prepare payload
            const payload = {
                customerName: username.value.trim(),
                customerEmail: email.value.trim(),
                password: password.value
            };

            submitBtn.disabled = true;
            submitBtn.textContent = 'Creating...';
            formStatus.textContent = '';

            fetch('http://localhost:8081/register', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(payload)
            }).then(async resp => {
                const text = await resp.text();
                let data = text;
                try{ data = JSON.parse(text); }catch(err){}

                if(resp.ok){
                    formStatus.className = 'success';
                    formStatus.textContent = (data && data.message) ? data.message : 'Registration successful. Redirecting to login...';
                    // Optionally clear sensitive fields
                    password.value = '';
                    confirmPassword.value = '';
                    // Redirect to login page after a short delay so user can read the message
                    setTimeout(function(){
                        window.location.href = '<%=request.getContextPath()%>/login.jsp';
                    }, 1200);
                } else {
                    formStatus.className = 'error';
                    const msg = (data && data.error) ? data.error : (data && data.message) ? data.message : (text || 'Registration failed.');
                    formStatus.textContent = msg;
                }
            }).catch(err => {
                formStatus.className = 'error';
                formStatus.textContent = 'Unable to reach the registration service. Please try again later.';
            }).finally(()=>{
                submitBtn.disabled = false;
                submitBtn.textContent = 'Create account';
            });
        });

        // Live validation on blur
        [username, email, password, confirmPassword].forEach(input=>{
            input.addEventListener('blur', function(){ validateAll(); });
        });
    })();
</script>

</body>
</html>
