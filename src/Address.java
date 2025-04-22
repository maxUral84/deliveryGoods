import java.util.Objects;

public class Address {
    String country;
    String city;

    public Address(String country, String city) {
        this.country = country.toLowerCase();
        this.city = city.trim().toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if ((o instanceof Address) == false) {
            return false;
        }

        Address address = (Address) o;

        return country.equals(address.country) && city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }

    @Override
    public String toString() {
        return country + ", " + city;
    }
}
