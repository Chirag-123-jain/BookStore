BookStore

Bookstore is a simple Java Spring Boot application to store and sell books. It stores and sells books of following categories: 1)LITERATURE, 2) NONFICTION, 3)ACTION, 4)THRILLER, 5)TECHNOLOGY, 6)DRAMA, 7)POETRY, 8)MEDIA, 9) OTHERS. In a java project, these categories are arranged in constants folder as an enum.

Functionality And Approach Taken:

BookStore uses MySql and consists of database named “bookstore” which has only one table named: “book”. The book table consist of following columns: 1)id 2)author 3)title 4)category 5)price 6)total_count 7)sold. ‘total_count’ and ‘sold’ column helps to keep the records of the book in the store. Jpa/Hibernate is used to communicate with database. In java project the database structure is present in “domain” folder. BookStore supports following functionality:

Addition of book: Addition of book is done by two end points.

“/api/add-new-book”: If the book is not registered before, it should be registered and the amount of books to be added can be specified.

“api/add-book”: For the book that are already registered into database, you can just add amount of books to be added to the already registered book.

Get book by Id: It gets all the detail of book for that id. The end point for this function is:”/api/book/{id}”. Here id is the path variable.

Get All Books: It gets all the books that are registered. The url for this function is: “/api/book-list”.

Get Number of books available by id: The end point for this function is:”/api/number-of-books/{id}”. Here id is the path variable.

Update a book: The end point is “/api/books/{id}” where id is path variable. Here we pass the BookDto object too. While updating if “id” in the BookDto is changed and doesn’t match with the path variable “id” in the url, it gives exception. While updating if “id” in the bookDto object is removed, it still updates other field updated in the id of the path variable.

Sell a Book: The end point is “/api/sell-book/{id}”. Here the id is path variable. It will sell one book of given id at a time. If there is no book to sell, it will throw exception.

Sell List of Books:The end point is “/api/sell-books”. Here the List of SellDto object is passed on request body. SellDto object specifies the book id and the number of copies of that book, we want to sell. If there is enough book, it throws exception.

Get books by category and keyword: The end point is “/api/books?keyword=keyword&category=category”. It has two request param-keyword and category. Category represents the 9 categories of books. Keyword is assumed to be any group of strings in id, author or title.

Get Number of books sold per category and keyword: The end point is “/api/number-of-books?keyword=keyword&category=category”.

Unit Tests: The unit test is done in service and controller level. In Controller level, the unit test is done using mockMvc, Mockito and junit. In Service level, the unit test is done using junit. It has over 89% line code coverage. Jacoco can also be used to generate unit test report. For more information on jacoco look into step 8 of section:Steps to run the application.
