public class Ticket {
    private int row;
    private int seat;
    private int price;
    private Person person;

    public Ticket(int row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public Ticket() {
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String print() {
        return "Ticket = " +
                " row = " + row +
                " | seat = " + seat +
                " | price = " + price +
                " | person name = " + person.getName()+
                " | person surname = " + person.getSurname();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "row=" + row +
                ", seat=" + seat +
                ", price=" + price +
                ", person=" + person +
                '}';
    }
}
