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
    var currentUser = null;

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
        userService.updateProfile(user).then(renderUser);
    }

    function renderUser(user) {
        currentUser = user;
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

    }

    $(init);
})();