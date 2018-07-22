function UserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.register = register;
    this.findUserByUserName = findUserByUserName;
    this.login = login;
    this.logout = logout;
    this.updateProfile = updateProfile;
    this.getProfile = getProfile;

    this.url = 'https://webdev-summer2-xli.herokuapp.com/api/user';
    var self = this;
    function createUser(user) {
        return fetch(self.url, {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    function findAllUsers() {
        return fetch(self.url)
        .then(function (response) {
            return response.json();
        });
    }

    function findUserById(userId) {
        return fetch(self.url + '/' + userId)
            .then(function(response){
                return response.json();
            });
    }

    function findUserByUserName(userName) {
        return fetch('/api/user/username/' + userName);
    }

    function updateUser(userId, user) {
        return fetch(self.url + '/' + userId, {
              method: 'put',
              body: JSON.stringify(user),
              headers: {
                  'content-type': 'application/json'
              }
          })
        .then(function(response){
            if(response.bodyUsed) {
                return response.json();
            } else {
                return null;
            }
        });
    }

    function deleteUser(userId) {
        return fetch(self.url + '/' + userId, {
          method: 'delete'
      })
    }

    function register(userObj) {
        var userObjStr = JSON.stringify(userObj);
        return fetch('/api/register', {
            method: 'post',
            body: userObjStr,
            credentials : 'include',
            headers: {
                'Content-Type': 'application/json'
            },
        });
    }

    function login(user) {
        return fetch('/api/login', {
            method: 'post',
            body: JSON.stringify(user),
            credentials: 'include',
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    function updateProfile(user) {
        return fetch('/api/profile/update', {
              method: 'put',
              body: JSON.stringify(user),
              credentials: 'include',
              headers: {
                  'content-type': 'application/json'
              }
          })
        .then(function(response){
            if(response.bodyUsed) {
                return response.json();
            } else {
                return null;
            }
        });
    }

    function getProfile() {
        return fetch('/api/profile', {
            'credentials': 'include'
        }).then(function (response) {
            return response.json();
        });
    }

    function logout(user) {
        return fetch('/api/logout', {
            method: 'post',
            body: JSON.stringify(user),
            credentials: 'include',
            headers: {
                'content-type': 'application/json'
            }
        });
    }

}
