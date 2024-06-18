package execption;

public class BookAlreadyBorrowedException extends Exception {
    public BookAlreadyBorrowedException (String massage) {
        super(massage);
    }
}
