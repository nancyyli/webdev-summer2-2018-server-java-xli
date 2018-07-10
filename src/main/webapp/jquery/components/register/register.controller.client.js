(function () {

    var registerBtn;
    var usernameFld;
    var passwordFld;
    var password2Fld;
    var userService = new UserServiceClient();

    function init() {
        registerBtn = $('#registerBtn');
        usernameFld = $('#username');
        passwordFld = $('#password');
        password2Fld = $('#validate-password');

        registerBtn.click(registerHandler);
    }



    function registerHandler() {
        var usernameStr = usernameFld.val();
        var passwordStr = passwordFld.val();
        var password2Str = password2Fld.val();

        var userObj = {
            username: usernameStr,
            password: passwordStr
        };

        userService.findUserByUserName(usernameStr)
            .then(function(response){
                return response.text();
            }).then(function(user) {
                if(user.length) {
                    displayErrorMessage();
                } else {
                    registerUser(userObj);
                }
            });
    }
    function displayErrorMessage() {
        $('.user-exist-message').css('display', 'block');
    }

    function registerUser(userObj) {
        userService.register(userObj).then(registrationSuccessful, registrationFailed);
    }

    function registrationSuccessful() {
        // window.location.href = '../profile/profile.template.client.html';
    }
    function registrationFailed() {
        alert('oops registration failed');
    }


    $(init);
})();