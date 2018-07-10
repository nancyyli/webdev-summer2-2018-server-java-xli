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
            'username': usernameFld.val(),
            "password": passwordFld.val()
        };

        userService.login(user).then(function(response){
            return response.text();
        }).then(function(user) {
            if(user.length) {
                navigateToProfile();
            } else {
                displayErrorMessage();
            }
        });
    }

    function displayErrorMessage() {
        $('.invalid-login').css('display', 'block');
    }

    function navigateToProfile() {
        window.location.href = '../profile/profile.template.client.html';
    }

    $(init);
})();