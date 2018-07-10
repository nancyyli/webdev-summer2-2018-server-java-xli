function User(username, password, firstName, lastName, role, email, phone, dateOfBirth) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
    this.email = email;
    this.phone = phone;
    this.dateOfBirth = dateofBirth;

    this.setUsername = setUsername;
    this.getUsername = getUsername;

    this.setPassord = setPassword;
    this.getPassword = getPassword;

    this.setFirstName = setFirstName;
    this.getFirstName = getfirstName;

    this.setLastName = setLastName;
    this.setLastName = setLastName;

    this.setRole = setRole;
    this.getRole = getRole;

    this.setEmail = setEmail;
    this.getEmail = getEmail;

    this.setPhone = setPhone;
    this.getPhone = getPhone;

    this.setDateOfBirth = setDateOfBirth;
    this.getDateOfBirth = getDateOfBirth;


    function setUsername(username) {
        this.username = username;
    }
    function getUsername() {
        return this.username;
    }

    function setPassword(password) {
        this.password = password
    }
    function getPassword() {
        return this.password
    }

    function setFirstName(firstName) {
        this.firstName = firstName;
    }
    function getFirstName() {
        return this.firstName;
    }

    function setLastName(lastName) {
        this.lastName = lastname;
    }
    function getLastName() {
        return this.lastName;
    }

    function setRole(role) {
        this.role = role;
    }
    function getRole() {
        return this.role;
    }

    function setEmail(email) {
        this.email = email;
    }
    function getEmail() {
        return this.email;
    }

    function setPhone(phone) {
        this.phone = phone;
    }
    function getPhone() {
        return this.phone;
    }

    function setDateOfBirth(dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    function getDateOfBirth() {
        return this.dateOfBirth;
    }
}
