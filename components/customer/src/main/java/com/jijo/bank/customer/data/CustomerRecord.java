package com.jijo.bank.customer.data;

public class CustomerRecord {

    public final long id;
    public final String name;

    public CustomerRecord(long id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerRecord that = (CustomerRecord) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerRecord{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
