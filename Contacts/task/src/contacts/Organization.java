package contacts;

public class Organization extends Contact{

    public String organizationName;
    public String address;

    public Organization(String organizationName, String address, String phoneNumber) {
        super(phoneNumber, false);
        this.organizationName = organizationName;
        this.address = address;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return organizationName;
    }

    @Override
    public void info() {
        System.out.println("Organization name: " + organizationName);
        System.out.println("Address: " + address);
        if (hasNumber()) {
            System.out.println("Number: " + getPhoneNumber());
        } else {
            System.out.println("Number: [no data]");
        }
        if (timeCreated != null) {
            System.out.println("Time created: " + timeCreated);
        } else {
            System.out.println("Time created: [no data]");
        }
        if (timeEdit!= null) {
            System.out.println("Time last edit: " + timeCreated);
        } else {
            System.out.println("Time last edit: [no data]");
        }
    }

    @Override
    public boolean containsQuery(String query) {
        if (hasNumber()) {
            if (getPhoneNumber().toLowerCase().contains(query.toLowerCase())) {
                return true;
            }
        }
        if (organizationName.toLowerCase().contains(query.toLowerCase())) {
            return true;
        }
        if (address.toLowerCase().contains(query.toLowerCase())) {
            return true;
        }
        return false;
    }
}
