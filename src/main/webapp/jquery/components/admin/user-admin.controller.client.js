(function () {
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

    function findUserById(userID) {
        userService.findUserById(userID);
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
        tbody.empty();
        console.log(users.length);
        for(var i=0; i<users.length; i++) {
            var user = users[i];
            var clone = template.clone();

            clone.attr('id', user.id);

            clone.find('.delete').click(deleteUser);

            // clone.find('.edit').click(editUser);

            clone.find('.username')
                .html(user.username);
            clone.find('.firstname')
                .html(user.firstName);
            clone.find('.lastname')
                .html(user.lastName);
            tbody.append(clone);
        }
    }
})();
