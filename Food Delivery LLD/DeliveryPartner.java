public class DeliveryPartner extends user {

    private int partnerId;
    private boolean available;

    public DeliveryPartner(
            int partnerId,
            String username,
            String password,
            long phone,
            String address) {

        super(username, password, phone, address);

        this.partnerId = partnerId;
        this.available = true;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}