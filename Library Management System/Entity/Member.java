package Entity;

public class Member extends Account{
    Date dateOfMembership;
    int totalBookIssued;
    public static final int MAX_BOOK_ISSUED = 5;

    public void issueBook(BookItem bookItem);

    public void returnBook(bookItem);
    public void renewBook(bookItem);
    public void checkForFine();
}
