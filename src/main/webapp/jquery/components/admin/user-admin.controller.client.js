(function () {
    var tbody;
    var template;
    var userService = new UserServiceClient();
    $(main);

    function main() {
        tbody = $('tbody');
        template = $('.template');
        $('.wbdv-create').click(createUser);
        $('.wbdv-update').click(updateUser);

        findAllUsers();
    }
    function createUser() {
        var username = $('#usernameFld').val();
        var password = $('#passwordFld').val();
        var firstName = $('#firstNameFld').val();
        var lastName = $('#lastNameFld').val();
        var role = $('#roleFld').val();

        var user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
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
        return userService.findUserById(userID);
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
        var editBtn = $(event.currentTarget);
        var userColumn = editBtn
            .parent()
            .parent();

        var userId = userColumn
            .attr('id');
        $(userColumn).addClass('selected');
        $('.wbdv-form').attr('id', userId);
    }

    function updateUser() {
        var userId = $('.wbdv-form').attr('id');
        var username = $('#usernameFld').val();
        var password = $('#passwordFld').val();
        var firstName = $('#firstNameFld').val();
        var lastName = $('#lastNameFld').val();
        var role = $('#roleFld').val();

        var user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
        };
        userService.updateUser(userId, user).then(findAllUsers);
    }
    function renderUser(user) {

    }
    function renderUsers(users) {
        tbody.empty();
        for(var i=0; i<users.length; i++) {
            var user = users[i];
            var clone = template.clone();

            clone.attr('id', user.id);

            clone.find('#wbdv-remove').click(deleteUser);

            clone.find('#wbdv-edit').click(selectUser);

            clone.find('.wbdv-username')
                .html(user.username);
            clone.find('.wbdv-firstname')
                .html(user.firstName);
            clone.find('.wbdv-lastname')
                .html(user.lastName);
            clone.find('.wbdv-role')
                .html(user.role);
            tbody.append(clone);
        }
    }
})();
