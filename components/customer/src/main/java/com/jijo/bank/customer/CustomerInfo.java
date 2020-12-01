package com.jijo.bank.customer;

public class CustomerInfo {

    public final long id;
    public final String name;
    public final String info;

    public CustomerInfo(long id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    private CustomerInfo() {
        this(0, null, null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerInfo customerInfo = (CustomerInfo) o;

        if (id != customerInfo.id) return false;
        if (name != null ? !name.equals(customerInfo.name) : customerInfo.name != null)
            return false;
        return info != null ? info.equals(customerInfo.info) : customerInfo.info == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", info='" + info + '\'' +
            '}';
    }
}
