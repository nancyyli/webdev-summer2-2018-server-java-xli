(function () {
    var updateBtn,
        logoutBtn,
        userName,
        email,
        phone,
        firstName,
        lastName,
        role,
        dateOfBirth,
        userService = new UserServiceClient();

    function init() {
        updateBtn = $('#updateBtn');
        logoutBtn = $('#logoutBtn');
        userName = $('#staticUsername');
        email = $('#emailFld');
        phone = $('#phoneFld');
        firstName = $('#firstNameFld');
        lastName = $('#lastNameFld');
        role = $('#roleFld');
        dateOfBirth = $('#dobFld');


        updateBtn.click(updateProfile);
        logoutBtn.click(logout);

        profile()
            .then(renderUser);
    }

    function updateProfile() {
        var user = {
            'username' : userName.val(),
            'firstName' : firstName.val(),
            'lastName' : lastName.val(),
            'role' : role.val(),
            'email' : email.val(),
            'phone' : phone.val(),
            'dateOfBirth' : dateOfBirth.val()
        }
        userService.updateProfile(user).then(successUpdateProfile(user));
    }

    function successUpdateProfile(user) {
        renderUser(user);
        $('.update-success').css('display', 'block');
    }

    function renderUser(user) {
        $('#staticUsername').val(user.username);
        $('#firstNameFld').val(user.firstName);
        $('#lastNameFld').val(user.lastName);
        $('#roleFld').val(user.role);
        $('#emailFld').val(user.email);
        $('#phoneFld').val(user.phone);
        $('#dobFld').val(user.dateOfBirth);
    }

    function profile() {
        return userService.getProfile();
    }

    function logout() {
        var user = {
            'username' : userName.val(),
            'firstName' : firstName.val(),
            'lastName' : lastName.val(),
            'role' : role.val(),
            'email' : email.val(),
            'phone' : phone.val(),
            'dateOfBirth' : dateOfBirth.val()
        }
        userService.logout(user).then(navigateToLogin);
    }

    function navigateToLogin() {
        window.location.href = '../login/login.template.client.html';
    }

    $(init);
})();