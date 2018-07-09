function UserServiceClient() {
    this.register = register;
    this.findUserByUsername = findUserByUsername;

    function findUserByUsername(userName) {
        return fetch('/api/user/' + userName);
    }
    function register(userObj) {
        var userObjStr = JSON.stringify(userObj);
        return fetch('/api/register', {
            method: 'post',
            body: userObjStr,
            headers: {
                'Content-Type': 'application/json'
            },
            'credentials' : 'include'
        });
    }
}
