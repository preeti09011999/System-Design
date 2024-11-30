package Entity;

public class BookItem extends Book {
    String barcode;
    BookStatus bookStatus;
    Date borrowedDate;
    Date dueDate;
    Rack locationOfBook;
    
    issueBook(memberId){
        // check bookStatus
        // check if lending is possible
        // updateBookItemStatus
    }
}
