package Pojos;

public class PojoHerokuappResponseBody {
    /*
    {
         bookingid": 24,
         booking": {
     */
    private int bookingId;
    private PojoHerokuappRequestBody booking;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public PojoHerokuappRequestBody getBooking() {
        return booking;
    }

    public void setBooking(PojoHerokuappRequestBody booking) {
        this.booking = booking;
    }

    public PojoHerokuappResponseBody(int bookingId, PojoHerokuappRequestBody booking) {
        this.bookingId = bookingId;
        this.booking = booking;
    }

    public PojoHerokuappResponseBody() {
    }

    @Override
    public String toString() {
        return "PojoHerokuappResponseBody{" +
                "bookingId=" + bookingId +
                ", booking=" + booking +
                '}';
    }
}
