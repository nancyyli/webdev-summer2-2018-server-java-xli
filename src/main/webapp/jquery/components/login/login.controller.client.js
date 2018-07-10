(function () {
    var loginBtn,
    usernameFld,
    passwordFld,
    userService = new UserServiceClient();

    function init() {
        usernameFld = $('#username');
        passwordFld = $('#password');
        loginBtn = $('#loginBtn');

        loginBtn.click(login);
    }

    function login() {
        var user = {
            'username': username.val(),
            "password": password.val()
        };
        userService.login(user).then(navigateToProfile);
    }

    function navigateToProfile() {
        window.location.href = '/profile.template.client.html';
    }

    $(init);
})();