<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <title>Dashboard - Bluewave Bank</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <style>
        body{background:#f7fafc;font-family:Inter,system-ui,-apple-system,Segoe UI,Roboto,'Helvetica Neue',Arial;color:#0f172a}
        .wrap{max-width:920px;margin:36px auto;padding:28px}
        .card{background:#fff;border-radius:12px;box-shadow:0 6px 18px rgba(15,23,42,0.06);padding:22px}
        .top{display:flex;justify-content:space-between;align-items:center}
        .btn{background:#2563eb;color:white;padding:8px 12px;border-radius:8px;border:0;font-weight:600;cursor:pointer}
    </style>
</head>
<body>

<div class="wrap">
    <div class="card">
        <div class="top">
            <div>
                <h1 id="welcome">Welcome</h1>
                <p id="sub" style="color:#6b7280;margin:6px 0 0"></p>
            </div>
            <div>
                <button id="logoutBtn" class="btn">Sign out</button>
            </div>
        </div>

        <hr style="margin:18px 0">

        <div id="content">
            <p style="color:#6b7280">This is your dashboard. Replace with real account widgets and data.</p>
        </div>
    </div>
</div>

<script>
    (function(){
        // Read user info from sessionStorage
        let user = null;
        try{ user = JSON.parse(sessionStorage.getItem('user')); }catch(e){ user = null; }

        if(!user){
            // No user — redirect to login
            window.location.href = '<%=request.getContextPath()%>/login.jsp';
        } else {
            const displayName = user.name || user.username || user.customerName || 'User';
            document.getElementById('welcome').textContent = 'Welcome, ' + displayName;
            if(user.email) document.getElementById('sub').textContent = user.email;
        }

        document.getElementById('logoutBtn').addEventListener('click', function(){
            try{ sessionStorage.removeItem('user'); }catch(e){}
            window.location.href = '<%=request.getContextPath()%>/login.jsp';
        });
    })();
</script>

</body>
</html>
