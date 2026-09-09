public class user {

    protected String username;
    protected String password;
    protected long phone;
    protected String address;

    public user(String username, String password,
                long phone, String address) {

        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public boolean loginValidation(String username, String password) {

        return this.username.equals(username)
                && this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}