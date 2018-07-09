(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld;
    var $userRowTemplate, $tbody;
    var tbody;
    var template;
    var userService = new UserServiceClient();
    $(main);

    function main() {
        tbody = $('tbody');
        template = $('.template');
        $('#createUser').click(createUser);

        findAllUsers();
    }
    function createUser() {
        var username = $('#usernameFld').val();
        var password = $('#passwordFld').val();
        var firstName = $('#firstNameFld').val();
        var lastName = $('#lastNameFld').val();

        var user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName
        };

        userService
            .createUser(user)
            .then(findAllUsers);
    }
    function findAllUsers() {
        userService
            .findAllUsers()
            .then(renderUsers);
    }
    function findUserById() {
    }
    function deleteUser() {
        var deleteBtn = $(event.currentTarget);
        var userId = deleteBtn
            .parent()
            .parent()
            .attr('id');

        userService
            .deleteUser(userId)
            .then(findAllUsers);
    }
    function selectUser() {

    }
    function updateUser() {

    }
    function renderUser(user) {

    }
    function renderUsers(users) {

    }
})();
