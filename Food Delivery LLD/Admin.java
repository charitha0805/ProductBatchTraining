public class Admin extends user {

    private int adminId;

    public Admin(int adminId,
                 String username,
                 String password,
                 long phone,
                 String address) {

        super(username, password, phone, address);

        this.adminId = adminId;
    }

    public int getAdminId() {
        return adminId;
    }
}