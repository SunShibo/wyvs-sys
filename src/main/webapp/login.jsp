<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!Doctype html>
<html>
<head>
    <title>        
        wyvs pms system
    </title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link rel="stylesheet" type="text/css" href="static/css/mainCss/shared.css" />
    <%--<link rel="stylesheet" type="text/css" href="static/css/mainCss/jquery.fancybox.min.css" />--%>
    <link rel="stylesheet" type="text/css" href="static/css/mainCss/cn.css" />
    <script type="text/javascript" src="/static/js/mainJs/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/mainJs/jquery.placeholder.js"></script>
    <script type="text/javascript" src="/static/js/mainJs/main.js"></script>
    
</head>
<body>
    <div class="etc-login-wrapper">
        <div class="etc-login">
            <div class="etc-login-header">
                wyvs pms system</div>                
            <div class="etc-login-form">
                <h1>
                    Member Login</h1>
                <form id="etc-login-form" method="post" action="login?action=login">
                    <p class="etc-login-error">
                        <!-- server error -->
                        <span id="etc-login-error-server" class="etc-login-error-msg"  style="display: inline;">${information}</span>
                        <span id="etc-login-error-empty" class="etc-login-error-msg">Please input the username and password</span>
                    </p>
                    <input class="etc-login-input" tabindex="3" id="username" name="email" type="text" placeholder="Email address or username"
                           value="" />
                    <input class="etc-login-input" tabindex="4" id="password" name="password" type="password" placeholder="Password"
                           name="password" />
                    <button class="etc-login-btn" type="submit">
                        Sign In</button>
                    <p class="etc-login-forgot-password"><span class="etc-login-icon-lock etc-login-sprite"></span><span id="forgot-password" href="#dialog-forgot-password">Forgot your password?</span></p>
                </form>
            </div>
        </div>
        <div class="etc-login-footer">
            <p class="etc-login-copyright">
                Copyright &copy; World Youth Value Society | New Dream() 保留一切權利。<br/>
            </p>
        </div>
        <div class="etc-hidden">
            <div class="etc-login-intercept" id="dialog-forgot-password">
                <div class="etc-login-intercept-head">
                    <h2 class="etc-login-intercept-title"><span class="etc-login-icon-slash etc-login-sprite"></span>Forgot your password?</h2>
                </div>
                <div>
                    <p class="etc-login-intercept-note">Please input your registered email address to get your study account information</p>
                    <form id="etc-login-intercept-form">
                        <input type="hidden" value="cn_sh" name="marketCode" />
                        <input type="hidden" value="ch" name="langCode"  />
                        <input type="hidden" value="" id="ecforgetpwdtoken" name="ecforgetpwdtoken"  />
                        <p class="etc-login-error">
                            <span id="etc-login-error-email" class="etc-login-error-msg">Please provide a valid email address</span>
                            <span id="etc-login-error-captcha" class="etc-login-error-msg">Authenticode is not correct</span>
                            <span id="etc-login-error-captcha-empty" class="etc-login-error-msg">Please input authenticode</span>
                            <span id="etc-login-error-server-msg" class="etc-login-error-msg"></span>
                        </p>
                        <div class="etc-login-intercept-line">
                            <span class="etc-login-icon-mail etc-login-sprite"></span>
                            <input tabindex="1" id="input-email" name="userEmail" type="text" placeholder="Email address" class="etc-login-intercept-input" />
                        </div>
                        <div class="etc-login-intercept-line">
                            <span class="etc-login-icon-shield etc-login-sprite"></span>
                            <input tabindex="2" id="input-captcha" name="ecforgetpwdvalue" type="text" placeholder="Authenticode" class="etc-login-intercept-input is-short" /><img id="captcha" class="etc-login-intercept-captcha" /><span class="etc-login-captcha-refresh"><span class="etc-login-icon-refresh etc-login-sprite"></span></span>
                        </div>
                        <div>
                            <button id="confirm-btn" class="etc-login-btn" type="button">confirm</button>
                        </div>
                    </form>
                </div>
            </div>

            <div class="etc-login-intercept" id="dialog-send-email">
                <div class="etc-login-intercept-head">
                    <h2 class="etc-login-intercept-title"><span class="etc-login-icon-slash etc-login-sprite"></span>Forgot your password?</h2>
                </div>
                <div>
                    <p id="email-sent">We&#39;ve sent an email to your registered email {0}.</p>
                    <p>Please check out your study account information there.</p>
                    <div>
                        <a class="etc-login-btn is-small etc-login-intercept-close">Close</a>
                    </div>
                </div>
                <div class="etc-login-intercept-tip">
                    <strong>Tips:</strong>
                    <p>If you haven&#39;t received the notification, please double check your spam filter or your junk mail folder.</p>
                </div>
            </div>
        </div>
    </div>
<!--<script type="text/javascript" src="_scripts/visittracking.js"></script>-->

<script type="text/javascript">


</script>

<noscript><div><img src="track/trackhandler.ashx" height="1" width="1" alt="" /></div></noscript>

</body>
</html>
